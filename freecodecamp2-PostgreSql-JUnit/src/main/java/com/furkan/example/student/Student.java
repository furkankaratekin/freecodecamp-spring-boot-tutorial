package com.furkan.example.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.furkan.example.school.School;
import com.furkan.example.studentprofile.StudentProfile;
import jakarta.persistence.*;

//Entity ile oluşturduğumuzda bizden bir tane değer ister onu da id'de
//annotation vererek çözeceğiz.
@Entity
@Table(name = "T STUDENT")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(
            name = "c fname",
            length = 20
    )
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private int age;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL )
    private StudentProfile studentProfile;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    @JsonBackReference
    private School school;
//    Bir tane de boş bir constructor oluşturuyoruz.

    public Student() {
    }


//    Constructor oluştururken id eklenmez çünkü örneğin post ile
//    istek atıyoruz ama id yi kullanıcı vermez biz kendimiz oluştururuz

    public Student(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
