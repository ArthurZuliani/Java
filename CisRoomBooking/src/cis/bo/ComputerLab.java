package cis.bo;

import cis.util.CisUtility;

/**
 * Handles Computer Lab features
 * 
 * @author Arthur
 * @since 20220321
 */
public class ComputerLab extends Room {

    private int numberOfComputers;

    /**
     * Default constructor
     * 
     * @author Arthur Zuliani
     * @since 20220321
     */
    public ComputerLab() {
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
     * @param numberOfComputers
     */
    public ComputerLab(String roomNumber, boolean available, int numberOfSeats, int numberOfComputers) {
        super(roomNumber, available, numberOfSeats);
        this.numberOfComputers = numberOfComputers;
    }

    /**
     * Get information from the user (super + computer amount)
     * 
     * @author Arthur Zuliani
     * @since 20220321
     */
    @Override
    public void getInformation() {
        super.getInformation();
        numberOfComputers = CisUtility.getInputInt("How many computers do you need?");
    }

    //Setters and getters
    public int getNumberOfComputers() {
        return numberOfComputers;
    }

    public void setNumberOfComputers(int numberOfComputers) {
        this.numberOfComputers = numberOfComputers;
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
        return super.toString() + System.lineSeparator()
                + "Number of Computers: " + numberOfComputers;
    }
}
