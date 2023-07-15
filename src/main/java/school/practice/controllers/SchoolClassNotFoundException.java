package school.practice.controllers;

public class SchoolClassNotFoundException extends RuntimeException {
    private Long schoolClassId;

    public SchoolClassNotFoundException(Long schoolClassId) {
        super("School class with ID " + schoolClassId + " not found");
        this.schoolClassId = schoolClassId;
    }

    public Long getSchoolClassId() {
        return schoolClassId;
    }
}
