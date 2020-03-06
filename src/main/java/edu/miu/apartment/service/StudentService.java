package edu.miu.apartment.service;

import edu.miu.apartment.domain.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student) throws Exception;
    List<Student> getAllStudents();
    Student updateStudent(Student student) throws Exception;
    Student getStudentById(Long id);
}
