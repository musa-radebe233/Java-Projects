
/**
 * Write a description of class testShop here.
 *
 * @author (Solution)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;

public class testShop
{
    public static void main(String [] args)
    {
        ArrayList<Shop> arrShops = new ArrayList<Shop>(10);
        arrShops = fillArray(arrShops);
        //int number = Shop.getNumberOfShops();
        displayArray(arrShops);
        
        arrShops = updateVisitors(arrShops);
        arrShops = removeShop(arrShops);
    }
    
    public static ArrayList<Shop> fillArray(ArrayList<Shop> arrShops)
    {
        int count = 0;
        Scanner inputText = new Scanner(System.in);
        System.out.println("Enter the name of a shop (X to quit): ");
        String name = inputText.nextLine();
        while (!(name.equals("X")) && !(name.equals("x")) && count < 10 )
        {
            Shop temp = new Shop(name);
            arrShops.add(temp);
           
            System.out.println("Enter the name of a shop (X to quit): ");
            name = inputText.nextLine();
            count++;
        }
        if (count >= 10)
           System.out.println("Only space for the information of 10 shops ");
           
        return arrShops;
    }
    
    public static void displayArray(ArrayList<Shop> arrShops)
    {
        System.out.printf("\n%-15s%s\n","  Name", "  Visitors");
        for (int k = 0; k < arrShops.size(); k++)
        {
            System.out.println((k+1) + " " + arrShops.get(k).toString());
        }        
    }
    
    public static ArrayList<Shop> updateVisitors(ArrayList<Shop> arrShops)
    {
        //int numShops = Shop.getNumberOfShops();
        displayArray(arrShops);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number from the list (-1 to quit): ");
        int number = input.nextInt();
        while (number != -1)
        {
             System.out.println("Enter the number of visitors to add: ");
             int numToAdd = input.nextInt();
             arrShops.get(number-1).updateVisitors(numToAdd);
             
             displayArray(arrShops);
             System.out.println("Enter another number from the list (-1 to quit): ");
             number = input.nextInt();
        }    
        return arrShops;
    }
    
    public static ArrayList<Shop> removeShop(ArrayList<Shop> arrShops)
    {
        //int numShops = Shop.getNumberOfShops();
        displayArray(arrShops);
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number from the list to remove: ");
        int number = input.nextInt();
        arrShops.remove(number -1);
        /*
        for (int k = number - 1; k < arrShops.size(); k++)
        {
            arrShops[k] = arrShops[k + 1];
            
        }
        numShops--;
        Shop.setNumberOfShops(numShops); // update the numberOfShops static variable */
        
        System.out.println("Shop has been remove");
        displayArray(arrShops);       
        
        return arrShops;
    }
   
}
