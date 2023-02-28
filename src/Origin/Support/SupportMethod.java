/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package origin.Support;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author admin
 */
public class SupportMethod {
    Scanner sc = new Scanner(System.in);
    java.util.Date date = new java.util.Date(); 
    public Date catchDate(){
        String format; Date d = null; int c;
        int day, month, year;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
            do{
                try {
                    int []dayMax= {0,31,28,31,30,31,30,31,31,30,31,30,31};
                    c = 1;
                    format = sc.nextLine();
                    
                    d = df.parse(format);
                    StringTokenizer stk = new StringTokenizer(format,"/");           
                    day = Integer.parseInt(stk.nextToken());
                    month = Integer.parseInt(stk.nextToken());
                    year = Integer.parseInt(stk.nextToken());
                    if (day <= 0) System.out.println("day must higher than 0!");
                    if (month <= 0) System.out.println("month must higher than 0!");
                    if (month > 12) System.out.println("month must lower than 12!");
                    if (year < 0) System.out.println("year can't below 0!");
                    if (day <= 0 || month < 0 || month > 12 || year < 0){
                        c=0;
                    } else {
                   
                        if ((year % 100 == 0 && year % 400 == 0) && month == 2){
                            dayMax[2] = 29;
                            System.out.println("In "+ year + " have 29 date in month 2");
                        } else if (year % 100 != 0 && year % 4 == 0 && month == 2 ){
                            dayMax[2] = 29;
                            System.out.println("In "+ year + " have 29 date in month 2");
                        }
                      
                        if (day > dayMax[month]){
                            c=0;
                            System.out.println("Enroll, the date "+ day +" is higher than max day in "+month );
                        }
//                        if(d.before(date)) {
//                            c = 0;
//                            System.out.println("Enroll, the expired Date must after today!");
//                        }

                    }
                    if (c == 0) {
                        
                        System.out.print("Please Re-Enter: ");
                    }
                }catch( Exception e) {
                    System.out.println("The format not correct (day/month/years)!");
                    System.out.print("Please Re-Enter: ");
                    c = 0;
                }  
                
            } while (c == 0);     
        
        return d;
    }
    
    public double catchDouble(){
        double c, a = 0;
        do{
            try{
                c = 1;
                a = Double.parseDouble(sc.nextLine());
            } catch (Exception e) {   
                System.out.println("It isn't a Number. Please re-insert: ");
                c = 0;
            }
            if (a<=0){
                c = 0;
                System.out.println("Weight can't below or equal '0'!  ");
                System.out.print("Please Re-Enter: ");
            }
        }while(c == 0);
        return a;
    }
    
    public String printDate(Date d){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if(d==null) return null;
        return df.format(d);
    }
    public Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); 
        return cal.getTime();
    }
    
    public int catchInt(){
        int c,a = 0;
        do{
            try{
                c = 1;
                a = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {   
                System.out.print("It isn't an Integer. Please re-insert: ");
                c = 0;
            }
        }while(c == 0);
        return a;
    }
    

    
    public String fixContent(String blank){
        String content; int c;
        do{
            c = 1;
            content = sc.nextLine();
            if (content.length() < 1){
                c = 0;
                System.out.println("This '"+blank+ "' can't be emty");
                System.out.print("Please Re-Enter: ");
            }
        }while(c == 0);
        return content;
    }
    public int switchInt(int num){
        int c ,a = 0;
        do{
            try{
                c = 1;
                a = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {   
                System.out.print("It isn't an Integer. Please re-insert:");
                c = 0;
            }
            if(a < 0 || a > num){
                System.out.print("The number is out range. Please re-insert:");
            }
        }while(c == 0 ||(a < 0 || a > num));
        return a;
    }
    public Date catchDateCanBlank(){
        String format; Date d = null; int c;
        int day, month, year;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
            do{
                try {
                    int []dayMax= {0,31,28,31,30,31,30,31,31,30,31,30,31};
                    c = 1;
                    format = sc.nextLine();
                    if(format.equals("")){format=null; break;}
                    else {
                    d = df.parse(format);
                    StringTokenizer stk = new StringTokenizer(format,"/");           
                    day = Integer.parseInt(stk.nextToken());
                    month = Integer.parseInt(stk.nextToken());
                    year = Integer.parseInt(stk.nextToken());
                    if (day <= 0) System.out.println("day must higher than 0!");
                    if (month <= 0) System.out.println("month must higher than 0!");
                    if (month > 12) System.out.println("month must lower than 12!");
                    if (year < 0) System.out.println("year can't below 0!");
                    if (day <= 0 || month < 0 || month > 12 || year < 0){
                        c=0;
                    } else {
                   
                        if ((year % 100 == 0 && year % 400 == 0) && month == 2){
                            dayMax[2] = 29;
                            System.out.println("In "+ year + " have 29 date in month 2");
                        } else if (year % 100 != 0 && year % 4 == 0 && month == 2 ){
                            dayMax[2] = 29;
                            System.out.println("In "+ year + " have 29 date in month 2");
                        }
                      
                        if (day > dayMax[month]){
                            c=0;
                            System.out.println("Enroll, the date "+ day +" is higher than max day in "+month );
                        }
                    }
                    if (c == 0) {
                        
                        System.out.print("Please Re-Enter: ");
                    }
                    }
                }catch( Exception e) {
                    System.out.println("The format not correct (day/month/years)!");
                    System.out.print("Please Re-Enter: ");
                    c = 0;
                }            
            } while (c == 0);     
        
        return d;
    }
}
