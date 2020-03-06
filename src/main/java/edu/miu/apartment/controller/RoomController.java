package edu.miu.apartment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.miu.apartment.domain.Building;
import edu.miu.apartment.domain.Room;
import edu.miu.apartment.service.BuildingService;
import edu.miu.apartment.service.RoomService;

@Controller
public class RoomController {
	
	@Autowired
	RoomService roomService;
	@Autowired
	BuildingService buildingService;
	
	@RequestMapping(value="/roomList", method = RequestMethod.GET)
	public @ResponseBody List<Room> roomList() {
		return roomService.findAll();
	}
	
	 @RequestMapping(value = "/getRoom/{roomNo}", method = RequestMethod.GET)
	    public @ResponseBody Room getRoom (@PathVariable("roomNo") Long roomNo) {
	         return roomService.findByRoomNumber(roomNo);
	    }
	 
	  
	
	@RequestMapping(value = "/addRoom", method = RequestMethod.POST)
	public @ResponseBody Room addRoom(@Valid @RequestBody Room room) throws Exception {		
			room.setBuilding(buildingService.findByBuildingNumber(room.getBid()));
			return roomService.createRoom(room);
		 
	}

	
	@RequestMapping(value = "/updateRoom", method = RequestMethod.POST)
	public @ResponseBody Room updateBuilding(@Valid @RequestBody Room room) throws Exception {
		Room foundRoom = roomService.findByRoomNumber(room.getRoomNo());
		if (foundRoom == null) {
			throw new Exception("No Building found to be updated");
		}
		return roomService.updateRoom(room);

	}
}
