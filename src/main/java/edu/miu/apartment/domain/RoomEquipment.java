package edu.miu.apartment.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



import java.io.Serializable;
import java.util.List;
@Entity
public class RoomEquipment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomEquipmentId;
    
    @NotEmpty
    @Size(min=4,max=25, message="{Size.message.validate}")
    private String roomEquipmentStatus;
    @ManyToOne
    @JoinColumn(name="room_no")
    @Valid
    private Room room;
    
  
    @Transient
    private Long inputEquipment;
    
    

	@Transient
    private Long myRoomId;
    @ManyToOne
    @JoinColumn(name="equipment_id")
    @Valid
    private Equipment equipment;

    public Long getRoomEquipmentId() {
        return roomEquipmentId;
    }

    public void setRoomEquipmentId(Long roomEquipmentId) {
        this.roomEquipmentId = roomEquipmentId;
    }

    public String getRoomEquipmentStatus() {
        return roomEquipmentStatus;
    }

    public void setRoomEquipmentStatus(String roomEquipmentStatus) {
        this.roomEquipmentStatus = roomEquipmentStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

	public Long getMyRoomId() {
		return myRoomId;
	}

	public void setMyRoomId(Long myRoomId) {
		this.myRoomId = myRoomId;
	}

	public Long getInputEquipment() {
		return inputEquipment;
	}

	public void setInputEquipment(Long inputEquipment) {
		this.inputEquipment = inputEquipment;
	}
    
	
    
}
