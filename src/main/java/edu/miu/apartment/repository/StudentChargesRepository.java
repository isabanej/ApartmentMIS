package edu.miu.apartment.repository;

import edu.miu.apartment.domain.StudentCharges;
import edu.miu.apartment.domain.StudentRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentChargesRepository extends CrudRepository<StudentCharges,Long> {
    public List<StudentCharges> findByStudentRoom(StudentRoom studentRoom);
}
