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
import java.util.stream.Collectors;

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
        SchoolClass oldClass = s.getSchoolClass(); // Получаем текущий класс студента
        if (oldClass != null) {
            oldClass.getStudents().remove(s); // Удаляем студента из старого класса
        }
        s.setSchoolClass(sc); // Обновляем класс студента
        sc.getStudents().add(s); // Добавляем студента в новый класс
        studentRepository.save(s);
    }

    @Override
    public List<StudentDto> findStudentsBySchoolClass(String schoolClassName) {
        return studentRepository.findAllBySchoolClassName(schoolClassName).stream().map((s) -> modelMapper.map(s, StudentDto.class)).collect(Collectors.toList());

    }

    @Override
    public List<StudentDto> findAllBySurname(String surname) {
        return studentRepository.findAllBySurname(surname).stream().map((s) -> modelMapper.map(s, StudentDto.class)).collect(Collectors.toList());
    }


    @Override
    public List<StudentDto> getAll() {
        return studentRepository.findAll().stream().map((s) -> modelMapper.map(s, StudentDto.class)).collect(Collectors.toList());
    }


}

