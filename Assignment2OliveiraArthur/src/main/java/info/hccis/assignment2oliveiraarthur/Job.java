/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.assignment2oliveiraarthur;

import java.util.Scanner;

/**
 * @author Arthur Zuliani
 * @since 20211006
 *
 * Assignment 2 - Java Program - Job class
 */
public class Job {
        
    private String userName;
    private int lengthOfLawn;
    private int widthOfLawn;
    private int numberOfVehicles;
    
    private int area;
    private double costGrassCutting;
    private double costWashing;
    private double costTotal;
        
    //Creation of public constants to use in calculations
    public static final String BUSINESS_NAME = "Will's Summer Services";
    public static final double COST_PER_SQUARE_METER = 0.016;
    public static final double COST_WASH_PER_VEHICLE = 20.0;
    
    
    /**
     * Default constructor
     * @author Arthur Zuliani
     * @since 20211006
     */
    public Job(){
        
    }
    
    /**
     * Constructor with the userName input
     * @author Arthur Zuliani
     * @since 20211006
     * @param userName
     */
    public Job(String userName) {
        this.userName = userName;
    }
    
    /**
     * Constructor for all private attributes, except calculations resutls 
     * @author Arthur Zuliani
     * @since 20211006
     * @param userName
     * @param lengthOfLawn
     * @param widthOfLawn 
     * @param numberOfVehicles 
     */
    public Job(String userName, int lengthOfLawn, int widthOfLawn, int numberOfVehicles){
        this.lengthOfLawn = lengthOfLawn;
        this.widthOfLawn = widthOfLawn;
        this.numberOfVehicles = numberOfVehicles;
    }
    
    /**
     * This method prompts the user for input information about his name, lawn size and amount of cars
     * @author Arthur Zuliani
     * @since 20211006
     */
    public void getInformation(){
        
        //Prepare the input to read the keyboard
        Scanner input = new Scanner(System.in);
    
        //Here starts the interactive section, where the user will enter the requested information
        System.out.println("Client's name?");
        userName = input.nextLine();

        System.out.println("What is the length of the lawn(meters)?");
        lengthOfLawn = input.nextInt();
        input.nextLine();  //burn
        
        System.out.println("What is the width of the lawn(meters)?");
        widthOfLawn = input.nextInt();
        input.nextLine();  //burn
        
        System.out.println("How many vehicles to wash?");
        numberOfVehicles = input.nextInt();
        input.nextLine();  //burn
    }
    
    /**
     * This method calculates the whole cost for grass cutting, washing cost and total cost
     * @author Arthur Zuliani
     * @since 20211006
     * @return the total cost
     */
    public double calculateCost(){
        area = lengthOfLawn * widthOfLawn;
        costGrassCutting = area * COST_PER_SQUARE_METER;
        costWashing = numberOfVehicles * COST_WASH_PER_VEHICLE;
        costTotal = costGrassCutting + costWashing; 
     
        return costTotal;        
    }
    
    //Start of Getters and Setters of the class
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLengthOfLawn() {
        return lengthOfLawn;
    }

    public void setLengthOfLawn(int lengthOfLawn) {
        this.lengthOfLawn = lengthOfLawn;
    }

    public int getWidthOfLawn() {
        return widthOfLawn;
    }

    public void setWidthOfLawn(int widthOfLawn) {
        this.widthOfLawn = widthOfLawn;
    }

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCostGrassCutting() {
        return costGrassCutting;
    }

    public void setCostGrassCutting(double costGrassCutting) {
        this.costGrassCutting = costGrassCutting;
    }

    public double getCostWashing() {
        return costWashing;
    }

    public void setCostWashing(double costWashing) {
        this.costWashing = costWashing;
    }

    public double getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(double costTotal) {
        this.costTotal = costTotal;
    }
    
    /**
     * This method prints out the summary to the user
     * @author Arthur Zuliani
     * @since 20211006
     */
    public void display(){
        //Receipt printout - Summary as Expected I/O
        System.out.println(toString());
    }
    
    /**
     * This method prepares the output string to be printed
     * @author Arthur Zuliani
     * @since 20211006
     */
    @Override
    public String toString(){
        
        String outputString = "---------------------------------" + System.lineSeparator()
                                + "- Summary for " + userName + System.lineSeparator() 
                                + "- Size of lawn: " + area + " square meters" + System.lineSeparator()
                                + "- Cost for grass cutting: $" + costGrassCutting + System.lineSeparator()
                                + "- Vehicles to wash: " + numberOfVehicles + System.lineSeparator()
                                + "- Cost for washing: $" + costWashing + System.lineSeparator()
                                + "- Total cost: $" + costTotal + System.lineSeparator()
                                + "---------------------------------" + System.lineSeparator();        
        return outputString;
    }
}

    
   
        
        
        