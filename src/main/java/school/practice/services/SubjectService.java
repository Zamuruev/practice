package school.practice.services;

import school.practice.dtos.StudentDto;
import school.practice.dtos.SubjectDto;

import java.util.List;

public interface SubjectService<ID>{
    SubjectDto register(SubjectDto subject);
    void expel(SubjectDto subject);
    List<SubjectDto> getAll();

}
