package com.BRIS.Login.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "blotter")
public class NewBlotter {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_num")
    private Long id;

    @Getter
    @Setter
    @Column(name = "complainant_first_name")
    private String Comfirstname;

    @Getter
    @Setter
    @Column(name = "complainant_middle_name")
    private String Commiddlename;

    @Getter
    @Setter
    @Column(name = "complainant_last_name")
    private String Comlastname;

    @Getter
    @Setter
    @Column(name = "complainant_contact")
    private String Ccontact;

    @Getter
    @Setter
    @Column(name = "complainant_age")
    private String Cage;

    @Getter
    @Setter
    @Column(name = "complainant_address")
    private String Caddress;

    @Getter
    @Setter
    @Column(name = "blottered_first_name")
    private String Resfirstname;

    @Getter
    @Setter
    @Column(name = "blottered_middle_name")
    private String Resmiddlename;

    @Getter
    @Setter
    @Column(name = "blottered_last_name")
    private String Reslastname;

    @Getter
    @Setter
    @Column(name = "complained_contact")
    private String Rcontact;

    @Getter
    @Setter
    @Column(name = "complained_age")
    private String Rage;

    @Getter
    @Setter
    @Column(name = "case_no")
    private String caseno;

    @Getter
    @Setter
    @Column(name = "complained_address")
    private String Raddress;

    @Getter
    @Setter
    @Column(name = "date_of_complain")
    private String complaindate;

    @Getter
    @Setter
    @Column(name = "blotter_status")
    private String status;

    @Getter
    @Setter
    @Column(name = "location_of_incidence")
    private String location;

    @Getter
    @Setter
    @Column(name = "officer_in_charge")
    private String official;

    @Getter
    @Setter
    @Column(name = "statement_of_complain")
    private String casedescription;

    @Getter
    @Setter
    @Column(name = "action_taken")
    private String action;



}
