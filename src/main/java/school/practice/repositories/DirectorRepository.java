package school.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.practice.models.Director;
import school.practice.models.SchoolClass;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Long> {
    List<Director> findAllBy(Long id);
}