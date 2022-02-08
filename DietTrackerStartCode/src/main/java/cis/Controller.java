package cis;

import cis.util.CisUtility;
import java.util.Scanner;

/**
 * Diet tracker start code
 *
 * @author bjmaclean
 * @since 20220131
 */
public class Controller {

    //DATA STRUCTURES
    public static final int NUMBER_OF_DAYS = 2;
    public static final int NUMBER_OF_MEALS = 4;

    private static int[][] dietDetails = new int[NUMBER_OF_MEALS][NUMBER_OF_DAYS];

    public static final String[] LABEL_MEALS = {"Breakfast", "Lunch", "Dinner", "Bedtime Snack"};
    public static final String[] LABEL_DAYS = {"Saturday", "Sunday"};

    public static final int SATURDAY_INDEX = 0;
    public static final int SUNDAY_INDEX = 1;

    public static final int CALORIES_PER_LB = 3500;
    public static final int CALORIES_BURNT_PER_DAY = 2500;
    public static final int CALORIES_GOAL_AMOUNT = 2500;
    
    public static final int DAYS_IN_A_YEAR = 365;

    public static final int BEDTIME_INDEX = 3;
    public static final double BEDTIME_PERCENT = 0.20;

    public static double[] totalDayCalories = new double[NUMBER_OF_DAYS];

    public static final String EXIT = "X";
    private static final String MENU
            = "\n-------------------------\n"
            + "- CIS Diet Tracker\n"
            + "- A-Get weekend details\n"
            + "- B-Show total calories\n"
            + "- C-Days under 2500 calories\n"
            + "- D-Did they have 20% of weekend calories as snack?\n"
            + "- E-Weight gained per year based on these calories?\n"
            + "- X-eXit\n"
            + "-------------------------\n"
            + "Option-->";

    public static void main(String[] args) {

        //Just an array filler
        for (int i = 0; i < NUMBER_OF_MEALS; i++) {
            for (int j = 0; j < NUMBER_OF_DAYS; j++) {
                dietDetails[i][j] = 500;
            }
        }
        
        //Add a loop below to continuously promput the user for their choice 
        //until they choose to exit.
        String option = "";

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
     */
    public static void processMenuOption(String option) {
        //Add a switch to process the option
        switch (option.toUpperCase()) {
            case "A":
                getWeekendDetails();
                break;
            case "B":
                System.out.println("Total calories is: " + showTotalCalories());
                break;
            case "C":
                showDaysThatMetGoal();
                break;
            case "D":
                showIfTheyHad20PercentForSnack();
                break;
            case "E":
                showWeightGainPerYear();
                break;
            case "X":
                CisUtility.display("User picked x");
                break;
            default:
                CisUtility.display("Invalid entry");
        }
    }

    /**
     * This method will get user`s information about calories
     *
     * @author Arthur Zuliani
     * @since 20220201
     */
    public static void getWeekendDetails() {

        int inputCalories = 0;

        for (int currentDay = 0; currentDay < LABEL_DAYS.length; currentDay++) {
            for (int currentMeal = 0; currentMeal < LABEL_MEALS.length; currentMeal++) {
                inputCalories = CisUtility.getInputInt(LABEL_DAYS[currentDay] + "- Enter the number of calories for " + LABEL_MEALS[currentMeal]);

                if (inputCalories >= 0 && inputCalories <= 5000) {
                    dietDetails[currentMeal][currentDay] = inputCalories;
                } else {
                    System.out.println("Calories must be between 0 and 5000");
                    currentMeal--;
                }
            }
        }
    }

    /**
     * Shows the total calories for the weekend
     *
     * @author Arthur Zuliani
     * @since 20220201
     */
    public static double showTotalCalories() {

        double totalCalories = 0;

        for (int currentDay = 0; currentDay < NUMBER_OF_DAYS; currentDay++) {
            for (int currentMeal = 0; currentMeal < NUMBER_OF_MEALS; currentMeal++) {
                totalCalories += dietDetails[currentMeal][currentDay];
            }
            totalDayCalories[currentDay] = totalCalories;
        }

        return totalCalories;
    }

    /**
     * Shows the day that user is under 2500 calories and also the day`s total
     * amount
     *
     * @author Arthur Zuliani
     * @since 20220201
     */
    public static void showDaysThatMetGoal() {
        showTotalCalories();
        
        for (int currentDay = 0; currentDay < NUMBER_OF_DAYS; currentDay++) {

            if (totalDayCalories[currentDay] < CALORIES_GOAL_AMOUNT) {
                System.out.println("On " + LABEL_DAYS[currentDay] + " you are under your calorie goal (" + CALORIES_GOAL_AMOUNT
                        + ") with " + totalDayCalories[currentDay] + " calories");
            }
        }
    }

    /**
     * Shows if the user hit 20% of calories just in bedtime snack
     *
     * @author Arthur Zuliani
     * @since 20220201
     */
    public static void showIfTheyHad20PercentForSnack() {

        double bedtimeCalorie = 0;

        bedtimeCalorie = dietDetails[BEDTIME_INDEX][SATURDAY_INDEX] + dietDetails[BEDTIME_INDEX][SUNDAY_INDEX];
        double percentBedtimeCalories = (bedtimeCalorie / showTotalCalories());

        if (percentBedtimeCalories > BEDTIME_PERCENT) {
            System.out.println("Your bedtime snack calories is " + CisUtility.toPercent(percentBedtimeCalories));
        }

    }

    /**
     * This method show how much weight a user may lose or gain during a year
     * 
     * @author Arthur Zuliani
     * @since 20220201
     */
    public static void showWeightGainPerYear() {

        double totalCaloriesOverYear = 0;
        double netPound = 0;

        for (int currentWeekend = 0; currentWeekend < DAYS_IN_A_YEAR; currentWeekend++) {

            totalCaloriesOverYear += (showTotalCalories() / NUMBER_OF_DAYS) - CALORIES_BURNT_PER_DAY;
        }
        
        netPound = totalCaloriesOverYear / CALORIES_PER_LB;
        
        if(totalCaloriesOverYear > 0) {
            System.out.println("You gained " + CisUtility.toFraction(netPound) + " Lb");
        } else if (totalCaloriesOverYear < 0) {
            System.out.println("You lost " + CisUtility.toFraction(netPound) + " Lb");            
        } else {
            System.out.println("You did not gain or lose any Lb");
        }
        
    }

}
