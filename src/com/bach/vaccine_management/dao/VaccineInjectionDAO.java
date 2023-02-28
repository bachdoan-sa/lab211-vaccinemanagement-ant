/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.vaccine_management.dao;

import com.bach.vaccine_management.dao.file.VaccineInjectionIOFile;
import com.bach.vaccine_management.dto.VaccineInjectionDTO;
import java.util.ArrayList;
import java.util.Date;
import origin.Support.SupportMethod;

/**
 *
 * @author AN515-57
 */
public class VaccineInjectionDAO {

    private static ArrayList<VaccineInjectionDTO> vaccineInjectionList = new ArrayList<>();

    public static ArrayList<VaccineInjectionDTO> getVaccineInjectionList() {
        return vaccineInjectionList;
    }

    public static void setVaccineInjectionList(ArrayList<VaccineInjectionDTO> vaccineInjectionList) {
        VaccineInjectionDAO.vaccineInjectionList = vaccineInjectionList;
    }
    
    public static void cloneList(){
        VaccineInjectionIOFile injio = new VaccineInjectionIOFile();
        setVaccineInjectionList((ArrayList<VaccineInjectionDTO>) injio.readFile().clone());
    }
    
    SupportMethod sp = new SupportMethod();
    StudentDAO stdao = new StudentDAO();
    VaccineDAO vcdao = new VaccineDAO();

    // The method Add Injection start form this.
    public boolean create() {
        try {
            
            System.out.print("Enter the Student ID: ");
            String studentID = sp.fixContent("studentID");
            int studentIndex = stdao.whereStudentExist(studentID);
            //if studentIndex == -1 then the List dont have that student
            while (studentIndex != -1) {
                short numberOfInjection = countInjectionByStudentID(studentID);
                boolean isAdd = add(numberOfInjection, studentID);
                if(isAdd)
                    break;
            }
            
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private short countInjectionByStudentID(String studentID) {
        short count = 0;
        for (VaccineInjectionDTO object : vaccineInjectionList) {
            if (studentID.equals(object.getStudentID())) {
                count++;
            }
        }
        System.out.printf("This student have: " + count + " Injection.");
        return count;
    }

    private boolean add(short injectionTurn, String studentID) {
        if (injectionTurn < 2) {
            System.out.printf("Enter the Injection ID:");
            String injectID = CheckInjectID();

            System.out.printf("Enter the Injection place:");
            String place = sp.fixContent("First Place");

            System.out.printf("Enter the Injection Date:");
            Date injectionDate = sp.catchDate();

            injectionTurn++;
            System.out.printf("Enter the VaccineID:");
            String vaccineID = vcdao.checkVaccine();

            VaccineInjectionDTO injection = new VaccineInjectionDTO(injectID, place, injectionDate, injectionTurn, studentID, vaccineID);
            vaccineInjectionList.add(injection);
            System.err.println("Add Successed");
        }
        return false;
    }

    private String CheckInjectID() {
        String ID = "";
        boolean isExist = true;
        do {
            ID = sp.fixContent("Injection ID");
            isExist = isInjectionExist(ID);
            if (isExist) {
//                System.out.println("Vaccine not exist.\n Do you want to read Injection List? ");
//                System.out.println("(1:yes | 0:No): \n-> choose:  ");
//                int chose = sp.switchInt(1);
//                if (chose == 1) {
//                    readList(vaccineInjectionList);
//                }
                System.out.println("Please re-enter Injection ID: ");
            }
        } while (isExist);
        return ID;
    }

    private boolean isInjectionExist(String ID) {

        for (VaccineInjectionDTO object : vaccineInjectionList) {
            if (object.getVaccineInjectionID().equals(ID)) {
                System.out.println("Injection Exist: " + object.getVaccineInjectionID());
                return true;
            }
        }
        return false;

    }
    //End of method Add Injection

}
