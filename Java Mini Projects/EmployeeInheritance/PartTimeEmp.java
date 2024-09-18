
/**
 * Write a description of class PartTimeEmp here.
 *
 * @author (Nkosingiphile Radebe)
 * @version (18 March 2023)
 */
public class PartTimeEmp extends Employee
{
    private int hours;
    private int rate;
    
    public  PartTimeEmp()
    {
        
    }
    
    public  PartTimeEmp(String name, String IDNumber, String mStatus, int hours, int rate)
    {
        super(name, IDNumber, mStatus);
        this.hours = hours;
        this.rate = rate;
    }
    
    public int getHours()
    {
        return hours;
    }
    
    public int getRate()
    {
        return rate;
    }
    
    public int calcSalary()
    {
        int salary = hours * rate;
        return salary;
    }
    
    @Override
    public String toString()
    {
        String str;
        str = String.format("%s\t%d\t%s%d\t%s%d\t", super.toString(),hours,"R",rate,"R",calcSalary());
        return str;
    }
}
