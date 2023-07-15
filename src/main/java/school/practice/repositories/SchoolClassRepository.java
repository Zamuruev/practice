package school.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.practice.dtos.StudentDto;
import school.practice.models.SchoolClass;
import school.practice.models.Student;

import java.util.List;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass,Long> {
    List<SchoolClass> findAllBy(Long id);
    List<SchoolClass> findAllByName(String name);
    List<SchoolClass> findSchoolClassByStudent(StudentDto student);
}
