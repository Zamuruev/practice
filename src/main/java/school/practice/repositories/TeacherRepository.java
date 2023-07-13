package school.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.practice.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
