package school.practice.services;

import school.practice.dtos.SchoolClassDto;


public interface SchoolClassService<ID> {
    void register(SchoolClassDto schoolClass);
    void expel(SchoolClassDto schoolClass);
}
