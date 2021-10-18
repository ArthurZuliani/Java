/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.musicproject.bo;

import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class Student {

    private String name = "";
    private String favouriteInstrument = "";
    private double amountDonated = 0.0;

    /**
     * Default constructor
     *
     * @author Arthur Zuliani
     * @since 20211018
     */
    public Student() {

    }

    /**
     * Constructor that can assign a name to the student
     *
     * @author Arthur Zuliani
     * @since 20211018
     * @param name
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     * This method is responsible to get all information from the students
     *
     * @author Arthur Zuliani
     * @since 20211008
     */
    public void getInformation() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name:");
        name = input.nextLine();
        System.out.println("Enter your favourite instrument:");
        favouriteInstrument = input.nextLine();
        System.out.println("Enter amount to be donated (CDN):");
        amountDonated = input.nextDouble();
        input.nextLine(); //Burn the line
    }

    //All setters and getters for private attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavouriteInstrument() {
        return favouriteInstrument;
    }

    public void setFavouriteInstrument(String favouriteInstrument) {
        this.favouriteInstrument = favouriteInstrument;
    }

    public double getAmountDonated() {
        return amountDonated;
    }

    public void setAmountDonated(double amountDonated) {
        this.amountDonated = amountDonated;
    }

    /**
     * This method is responsible to print out the summary information
     *
     * @author Arthur Zuliani
     * @since 20211008
     */
    public void display() {
        System.out.println(toString());
    }

    /**
     * This method is responsible to build the output string for the class
     *
     * @author Arthur Zuliani
     * @since 20211008
     * @return the builded string
     */
    @Override
    public String toString() {

        return "" + System.lineSeparator()
                + "Student name: " + name + System.lineSeparator()
                + "Student favourite instrument: " + favouriteInstrument;
    }

}
