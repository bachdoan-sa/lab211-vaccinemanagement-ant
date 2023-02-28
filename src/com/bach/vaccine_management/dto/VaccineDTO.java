/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.vaccine_management.dto;

import java.io.Serializable;

/**
 *
 * @author AN515-57
 */
public class VaccineDTO implements Serializable{
    private String vaccineID;
    private String vaccineName;

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
    
    public VaccineDTO(){   
    }

    public VaccineDTO(String vaccineID, String vaccineName) {
        this.vaccineID = vaccineID;
        this.vaccineName = vaccineName;
    }

    @Override
    public String toString() {
        return "VaccineDTO{" + "vaccineID=" + vaccineID + ", vaccineName=" + vaccineName + "}";
    }
    
}
