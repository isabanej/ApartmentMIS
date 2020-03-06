package edu.miu.apartment.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id", "room_no"})})
public class StudentRoom implements Serializable {

    @Id
    @GeneratedValue
    private Long studentRoomId;
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name="room_no")
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;
    private String checkStatus;

    @Transient
    private Long myRoomId;

    @Transient
    private Long myStudentId;

    public Long getStudentRoomId() {
        return studentRoomId;
    }

    public void setStudentRoomId(Long studentRoomId) {
        this.studentRoomId = studentRoomId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Long getMyRoomId() {
        return myRoomId;
    }

    public void setMyRoomId(Long myRoomId) {
        this.myRoomId = myRoomId;
    }

    public Long getMyStudentId() {
        return myStudentId;
    }

    public void setMyStudentId(Long myStudentId) {
        this.myStudentId = myStudentId;
    }
}
