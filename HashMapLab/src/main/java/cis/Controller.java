package cis;

import cis.util.CisUtility;
import java.util.HashSet;

/**
 * Canes Camp application - Lab activity with HashSet
 *
 * @author Arthur Zuliani
 * @since 20220208
 */
public class Controller {

    public static HashSet<String> campers = new HashSet();

    public static final String EXIT = "X";
    private static final String MENU
            = "\n-------------------------\n"
            + "- Canes Campus\n"
            + "- A-Checkin\n"
            + "- B-Checkout\n"
            + "- C-Check if present\n"
            + "- D-Show all campers\n"
            + "- X-eXit\n"
            + "-------------------------\n"
            + "Option-->";

    public static void main(String[] args) {

        String option;

        CisUtility.display("Today is: " + CisUtility.getCurrentDate(null), "Red");

        do {
            option = CisUtility.getInputString(MENU, "Green");
            processMenuOption(option);
        } while (!option.equalsIgnoreCase(EXIT));
    }

    /**
     * This method will process the menu option specified in the input
     * parameter. It will call appropriate functionality based on its value.
     *
     * @param option The menu option
     * @since 20171102
     * @author cis1201b
     *
     * @modified by Arthur Zuliani - Added the new method calls
     */
    public static void processMenuOption(String option) {

        //Add a switch to process the option
        switch (option.toUpperCase()) {
            case "A":
                checkIn();
                break;
            case "B":
                checkOut();
                break;
            case "C":
                checkPresence();
                break;
            case "D":
                showAllCampers();
                break;
            case "X":
                CisUtility.display("User picked x");
                break;
            default:
                CisUtility.display("Invalid entry");
        }
    }

    /**
     * This method check in a new camper
     * 
     * @author Arthur Zuliani
     * @since 20220209
     */
    public static void checkIn() {

        System.out.println("----- Checkin -----");
        String name = capitalizeFirstLetter(CisUtility.getInputString("Enter camper's name: "));

        campers.add(name);
        System.out.println("Checkin completed for " + name);
    }

    /**
     * This method check out a camper
     * 
     * @author Arthur Zuliani
     * @since 20220209
     */
    public static void checkOut() {

        System.out.println("----- Checkout -----");
        String name = capitalizeFirstLetter(CisUtility.getInputString("Enter camper's name: "));

        boolean isPresent = campers.contains(name);
        if (isPresent) {
            campers.remove(name);
            System.out.println("Checkout completed for " + name);
        } else {
            System.out.println("There is anyone with this name with us right now");
        }
    }

    /**
     * This method check if the camper is present in the camp
     * 
     * @author Arthur Zuliani
     * @since 20220209
     */
    public static void checkPresence() {

        System.out.println("----- Check if present -----");
        String name = capitalizeFirstLetter(CisUtility.getInputString("Enter camper's name: "));

        boolean isPresent = campers.contains(name);
        if (isPresent) {
            System.out.println(name + " is present");
        } else {
            System.out.println(name + " is not here with us");
        }
    }

    /**
     * This method show all campers presents
     * 
     * @author Arthur Zuliani
     * @since 20220209
     */
    public static void showAllCampers() {

        if (campers.size() > 0) {

            System.out.println("----- All Campers -----");
            for (String currentCamper : campers) {
                System.out.println(currentCamper);
            }
        } else {
            System.out.println("There is anyone with us now");
        }

    }

    /**
     * This method capitalizes the first letter of a string
     * 
     * @author Arthur Zuliani
     * @since 20220209
     * 
     * @param inputString 
     * @return String with Capitalized First Letter
     */
    public static String capitalizeFirstLetter(String inputString) {
        String outputString;

        return outputString = inputString.substring(0, 1).toUpperCase() + inputString.substring(1).toLowerCase();
    }

}
