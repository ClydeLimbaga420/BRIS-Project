package com.BRIS.Login.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "blotter")
public class NewBlotter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_num")
    private Long id;

    @Column(name = "complainant_first_name")
    private String Comfirstname;

    @Column(name = "complainant_middle_name")
    private String Commiddlename;

    @Column(name = "complainant_last_name")
    private String Comlastname;

    @Column(name = "complainant_contact")
    private String Ccontact;

    @Column(name = "complainant_age")
    private String Cage;

    @Column(name = "complainant_address")
    private String Caddress;

    @Column(name = "blottered_first_name")
    private String Resfirstname;

    @Column(name = "blottered_middle_name")
    private String Resmiddlename;

    @Column(name = "blottered_last_name")
    private String Reslastname;

    @Column(name = "complained_contact")
    private String Rcontact;

    @Column(name = "complained_age")
    private String Rage;

    @Column(name = "case_no")
    private String caseno;

    @Column(name = "complained_address")
    private String Raddress;

    @Column(name = "date_of_complain")
    private String complaindate;

    @Column(name = "blotter_status")
    private String status;

    @Column(name = "location_of_incidence")
    private String location;

    @Column(name = "officer_in_charge")
    private String official;

    @Column(name = "statement_of_complain")
    private String casedescription;

    @Column(name = "action_taken")
    private String action;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getComfirstname() {
        return Comfirstname;
    }
    public void setComfirstname(String Comfirstname) {
        this.Comfirstname = Comfirstname;
    }

    public String getCommiddlename() {
        return Commiddlename;
    }
    public  void setCommiddlename(String Commiddlename) {
        this.Commiddlename = Commiddlename;
    }

    public String getComlastname() {
        return Comlastname;
    }
    public void setComlastname(String Comlastname) {
        this.Comlastname = Comlastname;
    }

    public String getCcontact() {
        return Ccontact;
    }
    public void setCcontact(String Ccontact) {
        this.Ccontact = Ccontact;
    }

    public String getCage() {
        return Cage;
    }
    public void setCage(String Cage) {
        this.Cage = Cage;
    }

    public String getCaddress() {
        return Caddress;
    }
    public void setCaddress(String Caddress) {
        this.Caddress = Caddress;
    }

    public String  getResfirstname() {
        return Resfirstname;
    }
    public void setResfirstname(String Resfirstname) {
        this.Resfirstname = Resfirstname;
    }

    public String  getResmiddlename() {
        return Resmiddlename;
    }
    public void setResmiddlename(String Resmiddlename) {
        this.Resmiddlename = Resmiddlename;
    }

    public String getReslastname() {
        return Reslastname;
    }
    public void setReslastname(String Reslastname) {
        this.Reslastname = Reslastname;
    }

    public String getRcontact() {
        return Rcontact;
    }
    public void setRcontact(String Rcontact) {
        this.Rcontact = Rcontact;
    }

    public String getRage() {
        return Rage;
    }
    public void setRage(String Rage) {
        this.Rage = Rage;
    }

    public String getCaseno() {
        return caseno;
    }
    public void setCaseno ( String caseno ) {
        this.caseno = caseno;
    }

    public String getRaddress() {
        return Raddress;
    }
    public void setRaddress ( String Raddress ) {
        this.Raddress = Raddress;
    }

    public String getComplaindate() {
        return complaindate;
    }
    public void setComplaindate ( String complaindate ) {
        this.complaindate = complaindate;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus ( String status ) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation ( String location ) {
        this.location = location;
    }

    public String getOfficial() {
        return official;
    }
    public void setOfficial ( String official ) {
        this.official = official;
    }

    public String getCasedescription() {
        return casedescription;
    }
    public void setCasedescription ( String casedescription ) {
        this.casedescription = casedescription;
    }

    public String getAction() {
        return action;
    }
    public void setAction ( String action ) {
        this.action = action;
    }
}
