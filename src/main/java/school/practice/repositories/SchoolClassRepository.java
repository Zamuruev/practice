package school.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.practice.models.SchoolClass;

import java.util.List;

public interface SchoolClassRepository extends JpaRepository<SchoolClass,Long> {
    List<SchoolClass> findAllBy(Long id);
}
