package com.BRIS.Login.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "residents_details")  // 👈 matches your MySQL table name
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "residents_id")
    private Long id;  // 👈 must match your primary key (change name if needed)

    @Column(name = "first_name")  // 👈 matches MySQL column
    private String firstName;

    @Column(name = "last_name")   // 👈 matches MySQL column
    private String lastName;

    @Column(name = "sitio")
    private String sitio;

    @Column(name = "age")
    private int age;

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getSitio() { return sitio; }
    public void setSitio(String sitio) { this.sitio = sitio; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
