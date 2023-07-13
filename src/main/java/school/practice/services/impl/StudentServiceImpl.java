package school.practice.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.practice.dtos.StudentDto;
import school.practice.models.SchoolClass;
import school.practice.models.Student;
import school.practice.repositories.SchoolClassRepository;
import school.practice.repositories.StudentRepository;
import school.practice.services.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    private SchoolClassRepository schoolClassRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public StudentDto register(StudentDto student){
        Student s= modelMapper.map(student,Student.class);
        if (student.getSchoolClass().getId() != 0){
            SchoolClass g = schoolClassRepository.findById(student.getSchoolClass().getId()).get();
            s.setSchoolClass(g);
        }
        return modelMapper.map(studentRepository.save(s),StudentDto.class);
    }



    @Override
    public List<StudentDto> getAll() {
        return null;
    }


}

