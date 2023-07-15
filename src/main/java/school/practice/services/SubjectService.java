package school.practice.services;

import school.practice.dtos.SubjectDto;
import school.practice.models.SchoolClass;
import school.practice.models.Subject;

import java.util.List;
import java.util.Set;

public interface SubjectService<ID>{
    SubjectDto register(SubjectDto subject);

    void expel(SubjectDto subject);

    void expel(ID id);

    void transfer(SubjectDto subjectDto, Set<SchoolClass> schoolClasses);

    List<SubjectDto> findSubjectBySchoolClass(String schoolClass);

    List<SubjectDto> findSubjectByCounthoursOrderByCounthours(int counthours);

    List<SubjectDto> getAll();

}
