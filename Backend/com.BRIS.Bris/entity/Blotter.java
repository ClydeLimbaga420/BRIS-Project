package com.BRIS.Login.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "blotter")
public class Blotter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_num")
    private Long id;

    @Column(name = "blottered_first_name")
    private String blotteredFirstName;

    @Column(name = "blottered_last_name")
    private String blotteredLastName;

    @Column(name = "blotter_status")
    private String blotterStatus;

    @Column(name = "case_no")
    private String caseNo;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String  getBlotteredFirstName() {
        return blotteredFirstName;
    }
    public void  setBlotteredFirstName(String blotteredFirstName) {
        this.blotteredFirstName = blotteredFirstName;
    }

    public String  getBlotteredLastName() {
        return blotteredLastName;
    }
    public void  setBlotteredLastName(String blotteredLastName) {
        this.blotteredLastName = blotteredLastName;
    }

    public String getBlotterStatus() {
        return blotterStatus;
    }
    public void setBlotterStatus(String blotterStatus) {
        this.blotterStatus = blotterStatus;
    }

    public String getCaseNo() {
        return caseNo;
    }
    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }


}
