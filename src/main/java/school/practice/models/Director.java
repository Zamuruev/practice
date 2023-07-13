package school.practice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "directors")
public class Director extends User {

    public Director(String surname, String name, String fatherName, Long phone) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.phone = phone;
    }

    protected Director() {}

}
