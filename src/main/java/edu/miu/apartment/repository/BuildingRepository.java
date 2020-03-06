package edu.miu.apartment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.miu.apartment.domain.Building; 
@Repository
public interface BuildingRepository extends CrudRepository<Building, Long> {
	@Query("select b from Building b where b.buildingId= :buildingId")
    public Building findByBuildingNumber(@Param("buildingId") Long buildingId);

}
