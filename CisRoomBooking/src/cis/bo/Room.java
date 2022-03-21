package cis.bo;

import cis.util.CisUtility;

/**
 * Handles room features
 * 
 * @author Arthur
 * @since 20220321
 */
public class Room {

    private String roomNumber;
    private boolean available;
    private int numberOfSeats;

    /**
     * Default constructor
     * 
     * @author Arthur Zuliani
     * @since 20220321
     */
    public Room() {

    }

    /**
     * Custom constructor
     * 
     * @author Arthur Zuliani
     * @since 20220321
     * 
     * @param roomNumber
     * @param available
     * @param numberOfSeats
     */
    public Room(String roomNumber, boolean available, int numberOfSeats) {
        this.roomNumber = roomNumber;
        this.available = available;
        this.numberOfSeats = numberOfSeats;
    }

    /**
     * Get information from the user
     * 
     * @author Arthur Zuliani
     * @since 20220321
     */
    public void getInformation() {
        roomNumber = CisUtility.getInputString("What is the room number?");
        available = CisUtility.getInputString("Is the room available? (Y / N)").toLowerCase().equals("y");
        numberOfSeats = CisUtility.getInputInt("How many seats do you need?");
    }

    //Setters and Getters
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    /**
     * Displays the outputString of the object
     * 
     * @author Arthur Zuliani
     * @since 20220321
     */
    public void display() {
        System.out.println(toString());
    }

    /**
     * Craft the object output String
     * 
     * @author Arthur Zuliani
     * @since 20220321
     * 
     * @return outputString
     */
    @Override
    public String toString() {
        return "Room number: " + roomNumber + System.lineSeparator()
                + "Availability: " + (available ? "Available" : "Booked") + System.lineSeparator()
                + "Number of seats: " + numberOfSeats;
    }

}
