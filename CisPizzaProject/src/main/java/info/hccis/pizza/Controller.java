package info.hccis.pizza;

import info.hccis.pizza.bo.Order;
import info.hccis.util.CisUtility;
import java.util.Scanner;

/**
 * Pizza ordering System
 * 
 * @author bjmaclean
 * @since Oct 19, 2021
 * 
 * @modified by Arthur Zuliani 2021-11-23
 */
public class Controller {

    private static double costOfAllPizzas = 0;
    
    public static final String MENU = "-------------------------" + System.lineSeparator()
            + "- CIS Menu" + System.lineSeparator()
            + "- A-Create a pizza order" + System.lineSeparator()
            + "- B-Show how much pizza orders cost" + System.lineSeparator()
            + "- X-eXit" + System.lineSeparator()
            + "-------------------------" + System.lineSeparator()
            + "Option -->";

    public static void main(String[] args) {
                
        System.out.println("Welcome (" + CisUtility.getTodayString("yyyy-MM-dd") + ")");
        String option = "";
               
        while (!option.equalsIgnoreCase("X")) {
            option = CisUtility.getInputString(MENU);
            option = option.toUpperCase();
            switch (option) {
                case "A":
                    addAPizza();
                    break;
                case "B":
                    showCostOfAllPizzas();
                    break;
                case "X":
                    System.out.println("thanks for using our program - have a good day");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

    }

    /**
     * Allow the user to create an order.  This will use the functionality of the 
     * order class.
     * 
     * @since 20211122
     * @author BJM
     * 
     * @modified by Arthur Zuliani
     */
    public static void addAPizza() {
        
        Order order = new Order();
        order.getInformation();
        costOfAllPizzas += order.calculateCost();
        order.display();
    }

    /**
     * This method will printout the total cost for all pizzas
     * 
     * @author Arthur Zuliani
     * @since 2021-11-23
     */
    public static void showCostOfAllPizzas() {

        System.out.println("Summary:");
        System.out.println("The total of all orders is " + CisUtility.toCurrency(costOfAllPizzas));

    }


}
