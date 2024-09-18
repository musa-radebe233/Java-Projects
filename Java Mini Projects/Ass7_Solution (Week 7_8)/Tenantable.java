
/**
 * Write a description of interface Tenantable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Tenantable
{
    public abstract double getDiscount(double rent);
    
    public abstract void setApartmentNum(String number);
    
    public abstract String getApartmentNum();
}
