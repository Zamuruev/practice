package school.practice.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "students")
public class Student extends User {
    @ManyToOne(optional = false)
    @JoinColumn(name = "schoolclass_id", referencedColumnName = "id", nullable=false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private SchoolClass schoolClass;


    public Student(String surname, String name, String fatherName, Long phone) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.phone = phone;
    }

    protected Student(){}

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    @Override
    public String toString() {
        return "Student: " + this.id + ", " + this.surname
                + " " + this.name + " " + this.fatherName + ", phone: " + this.phone + ", class: " + this.schoolClass.getName();
    }

}
