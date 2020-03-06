package edu.miu.apartment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.apartment.domain.Student;
import edu.miu.apartment.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("Student Controller Test")
public class StudentControllerTest {

    @InjectMocks
    EmployeeController employeeController;
    private static final Logger LOG = LoggerFactory.getLogger(StudentControllerTest.class);

    @Mock
    StudentServiceImpl studentService;

    MockMvc mockMvc;
    Student s1 = new Student();
    Student s2 = new Student();
    List<Student> studentList =new ArrayList<Student>();
    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();

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

//    @Test
//    void registerStudent() {
//        try {
//            mockMvc.perform(post("/registerStudent")
//                    .content(makeItJson(s1))
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andExpect(jsonPath("$.studentFirstName", Matchers.is(s1.getStudentFirstName())));
//        } catch (Exception e) {
//
//        }
//
//    }

    public String makeItJson(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @Test
//    void testViewAllStudents() throws Exception {
//
//        // Testing view All Employees Controller
//        mockMvc.perform(get("/getStudentList")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }

    @Test
    void testHello() throws Exception {
        mockMvc.perform(get("/apartmentmis/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello there"));
    }


}
