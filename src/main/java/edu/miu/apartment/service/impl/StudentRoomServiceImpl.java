package edu.miu.apartment.service.impl;

import edu.miu.apartment.domain.Room;
import edu.miu.apartment.domain.Student;
import edu.miu.apartment.domain.StudentRoom;
import edu.miu.apartment.repository.StudentRoomRepository;
import edu.miu.apartment.service.ProgramEntryService;
import edu.miu.apartment.service.RoomService;
import edu.miu.apartment.service.StudentRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StudentRoomServiceImpl implements StudentRoomService {

    @Autowired
    private StudentRoomRepository studentRoomRepository;

    @Autowired
    private ProgramEntryService programEntryService;

    @Autowired
    private RoomService roomService;

    @Override
    public StudentRoom createStudentRoom(StudentRoom studentRoom) throws Exception {
        //updating room status
        //create student charges immediately


        if (studentRoom == null){
            throw new Exception("Invalid data...");
        }
        Room room = studentRoom.getRoom();
        if(room.getRoomStatus().equals("Occupied")){
            throw new Exception("Room Is Occupied by another Student");
        }
        room.setRoomStatus("Ocuupied");
        roomService.createRoom(room);
        studentRoom.setCheckStatus("pending");
        studentRoom.setCheckInDate(new Date());
        studentRoom.setCheckOutDate(programEntryService.getEntryByStatus("Current").getEntryEndDate());
        return studentRoomRepository.save(studentRoom);
    }

    @Override
    public List<StudentRoom> getAllStudentRoom() {
        return (List<StudentRoom>) studentRoomRepository.findAll();
    }

    @Override
    public StudentRoom changeRoomForStudent(Student student, Room newRoom, Room oldRoom) throws Exception {

        StudentRoom newStudentRoom = studentRoomRepository.findByRoom(newRoom);
        StudentRoom currentStudentRoom = studentRoomRepository.findByStudentAndRoom(student,oldRoom);
        if(newStudentRoom!=null){
            throw new Exception("The Room is occupied by another Student");
        }

        if(currentStudentRoom==null){
            throw new Exception("No match found for the given parameters");
        }

        newStudentRoom.setRoom(newRoom);
        newStudentRoom.setStudent(student);
        newStudentRoom.setCheckInDate(currentStudentRoom.getCheckInDate());
        newStudentRoom.setCheckOutDate(currentStudentRoom.getCheckOutDate());
        newStudentRoom.setCheckStatus(currentStudentRoom.getCheckStatus());
        return studentRoomRepository.save(newStudentRoom);
    }

    @Override
    public StudentRoom getByStudentAndRoom(Student student, Room room) {
        return studentRoomRepository.findByStudentAndRoom(student,room);
    }

    @Override
    public StudentRoom getByStudent(Student student) {
        return studentRoomRepository.findByStudent(student);
    }

    @Override
    public StudentRoom getByRoom(Room room) {
        return studentRoomRepository.findByRoom(room);
    }
}
