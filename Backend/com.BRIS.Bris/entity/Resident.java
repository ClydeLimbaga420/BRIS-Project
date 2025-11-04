package com.BRIS.Login.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "residents_details")
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "residents_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sitio")
    private String sitio;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private int age;




    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getSitio() { return sitio; }
    public void setSitio(String sitio) { this.sitio = sitio; }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
