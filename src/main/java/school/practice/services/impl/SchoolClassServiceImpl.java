package school.practice.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.StudentDto;
import school.practice.models.SchoolClass;
import school.practice.repositories.SchoolClassRepository;
import school.practice.services.SchoolClassService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolClassServiceImpl implements SchoolClassService<Long> {
    @Autowired
    SchoolClassRepository schoolClassRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public SchoolClassDto register(SchoolClassDto schoolClass){
        /*Student s= modelMapper.map(student,Student.class);
        if (student.getSchoolClass().getId() != 0){
            SchoolClass g = schoolClassRepository.findById(student.getSchoolClass().getId()).get();
            s.setSchoolClass(g);
        }
        return modelMapper.map(studentRepository.save(s),StudentDto.class);*/
        return schoolClass;
    }

    @Override
    public List<SchoolClassDto> findSchoolClassByStudent(StudentDto student){
        return schoolClassRepository.findSchoolClassByStudent(student).stream().map((s)->modelMapper.map(s,SchoolClassDto.class)).collect(Collectors.toList());
    }

    @Override
    public void expel(Long id){schoolClassRepository.deleteById(id);}

    @Override
    public void expel(SchoolClassDto schoolClass){schoolClassRepository.deleteById(schoolClass.getId());}

    @Override
    public List<SchoolClassDto> getAll() {
        return null;
    }

}
