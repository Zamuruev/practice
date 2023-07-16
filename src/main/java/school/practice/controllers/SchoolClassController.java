package school.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.StudentDto;
import school.practice.services.SchoolClassService;
import school.practice.services.StudentService;

import java.util.Optional;


@RestController
public class SchoolClassController {
    @Autowired
    private SchoolClassService schoolClassService;

    @Autowired
    private StudentService studentService;


    @GetMapping("/schoolClass")
    public Iterable<SchoolClassDto> all() {
        return schoolClassService.getAll();
    }

    @GetMapping("/schoolClass/{studentId}")
    SchoolClassDto one(@PathVariable Long studentId) {
        Optional<StudentDto> studentDto = studentService.findStudent(studentId);
        if (studentDto.isPresent()) {
            return (SchoolClassDto) schoolClassService.findSchoolClassByStudent(studentDto.get());
        } else {
            // Если студент не найден, вернем null
            return null;
        }
    }

    @DeleteMapping("/schoolClass/delete/{id}")
    void deleteSchoolClass(@PathVariable Long id) {
        schoolClassService.expel(id);
    }

}
