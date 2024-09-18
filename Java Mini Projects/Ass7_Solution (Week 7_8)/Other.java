
/**
 * Write a description of class Other here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Other extends Tenant
{
    private String apartmentNum;
    
    public Other()
    {
      super();  
    }
    
    public Other(String name, String cell_number, int numOutPayments, int rent_period, String apartmentNum)
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
        
        if(super.getNumOutPayments() == 0)
        {
            discount = 0.025;
            if(super.getRentPeriod() > 12)
            {
                discount = discount + 0.075;
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
