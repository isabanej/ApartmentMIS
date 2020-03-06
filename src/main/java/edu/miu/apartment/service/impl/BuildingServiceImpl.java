package edu.miu.apartment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.apartment.domain.Building;
import edu.miu.apartment.domain.Room;
import edu.miu.apartment.repository.BuildingRepository;
import edu.miu.apartment.service.BuildingService; 
@Service
@Transactional

public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;

	@Override
	public Building createBuilding(Building building) throws Exception {		 
		if(building==null) {
			throw new Exception("No Building found");
		}		
		return buildingRepository.save(building);
	}

	@Override
	public List<Building> findAll() {
		return (List<Building>)buildingRepository.findAll();
	}

	@Override
	public Building updateBuilding(Building building) throws Exception {
		Building foundBuilding = buildingRepository.findByBuildingNumber(building.getBuildingId());
		if(foundBuilding==null) {
			throw new Exception("No Building found");
		}		
		return buildingRepository.save(building);
	}

	@Override
	public Building findByBuildingNumber(Long buildingId) {
		return buildingRepository.findByBuildingNumber(buildingId);
	}

	 
}
