package com.BRIS.Login.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "residents_details")
public class NewResident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "residents_id")
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "middle_name")
    private String middlename;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "suffix")
    private String suffix;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "civil_status")
    private String civilstatus;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "educational_attainment")
    private String education;

    @Column(name = "no_household")
    private String household;

    @Column(name = "contact_number")
    private String contactnumber;

    @Column(name = "email_address")
    private String email;

    @Column(name = "religion")
    private String religion;

    @Column(name = "sitio")
    private String sitio;

    @Column(name = "voter_status")
    private String voterstatus;

    @Column(name = "PWD")
    private boolean pwd;

    @Column(name = "blood_type")
    private String bloodtype;

    @Column(name = "senior")
    private Boolean senior;

    @Lob
    @Column(name = "residents_photo")
    private byte[] photo;



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSuffix() {
        return suffix;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCivilstatus() {
        return civilstatus;
    }
    public void setCivilstatus(String civilstatus) {
        this.civilstatus = civilstatus;
    }

    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }

    public String getHousehold() {
        return household;
    }
    public void setHousehold(String household) {
        this.household = household;
    }

    public String getContactnumber() {
        return contactnumber;
    }
    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getReligion() {
        return religion;
    }
    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSitio() {
        return sitio;
    }
    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getVoterstatus() {
        return voterstatus;
    }
    public void setVoterstatus(String voterstatus) {
        this.voterstatus = voterstatus;
    }

    public boolean isPwd() {
        return pwd;
    }
    public void setPwd(boolean pwd) {
        this.pwd = pwd;
    }

    public String getBloodtype() {
        return bloodtype;
    }
    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public Boolean getSenior() {
        return senior;
    }
    public void setSenior(Boolean senior) {
        this.senior = senior;
    }

    public byte[] getPhoto() {
        return photo;
    }
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
