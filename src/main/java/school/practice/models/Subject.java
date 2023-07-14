package school.practice.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;

    @Column(name = "counthours")
    int counthours;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "class_subject",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "schoolclass_id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<SchoolClass> schoolClass;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_subject",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Teacher> teachers;

    public Subject(String name, int counthours) {
        this.name = name;
        this.counthours = counthours;
    }

    protected Subject(){}

    public Long getId() { return id; }

    private void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    private void setName(String name) { this.name = name; }

    public int getCounthours() { return counthours; }

    private void setCounthours(int counthours) { this.counthours = counthours; }

    public SchoolClass getSchoolClass() { return (SchoolClass) schoolClass; }

    public void setSchoolClass(SchoolClass schoolClass) { this.schoolClass = (Set<SchoolClass>) schoolClass; }

    public void setSchoolClass(Set<SchoolClass> schoolClass) { this.schoolClass = schoolClass; }

    public Set<Teacher> getTeachers() { return teachers; }

    public void setTeachers(Set<Teacher> teachers) { this.teachers = teachers; }


    @Override
    public String toString() {
        return "Subject: " + this.id.toString() + ", " + this.name + ",countHours " + this.counthours;
    }
}
