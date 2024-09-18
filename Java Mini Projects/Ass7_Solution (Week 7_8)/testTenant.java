
/**
 * Write a description of class testTenant here.
 *
 * author ()
 * @version (a version number or a date)
 */
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.IOException;

public class testTenant
{
    public static void main(String[] args)
    {
        Tenantable[] arrTenants = new Tenantable[50];
        
        tenantFile file = new tenantFile();
        file.readFromFile();
        arrTenants = file.getArray();
        file.saveStudents(arrTenants);
        
        displayData(arrTenants, file); 
        
        //sort and display array
        arrTenants = Arrays.copyOf(arrTenants, file.getCount());
        Arrays.sort(arrTenants);
        
        displayData(arrTenants, file);
        displayStudentInfo(file);
    }
    
    private static void displayData(Tenantable[] array, tenantFile file)
    {
        System.out.println("\nList of tenants");
        String heading = String.format("%-15s%-20s%-15s%-15s%-10s%-10s", "Apartment", "Name", "Cell Number", "Discount", "Payments", "Rent Period");
        System.out.println(heading);
        
        for(int i = 0; i < file.getCount(); i++)
        {
            System.out.println(array[i].toString());
        }
    }
    
    private static void displayStudentInfo(tenantFile file)
    {
        boolean endOfFile = false;
        try
        {
            FileInputStream inStream = new FileInputStream("Students.ser");
            ObjectInputStream inFile = new ObjectInputStream(inStream);
            
            String heading = String.format("%-20s%-15s", "\n\nStudent Name", "Apartment Num");
            System.out.println(heading);
            while(!(endOfFile))
            {
                try
                {
                    Student student = (Student)inFile.readObject();
                    
                    String str = String.format("%-20s%-15s", student.getName(), student.getApartmentNum());
                    System.out.println(str);
                }
                catch (EOFException e)
                {
                    endOfFile = true;
                }
            }
            inFile.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.toString());
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex.toString());
        }
    }
}
