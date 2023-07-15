package school.practice.controllers;

public class StudentNotFoundException extends RuntimeException {
    private Long studentId;

    public StudentNotFoundException(Long studentId) {
        super("Student with ID " + studentId + " not found");
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }
}