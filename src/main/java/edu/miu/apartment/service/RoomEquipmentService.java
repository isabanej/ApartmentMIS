package edu.miu.apartment.service;

import java.util.List;

import edu.miu.apartment.domain.RoomEquipment;

public interface RoomEquipmentService {
	public RoomEquipment createRoomEquipment(RoomEquipment roomEquipment) throws Exception;
	
	public RoomEquipment getRoomEquipmentById(Long id) throws Exception;
	public List<RoomEquipment> getAllRoomEquipments();
	public List<RoomEquipment> getRoomEquipmentByStatus(String status) throws Exception;

}
