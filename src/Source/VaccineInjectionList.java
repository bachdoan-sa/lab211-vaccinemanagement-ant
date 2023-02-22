/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import Support.SupportMethod;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author admin
 */
public class VaccineInjectionList{
    List<Student> studentList = new ArrayList<>();
    List<Vaccine> vaccineList = new ArrayList<>();
    List<VaccineInjection> vaccineInjectionList = new ArrayList<>();
    public VaccineInjectionList(){
        studentList = new ArrayList<>();
        vaccineList = new ArrayList<>();
        vaccineInjectionList = new ArrayList<>();
    }
    public VaccineInjectionList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    public void msg(String mess){
        System.out.print(mess);
    }
    Scanner sc = new Scanner(System.in);
    SupportMethod sp = new SupportMethod();
    public void writeVaccine() {
        String fileName="vaccine.dat";
        try{
            
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            
            vaccineList.add(new Vaccine("Covid-V001","AstraZeneca"));
            vaccineList.add(new Vaccine("Covid-V002","SPUTNIK V"));
            vaccineList.add(new Vaccine("Covid-V003","Vero Cell"));
            vaccineList.add(new Vaccine("Covid-V004","Pfizer"));
            vaccineList.add(new Vaccine("Covid-V005","Moderna"));  
            
            for(Vaccine vc: vaccineList) {
                oStream.writeObject(vc);
            }
            
            oStream.close();
            file.close();
            msg("WriteFile "+fileName+" Successed!\n");
        } catch (Exception e){
            msg("WriteFile "+fileName+" Fail!\n");
        }
    }
    public void createVaccine(){
        Scanner sc = new Scanner(System.in);
        msg("Enter ID: ");
        String ID = sc.nextLine();
        msg("Enter name: ");
        String name = sc.nextLine();
        
        Vaccine vac = new Vaccine(ID,name);
        vaccineList.add(vac);
    }

    public void readVaccineList(){
        System.out.printf("%-13s %-13s\n","VaccineID","VaccineName");
        for(Vaccine s : vaccineList){
            System.out.printf("%-13s %-13s\n",s.getVaccineID(),s.getVaccineName());
        }
    }
    
    public void writeStudent(){
        String fileName="student.dat";
        try{
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            
            studentList.add(new Student("SE15000", "Hoa Doan"));
            studentList.add(new Student("SE15021", "Hai Doan"));
            studentList.add(new Student("SE15032", "Phong Ha"));
            studentList.add(new Student("SE15001", "Nhat Tam"));
            studentList.add(new Student("SE15012", "Lam Thoi"));
            studentList.add(new Student("SE15002", "Hoa Ha"));
            studentList.add(new Student("SE15123", "Hai Loi"));
            studentList.add(new Student("SE15033", "Kiep Ha"));
            studentList.add(new Student("SE15011", "Nguyet Ha"));
            studentList.add(new Student("SE15017", "Lam Sac"));
            
            
            for(Student s : studentList){
                oStream.writeObject(s);
            }
            
            oStream.close();
            file.close();
            msg("WriteFile "+fileName+" Successed!\n");
        } catch (Exception e){
            msg("WriteFile "+fileName+" Fail!\n");
        }
    }
    public void createStudent(){
        Scanner sc = new Scanner(System.in);
        msg("Enter Student's ID: ");
        String studentID = sc.nextLine();
        msg("Enter Student's name: ");
        String studentName = sc.nextLine();
        Student stu = new Student(studentID,studentName);
        studentList.add(stu);
    }
    public void readStudentList(){
        System.out.printf("%-13s %-13s\n","StudentID","StudentName");
        for(Student s : studentList){
            System.out.printf("%-13s %-13s\n",s.getStudentID(),s.getStudentName());
        }
    }
    
    private String CheckVaccine(){
        String ID = ""; 
        do{
            int flag = 1;
            ID = sp.fixContent("VaccineID");
            for (Vaccine s : this.vaccineList) {
                if (s.getVaccineID().equals(ID)) {
                    flag = 0;
                    msg("Vaccine found: "+ s.getVaccineName()+"\n");
                    break;
                }
            }
            if (flag==1) {
                msg("Vaccine not exist.\n Do you want to read Vaccine List? ");
                msg("(1:yes | 0:No): \n-> choose:  ");
                int chose = sp.switchInt(1);
                if (chose == 1){
                    readVaccineList();
                }
                msg("Please re-enter Vaccine ID: ");
            }
            if ( flag == 0) {
                break;
            }  
        }while(true);
        return ID;
    }
    private String CheckInjectID(){
        String ID; 
        do{
            
            int flag = 0;
            ID = sp.fixContent("VaccineInjectionID");
            for (VaccineInjection vi : vaccineInjectionList) {
                if (vi.getVaccineInjectionID().equals(ID)) {
                    flag++;
                    msg("VaccineInjectionID exist.\n");
                    msg("Please re-enter new one: \n");
                    break;
                }
            }
            if ( flag == 0) {
                break;
            }  
        }while (true);
        return ID;
    }
    private String CheckVaccineName(String text){
        for(Vaccine s : this.vaccineList){
            if(s.getVaccineID().equals(text)){
                return s.getVaccineName();
            }
        }
        return null;
    }

