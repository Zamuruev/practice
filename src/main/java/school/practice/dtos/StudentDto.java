package school.practice.dtos;

public class StudentDto {
    private Long id;
    private String surname;
    private String name;
    private String fatherName;
    private Long phone;

    private Long schoolClassId;

    public StudentDto(Long id, String surname, String name, String fatherName, Long phone, Long schoolClassId) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.phone = phone;
        this.schoolClassId = schoolClassId;
    }
    public StudentDto() {
        // Пустой публичный конструктор необходим для ModelMapper
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(Long schoolClassId) {
        this.schoolClassId = schoolClassId;
    }


    @Override
    public String toString() {
        return "Student: " + this.id + ", " + this.surname
                + " " + this.name + " " + this.fatherName + ", phone: " + this.phone;
    }

}
