package edu.miu.apartment.repository;

import edu.miu.apartment.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    public Student findByStudentId(Long id);
}
