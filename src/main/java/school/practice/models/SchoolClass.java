package school.practice.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "schoolclasses")
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private Set<Student> students;

    public SchoolClass(Long id) {
        this.id = id;
        students = new HashSet<Student>();
    }
    public SchoolClass(){}

    public Long getId() {return id;}

    public Set<Student> getStudents(){return students;}
    public  void setStudents(Set<Student> students){this.students=students;}

    public void setId(Long id) {this.id = id;}
}
