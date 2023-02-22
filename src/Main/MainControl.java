/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Source.VaccineInjectionList;
import Support.SupportMethod;
import java.io.FileNotFoundException;

/**
 *
 * @author admin
 */
public class MainControl {
    public static void main(String[] args) throws FileNotFoundException{
        SupportMethod sp = new SupportMethod();
        VaccineInjectionList vil = new VaccineInjectionList();
        try{
            vil.ReadFile();
        }catch (Exception e) {
        }
      
        vil.writeStudent();
        vil.writeVaccine();
        while(true){
            mainmenu();
            msg("Choose Method: ");
            int choise = sp.catchInt();
            if (choise < 1 || choise > 8){
                break;
            }
            switch(choise){
                case 1 -> vil.ReadList();
                case 2 -> vil.Add();
                case 3 -> vil.Update();
                case 4 -> vil.Delete();
                case 5 -> vil.Search();
                case 6 -> vil.SaveToFile();
                case 7 -> vil.readStudentList();
                case 8 -> vil.readVaccineList();
            }
            
        }
        
        
        System.out.println("Bye!");
        System.exit(0);
        
    }
     
    public static void mainmenu() {
        msg("+--------------------------Main_Menu--------------------------+\n"); 
        msg("| 1 - Show information all students have been injected        |\n");
        msg("| 2 - Add student's vaccine injection information             |\n");
        msg("| 3 - Updating information of students' for second injection  |\n");
        msg("| 4 - Delete student vaccine injection information            |\n");
        msg("| 5 - Search for injection information by studentID           |\n");
        msg("| 6 - Save To File                                            |\n");
        msg("| 7 - Read Student List                                       |\n");
        msg("| 8 - Read Vaccine List                                       |\n");
        msg("| Others - Exit Program                                       |\n");
        msg("+-------------------------------------------------------------+\n");       
    }
    
    public static void msg(String mess) {
        System.out.print(mess);
    }
    
}
