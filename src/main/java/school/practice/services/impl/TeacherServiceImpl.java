package school.practice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.practice.dtos.SubjectDto;
import school.practice.dtos.TeacherDto;
import school.practice.models.Teacher;
import school.practice.repositories.TeacherRepository;
import school.practice.services.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public TeacherDto register(TeacherDto teacher){
        /*Student s= modelMapper.map(student,Student.class);
        if (student.getSchoolClass().getId() != 0){
            SchoolClass g = schoolClassRepository.findById(student.getSchoolClass().getId()).get();
            s.setSchoolClass(g);
        }
        return modelMapper.map(studentRepository.save(s),StudentDto.class);*/
        return teacher;
    }

    @Override
    public List<TeacherDto> getAll() {
        return null;
    }

    @Override
    public void expel(TeacherDto teacher){teacherRepository.deleteById(teacher.getId());}


}
