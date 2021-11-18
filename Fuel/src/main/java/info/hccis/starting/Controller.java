package info.hccis.starting;

import info.hccis.starting.bo.FuelOrder;

/**
 * This is the main class for the Fuel application
 * 
 * @author Arthur Zuliani
 * @since 2021-11-16
 */
public class Controller {
    
    public static void main(String[] args) {

        FuelOrder newOrder1 = new FuelOrder(10,4,false);
        
        newOrder1.display();
        
        if(newOrder1.getCostOfOrder() > 100){
            System.out.println("Big Order");
        }
        
        FuelOrder newOrder2 = new FuelOrder();
        
        newOrder2.getInformation();
        newOrder2.display();
        
        if(newOrder2.getCostOfOrder() > 100){
            System.out.println("Big Order");
        }

    }
}
