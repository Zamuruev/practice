package school.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.practice.models.Subject;
@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
