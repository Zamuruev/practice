package school.practice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.StudentDto;
import school.practice.models.SchoolClass;
import school.practice.repositories.SchoolClassRepository;
import school.practice.services.SchoolClassService;

import java.util.List;

@Service
public class SchoolClassServiceImpl implements SchoolClassService<Long> {
    @Autowired
    SchoolClassRepository schoolClassRepository;
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
    public void expel(SchoolClassDto schoolClass){schoolClassRepository.deleteById(schoolClass.getId());}

    @Override
    public List<SchoolClassDto> getAll() {
        return null;
    }

}
