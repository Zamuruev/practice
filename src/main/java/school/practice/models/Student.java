package school.practice.models;

import jakarta.persistence.*;
@Entity
@Table(name = "students")
public class Student extends User {

    private SchoolClass schoolClass;

    public Student(String surname, String name, String fatherName, Long phone) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.phone = phone;
        this.schoolClass = schoolClass;
    }

    @Override
    public String toString() {
        return "Student: " + this.id.toString() + ", " + this.surname
                + " " + this.name + " " + this.fatherName + ", phone: " + this.phone;
    }

    protected Student(){}

    public SchoolClass getSchoolClass(){return schoolClass;}

    public void setSchoolClass(SchoolClass schoolClass){this.schoolClass=schoolClass;}
}
