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

import java.util.Collections;
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
    public SchoolClassDto findSchoolClassByStudent(StudentDto studentDto) {
        List<SchoolClass> schoolClasses = schoolClassRepository.findSchoolClassByStudentId(studentDto.getId());
        if (!schoolClasses.isEmpty()) {
            // Предполагаем, что студент принадлежит только одному школьному классу
            SchoolClass schoolClass = schoolClasses.get(0);
            // Принудительно инициализируем коллекцию students, чтобы избежать ошибки LazyInitializationException
            Hibernate.initialize(schoolClass.getStudents());
            return modelMapper.map(schoolClass, SchoolClassDto.class);
        } else {
            // Если школьный класс не найден, вернем null
            return null;
        }
    }

    @Override
    public void expel(Long id){schoolClassRepository.deleteById(id);}

    @Override
    public Optional<SchoolClassDto> findSchoolClass(Long id){
        return Optional.ofNullable(modelMapper.map(schoolClassRepository.findById(id),SchoolClassDto.class));
    }

    @Override
    public void expel(SchoolClassDto schoolClass){schoolClassRepository.deleteById(schoolClass.getId());}

    @Override
    public List<SchoolClassDto> getAll() {
        return schoolClassRepository.findAll().stream().map((s) -> modelMapper.map(s, SchoolClassDto.class)).collect(Collectors.toList());
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
