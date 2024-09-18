
/**
 * Write a description of class testProperties here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Scanner;
public class testProperties
{
    public static void main(String [] args)
    {
        Property [] arrProp = new Property[10];

        Scanner input = new Scanner(System.in);
        Scanner inputValues = new Scanner(System.in);
        
        arrProp = fillArray(arrProp);

        int count = Property.getNumProperties();       
        displayProperties(arrProp, count);
        
        System.out.print("\n");      
        
    }
    
    public static Property [] fillArray(Property [] arrProperties)
   {
       Scanner inputStr = new Scanner(System.in);
       Scanner inputValue = new Scanner(System.in);
       Scanner inputType = new Scanner(System.in);
       
       int count = 0;
       System.out.println("Enter the name of owner (X to quit): ");
       String name = inputStr.nextLine().toUpperCase();
     
       while (!(name.equals("X")) && count < 15)
       {
           System.out.println("Enter the cellphone number of the owner: ");
           String cellNum = inputStr.nextLine();
           System.out.println("Enter the number of months: ");
           int months = inputValue.nextInt();
           System.out.println("Enter a character for type of property (R-residential, B-business): ");
           char typeProp = inputStr.nextLine().charAt(0);
           if (Character.toUpperCase(typeProp) == 'R')
           {
               System.out.println("Enter type of residential property (F-Flat,T-Townhouse,H-House): ");
               char type = inputStr.nextLine().charAt(0);
               System.out.println("Enter number of bathrooms: ");
               int bathRooms = inputValue.nextInt();
               System.out.println("Enter number of bedrooms: ");
               int bedRooms = inputValue.nextInt();
               
               arrProperties[count] = new ResProperty(name, cellNum, months, type, bathRooms, bedRooms);               
           }
           else
           {
               System.out.println("Enter the size of the property: ");
               int size = inputValue.nextInt();
               
               arrProperties[count] = new BussProperty(name, cellNum, months, size);   
           }
           count++;
           System.out.println("Enter the name of owner (X to quit): ");
           name = inputStr.nextLine().toUpperCase();
       }      
       return arrProperties;
   }
   
   
    public static void displayProperties(Property [] arrProp, int count)
    {
        System.out.println("Residential Properties");
        System.out.printf("%-15s %-15s %-10s %-8s %-8s %-12s %-10s\n","Name", "Cell num", "Months", "Type", "Beds", "Baths", "Rent(pm)" );
        
        for(int k = 0; k < count; k++)
        {
            if (arrProp[k] instanceof ResProperty)
            {
                 ResProperty prop = (ResProperty)arrProp[k];
                 System.out.printf("%s R%-10.2f\n",prop.toString(), prop.calcMonthRent());
            }
        }
        
        System.out.println("Business Properties");
        System.out.printf("%-15s %-15s %-10s %-7s %-12s %-10s\n","Name", "Cell num", "Months", "Size", "Insurance", "Rent(pm)" );
        
        for(int k = 0; k < count; k++)
        {
            if (arrProp[k] instanceof BussProperty)
            {
               BussProperty prop = (BussProperty)arrProp[k];
               System.out.printf("%sR%-12.2fR%-10.2f\n", prop.toString(), prop.calcInsurance(), prop.calcMonthRent());
            }
        }
    }
    
    
}
