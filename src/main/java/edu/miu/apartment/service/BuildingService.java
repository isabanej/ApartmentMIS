package edu.miu.apartment.service;

import java.util.List;

import edu.miu.apartment.domain.Building; 

public interface BuildingService {
	public Building createBuilding(Building building) throws Exception;
	public List<Building> findAll(); 
	public Building updateBuilding(Building building) throws Exception;
	public Building findByBuildingNumber(Long buildingId);
}
