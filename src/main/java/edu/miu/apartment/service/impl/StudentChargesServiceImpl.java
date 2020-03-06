package edu.miu.apartment.service.impl;

import edu.miu.apartment.domain.StudentCharges;
import edu.miu.apartment.domain.StudentRoom;
import edu.miu.apartment.repository.StudentChargesRepository;
import edu.miu.apartment.repository.StudentRoomRepository;
import edu.miu.apartment.service.StudentChargesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
@Transactional
public class StudentChargesServiceImpl implements StudentChargesService {

    @Autowired
    private StudentChargesRepository studentChargesRepository;

    @Autowired
    private StudentRoomRepository studentRoomRepository;

    @Override
    public StudentCharges createStudentCharges(StudentCharges studentCharges) {
        Date dd = studentCharges.getStudentRoom().getCheckInDate();
        LocalDate currentDate = LocalDate.now();
        LocalDate dateIn = LocalDate.of(dd.getYear(), dd.getMonth(), dd.getDay());
        int days = (int) ChronoUnit.DAYS.between(dateIn, currentDate);
        double amount = days* studentCharges.getStudentRoom().getRoom().getRoomCost();
        if(studentCharges.getStudentRoom().getCheckStatus().equals("inroom")){
            studentCharges.setRoomCharges(amount);
            studentCharges.setDescription("Room Charges");
        }

        return studentChargesRepository.save(studentCharges);
    }

    @Override
    public List<StudentCharges> getAllStudentCharges() {
        return (List<StudentCharges>) studentChargesRepository.findAll();
    }

    @Override
    public List<StudentCharges> getStudentChargesByStudentRoom(StudentRoom studentRoom) {
        return studentChargesRepository.findByStudentRoom(studentRoom);
    }
}
