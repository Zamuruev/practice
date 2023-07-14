package school.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.practice.dtos.SchoolClassDto;
import school.practice.services.SchoolClassService;


@RestController
public class SchoolClassController {
    @Autowired
    private SchoolClassService schoolClassService;
    @GetMapping("/schoolClasses")
    Iterable<SchoolClassDto> all(){return schoolClassService.getAll();}

    @PostMapping("/newSchoolClass")
    SchoolClassDto newSchoolClass(@RequestBody SchoolClassDto newSchoolClass){return schoolClassService.register(newSchoolClass);}


}
