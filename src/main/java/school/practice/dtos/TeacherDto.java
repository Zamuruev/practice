package school.practice.dtos;

public class TeacherDto {
    private Long id;
    private String surname;
    private String fatherName;
    private Long phone;

    public TeacherDto(Long id, String surname, String fatherName, Long phone) {
        this.id = id;
        this.surname = surname;
        this.fatherName = fatherName;
        this.phone = phone;
    }
    public TeacherDto(){}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getSurname() {return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public String getFatherName() {return fatherName;}

    public void setFatherName(String fatherName) {this.fatherName = fatherName;}

    public Long getPhone() {return phone;}

    public void setPhone(Long phone) {this.phone = phone;}
}
