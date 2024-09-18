
/**
 * Write a description of class CompGroup here.
 *
 * @author (Nkosingiphile Radebe - 43798195)
 * @version (19 April 2023)
 */
public class CompGroup extends Group
{
    private String compName;
    private String refNumber;
    private static int compCount = 1000;
    
    public CompGroup()
    {
        super();
    }
    
    public CompGroup(String compName)
    {
        super(organiser, groupSize, lunch);
        this.compName = compName;
        
        compCount++;
    }
    
    public String getCompName()
    {
        return compName;
    }
    
    public String getRefNumber()
    {
        return refNumber;
    }
    
    public void compileRefNum()
    {
        refNumber = "COMP-" + compCount;
    }
    
    public double calcLunchAmt(int groupSize)
    {
        double lunchAmt = 250 * groupSize;
        return lunchAmt;
    }
    
    public double calcFinalAmt()
    {
        double finalAmt = super.calcEntranceAmt(groupSize) + calcLunchAmt(groupSize);
        return finalAmt;
    }
    
    public String toString()
    {
        String str = String.format("%s\t%s\t%s\t%8.2f\t%8.2f\t%8.2f\t", refNumber,super.toString(), compName, super.calcEntranceAmt(groupSize), calcLunchAmt(groupSize), calcFinalAmt());
        return str;
    }
}
