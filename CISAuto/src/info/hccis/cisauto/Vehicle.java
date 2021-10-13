/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.hccis.cisauto;
import java.util.Scanner;
/**
 *
 * @author zulianideoliveiraa
 * @since 
 */
public class Vehicle {
    
    private String make;
    private String model;
    private int modelYear;
    private double cost;
    
    /**
     * Default constructor
     * @author Arthur Zuliani
     * @since 20211012
     */
    public Vehicle(){
        
    }

    /**
     * Constructor that accepts all attributes initialization values
     * @author Arthur Zuliani
     * @since 20211012
     * @param make
     * @param model
     * @param modelYear
     * @param cost
     */
    public Vehicle(String make, String model, int modelYear, double cost) {
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
        this.cost = cost;
    }        
    
    /**
     * Method responsible to prompt the user for values of the vehicles
     * @author Arthur Zuliani
     * @since 20211012
     */
    public void getInformation(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter make:");
        make = input.nextLine();
        
        System.out.println("Enter model:");
        model = input.nextLine();
        
        System.out.println("Enter model year:");
        modelYear = input.nextInt();
        input.nextLine(); //Burn line
        
        System.out.println("Enter cost:");
        cost = input.nextDouble();
        input.nextLine(); //Burn line
    }

    //All getters/setters for private attributes
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    /**
     * Method responsible to display the information to the user
     * @author Arthur Zuliani
     * @since 20211012
     */  
    public void display(){
        System.out.println(toString());
    }

    /**
     * Method responsible to create the standard string to print out
     * @author Arthur Zuliani
     * @since 20211012
     * @return String to be printout
     */    
    @Override
    public String toString(){
        return modelYear + " " + make + " " + model + " $" + cost;
    }
}
