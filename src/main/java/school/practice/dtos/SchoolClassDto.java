package school.practice.dtos;

import java.util.Set;

public class SchoolClassDto {
    private Long id;
    private String name;
    private Set<String> studentNames;
    private Set<String> teacherNames;
    private Set<String> subjectNames;

    public SchoolClassDto(Long id, String name, Set<String> studentNames, Set<String> teacherNames, Set<String> subjectNames) {
        this.id = id;
        this.name = name;
        this.studentNames = studentNames;
        this.teacherNames = teacherNames;
        this.subjectNames = subjectNames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(Set<String> studentNames) {
        this.studentNames = studentNames;
    }

    public Set<String> getTeacherNames() {
        return teacherNames;
    }

    public void setTeacherNames(Set<String> teacherNames) {
        this.teacherNames = teacherNames;
    }

    public Set<String> getSubjectNames() {
        return subjectNames;
    }

    public void setSubjectNames(Set<String> subjectNames) {
        this.subjectNames = subjectNames;
    }

    @Override
    public String toString() {
        return "SchoolClass: " + this.id + ", " + this.name;
    }

}
