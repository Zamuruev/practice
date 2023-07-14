package school.practice.services;

import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.SubjectDto;
import school.practice.dtos.TeacherDto;
import school.practice.models.Teacher;

import java.util.List;

public interface TeacherService <ID>{
    TeacherDto register(TeacherDto teacher);
    List<TeacherDto> getAll();

    void expel(TeacherDto teacher);
}
