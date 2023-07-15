package school.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.StudentDto;
import school.practice.models.SchoolClass;
import school.practice.models.Student;
import school.practice.services.SchoolClassService;

import java.util.Optional;


@RestController
public class SchoolClassController {
    @Autowired
    private SchoolClassService schoolClassService;
    @GetMapping("/schoolClasses")
    Iterable<SchoolClassDto> all(){return schoolClassService.getAll();}

    @GetMapping("/schoolclass/{student}")
    SchoolClassDto one(@PathVariable StudentDto student){
        return (SchoolClassDto) schoolClassService.findSchoolClassByStudent(student);
    }

    @DeleteMapping("/schoolclass/delete/{id}")
    void deleteSchoolClass(@PathVariable Long id){schoolClassService.expel(id);}

    @DeleteMapping("/schoolclass/delete/{schoolclass}")
    void deleteSchoolClass(@PathVariable SchoolClassDto schoolClass){schoolClassService.expel(schoolClass.getId());}

    @GetMapping("/schoolclass/{id}")
    SchoolClassDto one(@PathVariable Long id){
        Optional<SchoolClassDto> schoolClass = schoolClassService.findSchoolClass(id);
        return schoolClass.orElse(null);
    }
}
