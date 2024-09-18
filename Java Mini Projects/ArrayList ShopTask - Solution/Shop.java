
/**
 * Write a description of class Shop here.
 *
 * @author (Solution)
 * @version (16 March 2022)
 */
import java.util.Random;
public class Shop
{
    private String name;
    private int visitors;
    private static int numberOfShops;
    
    public Shop()
    {
      numberOfShops++; 
    }
    
    public Shop(String name)
    {
        this.name = name;
        setVisitors();
        numberOfShops++;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getVisitors()
    {
        return visitors;
    }
    
    public static int getNumberOfShops()
    {
        return numberOfShops;
    }
    
    public void setVisitors()
    {
        Random random = new Random();
        visitors = random.nextInt(101);
    }
    
    public void updateVisitors(int number)
    {
        visitors = visitors + number;
    }
    
    public static void setNumberOfShops(int number)
    {
       numberOfShops = number; 
    }
    
    @Override
    public String toString()
    {
        String str = String.format("%-15s%4d", name, visitors);
        return str;
    }
    
}
