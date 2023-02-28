/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.vaccine_management.dao.file;

import com.bach.vaccine_management.dao.VaccineInjectionDAO;
import com.bach.vaccine_management.dto.VaccineInjectionDTO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author AN515-57
 */
public class VaccineInjectionIOFile implements IOFile{
    
    @Override
    public boolean writeFile(){
        String fileName="injection.dat";
        try{
           
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            
            for(VaccineInjectionDTO vi : VaccineInjectionDAO.getVaccineInjectionList()){
                oStream.writeObject(vi);
            }
            
            oStream.close();
            file.close();
            System.err.println("WriteFile "+fileName+" Successed!\n");
            return true;
        } catch (Exception e){
            System.err.println("WriteFile "+fileName+" Fail!\n");
            return false;
        }
    }
    
    
    @Override
    public ArrayList<Object> readFile(){
        String fileName="injection.dat";
        ArrayList list = new ArrayList<>();
        try{
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream oStream = new ObjectInputStream(file);
            
            
            while (true){
                var read = (VaccineInjectionDTO) oStream.readObject();
                list.add(read);
                if(file.available()< 1) break;
            }
            
            
            oStream.close();
            file.close();
            System.err.println("ReadFile "+fileName+" Successed!\n");
        } catch (Exception e){
            System.err.println("ReadFile "+fileName+" Fail!\n");
        }
        return list;
    }
}
