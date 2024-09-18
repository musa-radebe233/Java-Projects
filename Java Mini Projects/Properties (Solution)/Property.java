
/**
 * Write a description of class Property here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Property
{
    private String name;
    private String cell_num;
    private int months;
    private static int numProperties;
    
    public Property()
    {
       numProperties++;   
    }
    
    public Property(String name, String cell_num, int months)
    {
        setName(name);
        setCell(cell_num);
        setMonths(months);
        numProperties++;
    }
    
    public String getName()
    {
        return name;
    }
    public String getCell()
    {
        return cell_num;
    }
    public int getMonths()
    {
        return months;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setCell(String cell_num)
    {
        this.cell_num = cell_num;
    }
    
    public void setMonths(int months)
    {
        this.months = months;
    }
    public static int getNumProperties()
    {
        return numProperties;
    }
    
    @Override    
    public String toString()
    {
        String str = String.format("%-15s %-15s %-10d", name, cell_num, months);
        return str;
    }
    
    
    
    
    
    
    
}
