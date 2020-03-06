package edu.miu.apartment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.miu.apartment.domain.Equipment;
import edu.miu.apartment.service.EquipmentService;

@Controller
public class EquipmentController {
	@Autowired
	EquipmentService equipmentService;
	
	
	 
	@RequestMapping(value = "/registerEquipment", method = RequestMethod.POST)
	
	public  @ResponseBody Equipment saveEquipment(@Valid  @RequestBody Equipment equipment) throws Exception {
		
			
			return equipmentService.createEquipment(equipment);
		
		
	}
	
	@RequestMapping(value = "/getEquipmentList", method = RequestMethod.GET)
	
	public @ResponseBody List<Equipment> getAllEquipment(){
		return equipmentService.getAllEquipments() ;
		
	}
	
	@RequestMapping(value = "/getEquipmentById/{equipmentId}", method = RequestMethod.GET)
	
	public @ResponseBody Equipment getEquipmentById(@Valid @PathVariable("equipmentId") Long id) throws Exception {
		
		return equipmentService.getEquipmentById(id);
		
	}
		@RequestMapping(value = "/getEquipmentByName", method = RequestMethod.GET)
		
		public @ResponseBody  Equipment getEquipmentByName(@Valid @RequestBody String name) throws Exception {
			
			return equipmentService.getEquipmentByName(name);
		}
		
		
	
	
	

}
