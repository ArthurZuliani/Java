/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.dogboarding;
import java.util.Scanner;

/**
 * Exercise #2 - Lab Activity - Dog Boarding
 * @author zulianideoliveiraa
 * @since 20211409
 */
public class Controller {
    
    public static final double COST_POUND_DAY = 0.50;
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        //Reads the data from the user
        //System.out.println("");
        System.out.println("Dog weight: ");
        int dogWeight = input.nextInt();    //Read dog weight in pounds
        //input.nextLine();   //Flush the "ENTER" value from buffer
        System.out.println("");
        
        System.out.println("Number of days: ");
        int numberOfDays = input.nextInt();    //Read number of days
        //input.nextLine();   //Flush the "ENTER" value from buffer
        System.out.println("");
        
        //Calculations
        double totalPrice = ((dogWeight * COST_POUND_DAY) * numberOfDays);
        
        //System printouts
        System.out.println("TotalPrice: $" + totalPrice);
        
    }
}
