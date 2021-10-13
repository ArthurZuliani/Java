
package info.hccis.testinvoice.bo;
import java.util.Scanner;

/**
 * This is the invoice class
 * @author zulianideoliveiraa
 * @since 20211012
 */
public class Invoice {

    private int itemNumber;
    private String itemName;
    private int itemQuantity;
    private double itemPrice;
    private double totalPrice;
    
    /**
     * Default constructor
     * @author Arthur Zuliani
     * @since 20211012
     */
    public Invoice(){
        
    }

    /**
     * Custom constructor able to receive all private attributes values
     * @author Arthur Zuliani
     * @since 20211012
     * @param itemNumber
     * @param itemName
     * @param itemQuantity
     * @param itemPrice 
     */
    public Invoice(int itemNumber, String itemName, int itemQuantity, double itemPrice) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        
        calculateTotal();
    }
      
    /**
     * Method responsible to get information from the user
     * @author Arthur Zuliani 
     * @since 20211012      
     */
    public void getInformation(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the item number:");
        itemNumber = input.nextInt();
        input.nextLine();
        
        System.out.println("Enter the item name:");
        itemName = input.nextLine();
        
        System.out.println("Enter the item quantity:");
        itemQuantity = input.nextInt();
        input.nextLine(); //Burn the line
        
        System.out.println("Enter the item price:");
        itemPrice = input.nextDouble();
        input.nextLine(); //Burn the line
        
        calculateTotal();   //Calculates the total price for the item
    }
    
    /**
     * Method responsible to calculate the total price for the item
     * @author Arthur Zuliani
     * @since 20211012
     */
    public final void calculateTotal(){
        this.totalPrice = this.itemQuantity * this.itemPrice;
    }

    //All setters
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
        calculateTotal();
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
        calculateTotal();
    } 

    /**
     * Method responsible to printout the information for the user
     * @author Arthur Zuliani
     * @since 20211012
     */
    public void display(){
        System.out.println(toString());
    }
    
    /**
     * Method responsible to create the output string
     * @author Arthur Zuliani
     * @since 20211012
     * @return String to be print out
     */
    @Override
    public String toString(){
        return itemNumber + "- " + itemName + " " + itemQuantity + " ea($)" + itemPrice + " = $" + totalPrice;
    }
    
}
