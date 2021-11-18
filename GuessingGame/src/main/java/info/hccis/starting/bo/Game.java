package info.hccis.starting.bo;

import info.hccis.util.CisUtility;

/**
 * This class will handle game mechanics
 *
 * @author Arthur Zuliani
 * @since 20211109
 */
public class Game {

    private int userGuess;
    private int maximumNumber;
    private int winnigRandomNumber;

    /**
     * Default constructor
     *
     * @author Arthur Zuliani
     * @since 20211109
     */
    public Game() {

    }

    /**
     * Custom constructor that accepts the maximum number of guesses
     *
     * @author Arthur Zuliani
     * @since 20211109
     * @param maximumNumber 
     */
    public Game(int maximumNumber) {
        this.maximumNumber = maximumNumber;
        setWinnigRandomNumber();
    }

    /**
     * Gets the user guess number
     *
     * @author Arthur Zuliani
     * @since 20211109
     */
    public void getInformation() {
        userGuess = CisUtility.getInputInt("Enter gues between 1 and " + maximumNumber);
    }

    /**
     * This method will return if the guess is winner or not
     *
     * @author Arthur Zuliani
     * @since 20211109
     * @return the string with the result
     */
    public String determineTheWinner() {

        String outputString = "";

        if (userGuess == winnigRandomNumber) {
            outputString += "You are the Winner";
        } else {
            outputString += "You are a Loser";
        }

        return outputString;
    }

    //Setters and getters 
    public int getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(int userGuess) {
        this.userGuess = userGuess;
    }

    public int getMaximumNumber() {
        return maximumNumber;
    }

    public void setMaximumNumber(int maximumNumber) {
        this.maximumNumber = maximumNumber;
    }

    public int getWinnigRandomNumber() {
        return winnigRandomNumber;
    }

    public final void setWinnigRandomNumber() {
        this.winnigRandomNumber = CisUtility.getRandom(1, maximumNumber);
    }

    /**
     * This method will display the result
     */
}
