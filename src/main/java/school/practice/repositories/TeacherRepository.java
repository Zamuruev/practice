package school.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.practice.dtos.TeacherDto;
import school.practice.models.Teacher;

import java.util.List;
import java.util.Set;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findSubjectsBySurname(String surname);

    Set<Teacher> findAllByNameIn(Set<TeacherDto> teachersDto);
}
