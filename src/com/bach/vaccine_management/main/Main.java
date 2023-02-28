/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.vaccine_management.main;

import com.bach.vaccine_management.dao.StudentDAO;
import com.bach.vaccine_management.dao.VaccineDAO;
import com.bach.vaccine_management.dao.VaccineInjectionDAO;
import com.bach.vaccine_management.dao.file.StudentIOFile;
import com.bach.vaccine_management.dao.file.VaccineIOFile;
import com.bach.vaccine_management.dao.file.VaccineInjectionIOFile;
import com.bach.vaccinemanagement.userinterface.console.ControlPanelInterface;

/**
 *
 * @author AN515-57
 */
public class Main {

    public static void main(String[] args) {
        StudentDAO.cloneListTakeFromFile();
        VaccineDAO.cloneListTakeFromFile();
        
        VaccineInjectionDAO injectdao = new VaccineInjectionDAO();
        ControlPanelInterface.showMainMenuInConsole();
        ControlPanelInterface.showPlaceToEnterMethodInConsole();
        
        injectdao.create();
    }
}
