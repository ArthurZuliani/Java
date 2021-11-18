package info.hccis.starting;

import info.hccis.util.CisUtility;

/**
 * This is the main class for the application EvenEntryLoop
 *
 * @author Arthur Zuliani
 * @since 2021-11-16
 */
public class Controller {

    public static int userNumber = 0;

    public static void main(String[] args) {

        while (userNumber != 999) {

            userNumber = CisUtility.getInputInt("Enter an even number to continue or 999 to stop");

            if (userNumber % 2 == 0) {
                System.out.println("Good Job!");
            } else if (userNumber != 999) {
                System.out.println("Invalid number (odd number)");
            }
        }
    }
}
