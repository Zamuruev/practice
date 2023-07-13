package school.practice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.practice.models.Student;
import school.practice.repositories.StudentRepository;
import school.practice.services.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void register(Student student) {}


}

