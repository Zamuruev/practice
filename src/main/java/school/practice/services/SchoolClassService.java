package school.practice.services;

import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.StudentDto;

import java.util.List;
import java.util.Optional;


public interface SchoolClassService<ID> {
    void expel(SchoolClassDto schoolClass);
    void expel(ID id);
    Optional<SchoolClassDto> findSchoolClass(ID id);

    SchoolClassDto register(SchoolClassDto schoolClassDto);

    List<SchoolClassDto> findSchoolClassByStudent(StudentDto student);

    List<SchoolClassDto> getAll();

    List<StudentDto> findStudentsBySchoolClass(Long schoolClassId);

}
