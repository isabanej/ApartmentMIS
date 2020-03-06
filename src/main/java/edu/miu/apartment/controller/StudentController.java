package edu.miu.apartment.controller;

import edu.miu.apartment.domain.Student;
import edu.miu.apartment.domain.StudentRoom;
import edu.miu.apartment.service.RoomService;
import edu.miu.apartment.service.StudentRoomService;
import edu.miu.apartment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRoomService studentRoomService;

    @Autowired
    RoomService roomService;

    @RequestMapping(value="/registerStudent", method = RequestMethod.POST)
    public @ResponseBody Student registerStudent(@Valid @RequestBody Student student) throws Exception {
        return studentService.createStudent(student);
    }

    @RequestMapping(value="/assignToRoom", method = RequestMethod.POST)
    public @ResponseBody StudentRoom assignToRoom(@Valid @RequestBody StudentRoom studentRoom) throws Exception {
        studentRoom.setRoom(roomService.findByRoomNumber(studentRoom.getMyRoomId()));
        studentRoom.setStudent(studentService.getStudentById(studentRoom.getMyStudentId()));
        return studentRoomService.createStudentRoom(studentRoom);
    }

    @RequestMapping(value = "/getStudent/{id}", method = RequestMethod.GET)
    public @ResponseBody Student getStudent (@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/getStudentList", method = RequestMethod.GET)
    public @ResponseBody List<Student> students (){

        return studentService.getAllStudents();
    }

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public @ResponseBody Student hello() {
    Student s = new Student();
    s.setCountry("Rwanda");
        return s;
    }

    @RequestMapping(value = "/studentRegistration", method = RequestMethod.GET)
    public String studentRegistrationPage(){
        return "studentRegistration";
    }
}
