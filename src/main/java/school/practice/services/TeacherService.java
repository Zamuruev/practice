package school.practice.services;

import school.practice.dtos.TeacherDto;
import school.practice.models.Teacher;

public interface TeacherService <ID>{
    void register(TeacherDto teacher);

    void expel(TeacherDto teacher);
}
