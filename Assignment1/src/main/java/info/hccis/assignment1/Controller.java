/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.assignment1;

import java.util.Scanner;

/**
 * Assignment 1 - Java Program
 *
 * @since 20210914
 * @author Arthur Zuliani
 */
public class Controller {

    public static final double COST_SQUARE_METER = 0.016;
    public static final double COST_VEHICLE_WASHED = 20.0;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("- Welcome to Will's Summer Services");
        System.out.println("---------------------------------");
        System.out.println();

        System.out.println("Client's name?");
        String name = input.nextLine();
        System.out.println("What is the length of the lawn(meters)?");
        int lawnLength = input.nextInt();
        System.out.println("What is the width of the lawn(meters)?");
        int lawnWidth = input.nextInt();
        System.out.println("How many vehicles to wash?");
        int numberOfVehicles = input.nextInt();
        System.out.println("---------------------------------");

        //Calculations time
        int squareMeters = lawnLength * lawnWidth;
        double costOfCut = squareMeters * COST_SQUARE_METER;
        double costOfWash = numberOfVehicles * COST_VEHICLE_WASHED;
        double totalCost = costOfCut + costOfWash;

        //Receipt printout
        System.out.println("- Summary for " + name);
        System.out.println("- Size of lawn: " + squareMeters + " square meters");
        System.out.println("- Cost for grass cutting: $" + costOfCut);
        System.out.println("- Vehicles to wash: " + numberOfVehicles);
        System.out.println("- Cost for washing: $" + costOfWash);
        System.out.println("- Total cost: $" + totalCost);
        System.out.println("---------------------------------");
    }
}
