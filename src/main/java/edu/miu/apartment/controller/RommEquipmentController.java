package edu.miu.apartment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.miu.apartment.domain.RoomEquipment;
import edu.miu.apartment.service.EquipmentService;
import edu.miu.apartment.service.RoomEquipmentService;
import edu.miu.apartment.service.RoomService;

@Controller
public class RommEquipmentController {
	@Autowired
	RoomEquipmentService roomEquipmentService;
	
	@Autowired
	RoomService roomService; 
	@Autowired
	EquipmentService equipmentService;
	
	@RequestMapping(value = "/addRoomEquipment", method = RequestMethod.POST)
	
	public @ResponseBody RoomEquipment saveRoomEquipment(@Valid  @RequestBody RoomEquipment roomEquipment) throws Exception {
		System.out.println("Testing.....:"+roomEquipment.getInputEquipment()+" "+roomEquipment.getMyRoomId());
		
		roomEquipment.setEquipment(equipmentService.getEquipmentById(roomEquipment.getInputEquipment()));
			roomEquipment.setRoom(roomService.findByRoomNumber(roomEquipment.getMyRoomId()));
			return roomEquipmentService.createRoomEquipment(roomEquipment);
					
	}
	
	@RequestMapping(value = "/getRoomEquipmentList", method = RequestMethod.GET)
	@ResponseBody
	public  List<RoomEquipment> getAllEquipment(){
		return roomEquipmentService.getAllRoomEquipments() ;
		
	}
	
	@RequestMapping(value = "/getRoomEquipmentById", method = RequestMethod.GET)
	@ResponseBody
	public  RoomEquipment getEquipmentById(@Valid @RequestBody Long id) throws Exception {
		
		return roomEquipmentService.getRoomEquipmentById(id);
		
	}
		@RequestMapping(value = "/getRoomEquipmentByStatus", method = RequestMethod.GET)
		@ResponseBody
		public  List<RoomEquipment> getEquipmentByName(@Valid @RequestBody String status) throws Exception {
			
			return roomEquipmentService.getRoomEquipmentByStatus(status);
		}

}
