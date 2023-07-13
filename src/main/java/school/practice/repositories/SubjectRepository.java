package school.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.practice.models.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
