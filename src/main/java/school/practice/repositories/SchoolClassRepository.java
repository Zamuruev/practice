package school.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import school.practice.dtos.StudentDto;
import school.practice.models.SchoolClass;
import school.practice.models.Student;

import java.util.List;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass,Long> {
    /*List<SchoolClass> findAll(Long id);*/
    List<SchoolClass> findAllByName(String name);
    @Query("SELECT sc FROM SchoolClass sc JOIN sc.students st WHERE st.id = :studentId")
    List<SchoolClass> findSchoolClassByStudentId(@Param("studentId") Long studentId);

}
