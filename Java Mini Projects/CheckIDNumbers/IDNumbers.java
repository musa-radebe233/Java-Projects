
/**
 * Write a description of class IDNumbers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class IDNumbers
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        String idNumber = "",digit_error ="",month_error = "", day= "", year = "" ,month = "";
        int idLength = 0, date_month = 0;
    
        System.out.print("Enter ID number: ");
        idNumber = input.nextLine();
        
        if(idNumber.length() == 13)
        {
            date_month = Integer.parseInt(idNumber.substring(2,4));
            if(date_month >= 1 && date_month <= 12)
            {
                 switch(date_month)
                 {
                     case 1: month = "January";
                             break;
                     case 2: month = "February";
                             break;
                     case 3: month = "March";
                             break;
                     case 4: month = "April";
                             break;
                     case 5: month = "May";
                             break;
                     case 6: month = "June";
                             break;
                     case 7: month = "July";
                             break;
                     case 8: month = "August";
                             break;
                     case 9: month = "Sebtember";
                             break;
                     case 10: month = "October";
                             break;
                     case 11: month = "November";
                             break;
                     case 12: month = "December";
                             break;
                 }
                 
                 day = idNumber.substring(4,6);
                 if(idNumber.charAt(0) > '0' )
                 {
                     year = "19" + idNumber.substring(0,2);
                 }
                 else
                 {
                     year = "20" + idNumber.substring(0,2);
                 }
                 
                 System.out.println("\nID Number: " + idNumber);
                 System.out.println("Date of birth: " + day + " " + month + " " + year);
            }
            else
            {
                System.out.println("ID Number: " + idNumber);
                System.out.println("Invalid ID number:");
                month_error = "Month value is invalid";
            }
        }
        else
        {
            System.out.println("ID Number: " + idNumber);
            System.out.println("Invalid ID number:");
            digit_error = "Incorrect number of digits";
            if(date_month < 1 || date_month > 12)
            {
                month_error = "Month value is invalid";
            }
        }
        
        System.out.println("\n" + digit_error);
        System.out.println(month_error);
    }
    
    
}
