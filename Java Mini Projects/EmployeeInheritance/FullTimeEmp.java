
/**
 * Write a description of class FullTimeEmp here.
 *
 * @author (Nkosingiphile Radebe)
 * @version (18 March 2023)
 */
public class FullTimeEmp extends Employee
{
    private double basicSalary;
    
    FullTimeEmp()
    {
        
    }
    
    FullTimeEmp(String name, String IDNumber, String mStatus, double basicSalary)
    {
        super(name, IDNumber, mStatus);
        this.basicSalary = basicSalary;
    }
    
    public double getBasicSalary()
    {
        
        return basicSalary;
    }
    
    public double calcAllowance()
    {
        double allowance = 0;
        
        if(super.toStringMarried() == "Married" && super.calcAge() >= 30)
            allowance = basicSalary * 0.1;
        
        return allowance;

    }
    
    @Override
    public String toString()
    {
        String str;
        str = String.format("%s\t%s%8.2f\t%s%8.2f\t", super.toString(), "R",basicSalary, "R",calcAllowance());
        return str;
    }
}
