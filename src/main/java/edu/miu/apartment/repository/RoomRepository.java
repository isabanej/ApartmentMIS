package edu.miu.apartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.miu.apartment.domain.Room;
@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{

	@Query("select r from Room r where r.roomNo= :roomNo")
    public Room findByRoomNumber(@Param("roomNo") Long roomNo);
	public List<Room> findByRoomStatus(String roomStatus);
}
