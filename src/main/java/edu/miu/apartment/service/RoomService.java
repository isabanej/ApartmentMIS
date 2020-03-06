package edu.miu.apartment.service;

import java.util.List;
import edu.miu.apartment.domain.Room;

public interface RoomService {
	public Room createRoom(Room room) throws Exception;
	public List<Room> findAll(); 
	public Room updateRoom(Room room) throws Exception;
	public Room findByRoomNumber(Long roomNo);
	public List<Room> findByRoomStatus(String roomStatus);
}
