package school.practice.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.practice.dtos.SubjectDto;

import school.practice.dtos.TeacherDto;
import school.practice.models.SchoolClass;
import school.practice.models.Subject;
import school.practice.models.Teacher;
import school.practice.repositories.SubjectRepository;
import school.practice.repositories.TeacherRepository;
import school.practice.services.SubjectService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService<Long> {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SubjectDto register(SubjectDto subject) {
        Subject s = modelMapper.map(subject, Subject.class);

        if (subject.getTeachersDto() != null && !subject.getTeachersDto().isEmpty()) {
            Set<Teacher> teachers = teacherRepository.findAllByNameIn(subject.getTeachersDto());
            s.setTeachers(teachers);
        }

        return modelMapper.map(subjectRepository.save(s), SubjectDto.class);
    }

    @Override
    public void expel(SubjectDto subject){ subjectRepository.deleteById(subject.getId()); }

    @Override
    public void expel(Long id) { subjectRepository.deleteById(id); }

    @Override
    public void transfer(SubjectDto subjectDto, Set<SchoolClass> schoolClasses) {
        Subject subject = subjectRepository.findById(subjectDto.getId()).orElse(null);

        if (subject != null) {
            // Удаляем предмет из старых классов, если он уже был связан с ними
            for (SchoolClass oldSchoolClass : subject.getSchoolClass()) {
                oldSchoolClass.getSubjects().remove(subject);
            }

            // Связываем предмет с новыми классами
            subject.setSchoolClass(schoolClasses);

            // Обновляем классы для каждого нового класса
            for (SchoolClass newSchoolClass : schoolClasses) {
                newSchoolClass.getSubjects().add(subject);
            }

            // Сохраняем обновленный объект Subject в базе данных
            subjectRepository.save(subject);
        } else {
            throw new IllegalArgumentException("Subject with ID " + subjectDto.getId() + " not found.");
        }
    }

    @Override
    public List<SubjectDto> findSubjectBySchoolClass(String schoolClass) {
        return subjectRepository.findSubjectBySchoolClass(schoolClass).stream().map(subject -> modelMapper.map(subject, SubjectDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<SubjectDto> findSubjectByCounthoursOrderByCounthours(int counthours) {
        return subjectRepository.findSubjectByCounthoursOrderByCounthours(counthours).stream().map((s) -> modelMapper.map(s, SubjectDto.class)).collect(Collectors.toList());

    }

    @Override
    public List<SubjectDto> findSubjectsByTeachers(Set<TeacherDto> teachers) {
        Set<Teacher> teacherEntities = teachers.stream().map(teacherDto -> modelMapper.map(teacherDto, Teacher.class)).collect(Collectors.toSet());

        List<Subject> subjects = subjectRepository.findSubjectsByTeachers(teacherEntities);

        return subjects.stream().map(subject -> modelMapper.map(subject, SubjectDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<SubjectDto> getAll() {
        return subjectRepository.findAll().stream().map((s) -> modelMapper.map(s, SubjectDto.class)).collect(Collectors.toList());
    }

}
