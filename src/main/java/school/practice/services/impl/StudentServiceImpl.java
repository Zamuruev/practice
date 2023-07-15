package school.practice.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.StudentDto;
import school.practice.models.SchoolClass;
import school.practice.models.Student;
import school.practice.repositories.SchoolClassRepository;
import school.practice.repositories.StudentRepository;
import school.practice.services.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService<Long> {
    @Autowired
    private StudentRepository studentRepository;
    private SchoolClassRepository schoolClassRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public StudentDto register(StudentDto student){
        Student s = modelMapper.map(student,Student.class);
        if (student.getSchoolClass().getId() != 0){
            SchoolClass sc = schoolClassRepository.findById(student.getSchoolClass().getId()).get();
            s.setSchoolClass(sc);
        }
        return modelMapper.map(studentRepository.save(s),StudentDto.class);
    }

    @Override
    public void expel(StudentDto student){ studentRepository.deleteById(student.getId());}

    @Override
    public void expel(Long id) { studentRepository.deleteById(id); }

    @Override
    public void transfer(StudentDto student, SchoolClassDto schoolClassDto) {
        Student s = studentRepository.findById(student.getId()).get();
        SchoolClass sc = schoolClassRepository.findById(schoolClassDto.getId()).get();
        s.setSchoolClass(sc);
        studentRepository.save(s);
    }

    @Override
    public List<StudentDto> findStudentsBySchoolClass(SchoolClassDto schoolClassDto) {
        return null;
    }


    @Override
    public List<StudentDto> getAll() {
        return null;
    }


}

