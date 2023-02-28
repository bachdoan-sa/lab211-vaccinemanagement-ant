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
public class StudentDTO implements Serializable{
    private String studentID;
    private String studentName;
    //getter & setter
    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    //Constructer
    public StudentDTO(){
    }

    public StudentDTO(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }
    //ToString()
    @Override
    public String toString() {
        return "StudentDTO{" + "studentID=" + studentID + ", studentName=" + studentName + "}";
    }
    
    //End of class StudentDTO 
}
