package school.practice.models;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends User {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_class",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "schoolclass_id"))
    private Set<SchoolClass> schoolClasses;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_subject",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects;

    public Teacher(String surname, String name, String fatherName, Long phone) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.phone = phone;
    }

    protected Teacher() {}

    public Set<SchoolClass> getSchoolClasses() { return schoolClasses; }

    public void setSchoolClasses(Set<SchoolClass> schoolClasses) { this.schoolClasses = schoolClasses; }

    public Set<Subject> getSubjects() { return subjects; }

    public void setSubjects(Set<Subject> subjects) { this.subjects = subjects; }

    @Override
    public String toString() {
        return "Teacher: " + this.id.toString() + ", " + this.surname
                + " " + this.name + " " + this.fatherName + ", phone: " + this.phone + ", sunjects: " + this.subjects.toString();
    }

}
