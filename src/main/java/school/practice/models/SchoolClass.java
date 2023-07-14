package school.practice.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.*;

@Entity
@Table(name = "schoolclasses")
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "schoolClass")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Student> students;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_class",
            joinColumns = @JoinColumn(name = "schoolclass_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Teacher> teachers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "class_subject",
            joinColumns = @JoinColumn(name = "schoolclass_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Subject> subjects;

    public SchoolClass(String name) {
        this.name = name;
        students = new HashSet<Student>();
        teachers = new HashSet<Teacher>();
        subjects = new HashSet<Subject>();
    }
    protected SchoolClass(){}

    public Long getId() { return id; }

    protected void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    protected void setName(String name) { this.name = name; }

    public Set<Student> getStudents() { return students; }

    public void setStudents(Set<Student> students) { this.students = students; }

    public Set<Teacher> getTeachers() { return teachers; }

    public void setTeachers(Set<Teacher> teachers) { this.teachers = teachers; }

    public Set<Subject> getSubjects() { return subjects; }

    public void setSubjects(Set<Subject> subjects) { this.subjects = subjects; }

    @Override
    public String toString() {
        return "SchoolClass: " + this.id + ", " + this.name;
    }

}
