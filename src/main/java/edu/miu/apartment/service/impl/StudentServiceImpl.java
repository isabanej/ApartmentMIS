package edu.miu.apartment.service.impl;

import edu.miu.apartment.domain.Student;
import edu.miu.apartment.repository.StudentRepository;
import edu.miu.apartment.service.ProgramEntryService;
import edu.miu.apartment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProgramEntryService entryService;

    @Override
    public Student createStudent(Student student) throws Exception {
        if(student==null){
            throw new Exception("Invalid Null Student");
        }

        student.setProgramEntry(entryService.getEntryByStatus("Current"));
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) throws Exception {

        Student foundStudent = studentRepository.findByStudentId(student.getStudentId());
        if(foundStudent==null){
            throw new Exception("Student Not found");
        }

        return studentRepository.save(foundStudent);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findByStudentId(id);
    }
}
