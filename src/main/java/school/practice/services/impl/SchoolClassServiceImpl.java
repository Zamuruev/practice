package school.practice.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.StudentDto;
import school.practice.models.SchoolClass;
import school.practice.repositories.SchoolClassRepository;
import school.practice.services.SchoolClassService;
import org.hibernate.Hibernate;

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
    public Optional<SchoolClassDto> findSchoolClass(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void expel(SchoolClassDto schoolClass){schoolClassRepository.deleteById(schoolClass.getId());}

    @Override
    public List<SchoolClassDto> getAll() {
        return null;
    }

    @Transactional
    @Override
    public List<StudentDto> findStudentsBySchoolClass(Long schoolClassId) {
        SchoolClass schoolClass = schoolClassRepository.findById(schoolClassId).orElse(null);
        if (schoolClass != null) {
            // Принудительно инициализируем коллекцию students, чтобы избежать ошибки LazyInitializationException
            Hibernate.initialize(schoolClass.getStudents());
            return schoolClass.getStudents().stream()
                    .map(student -> modelMapper.map(student, StudentDto.class))
                    .collect(Collectors.toList());
        } else {
            return null;
        }

}
}
