package edu.miu.apartment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import java.io.Serializable;

@Entity
public class Equipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long equipmentId;
    @Size(min=4,max=25, message="{Size.name.validation}")
    private String equipmentName;
    private double equipmentDamageCharge;
    @Size(min=4,max=25, message="{Size.name.validation}")
    private String description;
      

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public double getEquipmentDamageCharge() {
        return equipmentDamageCharge;
    }

    public void setEquipmentDamageCharge(double equipmentDamageCharge) {
        this.equipmentDamageCharge = equipmentDamageCharge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
