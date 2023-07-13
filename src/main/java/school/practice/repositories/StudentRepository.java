package school.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.practice.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
