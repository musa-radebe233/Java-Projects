
/**
 * Write a description of class Group here.
 *
 * @author (Nkosingiphile Radebe - 43798195)
 * @version (19 April 2023)
 */
public class Group
{
    private String organiser;
    private int groupSize;
    private char lunch;
    private static int objectCount;
    
    public Group()
    {
        objectCount++;
    }
    
    public Group(String organiser, int groupSize, char lunch)
    {
        setOrganiser(organiser);
        setGroupSize(groupSize);
        setLunch(lunch);
        objectCount++;
    }
    
    public void setOrganiser(String newOrganiser)
    {
        organiser = newOrganiser;
    }
    
    public void setGroupSize(int newGroupSize)
    {
        groupSize = newGroupSize;
    }
    
    public void setLunch(char newLunch)
    {
        lunch = newLunch;
    }
    
    public String getOrganiser()
    {
        return organiser;
    }
    
    public int getGroupSize()
    {
        return groupSize;
    }
    
    public char getLunch()
    {
        return lunch;
    }
    
    public double calcEntranceAmt(int groupSize)
    {
        double amount = 0;
        if(groupSize >= 1 && groupSize <= 20)
        {
            amount = 400 * groupSize;
        }
        else if(groupSize >= 21 && groupSize <= 40)
        {
            amount = 375 * groupSize;
        }
        else
        {
            amount = 350 * groupSize;
        }
        
        return amount;
    }
    
    public String toString()
    {
        String str = String.format("%s\t%3d\t%c\t", organiser, groupSize, lunch);
        return str;
    }
    
}
