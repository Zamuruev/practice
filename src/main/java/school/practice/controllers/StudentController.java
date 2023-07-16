package school.practice.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.practice.dtos.StudentDto;
import school.practice.services.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public Iterable<StudentDto> all() {
        return studentService.getAll();
    }

    @PostMapping("/students")
    public StudentDto newStudent(@RequestBody StudentDto newStudent) {
        return studentService.register(newStudent);
    }

    @GetMapping("/students/byClass/{schoolClassName}")
    public List<StudentDto> findBySchoolClassName(@PathVariable String schoolClassName) {
        return studentService.findStudentsBySchoolClass(schoolClassName);
    }

    @GetMapping("/students/bySurname/{surname}")
    public List<StudentDto> findBySurname(@PathVariable String surname) {
        return studentService.findAllBySurname(surname);
    }

    @DeleteMapping("/students/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.expel(id);
    }

    @DeleteMapping("/students/deleteByDto")
    public void deleteStudent(@RequestBody StudentDto studentDto) {
        studentService.expel(studentDto);
    }

    @GetMapping("/students/{id}")
    public StudentDto one(@PathVariable Long id) {
        Optional<StudentDto> studentDto = studentService.findStudent(id);
        return studentDto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()).getBody();

    }

}
