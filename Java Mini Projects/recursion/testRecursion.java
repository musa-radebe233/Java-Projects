
/**
 * Write a description of class testRecursion here.
 *
 * @author (Nkosingiphile Radebe)
 * @version (5 April 2023)
 */
public class testRecursion
{
    
    public static void main(String[] args) 
    {
      xMethod(1234567);
             
    }
    
     public static void xMethod(int n) 
     {
         if (n > 0)
         {
             System.out.print(n % 10);
             xMethod(n / 10);
         }
         
         
     }
         
}        
