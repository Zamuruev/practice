package school.practice.models;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;


    @Column(name = "surname", length = 15, nullable = false)
    protected String surname;

    @Column(name = "name", length = 15, nullable = false)
    protected String name;

    @Column(name = "fatherName", length = 15, nullable = true)
    protected String fatherName;

    @Column(name = "phone", length = 30, nullable = true)
    protected Long phone;

    public String getSurname() { return surname; }

    protected void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }

    protected void setName(String name) { this.name = name; }

    public String getFatherName() { return fatherName; }

    protected void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public Long getPhone() { return phone; }

    protected void setPhone(Long phone) { this.phone = phone; }

}
