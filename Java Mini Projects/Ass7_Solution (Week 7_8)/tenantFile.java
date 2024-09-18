
/**
 * Write a description of class tenantFile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class tenantFile
{
    private Tenantable[] arrTenants = new Tenantable[50];
    private static int count = 0;
    
    public void readFromFile()
    {
        try
        {
            Scanner file = new Scanner(new FileReader("tenantdata.txt"));
            while(file.hasNext())
            {
                String line = file.nextLine();
                String [] entries = line.split(" ");
                
                String apartment = entries[0].substring(0, 4);
                String name = entries[0].substring(5, entries[0].length());
                String cellNum = entries[1];
                int numOutPayments = Integer.parseInt(entries[2]);
                int rentPeriod = Integer.parseInt(entries[3]);
                
                if(apartment.charAt(0) == 'A')
                {
                    arrTenants[count] = new Student(name, cellNum, numOutPayments, rentPeriod, apartment);
                }
                else if(apartment.charAt(0) == 'B')
                {
                    arrTenants[count] = new Other(name, cellNum, numOutPayments, rentPeriod, apartment);
                }
                count++;
            }
            
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.toString());
        }
    }
    
    public Tenantable[] getArray()
    {
        return arrTenants;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public void saveStudents(Tenantable[] array)
    {
        try
        {
            FileOutputStream outStream = new FileOutputStream("Students.ser");
            ObjectOutputStream outFile = new ObjectOutputStream(outStream);
            
            for(int i = 0; i < count; i++)
            {
                if(array[i] instanceof Student)
                {
                    outFile.writeObject(array[i]);
                }
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.toString());
        }
    }
}
