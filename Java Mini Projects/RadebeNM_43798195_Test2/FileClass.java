
/**
 * Write a description of class FileClass here.
 *
 * @author (Nkosingiphile Radebe - 43798195)
 * @version (19 April 2023)
 */
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileClass
{
    private Group [] arrGroup = new Group[20];
    private int count = 0;
    
    public void readFromFile() throws IOException
    {
        String organiser = "";
        int groupSize = 0;
        char lunch;
        char type;
        String compName= "";
        String refNumber = "";
        String tourAgency = "";
        String currency = "";
        
        java.io.File file = new java.io.File("groups.txt");
        
        Scanner input = new Scanner(file);
        while(input.hasNext())
        {
            String line = input.nextLine();
            String [] info = line.split(",");
            
            type = info[0].charAt(0);
            organiser = info[1];
            groupSize = Integer.parseInt(info[2]);
            lunch = info[3].charAt(0);
            
            if(type == 'C')
            {
                compName= info[4];
                arrGroup[count] = new CompGroup(organiser, groupSize, lunch, compName);
                count++;
            }
            else
            {
                tourAgency = info[4];
                currency = info[5];
                arrGroup[count] = new TourGroup(organiser, groupSize, lunch, tourAgency);
                count++;
            }
            
        }
        
        input.close();
    }
    
    
    
    public Group [] getArray()
    {
        return arrGroup;
    }
    
    public int getCount()
    {
        return count;
    }
}
