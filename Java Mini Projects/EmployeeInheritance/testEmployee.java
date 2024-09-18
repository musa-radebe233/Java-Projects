
/**
 * Write a description of class testEmployee here.
 *
 * @author (Nkosingiphile Radebe)
 * @version (17 March 2023)
 */
import java.util.Scanner;

public class testEmployee
{
    public static void main()
    {
        FullTimeEmp arrFullTimeEmp[] = new FullTimeEmp[10];
        PartTimeEmp arrPartTimeEmp[] = new PartTimeEmp[10];
        String name = "";
        String IDNumber = "";
        String mStatus = "";
        String answer = "";
        double fullTimeSalary = 0;
        int partTimeSalary = 0;
        int hours = 0;
        int rate = 0;
        int fullCount = 0;
        int partCount = 0;
        Scanner input = new Scanner(System.in);
        Scanner inputValues = new Scanner(System.in);
        
        System.out.print("Enter the employee's name (X to stop): ");
        name = input.nextLine();
        
        while(!(name.equalsIgnoreCase("X")))
        {
            System.out.print("\nEnter the employee's ID number: ");
            IDNumber = input.nextLine();
            System.out.print("\nEnter the employee's marital status (M or S): ");
            mStatus = input.nextLine();
            System.out.print("\nIs the employee full-time? (Y/N): ");
            answer = input.nextLine();
            
            if(answer.equalsIgnoreCase("Y"))
            {
                System.out.print("\nEnter the employee's salary: ");
                fullTimeSalary = inputValues.nextDouble();
                
                arrFullTimeEmp[fullCount] = new FullTimeEmp(name, IDNumber, mStatus, fullTimeSalary);
                fullCount++;
            }
            else
            {
                System.out.print("\nEnter the number of hours worked this month: ");
                hours = inputValues.nextInt();
                System.out.print("\nEnter the hourly rate: ");
                rate = inputValues.nextInt();
                
                arrPartTimeEmp[partCount] = new PartTimeEmp(name, IDNumber, mStatus, hours, rate);
                partCount++;
            }
            
            System.out.print("\nEnter the employee's name (X to stop): ");
            name = input.nextLine();
        }
        
        displayFullTime(arrFullTimeEmp,fullCount);
        
        System.out.print("\n");
        
        displayPartTime(arrPartTimeEmp, partCount);
        
    }
    
    public static void displayFullTime(FullTimeEmp arrFullTimeEmp[], int count)
    {
        System.out.println("\nFull-time Employees:");
        System.out.println("Name" + "\t" + "ID number"+ "\t" + "M/status" + "\t" + "Age" + "\t" + "Basic salary" + "\t" + "Allowance");
        
        for(int i =0; i < fullCount; i++)
        {
            System.out.println(arrFullTimeEmp[i]);
        }
    }
    
    public static void displayPartTime(PartTimeEmp arrPartTimeEmp[], int count)
    {
        System.out.println("\nPart-time Employees:");
        System.out.println("Name" + "\t" + "ID number"+ "\t" + "M/status" + "\t" + "Age" + "\t" + "Hours" + "\t" + "Rate" + "\t" + "Salary");
        
        for(int i =0; i < partCount; i++)
        {
            System.out.println(arrPartTimeEmp[i]);
        }
    }
}
