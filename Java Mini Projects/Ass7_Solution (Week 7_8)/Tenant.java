
/**
 * Abstract class Tenant - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
import java.io.Serializable; 
public abstract class Tenant implements Tenantable, Comparable<Tenant>, Serializable
{
    private String name;
    private String cell_number;
    private int numOutPayments;
    private int rent_period;
    private static final double RENT = 8000;
    
    protected Tenant()
    {
        
    }
    
    protected Tenant(String name, String cell_number, int numOutPayments, int rent_period)
    {
        setName(name);
        setCellNum(cell_number);
        setNumOutPayments(numOutPayments);
        setRentPeriod(rent_period);
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getCellNum()
    {
        return cell_number;
    }
    
    public int getNumOutPayments()
    {
        return numOutPayments;
    }
    
    public int getRentPeriod()
    {
        return rent_period;
    }
    
    public double getRent()
    {
        return RENT;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setCellNum(String number)
    {
        if(number.length() == 10 && number.charAt(0) == '0')
        {
            cell_number = number;
        }
        else
        {
            cell_number = "Invalid";
        }
    }
    
    public void setNumOutPayments(int number)
    {
        numOutPayments = number;
    }
    
    public void setRentPeriod(int rent_period)
    {
        this.rent_period = rent_period;
    }
    
    public abstract double getDiscount(double RENT);
    
    public abstract void setApartmentNum(String number);
    
    public abstract String getApartmentNum();
    
    @Override
    public int compareTo(Tenant ten)
    {
        String thisTen = getName() + getApartmentNum();
        String otherTen = ten.getName() + ten.getApartmentNum();
        return (thisTen).compareTo(otherTen);
    }
   
    public String toString()
    {
        String str = String.format("%-20s%-15s%-20s%-10s%-12s", getName(), getCellNum(), "R " + getDiscount(getRent()), getNumOutPayments(), getRentPeriod());
        return str; 
    }
    
   
}
