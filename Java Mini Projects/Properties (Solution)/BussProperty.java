/**
 * Write a description of class BussProperty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BussProperty extends Property
{
    private int size; // square meters
    
    public BussProperty()
    {
    }
    
    public BussProperty(String name, String cell_num, int months, int size)
    {
        super(name, cell_num, months);
        setSize(size);
    }
    
    public int getSize()
    {
        return size;
    } 
    
    public void setSize(int size)
    {
        this.size = size;
    } 
    
    public double calcInsurance()
    {
        double insurance = calcMonthRent() * 10/100.0;
        return insurance;
    }
      
    public double calcMonthRent()
    {
        double amount = size * 250.0;
        return amount;
    }
        
    @Override
    public String toString()
    {
        String str = String.format("%s %-8d", super.toString(), size);
        return str;
    }
}
