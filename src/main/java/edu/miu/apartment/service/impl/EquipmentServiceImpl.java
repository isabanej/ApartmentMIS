package edu.miu.apartment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.apartment.domain.Equipment;
import edu.miu.apartment.repository.EquipmentRepository;
import edu.miu.apartment.service.EquipmentService;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {
	@Autowired
	EquipmentRepository equipmentRepository;

	@Override
	public Equipment getEquipmentById(Long id) throws Exception {
		if (id != null) {
			return equipmentRepository.findById(id).get();
		} else {
			throw new Exception("Emma");
		}

	}

	@Override
	public Equipment createEquipment(Equipment equipment) throws Exception {
		if (equipment != null) {
			Equipment savedEq = equipmentRepository.save(equipment);
			return savedEq;
		} else {
			throw new Exception("Equipment can not be emmpty");
		}

	}

	@Override
	public Equipment getEquipmentByName(String name) throws Exception {
		if (!(name.isEmpty())) {
			return equipmentRepository.findByEquipmentName(name);
		} else {
			throw new Exception("Equipment name can not be empty");
		}
	}

	@Override
	public List<Equipment> getAllEquipments() {

		return (List<Equipment>) equipmentRepository.findAll();
	}

}
