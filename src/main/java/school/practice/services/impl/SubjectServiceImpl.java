package school.practice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.practice.models.Subject;
import school.practice.repositories.SubjectRepository;
import school.practice.services.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public void register(Subject subject) {}

}
