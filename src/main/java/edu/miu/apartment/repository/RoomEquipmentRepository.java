package edu.miu.apartment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.apartment.domain.RoomEquipment;
@Repository
public interface RoomEquipmentRepository extends CrudRepository<RoomEquipment, Long>{
	public RoomEquipment findByRoomEquipmentId(Long id);
	public RoomEquipment findByRoomEquipmentStatus(String roomEquipmentStatus);

}
