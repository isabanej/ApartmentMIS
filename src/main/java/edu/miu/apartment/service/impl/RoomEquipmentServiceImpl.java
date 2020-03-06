package edu.miu.apartment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.apartment.domain.RoomEquipment;
import edu.miu.apartment.repository.RoomEquipmentRepository;
import edu.miu.apartment.service.RoomEquipmentService;

@Service
@Transactional
public class RoomEquipmentServiceImpl implements RoomEquipmentService {
	@Autowired
	RoomEquipmentRepository RoomEquipmentRepository;

	@Override
	public RoomEquipment createRoomEquipment(RoomEquipment roomEquipment) throws Exception {
		if (roomEquipment != null) {
			RoomEquipmentRepository.save(roomEquipment);
			return roomEquipment;
		} else {
			throw new Exception("Room Equipment can not be empty");
		}

	}

	@Override
	public RoomEquipment getRoomEquipmentById(Long id) throws Exception {
		if (id != null) {
			return RoomEquipmentRepository.findByRoomEquipmentId(id);
		} else {
			throw new Exception("id can not be null");
		}

	}

	@Override
	public List<RoomEquipment> getAllRoomEquipments() {
		// TODO Auto-generated method stub
		return (List<RoomEquipment>) RoomEquipmentRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoomEquipment> getRoomEquipmentByStatus(String status) throws Exception {
		if (!(status.isEmpty())) {
			return (List<RoomEquipment>) RoomEquipmentRepository.findByRoomEquipmentStatus(status);
		} else {
			throw new Exception("Status should have a value");
		}
	}
}
