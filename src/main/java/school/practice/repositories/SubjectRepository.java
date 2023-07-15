package school.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import school.practice.models.SchoolClass;
import school.practice.models.Subject;
import school.practice.models.Teacher;

import java.util.*;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query("SELECT DISTINCT s FROM Subject s JOIN s.teachers t WHERE t IN :teachers")
    List<Subject> findSubjectsByTeachers(@Param("teachers") Set<Teacher> teachers);

    List<Subject> findSubjectBySchoolClass(String schoolClass);

    List<Subject> findSubjectByCounthoursOrderByCounthours(int counthours);

}
