package edu.miu.apartment.service;

import java.util.List;

import edu.miu.apartment.domain.Equipment;

public interface EquipmentService {
	public Equipment getEquipmentById(Long id) throws Exception;
	public Equipment createEquipment(Equipment equipment) throws Exception;
	 public Equipment getEquipmentByName(String name) throws Exception;
	 public List<Equipment> getAllEquipments();

}
