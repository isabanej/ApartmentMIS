package edu.miu.apartment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.apartment.domain.Equipment;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Long> {
	public Equipment findByEquipmentId(Long id);
	public Equipment findByEquipmentName(String id);
	
	

}
