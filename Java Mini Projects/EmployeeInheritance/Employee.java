
/**
 * Write a description of class Employee here.
 *
 * @author (Nkosingiphile Radebe)
 * @version (17 March 2023)
 */
public class Employee
{
   private String name;
   private String IDNumber;
   private String mStatus;
   
   public Employee()
   {
       
   }
   
   public Employee(String name, String IDNumber, String mStatus)
   {
       this.name = name;
       this.IDNumber = IDNumber;
       this.mStatus = mStatus;
       
   }
   
   public String getName()
   {
       return name;
   }
   
   public String getIDNumber()
   {
       return IDNumber;
   }
   
   public String getMstatus()
   {
       return mStatus;
   }
   
   public int calcAge()
   {
       int year = 2023;
       int age;
       String digits = IDNumber.substring(0,2);
       
       if((IDNumber.charAt(0) - '0') > 0 && (IDNumber.charAt(0) - '0') <= 9)
       {
           digits = "19" + digits;
       }
       
       else
       {
           digits = "20" + digits;
       }
       
       age = year - Integer.parseInt(digits);
       return age;
   }
   
   public String toStringMarried()
   {
       String status; 
       if(mStatus == "S")
       {
           status = "Single";
       }
       else
       {
           status = "Married";
       }
       return status;
   }
   
   @Override
   public String toString()
   {
       String str;
       str = String.format("%s\t%s\t%s\t%2d", name, IDNumber, toStringMarried(), calcAge());
       return str;
   }
}
