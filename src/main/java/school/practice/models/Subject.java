package school.practice.models;

import jakarta.persistence.*;

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

    public Subject(String name, int counthours) {
        this.name = name;
        this.counthours = counthours;
    }

    protected Subject(){}

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getCounthours() {
        return counthours;
    }

    private void setCounthours(int counthours) {
        this.counthours = counthours;
    }

    @Override
    public String toString() {
        return "Subject: " + this.id.toString() + ", " + this.name + ",countHours " + this.counthours;
    }
}
