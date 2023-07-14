package school.practice.dtos;

public class StudentDto {
    private Long id;
    private String surname;
    private String name;
    private String fatherName;
    private Long phone;
    private SchoolClassDto schoolClassDto;


    public StudentDto(String surname, String name, String fatherName, Long phone, Long id, SchoolClassDto schoolClassDto) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.phone = phone;
        this.schoolClassDto = schoolClassDto;
    }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getFatherName() { return fatherName; }

    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public Long getPhone() { return phone; }

    public void setPhone(Long phone) { this.phone = phone; }

    public SchoolClassDto getSchoolClassDto() {
        return schoolClassDto;
    }

    public void setSchoolClassDto(SchoolClassDto schoolClassDto) {
        this.schoolClassDto = schoolClassDto;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    @Override
    public String toString() {
        return "Student: " + this.id + ", " + this.surname
                + " " + this.name + " " + this.fatherName + ", phone: " + this.phone + ", class: " + this.schoolClassDto.getName();
    }

}
