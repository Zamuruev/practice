package school.practice.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.StudentDto;
import school.practice.dtos.SubjectDto;
import school.practice.services.SubjectService;

import java.util.Optional;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @GetMapping("/subjects")
    Iterable<SubjectDto> all(){return subjectService.getAll();}

    @PostMapping("/newSubject")
    SubjectDto newSubject(@RequestBody SubjectDto newSubject){return subjectService.register(newSubject);}

    @GetMapping("/subjects/schoolclass/{schoolclass}")
    SubjectDto one(@PathVariable SchoolClassDto schoolClass){
        return (SubjectDto) subjectService.findSubjectBySchoolClass(schoolClass.getName());
    }
    @DeleteMapping("/subject/delete/{id}")
    void deleteSubject(@PathVariable Long id){subjectService.expel(id);}

    @DeleteMapping("/subject/delete/{subject}")
    void deleteSubject(@PathVariable SubjectDto subject){subjectService.expel(subject.getId());}

    @GetMapping("/subject/{counthours}")
    SubjectDto one(@PathVariable SubjectDto subject){
        return (SubjectDto) subjectService.findSubjectByCounthoursOrderByCounthours(subject.getCountHours());
    }
    @GetMapping("/subject/{id}")
    SubjectDto one(@PathVariable Long id){
        Optional<SubjectDto> subject = subjectService.findSubject(id);
        return subject.orElse(null);
    }
}
