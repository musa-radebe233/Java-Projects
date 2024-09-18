
/**
 * Write a description of class TourGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TourGroup extends Group
{
    private String tourAgency;
    private String refNumber;
    private String currency;
    private static int tourCount = 2000;
    
    public TourGroup()
    {
        super();
    }
    
    public TourGroup(String tourAgency)
    {
        super(organiser, groupSize, lunch);
        this.tourAgency = tourAgency;
        
    }
    
    public void compileRefNum()
    {
        refNumber = "Tour-" + tourCount;
    }
    
    public double calcLunchAmt(int groupSize)
    {
        double lunchAmt = 550 * groupSize;
        return lunchAmt;
    }
    
    public double calcFinalAmt()
    {
        double finalAmt = super.calcEntranceAmt(super.getGroupSize()) + calcLunchAmt(super.getGroupSize());
        return finalAmt;
    }
    
    public double convertAmt(char currency)
    {
        double convertAmt = 0 ;
        double rate = 0;
        switch (currency)
        {
            case 'U': rate = 17.50;
                      break;
            case 'E': rate = 15.80;
                      break;
            case 'P': rate = 22.50;
                      break;
            case 'Y': rate = 10.50;
                      break;          
            
        }
        
        convertAmt = calcFinalAmt() / rate;
        
        return convertAmt;
    }
    
    public String toString()
    {
        String str = String.format("%s\t%s\t%8.2f\t%8.2f\t%8.2f\t%8.2f\t", refNumber,super.toString(), super.calcEntranceAmt(groupSize), calcLunchAmt(groupSize), calcFinalAmt(), convertAmt(currency.charAt(0)));
        return str;
    }
}
