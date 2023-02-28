/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package origin.Source;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author admin
 */

public class VaccineInjection extends Vaccine implements Serializable{
    private String VaccineInjectionID;
    private String firstPlace;
    private String secondPlace;
    private Date firstDateInjection;
    private Date secondDateInjection;
    private String studentID;    

    public String getVaccineInjectionID() {
        return VaccineInjectionID;
    }

    public void setVaccineInjectionID(String VaccineInjectionID) {
        this.VaccineInjectionID = VaccineInjectionID;
    }

    public String getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(String firstPlace) {
        this.firstPlace = firstPlace;
    }

    public String getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(String secondPlace) {
        this.secondPlace = secondPlace;
    }

    public Date getFirstDateInjection() {
        return firstDateInjection;
    }

    public void setFirstDateInjection(Date firstDateInjection) {
        this.firstDateInjection = firstDateInjection;
    }

    public Date getSecondDateInjection() {
        return secondDateInjection;
    }

    public void setSecondDateInjection(Date secondDateInjection) {
        this.secondDateInjection = secondDateInjection;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public VaccineInjection() {
    }

    public VaccineInjection(String VaccineInjectionID, String firstPlace, String secondPlace, Date firstDateInjection, Date secondDateInjection, String studentID, String vaccineID, String vaccineName) {
        super(vaccineID, vaccineName);
        this.VaccineInjectionID = VaccineInjectionID;
        this.firstPlace = firstPlace;
        this.secondPlace = secondPlace;
        this.firstDateInjection = firstDateInjection;
        this.secondDateInjection = secondDateInjection;
        this.studentID = studentID;
    }
    
    @Override
    public String toString() {
        return  "VaccineInjectionID=" + VaccineInjectionID + ", firstPlace=" + firstPlace + ", secondPlace=" + secondPlace + ", firstDateInjection=" + firstDateInjection + ", secondDateInjection=" + secondDateInjection + ", studentID=" + studentID +", vaccineID=" + getVaccineID() +", vaccineName=" + getVaccineName() + "}\n";
    }
    
    

}
