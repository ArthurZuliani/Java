package info.hccis.cisauto;

/**
 * This activity will work with classes and methods. 
 * @author bjmaclean
 * @since 20161018
 * @modified by Arthur as required in Practical exam - Practice
 */
public class Controller {

    public static final String WELCOME_MESSAGE = "CIS Auto Application";
    
    public static void main(String[] args) {

        System.out.println(WELCOME_MESSAGE);
        System.out.println("");
        
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        Vehicle vehicle3 = new Vehicle();
        
        vehicle1.getInformation();
        vehicle2.getInformation();
        vehicle3.getInformation();        
        
        showSummary(vehicle1,vehicle2,vehicle3);
    }
    
    /**
     * Method responsible to show the vehicles summaries
     * @author Arthur Zuliani
     * @since 20211012
     * @param vehicle1
     * @param vehicle2
     * @param vehicle3 
     */
    private static void showSummary(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3){
        
        double totalCost = vehicle1.getCost() + vehicle2.getCost() + vehicle3.getCost();
        
        vehicle1.display();
        vehicle2.display();
        vehicle3.display();
        System.out.println("Total: $" + totalCost);        
    }
    
}
