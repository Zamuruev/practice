package school.practice.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.practice.dtos.SubjectDto;
import school.practice.services.SubjectService;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @GetMapping("/subjects")
    Iterable<SubjectDto> all(){return subjectService.getAll();}

    @PostMapping("/newSubject")
    SubjectDto newSubject(@RequestBody SubjectDto newSubject){return subjectService.register(newSubject);}


}
