/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.vaccine_management.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author AN515-57
 */
public class VaccineInjectionDTO implements Serializable {
    private String vaccineInjectionID;
    private String place;
    private Date injectionDate;
    private short injectionTurn;
    private String studentID; 
    private String vaccineID;

    public String getVaccineInjectionID() {
        return vaccineInjectionID;
    }

    public void setVaccineInjectionID(String vaccineInjectionID) {
        this.vaccineInjectionID = vaccineInjectionID;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getInjectionDate() {
        return injectionDate;
    }

    public void setInjectionDate(Date injectionDate) {
        this.injectionDate = injectionDate;
    }

    public short getInjectionTurn() {
        return injectionTurn;
    }

    public void setInjectionTurn(short injectionTurn) {
        this.injectionTurn = injectionTurn;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public VaccineInjectionDTO() {
    }

    public VaccineInjectionDTO(String vaccineInjectionID, String place, Date injectionDate, short injectionTurn, String studentID, String vaccineID) {
        this.vaccineInjectionID = vaccineInjectionID;
        this.place = place;
        this.injectionDate = injectionDate;
        this.injectionTurn = injectionTurn;
        this.studentID = studentID;
        this.vaccineID = vaccineID;
    }

    @Override
    public String toString() {
        return "VaccineInjectionDTO{" + "vaccineInjectionID=" + vaccineInjectionID + ", place=" + place + ", injectionDate=" + injectionDate + ", injectionTurn=" + injectionTurn + ", studentID=" + studentID + ", vaccineID=" + vaccineID + '}';
    }

    
    
    
}
