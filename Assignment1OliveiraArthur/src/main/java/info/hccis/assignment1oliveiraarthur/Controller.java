//This package name is different from programming standard because it has the same name of the project
//which is following the standard posted in Assignment1 - Assignment1LastFirst 
package info.hccis.assignment1OliveiraArthur; 

import java.util.Scanner;

/**
 * @author Arthur Zuliani de Oliveira
 * @since 20210914
 *
 * Assignment 1 - Java Program - Will's Summer Services
 */
public class Controller {

    //Creation of global constants to use in calculations section
    public static final double COST_SQUARE_METER = 0.016;
    public static final double COST_VEHICLE_WASHED = 20.0;

    public static void main(String[] args) {

        //Prepare the input to read the keyboard
        Scanner input = new Scanner(System.in);

        //Bussiness information to be prompt to the user
        System.out.println();   //This blank line is just to layout be equal to the "Expected I/O"
        System.out.println("---------------------------------");
        System.out.println("- Welcome to Will's Summer Services");
        System.out.println("---------------------------------");
        System.out.println();

        //Here starts the interactive section, where the user will enter the requested information
        System.out.println("Client's name?");
        String name = input.nextLine();

        //There is no burn line below because the next reading will be just numeric values (doubles and integers), 
        //so the "enter" in buffer will not interfer.
        System.out.println("What is the length of the lawn(meters)?");
        double lawnLength = input.nextDouble(); //double because the length can be a not integer number
        System.out.println("What is the width of the lawn(meters)?");
        double lawnWidth = input.nextDouble();  //double because the width can be a not integer number
        System.out.println("How many vehicles to wash?");
        int numberOfVehicles = input.nextInt(); //int because the vehicles are clean as whole
        System.out.println("---------------------------------");

        //Calculations time and preparation to the summary print-out
        double squareMeters = lawnLength * lawnWidth;   //double variable because the lawn dimensions can be a not integer number
        double costOfCut = squareMeters * COST_SQUARE_METER;    //double variable because the cost is a double value
        double costOfWash = numberOfVehicles * COST_VEHICLE_WASHED; //double was chose to have the same print out pattern (i.e: $20.0) 
        double totalCost = costOfCut + costOfWash;  //double because the total will have a sum of 2 double values

        //Receipt printout - Summary as Expected I/O
        System.out.println("- Summary for " + name);
        System.out.println("- Size of lawn: " + squareMeters + " square meters");
        System.out.println("- Cost for grass cutting: $" + costOfCut);
        System.out.println("- Vehicles to wash: " + numberOfVehicles);
        System.out.println("- Cost for washing: $" + costOfWash);
        System.out.println("- Total cost: $" + totalCost);
        System.out.println("---------------------------------");
        System.out.println();   //This blank line is just to layout be equal to the "Expected I/O"
    }
}
