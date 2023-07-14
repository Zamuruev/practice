package school.practice.services;

import school.practice.dtos.SubjectDto;
public interface SubjectService<ID>{
    void register(SubjectDto subject);
    void expel(SubjectDto subject);

}
