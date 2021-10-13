/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.fahrenheittocelsius;
import java.util.Scanner;

/**
 * Exercise #3 - Lab Activity - Fahrenheit to Celsius converter
 * @author zulianideoliveiraa
 * @since 20211409
 */
public class Controller {
    
    public static final double FIVE_NINETH = 0.5556;
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        //Initial message to the user
        System.out.println("Enter the Fahrenheit temperature value:");
        double temperatureFahrenheit = input.nextDouble();  //Reads the Fahrenheit temperature
        
        //Calculation time
        double temperatureCelsius = (temperatureFahrenheit - 32) * (5.0/9); //Converts the temperature (F - 32) * 5/9
        
        //System Printouts
        System.out.println("Temperature in Fahrenheit: " + temperatureFahrenheit + "°F");
        System.out.println("Temperature in Celsius: " + temperatureCelsius + "°C");        
    }
}
