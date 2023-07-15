package school.practice.services;

import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.StudentDto;
import school.practice.models.Student;

import java.util.List;

public interface StudentService<ID> {
    StudentDto register(StudentDto student);

    void expel(StudentDto student);

    void expel(ID id);

    void transfer(StudentDto student, SchoolClassDto schoolClassDto);

    List<StudentDto> findStudentsBySchoolClass(String schoolClassName);

    List<StudentDto> findAllBySurname(String surname);

    List<StudentDto> getAll();

}
