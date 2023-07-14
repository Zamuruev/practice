package school.practice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.StudentDto;
import school.practice.dtos.SubjectDto;

import school.practice.dtos.TeacherDto;
import school.practice.repositories.SubjectRepository;
import school.practice.services.SubjectService;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public SubjectDto register(SubjectDto subject){
        /*Student s= modelMapper.map(student,Student.class);
        if (student.getSchoolClass().getId() != 0){
            SchoolClass g = schoolClassRepository.findById(student.getSchoolClass().getId()).get();
            s.setSchoolClass(g);
        }
        return modelMapper.map(studentRepository.save(s),StudentDto.class);*/
        return subject;
    }


    @Override
    public void expel(SubjectDto subject){subjectRepository.deleteById(subject.getId());}

    @Override
    public List<SubjectDto> getAll() {
        return null;
    }

}
