package edu.miu.apartment.service;

import edu.miu.apartment.domain.StudentCharges;
import edu.miu.apartment.domain.StudentRoom;

import java.util.List;

public interface StudentChargesService {

    public StudentCharges createStudentCharges(StudentCharges studentCharges);
    public List<StudentCharges> getAllStudentCharges();
    public List<StudentCharges> getStudentChargesByStudentRoom(StudentRoom studentRoom);
}
