package school.practice.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.practice.dtos.TeacherDto;
import school.practice.repositories.TeacherRepository;
import school.practice.services.TeacherService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService<Long> {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ModelMapper modelMapper;
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
    public List<TeacherDto> findSubjectsBySurname(String surname){
        return teacherRepository.findSubjectsBySurname(surname).stream().map((t)->modelMapper.map(t,TeacherDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<TeacherDto> getAll() {
        return null;
    }

    @Override
    public void expel(TeacherDto teacher){teacherRepository.deleteById(teacher.getId());}

    @Override
    public void expel(Long id){teacherRepository.deleteById(id);}
}
