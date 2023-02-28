/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.vaccine_management.dao;

import com.bach.vaccine_management.dao.file.VaccineIOFile;
import com.bach.vaccine_management.dto.VaccineDTO;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import origin.Support.SupportMethod;

/**
 *
 * @author AN515-57
 */
public class VaccineDAO {
    SupportMethod sp = new SupportMethod();
    private static ArrayList<VaccineDTO> vaccineList;

    public static ArrayList<VaccineDTO> getVaccineList() {
        return vaccineList;
    }

    public static void setVaccineList(ArrayList<VaccineDTO> vaccineList) {
        VaccineDAO.vaccineList = vaccineList;
    }

    public VaccineDAO() {
        VaccineDAO.vaccineList = new ArrayList<>();
    }
    
    public static void cloneListTakeFromFile(){
        VaccineIOFile vacio = new VaccineIOFile();
        setVaccineList((ArrayList<VaccineDTO>) vacio.readFile().clone());
    }
    
    public boolean addIntoList() {
        ArrayList<VaccineDTO> list = getVaccineList();
        Scanner sc = new Scanner(System.in);
        System.err.print("Enter ID: ");
        String ID = sc.nextLine();
        System.err.print("Enter name: ");
        String name = sc.nextLine();

        VaccineDTO vac = new VaccineDTO(ID, name);
        list.add(vac);

        setVaccineList(vaccineList);
        return true;
    }

    public void readList(ArrayList<VaccineDTO> list) {
        System.out.printf("%-13s %-13s\n", "VaccineID", "VaccineName");
        for (VaccineDTO s : list) {
            System.out.printf("%-13s %-13s\n", s.getVaccineID(), s.getVaccineName());
        }
    }

    private boolean isVaccineExist(String ID) {
        for (VaccineDTO s : vaccineList) {
            if (s.getVaccineID().equals(ID)) { 
                System.out.println("Vaccine found: " + s.getVaccineName());
                return true;             
            }
        }
        return false;
    }

    public String checkVaccine() {
        String ID = "";
        boolean isExist;
        do {
            ID = sp.fixContent("VaccineID");
            isExist = isVaccineExist(ID);
            if (!isExist) {
                System.out.println("Vaccine not exist.\n Do you want to read Vaccine List? ");
                System.out.println("(1:yes | 0:No): \n-> choose:  ");
                int chose = sp.switchInt(1);
                if (chose == 1) {
                    readList(vaccineList);
                }
                System.out.println("Please re-enter Vaccine ID: ");
            }
        } while (!isExist);
        return ID;
    }
    
}
