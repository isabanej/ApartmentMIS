package edu.miu.apartment.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Entity
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomNo;
    
    @Column(unique=true)
    private Integer roomCode;
    private String roomStatus;
    @NotNull
    private double roomCost;

    @Transient
    private Long bid;
    @ManyToOne
    @JoinColumn(name="building_Id")
    private Building building;

    public Long getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Long roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public double getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(double roomCost) {
        this.roomCost = roomCost;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

	public Integer getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(Integer roomCode) {
		this.roomCode = roomCode;
	}

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}
    
    
}
