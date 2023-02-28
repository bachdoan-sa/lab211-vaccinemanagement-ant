/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.vaccinemanagement.userinterface.console;

/**
 *
 * @author AN515-57
 */
public class ControlPanelInterface {
    
    public static void showMainMenuInConsole() {
        System.err.println("+--------------------------Main_Menu--------------------------+"); 
        System.err.println("| 1 - Show information all students have been injected        |");
        System.err.println("| 2 - Add student's vaccine injection information             |");
        System.err.println("| 3 - Updating information of students' for second injection  |");
        System.err.println("| 4 - Delete student vaccine injection information            |");
        System.err.println("| 5 - Search for injection information by studentID           |");
        System.err.println("| 6 - Save To File                                            |");
        System.err.println("| 7 - Read Student List                                       |");
        System.err.println("| 8 - Read Vaccine List                                       |");
        System.err.println("| Others - Exit Program                                       |");
        System.err.println("+-------------------------------------------------------------+");       
    }
    public static void showPlaceToEnterMethodInConsole(){
        System.err.println("Enter your method: ");
    }
    public static void showGoodByeDialogWhenCloseProgramInConsole(){
        System.err.println("The System now offline. Good Bye!");
    }
}
