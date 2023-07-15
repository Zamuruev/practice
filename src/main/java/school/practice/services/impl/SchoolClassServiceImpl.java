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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SchoolClassServiceImpl implements SchoolClassService<Long> {
    @Autowired
    SchoolClassRepository schoolClassRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SchoolClassDto register(SchoolClassDto schoolClassDto) {
        SchoolClass schoolClass = modelMapper.map(schoolClassDto, SchoolClass.class);
        return modelMapper.map(schoolClassRepository.save(schoolClass), SchoolClassDto.class);
    }

    @Override
    public List<SchoolClassDto> findSchoolClassByStudent(StudentDto studentDto) {
        List<SchoolClass> schoolClasses = schoolClassRepository.findSchoolClassByStudentId(studentDto.getId());
        return schoolClasses.stream()
                .map(s -> modelMapper.map(s, SchoolClassDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void expel(Long id){schoolClassRepository.deleteById(id);}

    @Override
    public void expel(SchoolClassDto schoolClass){schoolClassRepository.deleteById(schoolClass.getId());}

    @Override
    public List<SchoolClassDto> getAll() {
        return null;
    }

    @Override
    public Optional<SchoolClassDto> findSchoolClass(Long id){
        return Optional.ofNullable(modelMapper.map(schoolClassRepository.findById(id),SchoolClassDto.class));
    }
}
