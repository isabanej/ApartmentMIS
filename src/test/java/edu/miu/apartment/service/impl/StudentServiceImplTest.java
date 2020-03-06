package edu.miu.apartment.service.impl;

import edu.miu.apartment.domain.Student;
import edu.miu.apartment.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Employee Services Test Cases")
public class StudentServiceImplTest {

    @Mock
    StudentServiceImpl studentService;

    Student s1 = new Student();
    Student s2 = new Student();
    List<Student> studentList =new ArrayList<Student>();

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        //First Student Dummy
        s1.setStudentFirstName("Dusenge");
        s1.setStudentLastName("John");
        s1.setProgram("Compro");
        s1.setCountry("Rwanda");

        //Second Student Dummy
        s2.setStudentFirstName("Kamana");
        s2.setStudentLastName("Prosper");
        s2.setProgram("data science");
        s2.setCountry("Brazil");

        //Populating List
        studentList = Arrays.asList(s1,s2);

    }

    @Test
    void testCreateStudent() {
        try {
            when(studentService.createStudent(s1)).thenReturn(s1);
            assertEquals(s1, studentService.createStudent(s1));
        } catch (Exception e) {

        }
    }

    @Test
    void testGetAllStudents() {
        try {
            when(studentService.getAllStudents()).thenReturn(studentList);
            assertEquals(2, studentService.getAllStudents().size());
        } catch (Exception e) {

        }
    }


}
