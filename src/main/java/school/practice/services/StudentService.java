package school.practice.services;

import school.practice.models.Student;

public interface StudentService<ID> {
    void register(Student student);
}
