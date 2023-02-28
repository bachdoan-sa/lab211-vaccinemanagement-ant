/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.vaccine_management.dao.file;


import com.bach.vaccine_management.dao.VaccineDAO;
import com.bach.vaccine_management.dto.VaccineDTO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import java.util.ArrayList;

/**
 *
 * @author AN515-57
 */
public class VaccineIOFile implements IOFile{
    ArrayList<VaccineDTO> vaccineList = VaccineDAO.getVaccineList();
    private final String fileName="vaccine.dat";
    private final String url = ".\\";
    @Override
    public boolean writeFile() {
        
        if (vaccineList==null)
            vaccineList = new ArrayList<>();
        try{
            
            FileOutputStream file = new FileOutputStream(url + fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            vaccineList.add(new VaccineDTO("Covid-V001","AstraZeneca"));
            vaccineList.add(new VaccineDTO("Covid-V002","SPUTNIK V"));
            vaccineList.add(new VaccineDTO("Covid-V003","Vero Cell"));
            vaccineList.add(new VaccineDTO("Covid-V004","Pfizer"));
            vaccineList.add(new VaccineDTO("Covid-V005","Moderna"));  
            for(VaccineDTO vaccine: vaccineList) {
                oStream.writeObject(vaccine);
            }
            
            oStream.close();
            file.close();
            
            System.err.println("WriteFile "+fileName+" Successed!\n");
            return true;
        } catch (Exception e){
            System.err.println("WriteFile "+fileName+" Fail:" + e);
            return false;
        }
    }
    @Override
    public ArrayList<Object> readFile(){
        ArrayList list = new ArrayList<>();
        try{
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream oStream = new ObjectInputStream(file);
            
            //Take all Vaccine Object and add into list when it avaiable.
            while (true){
                VaccineDTO read = (VaccineDTO) oStream.readObject();
                list.add(read);
                if(file.available()< 1) break;
            }
            
            oStream.close();
            file.close();
            
            System.err.println("ReadFile "+fileName+" Successed!\n");
        } catch (Exception e){
            System.err.println("ReadFile "+fileName+" Fail:"+ e);
        }   
        return list;
    }
   
}
