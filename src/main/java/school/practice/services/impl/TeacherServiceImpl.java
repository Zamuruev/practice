package school.practice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.practice.models.Teacher;
import school.practice.repositories.TeacherRepository;
import school.practice.services.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public void register(Teacher teacher) {}


}
