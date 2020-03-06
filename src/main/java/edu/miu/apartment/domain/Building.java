package edu.miu.apartment.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Entity
public class Building implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long buildingId;
    @Column(unique = true) 
    @Size(min=1)
    private String buildingName;
    
    private String buildingDescription;

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingDescription() {
        return buildingDescription;
    }

    public void setBuildingDescription(String buildingDescription) {
        this.buildingDescription = buildingDescription;
    }
}
