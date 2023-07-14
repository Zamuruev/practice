package school.practice.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.practice.dtos.TeacherDto;
import school.practice.services.TeacherService;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/teachers")
    Iterable<TeacherDto> all(){return teacherService.getAll();}

    @PostMapping("/newTeacher")
    TeacherDto newTeacher(@RequestBody TeacherDto newTeacher){return teacherService.register(newTeacher);}

}
