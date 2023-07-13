package school.practice.services;

import school.practice.dtos.StudentDto;
import school.practice.models.Student;

import java.util.List;

public interface StudentService<ID> {
    StudentDto register(StudentDto student);
    List<StudentDto> getAll();

}
