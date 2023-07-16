package school.practice.controllers;

public class StudentNotFoundException extends RuntimeException {
    private Long studentId;

    public StudentNotFoundException(String surname) {
        super("Student with surname '" + surname + "' not found");
    }

    public Long getStudentId() {
        return studentId;
    }
}