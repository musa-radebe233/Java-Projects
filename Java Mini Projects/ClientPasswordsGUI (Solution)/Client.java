
/**
 * Write a description of class Client here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Client
{
   private String name;
   private String emailAddr;
   private String password;
   
   public Client(String name, String emailAddr)
   {
       this.name = name;
       this.emailAddr = emailAddr;
       setPassword();
   }
   
   public String getName()
   {
       return name;
   }
   
   public String getEmailAddr()
   {
       return emailAddr;
   }
   
   public String getPassword()
   {
       return password;
   }
   
   public void setPassword()
   {
       String pWord = "";
       name = name.toLowerCase();
       for (int k = name.length() -1; k >=0; k--)
       {
           pWord = pWord + name.charAt(k);//substring(k-2, k-1);
       }
      
       
       int value = 10 + (int)(Math.random() * 90);
       pWord = pWord + "_" + value;
       if (pWord.length() < 10)
       {
           int diff = 10 - pWord.length();
           pWord = pWord + emailAddr.substring(0, diff -1);
       }
       password = pWord;       
   }
   
   public String toString()
   {
       String str = String.format("%-25s%-25s%-25s", name, emailAddr, password);
       return str;
   }
}
