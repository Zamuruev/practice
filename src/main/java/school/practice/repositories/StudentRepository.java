package school.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import school.practice.dtos.StudentDto;
import school.practice.models.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllBySurname(String surname);
    List<Student> findAllBySchoolClassName(String schoolClassName);
}
