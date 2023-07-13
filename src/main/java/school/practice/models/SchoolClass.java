package school.practice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "schoolclasses")
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

}
