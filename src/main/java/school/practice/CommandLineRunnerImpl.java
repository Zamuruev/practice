package school.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import school.practice.services.*;

import java.io.IOException;

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


    }

}
