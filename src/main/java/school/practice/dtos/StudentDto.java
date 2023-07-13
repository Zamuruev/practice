package school.practice.dtos;

public class StudentDto {
    private SchoolClassDto schoolClass;
    private Long id;
    private String surname;
    private String name;
    private String fatherName;
    private Long phone;

    public StudentDto(Long id, String surname, String name, String fatherName, Long phone) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.phone = phone;
    }

    public StudentDto(){}
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getSurname() {return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getFatherName() {return fatherName;}

    public void setFatherName(String fatherName) {this.fatherName = fatherName;}

    public Long getPhone() {return phone;}

    public void setPhone(Long phone) {this.phone = phone;}

    public SchoolClassDto getSchoolClass(){return schoolClass;}

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", phone=" + phone +
                '}';
    }
}
