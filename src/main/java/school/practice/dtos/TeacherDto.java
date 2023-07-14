package school.practice.dtos;

import java.util.Set;

public class TeacherDto {
    private Long id;
    private String surname;
    private String name;
    private String fatherName;
    private Long phone;
    private Set<String> schoolClassNames;
    private Set<String> subjectNames;

    public TeacherDto(String surname, String name, String fatherName, Long phone, Set<String> schoolClassNames, Set<String> subjectNames, Long id) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.phone = phone;
        this.schoolClassNames = schoolClassNames;
        this.subjectNames = subjectNames;
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Set<String> getSchoolClassNames() {
        return schoolClassNames;
    }

    public void setSchoolClassNames(Set<String> schoolClassNames) {
        this.schoolClassNames = schoolClassNames;
    }

    public Set<String> getSubjectNames() {
        return subjectNames;
    }

    public void setSubjectNames(Set<String> subjectNames) {
        this.subjectNames = subjectNames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
