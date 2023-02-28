/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.vaccine_management.dao;

import com.bach.vaccine_management.dao.file.StudentIOFile;
import com.bach.vaccine_management.dto.StudentDTO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author AN515-57
 */
public class StudentDAO implements CRUDInterface{
    
    
    private static ArrayList<StudentDTO> studentList = new ArrayList<>();
    
    public static ArrayList<StudentDTO> getStudentList() {
        return studentList;
    }

    public static void setStudentList(ArrayList<StudentDTO> studentList) {
        StudentDAO.studentList = studentList;
    }
    
    public static void cloneListTakeFromFile(){
        StudentIOFile stuio = new StudentIOFile();
        setStudentList((ArrayList<StudentDTO>) stuio.readFile().clone());
    }
    
    public void readStudentList() {
        System.out.printf("%-13s %-13s\n", "StudentID", "StudentName");
        for (StudentDTO s : studentList) {
            System.out.printf("%-13s %-13s\n", s.getStudentID(), s.getStudentName());
        }
    }
    
    public boolean isStudentExist(String studentID){
        for (StudentDTO studentObj : getStudentList()) {
            if (studentID.equals(studentObj.getStudentID())) {
                return true;
            }
        }
        return false;
    }
    public int whereStudentExist(String studentID){
        for (StudentDTO studentObj : getStudentList()) {
            if (studentID.equals(studentObj.getStudentID())) {
                return studentList.indexOf(studentObj);
            }
        }
        System.out.print("This Student ID don't exist.");
        return -1;
    }

    @Override
    public boolean readAllList(ArrayList<Class> arrayList) {
        try{
        System.out.printf("%-13s %-13s\n", "StudentID", "StudentName");
        for (StudentDTO s : studentList) {
            System.out.printf("%-13s %-13s\n", s.getStudentID(), s.getStudentName());
        }
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean createObjectInList(Object object, ArrayList<Class> arrayList) {
        try{
        Scanner sc = new Scanner(System.in);
        System.err.println("Enter Student's ID: ");
        String studentID = sc.nextLine();

        if (!isStudentExist(studentID)) {
            System.err.println("Enter Student's name: ");
            String studentName = sc.nextLine();
            StudentDTO stu = new StudentDTO(studentID, studentName);
            studentList.add(stu);
            System.err.println("Create Success!");
        } else {
            System.err.println("This student ID have Exist!");
        }
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateObjectInList(Object object, ArrayList<Class> arrayList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteObjectInList(Object object, ArrayList<Class> arrayList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
