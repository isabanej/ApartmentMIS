package edu.miu.apartment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.miu.apartment.domain.Building;
import edu.miu.apartment.domain.Student;
import edu.miu.apartment.service.BuildingService;

@Controller
//@RequestMapping({ "/buildings" })
@CrossOrigin
public class BuildingController {
	@Autowired
	private BuildingService buildingService;

	@RequestMapping(value = "/buildingList", method = RequestMethod.GET)
	public @ResponseBody List<Building> buildingList() {
		return buildingService.findAll();
	}

	@RequestMapping(value = "/getBuilding/{buildingId}", method = RequestMethod.GET)
	public @ResponseBody Building getBuilding(@PathVariable("buildingId") Long buildingId) {
		return buildingService.findByBuildingNumber(buildingId);
	}

	@RequestMapping(value = "/addNewBuilding", method = RequestMethod.POST)
	public @ResponseBody Building addNewBuilding(@Valid @RequestBody Building building) throws Exception {
		try {
			return buildingService.createBuilding(building);
		} catch (Exception e) {
			throw new Exception("Something is wrong");
		}

	}

	@RequestMapping(value = "/updateBuilding", method = RequestMethod.POST)
	public @ResponseBody Building updateBuilding(@Valid @RequestBody Building building) throws Exception {
		Building foundBuilding = buildingService.findByBuildingNumber(building.getBuildingId());
		if (foundBuilding == null) {
			throw new Exception("No Building found to be updated");
		}
		return buildingService.updateBuilding(building);

	}

}
