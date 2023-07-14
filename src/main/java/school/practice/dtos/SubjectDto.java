package school.practice.dtos;

import java.util.Set;

public class SubjectDto {
    private Long id;
    private String name;
    private int countHours;
    private Set<String> schoolClassNames;
    private Set<String> teacherNames;

    public SubjectDto(Long id, String name, int countHours, Set<String> schoolClassNames, Set<String> teacherNames) {
        this.id = id;
        this.name = name;
        this.countHours = countHours;
        this.schoolClassNames = schoolClassNames;
        this.teacherNames = teacherNames;
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

    public int getCountHours() {
        return countHours;
    }

    public void setCountHours(int countHours) {
        this.countHours = countHours;
    }

    public Set<String> getSchoolClassNames() {
        return schoolClassNames;
    }

    public void setSchoolClassNames(Set<String> schoolClassNames) {
        this.schoolClassNames = schoolClassNames;
    }

    public Set<String> getTeacherNames() {
        return teacherNames;
    }

    public void setTeacherNames(Set<String> teacherNames) {
        this.teacherNames = teacherNames;
    }

    @Override
    public String toString() {
        return "Subject: " + id +", '" + name + '\'' + ", countHours: " + countHours;
    }
}
