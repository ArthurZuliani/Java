package info.hccis.starting;

import info.hccis.util.CisUtility;
import info.hccis.starting.bo.BabysittingJob;

/**
 * This is the main class for Baby Sitter application
 *
 * @author Arthur Zuliani
 * @since 2021-11-23
 */
public class Controller {

    public static final String MENU = "--------------------" + System.lineSeparator()
            + "Georgette Babysitting" + System.lineSeparator()
            + "A-Create a custom job" + System.lineSeparator()
            + "B-Cindy example" + System.lineSeparator()
            + "C-Greg example" + System.lineSeparator()
            + "Q-Quit" + System.lineSeparator()
            + "--------------------" + System.lineSeparator()
            + "Option -->";

    public static void main(String[] args) {

        System.out.println("Welcome (" + CisUtility.getTodayString("yyyy-MM-dd") + ")");
        System.out.println("");

        String option = "";

        while (!option.equalsIgnoreCase("Q")) {

            option = CisUtility.getInputString(MENU);
            option = option.toUpperCase();

            switch (option) {
                case "A":   //The user must fill the information
                    BabysittingJob job1 = new BabysittingJob();
                    job1.getInformation();
                    job1.display();
                    break;
                case "B":   //It corresponds to Cindy given example
                    BabysittingJob job2 = new BabysittingJob(210001, 2, 3, 2);
                    job2.display();
                    break;
                case "C":   //It corresponds to Greg given example
                    BabysittingJob job3 = new BabysittingJob(210002, 1, 4, 4);
                    job3.display();
                    break;
                case "Q":
                    System.out.println("thanks for using our program - have a good day");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
