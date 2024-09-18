
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.Serializable; 
public class Student extends Tenant implements Serializable
{
    private String apartmentNum;
    
    public Student()
    {
        super();
    }
    
    public Student(String name, String cell_number, int numOutPayments, int rent_period, String apartmentNum)
    {
        super(name, cell_number, numOutPayments, rent_period);
        setApartmentNum(apartmentNum);
    }
    
    public void setApartmentNum(String number)
    {
        apartmentNum = number;
    }
    
    public String getApartmentNum()
    {
        return apartmentNum;
    }
    
    public double getDiscount(double RENT)
    {
        double discount = 0;
        double discount_amount;
        
        if(super.getNumOutPayments() < 2)
        {
            discount = 0.05;
            if(super.getRentPeriod() > 24)
            {
                discount = discount + 0.05;
            }
        }
        discount_amount = RENT * discount;
        
        return discount_amount;
    }
    
    public String toString()
    {
        String str = String.format("%-15s%-67s", getApartmentNum(), super.toString());
        return str; 
    }
}
