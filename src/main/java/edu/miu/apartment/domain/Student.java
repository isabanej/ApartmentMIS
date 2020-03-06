package edu.miu.apartment.domain;



import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    @NotEmpty(message="{NotEmpty}")
    private String studentFirstName;
    @NotEmpty(message="{NotEmpty}")
    private String studentLastName;
    private String studentGender;
    @Pattern(regexp ="[0-9]{3}-[0-9]{3}-[0-9]{4}" , message = "Invalid SSN Format")
    private String studentSSN;
    private String studentProgram;
    @NotEmpty(message="{NotEmpty}")
    private String country;

    @ManyToOne
    @JoinColumn(name="program_entry_id")
    private ProgramEntry programEntry;
    @Email(message = "{email.validation}")
    private String studentEmail;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentSSN() {
        return studentSSN;
    }

    public void setStudentSSN(String studentSSN) {
        this.studentSSN = studentSSN;
    }

    public String getProgram() {
        return studentProgram;
    }

    public void setProgram(String program) {
        this.studentProgram = program;
    }

    public ProgramEntry getProgramEntry() {
        return programEntry;
    }

    public void setProgramEntry(ProgramEntry programEntry) {
        this.programEntry = programEntry;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
