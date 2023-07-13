package school.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.practice.models.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
