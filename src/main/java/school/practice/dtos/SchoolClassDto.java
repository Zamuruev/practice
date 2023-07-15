package school.practice.dtos;

import java.util.Set;

public class SchoolClassDto {
    private Long id;
    private String name;
    private Set<StudentDto> students;


    public SchoolClassDto(Long id, String name,Set<StudentDto> students) {
        this.id = id;
        this.name = name;
        this.students=students;
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

    public Set<StudentDto> getStudents() {return students;}

    public void setStudents(Set<StudentDto> students) {this.students = students;}

    @Override
    public String toString() {
        return "SchoolClass: " + this.id + ", " + this.name;
    }

}
