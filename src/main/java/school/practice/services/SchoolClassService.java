package school.practice.services;

import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.StudentDto;

import java.util.List;


public interface SchoolClassService<ID> {
    SchoolClassDto register(SchoolClassDto schoolClass);
    void expel(SchoolClassDto schoolClass);
    List<SchoolClassDto> getAll();
}
