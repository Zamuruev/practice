package school.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.practice.models.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
