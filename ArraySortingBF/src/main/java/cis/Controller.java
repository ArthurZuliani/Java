package cis;

import cis.util.CisUtility;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * A starting project which we can use for applications that need a menu driven
 * program. Note that the name of the project should be modified to reflect the
 * specific requirements.
 *
 * @author bjmaclean
 * @since 20181115
 */
public class Controller {

    public static String[] classList = {"AM", "AV", "CF", "DD", "AZ", "FS", "FBN", "GA", "BD", "HE", "JR",};

    public static String[][] classLayout = new String[4][5];
    
    public static final String EXIT = "X";

    private static final String MENU
            = "\n-------------------------\n"
            + "- CIS Menu\n"
            + "- A-Sort Forward\n"
            + "- B-Sort Backwords\n"
            + "- C-Sort Backwords (without Collections)\n"
            + "- D-Show class layout row\n"
            + "- X-eXit\n"
            + "-------------------------\n"
            + "Option-->";

    public static void main(String[] args) {


        //AV OO JC MK AZ
        //MM MI MC CF JS
        //HE ZS BD DD JR
        //XX MD NG XX SS
        classLayout[0][0] = "AV";
        classLayout[0][1] = "OO";
        classLayout[0][2] = "JC";
        classLayout[0][3] = "MK";
        classLayout[0][4] = "AZ";

        int lengthOfSecondRow = classLayout[1].length;

        classLayout[1][0] = "MM";
        classLayout[1][1] = "MI";
        classLayout[1][2] = "MC";
        classLayout[1][3] = "CF";
        classLayout[1][4] = "JS";

        classLayout[2][0] = "HE";
        classLayout[2][1] = "ZS";
        classLayout[2][2] = "BD";
        classLayout[2][3] = "DD";
        classLayout[2][4] = "JR";

        classLayout[3][0] = " ";
        classLayout[3][1] = "MD";
        classLayout[3][2] = "NG";
        classLayout[3][3] = " ";
        classLayout[3][4] = "SS";

        for (int row = 0; row < classLayout.length; row++) {
            for (int column = 0; column < classLayout[row].length; column++) {
                System.out.print(classLayout[row][column] + "\t");
            }
            System.out.println("");
        }

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
                sortForward();
                break;
            case "B":
                sortBackwards();
                break;
            case "C":
                sortBackwards2();
                break;
            case "D":
                showRow();
                break;
            case "X":
                CisUtility.display("User picked x");
                break;
            default:
                CisUtility.display("Invalid entry");
        }
    }

    /**
     * Sorts the array backwards using collections
     *
     * @author Arthur Zuliani
     * @since 20220131
     */
    public static void sortBackwards() {
        Arrays.sort(classList, Collections.reverseOrder());
        System.out.println(Arrays.toString(classList));
    }

    /**
     * Sorts the array backwards without using collections
     *
     * @author Arthur Zuliani
     * @since 20220131
     */
    public static void sortBackwards2() {
        Arrays.sort(classList);

        String reversed = "";
        for (String currentInitial : classList) {
            reversed = currentInitial + " " + reversed;
        }
        System.out.println(Arrays.toString(classList));
        System.out.println(reversed);
    }

    /**
     * Sorts the array forward using collections
     *
     * @author Arthur Zuliani
     * @since 20220131
     */
    public static void sortForward() {
        Arrays.sort(classList);
        System.out.println(Arrays.toString(classList));
    }

    /**
     * Show students' initials from a class layout row
     * 
     * @author Arthur Zuliani
     * @since 20220131
     */
    public static void showRow() {
        
        int rowNumber = CisUtility.getInputInt("Enter row number: ");
        System.out.println(Arrays.toString(classLayout[rowNumber - 1]));
    }
}
