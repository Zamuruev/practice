package school.practice;

import java.util.List;
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
        // Выводим студентов из класса с ID = 1
        List<StudentDto> studentsInClass1 = schoolClassService.findStudentsBySchoolClass(1L);
        System.out.println("Студенты из класса с ID = 1:");
        for (StudentDto student : studentsInClass1) {
            System.out.println(student.toString());
        }
    }

    private void seedData() throws IOException {

        // Создаем объекты SchoolClassDto без установки идентификатора
        SchoolClassDto c1 = new SchoolClassDto(Long.parseLong("1"), "7А", null);
        SchoolClassDto c2 = new SchoolClassDto(Long.parseLong("2"), "8Б", null);

        // Регистрируем SchoolClassDto и получаем обновленные объекты с установленными идентификаторами
        c1 = schoolClassService.register(c1);
        c2 = schoolClassService.register(c2);

        // Создаем студентов
        StudentDto s1 = new StudentDto(Long.parseLong("1"),"Брежнева", "Алена", "Владимировна", Long.parseLong("89250437014"),Long.parseLong("1"));
        StudentDto s2 = new StudentDto(Long.parseLong("2"),"Замуруев", "Роман", "Романович", Long.parseLong("8921414014"), Long.parseLong("1"));
        StudentDto s3 = new StudentDto(Long.parseLong("3"),"Мухлынкина", "Валентина", "Викторовна", Long.parseLong("89204927618"), Long.parseLong("2"));
        StudentDto s4 = new StudentDto(Long.parseLong("4"),"Карпушин", "Андрей", "Славович", Long.parseLong("8925023514"), Long.parseLong("2"));

        // Регистрируем студентов
        s1 = studentService.register(s1);
        s2 = studentService.register(s2);
        s3 = studentService.register(s3);
        s4 = studentService.register(s4);
    }
}


