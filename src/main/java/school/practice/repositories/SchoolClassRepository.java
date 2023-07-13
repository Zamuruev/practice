package school.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.practice.models.SchoolClass;

public interface SchoolClassRepository extends JpaRepository<SchoolClass,Long> {
}
