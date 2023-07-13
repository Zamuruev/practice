package school.practice.models;


import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends User {

    public Teacher(String surname, String name, String fatherName, Long phone) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Teacher: " + this.id.toString() + ", " + this.surname
                + " " + this.name + " " + this.fatherName + ", phone: " + this.phone;
    }

    protected Teacher(){}

}
