package school.practice.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.practice.dtos.StudentDto;
import school.practice.services.StudentService;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    Iterable<StudentDto> all(){return studentService.getAll();}

    @PostMapping("/students")
    StudentDto newStudent(@RequestBody StudentDto newStudent){return studentService.register(newStudent);}

}
