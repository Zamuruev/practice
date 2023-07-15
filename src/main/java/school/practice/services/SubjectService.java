package school.practice.services;

import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.SubjectDto;
import school.practice.dtos.TeacherDto;
import school.practice.models.SchoolClass;
import school.practice.models.Subject;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SubjectService<ID>{
    SubjectDto register(SubjectDto subject);

    void expel(SubjectDto subject);

    void expel(ID id);

    void transfer(SubjectDto subjectDto, Set<SchoolClass> schoolClasses);

    List<SubjectDto> findSubjectBySchoolClass(String schoolClass);

    List<SubjectDto> findSubjectByCounthoursOrderByCounthours(int counthours);

    List<SubjectDto> findSubjectsByTeachers(Set<TeacherDto> teachers);

    List<SubjectDto> getAll();
    Optional<SubjectDto> findSubject(ID id);

}
