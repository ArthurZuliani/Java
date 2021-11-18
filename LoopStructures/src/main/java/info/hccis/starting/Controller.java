package info.hccis.starting;

import info.hccis.util.CisUtility;

/**
 *
 * @author Arthur Zuliani
 * @since 2021-11-16
 */
public class Controller {

    public static final String MENU = "CIS Menu" + System.lineSeparator()
            + "A - to draw lines with (x)" + System.lineSeparator()
            + "B - to sum 1 to n" + System.lineSeparator()
            + "C - to enter multiples of 12" + System.lineSeparator()
            + "X - to Exit the program" + System.lineSeparator();

    public static void main(String[] args) {

        System.out.println("Welcome (" + CisUtility.getTodayString("yyyy-MM-dd") + ")");

        String option = "";

        while (!option.equalsIgnoreCase("X")) {
            option = CisUtility.getInputString(MENU).toUpperCase(); //I used toUpperCase() to enable both cases options
            switch (option) {
                case "A":
                    drawXLines();
                    break;
                case "B":
                    SumOneToN();
                    break;
                case "C":
                    VerifyIfMultipleOfTwelve();
                    break;
                case "X":
                    System.out.println("thanks for using our program - have a good day");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }

    /**
     * This method will draw lines with spaces and a X to the output Ps.: Local
     * variables to not mix with other process variables
     *
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public static void drawXLines() {

        int spaceCounter = 0;
        int linesNumber = CisUtility.getInputInt("Enter the number of lines to draw");

        //Initial Arthur's solution
//        for (int i = 0; i < linesNumber; i++) {
//
//            for (int j = 0; j < spaceCounter; j++) {
//                System.out.print(" ");
//            }
//            System.out.println("x");
//            spaceCounter++;
//        }
        //The best solution (BJ flowchart)
        String output = "x";

        while (spaceCounter <= linesNumber) {
            System.out.println(output);
            output = " " + output;
            spaceCounter++;
        }
    }

    /**
     * This method will sum 1 to n, for every n from 1 to 50 
     * (out = n * (n+1)/2)
     *
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public static void SumOneToN() {
        int totalCount = 0;
        int currentNumber = 1;

        //While Solution
//        while (currentNumber <= 50) {
//            totalCount += currentNumber;
//
//            System.out.println(currentNumber + "-" + totalCount);
//            currentNumber++;
//        }

        //For Solution
        for (currentNumber = 1; currentNumber < 51; currentNumber++) {
            totalCount += currentNumber;
            System.out.println(currentNumber + "-" + totalCount);
        }
    }

    /**
     * This method will check if the number is multiple of 12
     *
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public static void VerifyIfMultipleOfTwelve() {

        boolean isMultipleOfTwelve;

        do {
            int enteredNumber = CisUtility.getInputInt("Enter a number multiple of 12");
            isMultipleOfTwelve = (enteredNumber % 12 == 0);

            if (!isMultipleOfTwelve) {
                System.out.println("Invalid number");
            } else {
                System.out.println("Thanks" + System.lineSeparator());
            }
        } while (isMultipleOfTwelve);

    }

}
