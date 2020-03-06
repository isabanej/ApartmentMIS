package edu.miu.apartment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 import edu.miu.apartment.domain.Room; 
import edu.miu.apartment.repository.RoomRepository;
import edu.miu.apartment.service.RoomService;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository roomRepository;
	@Override
	public Room createRoom(Room room) throws Exception {
		 if (room==null) {
			 throw new Exception("Room must not be empty");
		 }		 
		room.setRoomStatus("Available");
		return roomRepository.save(room);
	}

	@Override
	public List<Room> findAll() {
		return (List<Room>) roomRepository.findAll() ;
	}

	@Override
	public Room updateRoom(Room room) throws Exception {
		Room foundRoom = roomRepository.findByRoomNumber(room.getRoomNo());
		if(foundRoom==null) {
			throw new Exception("No room found");
		}
		
		return roomRepository.save(room);
	}

	@Override
	public Room findByRoomNumber(Long roomNo)  {
		/*
		 * Room foundRoomNumber = roomRepository.findByRoomNumber(roomNo); if
		 * (foundRoomNumber==null) { throw new Exception("No room found"); }
		 */
		return roomRepository.findByRoomNumber(roomNo);
	}

	@Override
	public List<Room> findByRoomStatus(String roomStatus) { 
		return roomRepository.findByRoomStatus(roomStatus);
	}

	 
}
