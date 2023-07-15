package school.practice.dtos;

import java.util.Set;

public class SubjectDto {
    private Long id;
    private String name;
    private int countHours;
    private Set<SchoolClassDto> schoolClassesDto;
    private Set<TeacherDto> teachersDto;

    public SubjectDto(Long id, String name, int countHours) {
        this.id = id;
        this.name = name;
        this.countHours = countHours;
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

    public Set<SchoolClassDto> getSchoolClassesDto() { return schoolClassesDto; }

    public void setSchoolClassesDto(Set<SchoolClassDto> schoolClassesDto) {
        this.schoolClassesDto = schoolClassesDto;
    }

    public Set<TeacherDto> getTeachersDto() { return teachersDto; }

    public void setTeachersDto(Set<TeacherDto> teachersDto) { this.teachersDto = teachersDto; }

    @Override
    public String toString() {
        return "Subject: " + id +", '" + name + '\'' + ", countHours: " + countHours;
    }

}
