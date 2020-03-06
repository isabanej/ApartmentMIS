package edu.miu.apartment.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class StudentCharges implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentChargesId;
    @ManyToOne
    @JoinColumn(name = "student_room_id")
    private StudentRoom studentRoom;
    private double roomCharges;
    private String description;

    public Long getStudentChargesId() {
        return studentChargesId;
    }

    public void setStudentChargesId(Long studentChargesId) {
        this.studentChargesId = studentChargesId;
    }

    public StudentRoom getStudentRoom() {
        return studentRoom;
    }

    public void setStudentRoom(StudentRoom studentRoom) {
        this.studentRoom = studentRoom;
    }

    public double getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(double roomCharges) {
        this.roomCharges = roomCharges;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
