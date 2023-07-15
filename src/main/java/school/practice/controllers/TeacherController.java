package school.practice.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.practice.dtos.SubjectDto;
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

    //не уверена на счет правильности реализации функции поиска предметов по фамили преподавателя перепроверь
    @GetMapping("/teacher/subjects/{surname}")
    TeacherDto one(@PathVariable TeacherDto teacher){
        return (TeacherDto) teacherService.findSubjectsBySurname(teacher.getSurname());}

    @DeleteMapping("/teacher/delete/{id}")
    void deleteTeacher(@PathVariable Long id){teacherService.expel(id);}

    @DeleteMapping("/teacher/delete/{teacher}")
    void deleteTeacher(@PathVariable TeacherDto teacher){teacherService.expel(teacher.getId());}

}
