
/**
 * Write a description of class ResProperty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResProperty extends Property
{
    private char type;
    private int bedRooms;
    private int bathRooms;
    
    private static final int FLAT = 8000 + 500;
    private static final int T_HOUSE = 15000 + 1000;
    private static final int HOUSE = 12000 + 800;
    
    
    public ResProperty()
    {
    }
    
    public ResProperty(String name, String cell_num, int months, char type, int bedRooms, int bathRooms)
    {
        super(name, cell_num, months);
        setType(type);
        setBedRooms(bedRooms);
        setBathRooms(bathRooms);
    }
    
    public char getType()
    {
        return type;
    }
    
    public int getBedRooms()
    {
        return bedRooms;
    }
    public int getBathRooms()
    {
        return bathRooms;
    }  
    
    public void setType(char type)
    {
        this.type = type;
    }
    
    public void setBedRooms(int bedRooms)
    {
        this.bedRooms = bedRooms;
    }
    public void setBathRooms(int bathRooms)
    {
        this.bathRooms = bathRooms;
    }
    
    public double calcMonthRent()
    {
        double amount = 0;
        switch (Character.toUpperCase(type)) 
        {
          case 'T':amount = T_HOUSE * bedRooms; break;
          case 'F':amount = FLAT * bedRooms; break;
          case 'H':amount = HOUSE * bedRooms; break;
        }
        return amount;
    }
        
    @Override
    public String toString()
    {
        String str = String.format("%s %-8s %-10d %-10d", super.toString(), type, bedRooms, bathRooms);
        return str;
    }
}
