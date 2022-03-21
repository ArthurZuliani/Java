package cis.bo;

import cis.util.CisUtility;

/**
 * Handles BoardRoom features
 * 
 * @author Arthur
 * @since 20220321
 */
public class BoardRoom extends Room {

    private boolean coffeeMakerEnabled;

    /**
     * Default constructor
     * 
     * @author Arthur Zuliani
     * @since 20220321
     */
    public BoardRoom() {

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
     * @param coffeMakerEnabled
     */
    public BoardRoom(String roomNumber, boolean available, int numberOfSeats, boolean coffeMakerEnabled) {
        super(roomNumber, available, numberOfSeats);
        this.coffeeMakerEnabled = coffeMakerEnabled;
    }

    /**
     * Get information from the user (super + coffee maker)
     * 
     * @author Arthur Zuliani
     * @since 20220321
     */
    @Override
    public void getInformation() {
        super.getInformation();

        coffeeMakerEnabled = CisUtility.getInputString("Do you need the coffee maker? (Y / N)").equalsIgnoreCase("y");
    }

    //Setters and getters
    public boolean isCoffeMakerEnabled() {
        return coffeeMakerEnabled;
    }

    public void setCoffeMakerEnabled(boolean coffeMakerEnabled) {
        this.coffeeMakerEnabled = coffeMakerEnabled;
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
                + "Coffee maker enabled :" + (coffeeMakerEnabled ? "Yes" : "NO");
    }
}