    private Date CheckSecondVacineDay(Date date){
        Date secondDay = null;
        {
                while(true){
                    secondDay = sp.catchDate();
                    Date compareDayMin = sp.addDays(date, 28);
                    Date compareDayMax = sp.addDays(date, 84);
                    if(secondDay.before(compareDayMin)){
                        msg("The time from the first injection is less than 4 weeks.\nPlease Re-Enter: ");
                    }else if(secondDay.after(compareDayMax)){
                        msg("The time from the first injection is more than 12 weeks.\nPlease Re-Enter: ");
                    }else{
                        break;
                    }
                }
        }
        return secondDay;
    }
    private Date CheckSecondVacineDayCanBlank(Date date){
        Date secondDay = null;
        {
                while(true){
                    secondDay = sp.catchDateCanBlank();
                    if(secondDay==null){break;}
                    Date compareDayMin = sp.addDays(date, 28);
                    Date compareDayMax = sp.addDays(date, 84);
                    if(secondDay.before(compareDayMin)){
                        msg("The time from the first injection is less than 4 weeks.\nPlease Re-Enter: ");
                    }else if(secondDay.after(compareDayMax)){
                        msg("The time from the first injection is more than 12 weeks.\nPlease Re-Enter: ");
                    }else{
                        break;
                    }
                }
        }
        return secondDay;
    }
    
    public void Add(){
        while(true){
            msg("Enter Student's ID: ");
            String studentID = sp.fixContent("Student ID");
            int flag = 0;
            for(Student s : studentList){
                if (s.getStudentID().equals(studentID)) {
                    flag = 1;   
                    msg("Student has found!\n");
                    if(VaccineAlready(studentID)){
                        
                        break;
                    }else{
                        msg("Enter the Injection ID:");
                        String injectID = CheckInjectID();

                        msg("Enter the VaccineID:");
                        String VaccineID = CheckVaccine();
                        
                        msg("Enter the first Injection place:");
                        String place1 = sp.fixContent("First Place");
                        
                        msg("Enter the first Injection Date:");
                        Date injectDate1 = sp.catchDate();
                        
                        
                        String place2 = null;
                                   
                        Date injectDate2 = null;

                        String VaccineName = CheckVaccineName(VaccineID);
                        VaccineInjection VI = new VaccineInjection(injectID,place1,place2,injectDate1,injectDate2,studentID,VaccineID,VaccineName);
                        vaccineInjectionList.add(VI);
                        msg("Add Successed");
                    }
                }
            }
            if (flag == 0) {
                    System.out.println("This student does not exist! (Tip: check the list Student)");
            }
            msg("Do you want to add more? (1:yes | 0:No): \n-> choose:  ");
            int chose = sp.switchInt(1);
            if (chose == 0){
                break;
            }
        }
    }
    
    public void ReadList(){
        if (vaccineInjectionList.isEmpty()){ msg("The list is EMTPY!\n"); }
        else{
            System.out.printf("%-13s %-13s %-20s %-13s %-20s %-13s %-10s\n", "InjectionID","FirstPlace","FirstDateInjection","SecondPlace","SecondDateInjection","StudentID","VaccineName");
            for(VaccineInjection vi : vaccineInjectionList){
            System.out.printf("%-13s %-13s %-20s %-13s %-20s %-13s %-10s\n",vi.getVaccineInjectionID(),vi.getFirstPlace(),sp.printDate(vi.getFirstDateInjection()),vi.getSecondPlace(),sp.printDate(vi.getSecondDateInjection()),vi.getStudentID(),vi.getVaccineName());    
            }
        }
    }
    private boolean VaccineAlready(String studentID){
        
        for (VaccineInjection vi : vaccineInjectionList){
            if(vi.getStudentID().equals(studentID)){
                msg("Student has already in the list with Injection ID: \""+vi.getVaccineInjectionID()+"\" !\n");
                return true;
            }
        }
        return false;
    }
    
