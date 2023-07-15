package school.practice.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.practice.dtos.SchoolClassDto;
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

    @GetMapping("/students/{schoolClassName}")
    StudentDto one(@PathVariable SchoolClassDto schoolClass){
        return (StudentDto) studentService.findStudentsBySchoolClass(schoolClass.getName());
    }

    @GetMapping("/student/{surname}")
    StudentDto one(@PathVariable StudentDto student){
        return (StudentDto) studentService.findAllBySurname(student.getSurname());
    }

    @DeleteMapping("/student/delete/{id}")
    void deleteStudent(@PathVariable Long id){studentService.expel(id);}

    @DeleteMapping("/student/{student}")
    void deleteStudent(@PathVariable StudentDto student){studentService.expel(student.getId());}


}
