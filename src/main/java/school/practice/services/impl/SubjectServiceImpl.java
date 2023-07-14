package school.practice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.practice.dtos.SubjectDto;

import school.practice.dtos.TeacherDto;
import school.practice.repositories.SubjectRepository;
import school.practice.services.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    public void register(SubjectDto subject) {}

    @Override
    public void expel(SubjectDto subject){subjectRepository.deleteById(subject.getId());}

}
