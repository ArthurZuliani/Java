package cis;

import cis.util.CisUtility;
import java.util.Scanner;

import cis.entity.Game;

/**
 * A starting project which we can use for applications that need a menu driven
 * program. Note that the name of the project should be modified to reflect the
 * specific requirements.
 *
 * @author bjmaclean
 * @since 20181115
 */
public class Controller {

    public static final String EXIT = "X";

    public static Game game = new Game();

    private static final String MENU
            = "\n-------------------------\n"
            + "- CIS Menu\n"
            + "- A-Initial Amount\n"
            + "- B-Bet\n"
            + "- X-eXit\n"
            + "-------------------------\n"
            + "Option-->";

    public static void main(String[] args) {

        //Add a loop below to continuously promput the user for their choice 
        //until they choose to exit.        
        String option = "";

        CisUtility.display("Today is: " + CisUtility.getCurrentDate(null), "Red");
        CisUtility.display("The random number is " + CisUtility.getRandom(20), "Green");

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
     */
    public static void processMenuOption(String option) {
        //Add a switch to process the option
        switch (option.toUpperCase()) {
            case "A":
                game.getStartAmount();
                break;
            case "B":
                game.getBetAmount();
                game.spinMachine();
                game.calculatePay();
                game.showResult();
                break;
            case "X":
                break;
            default:
                CisUtility.display("Invalid entry");
        }
    }

}
