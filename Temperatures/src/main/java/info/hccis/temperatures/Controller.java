package info.hccis.temperatures;

import java.util.Scanner;
/**
 * Activity 5.2 - Topic 4 - Selection 
 * 
 * @author Arthur Zuliani
 * @since 20211019
 */
public class Controller {

    public static void main(String args[]){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the higher temperature value (F):");
        double highTemperature = input.nextDouble();
        input.nextLine();   //Burn the line
        
        System.out.println("Enter the lower temperature value (F):");
        double lowTemperature = input.nextDouble();
        input.nextLine();   //Burn the line
        
        double temperatureDifference = highTemperature - lowTemperature;
        
        if(highTemperature >= 90){
            System.out.println("Heat warninng. \r\n");
        }
        if(lowTemperature < 32){
            System.out.println("Freeze warninng. \r\n");            
        }
        if(temperatureDifference > 40){
            System.out.println("Large temperature swing. \r\n");
        }        
    }
}
