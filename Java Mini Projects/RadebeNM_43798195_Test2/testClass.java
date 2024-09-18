
/**
 * Write a description of class testClass here.
 *
 * @author (Nkosingiphile Radebe - 43798195)
 * @version (19 April 2023)
 */
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class testClass
{
    public static void main(String [] args) throws IOException
    {
        Group [] arrGroup = new Group[20];
        int count = 0;
        FileClass file = new FileClass();
        
        file.readFromFile();
        displayGroup(file.getArray(), file.getCount());
        
    }
    
    public static void displayGroup(Group [] arrGroup, int count)
    {
        System.out.println("Code" + "\t" + "Organiser" + "\t" + "Number" + "\t" + "Lunch" + "\t" + "Comp/Agency" + "\t" + "Entrance" + "Lunch" + "\t" + "Final Amount" + "\t" + "Converted");
        
        
        for(int i = 0; i < count; i++)
        {
            if(arrGroup[i] instanceof CompGroup)
            {
                CompGroup comp = (CompGroup)arrGroup[i];
                System.out.println(comp.toString());
            }
            else
            {
                TourGroup tour = (TourGroup)arrGroup[i];
                System.out.println(tour.toString());
            }
            
        }
    }
}