    public void Update(){
        int flag =0;
        if (vaccineInjectionList.isEmpty()){ msg("The list is EMTPY!\n"); }
        else {
            msg("Enter Injection's ID: "); 
            String InjectionID = sp.fixContent("Injection ID");
            for(VaccineInjection vi : vaccineInjectionList){
                if(vi.getSecondPlace()!=null && vi.getSecondDateInjection()!=null && !"".equals(vi.getFirstPlace()) && !"".equals(sp.printDate(vi.getFirstDateInjection()))&&vi.getVaccineInjectionID().equals(InjectionID)){
                        msg("Student has completed 2 injections!\n");
                        flag =1;
                        break;
                    }
                if(vi.getVaccineInjectionID().equals(InjectionID)){   
                    flag=1;
                            
                    System.out.printf("%-13s %-13s %-20s %-13s %-20s %-13s %-10s\n", "InjectionID","FirstPlace","FirstDateInjection","SecondPlace","SecondDateInjection","StudentID","VaccineName");
                    System.out.printf("%-13s %-13s %-20s %-13s %-20s %-13s %-10s\n",vi.getVaccineInjectionID(),vi.getFirstPlace(),sp.printDate(vi.getFirstDateInjection()),vi.getSecondPlace(),sp.printDate(vi.getSecondDateInjection()),vi.getStudentID(),vi.getVaccineName());    
                    msg("Enter the second Injection place:");
                    vi.setSecondPlace(sp.fixContent("Second place."));
                    msg("Enter the second Injection Date:");
                    vi.setSecondDateInjection(CheckSecondVacineDay(vi.getFirstDateInjection()));
                    msg("-> Update completed.\n");
                    System.out.printf("%-13s %-13s %-20s %-13s %-20s %-13s %-10s\n", "InjectionID","FirstPlace","FirstDateInjection","SecondPlace","SecondDateInjection","StudentID","VaccineName");
                    System.out.printf("%-13s %-13s %-20s %-13s %-20s %-13s %-10s\n",vi.getVaccineInjectionID(),vi.getFirstPlace(),sp.printDate(vi.getFirstDateInjection()),vi.getSecondPlace(),sp.printDate(vi.getSecondDateInjection()),vi.getStudentID(),vi.getVaccineName());    
                    
                    if(vi.getSecondPlace()!=null && vi.getSecondDateInjection()!=null && !"".equals(vi.getFirstPlace()) && !"".equals(sp.printDate(vi.getFirstDateInjection()))){
                        msg("Student has completed 2 injections!\n");
                        break;
                    }
                    break;
                }    
            }
            if (flag == 0) {
                msg("This Injection ID does not exist!\n");
            }
        }
    }
    
    
    public void Delete(){
        int flag = 0;
        if (vaccineInjectionList.isEmpty()){ msg("The list is EMTPY!\n"); }
        else {
            try{
                msg("Enter Injection's ID: ");      
                String madinhdanh = sp.fixContent("Injection ID");    
                for (VaccineInjection vi : vaccineInjectionList) {
                    if (vi.getVaccineInjectionID().equals(madinhdanh)) {
                        flag = 1;
                        msg("Do you want to remove this Injection? (1:yes | 0:No): \n-> choose:  ");
                        int chose = sp.switchInt(1);
                        if (chose == 0){
                            msg("Delete fail.\n");    
                            break;
                        }else {             
                            flag = 2;
                            this.vaccineInjectionList.remove(vi);
                            break;
                        }
                    }
                }
                if (flag == 0) {
                    msg("This Injection ID does not exist!\n");
                }
            }catch(Exception e) {         
            }
            if (flag == 2) msg("Delete Succeed!\n");
        }
    }
    private String TakeStudentName(String studentID){
        String name = "";
        for(Student s: studentList){
            if(s.getStudentID().equals(studentID))
                name= s.getStudentName();
            break;
        }
        return name;
    }
    public void Search(){
        int flag = 0;
        if (vaccineInjectionList.isEmpty()){ msg("The list is EMTPY!\n"); }
        else {
            msg("Enter Student ID: "); 
            String madinhdanh = sp.fixContent("Student ID"); 
            for (VaccineInjection vi : vaccineInjectionList) {
            if (vi.getStudentID().contains(madinhdanh)) {
                flag = 1;
            }
            }
            if(flag == 1) 
                System.out.printf("%-13s %-13s %-20s %-13s %-13s %-20s %-20s %-10s\n", 
                        "InjectionID","StudentID","StudentName","FirstPlace","SecondPlace",
                        "FirstDateInjection","SecondDateInjection","VaccineName");
            for (VaccineInjection vi : vaccineInjectionList) {
                if (vi.getStudentID().contains(madinhdanh)) {
                    System.out.printf("%-13s %-13s %-20s %-13s %-13s %-20s %-20s %-10s\n",
                            vi.getVaccineInjectionID(),vi.getStudentID(),TakeStudentName(vi.getStudentID()),
                            vi.getFirstPlace(),sp.printDate(vi.getFirstDateInjection()),vi.getSecondPlace(),
                            sp.printDate(vi.getSecondDateInjection()),vi.getVaccineName());    
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println("Student ID not exist!\n");
            }
        }
    }
    
    
    public void SaveToFile(){
        String fileName="injection.dat";
        try{
           
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            
            for(VaccineInjection vi : vaccineInjectionList){
                oStream.writeObject(vi);
            }
            
            oStream.close();
            file.close();
            msg("WriteFile "+fileName+" Successed!\n");
        } catch (Exception e){
            msg("WriteFile "+fileName+" Fail!\n");
        }
    }
    
    
    public void ReadFile(){
        String fileName="injection.dat";
        
        try{
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream oStream = new ObjectInputStream(file);
            VaccineInjection read = null; 
            
            while (true){
                read = (VaccineInjection) oStream.readObject();
                vaccineInjectionList.add(read);
                if(file.available()< 1) break;
            }
            
            
            oStream.close();
            file.close();
            msg("ReadFile "+fileName+" Successed!\n");
        } catch (Exception e){
            msg("ReadFile "+fileName+" Fail!\n");
        }
    }

    
}
