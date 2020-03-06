package edu.miu.apartment.service;

import edu.miu.apartment.domain.Room;
import edu.miu.apartment.domain.Student;
import edu.miu.apartment.domain.StudentRoom;

import java.util.List;

public interface StudentRoomService {

    public StudentRoom createStudentRoom(StudentRoom studentRoom) throws Exception;
    public List<StudentRoom> getAllStudentRoom();
    public StudentRoom changeRoomForStudent(Student student, Room newRoom, Room oldRoom) throws Exception;
    public StudentRoom getByStudentAndRoom(Student student, Room room);
    public StudentRoom getByStudent(Student student);
    public StudentRoom getByRoom(Room room);
}
