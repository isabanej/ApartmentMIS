package edu.miu.apartment.repository;

import edu.miu.apartment.domain.Room;
import edu.miu.apartment.domain.Student;
import edu.miu.apartment.domain.StudentRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRoomRepository extends CrudRepository<StudentRoom, Long> {
    StudentRoom findByStudentAndRoom(Student student, Room room);
    StudentRoom findByStudent(Student student);
    StudentRoom findByRoom(Room room);
}
