package school.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.StudentDto;
import school.practice.models.Student;
import school.practice.services.SchoolClassService;


@RestController
public class SchoolClassController {
    @Autowired
    private SchoolClassService schoolClassService;
    @GetMapping("/schoolClasses")
    Iterable<SchoolClassDto> all(){return schoolClassService.getAll();}

    @PostMapping("/newSchoolClass")
    SchoolClassDto newSchoolClass(@RequestBody SchoolClassDto newSchoolClass){return schoolClassService.register(newSchoolClass);}

    @GetMapping("/schoolclass/student")
    SchoolClassDto one(@PathVariable StudentDto student){
        return (SchoolClassDto) schoolClassService.findSchoolClassByStudent(student);
    }

    @DeleteMapping("/schoolclass/delete/{id}")
    void deleteSchoolClass(@PathVariable Long id){schoolClassService.expel(id);}


}
