package school.practice.services;


import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.StudentDto;


import java.util.List;
import java.util.Optional;

public interface StudentService<ID> {
    StudentDto register(StudentDto student);

    void expel(StudentDto student);

    void expel(ID id);

    void transfer(StudentDto student, SchoolClassDto schoolClassDto);

    List<StudentDto> findStudentsBySchoolClass(String schoolClassName);


    List<StudentDto> getAll();

    Optional<StudentDto> findStudent(ID id);

    List<StudentDto> findAllBySurname(String surname);


}
