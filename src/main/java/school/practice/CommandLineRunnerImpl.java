package school.practice;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import school.practice.dtos.SchoolClassDto;
import school.practice.dtos.StudentDto;
import school.practice.services.*;

import java.io.IOException;
import java.util.HashSet;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    private SchoolClassService schoolClassService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TeacherService teacherService;


    @Override
    public void run(String... args) throws Exception {
        seedData();
    }


    private void seedData() throws IOException {



        StudentDto s1 = new StudentDto("Брежнева", "Алена", "Владимировна", Long.parseLong("89250437014"),Long.parseLong("1"));
        StudentDto s2 = new StudentDto("Замуруев", "Роман", "Романович", Long.parseLong("8921414014"),Long.parseLong("2"));
        StudentDto s3 = new StudentDto("Мухлынкина", "Валентина", "Викторовна", Long.parseLong("89204927618"),Long.parseLong("3"));
        StudentDto s4 = new StudentDto("Карпушин", "Андрей", "Славович", Long.parseLong("8925023514"),Long.parseLong("4"));

        Set<StudentDto> students = new HashSet<StudentDto>();
        students.add(s1);
        students.add(s2);
        Set<StudentDto> students2 = new HashSet<StudentDto>();
        students.add(s3);
        students.add(s4);


        SchoolClassDto c1 = new SchoolClassDto(Long.parseLong("1"),"7А",students);
        SchoolClassDto c2 = new SchoolClassDto(Long.parseLong("2"),"8Б",students2);

        s1 = studentService.register(s1);
        s2 = studentService.register(s2);
        s3 = studentService.register(s3);
        s4 = studentService.register(s4);

    }

}
