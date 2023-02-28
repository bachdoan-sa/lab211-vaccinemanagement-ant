package com.bach.vaccine_management.dao.file;

import com.bach.vaccine_management.dao.StudentDAO;
import com.bach.vaccine_management.dto.StudentDTO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AN515-57
 */
public class StudentIOFile implements IOFile{
    ArrayList<StudentDTO> studentList = StudentDAO.getStudentList();
    private final String fileName = "student.dat";
    
   
    @Override
    public boolean writeFile(){
        try{
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            
            studentList.add(new StudentDTO("SE15000", "Hoa Doan"));
            studentList.add(new StudentDTO("SE15021", "Hai Doan"));
            studentList.add(new StudentDTO("SE15032", "Phong Ha"));
            studentList.add(new StudentDTO("SE15001", "Nhat Tam"));
            studentList.add(new StudentDTO("SE15012", "Lam Thoi"));
            studentList.add(new StudentDTO("SE15002", "Hoa Ha"));
            studentList.add(new StudentDTO("SE15123", "Hai Loi"));
            studentList.add(new StudentDTO("SE15033", "Kiep Ha"));
            studentList.add(new StudentDTO("SE15011", "Nguyet Ha"));
            studentList.add(new StudentDTO("SE15017", "Lam Sac"));   
            
            for(StudentDTO s : studentList){
                oStream.writeObject(s);
            }
            
            oStream.close();
            file.close();
            System.err.println("WriteFile "+fileName+" Successed!");
            return true;
        } catch (IOException e){
            System.err.println("WriteFile "+fileName+" Fail!");
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
                StudentDTO read = (StudentDTO) oStream.readObject();
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
