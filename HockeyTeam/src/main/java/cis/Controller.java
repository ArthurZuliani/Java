/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis;

import cis.entity.Player;
import cis.util.CisUtility;

/**
 * Goal tracking app using three one dimensional arrays
 *
 * @author bjmaclean
 * @since 20220124
 */
public class Controller {

    public static final String EXIT = "X";

    private static final String MENU
            = "-------------------------\n"
            + "- CIS Menu\n"
            + "- A-Add a goal\n"
            + "- S-Show player stats\n"
            + "- X-eXit\n"
            + "-------------------------\n"
            + "Option-->";

    public static final int NUMBER_PLAYERS = 20;
    public static final int NUMBER_GAMES = 3;

    //private static int[][] playerDetails = new int[NUMBER_GAMES][NUMBER_PLAYERS];
    private static Player[] players = new Player[NUMBER_PLAYERS];

    public static void main(String[] args) {
        
        //Initialize the array with player numbers
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(i+1);
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
                CisUtility.display("Add a player");
                addGoal();
                break;
            case "S":
                CisUtility.display("Player details");
                showDetails();
                break;
            case "X":
                CisUtility.display("User picked x");
                break;
            default:
                CisUtility.display("Invalid entry");
        }
    }

    /**
     * Add a goal into player's score
     *
     * @author Arthur Zuliani
     * @since 20220124
     */
    public static void addGoal() {

        int gameNumber = CisUtility.getInputInt("Game#");
        int playerNumber = CisUtility.getInputInt("Player#");

        //Validate game number
        boolean valid = true;
        if (gameNumber < 1 || gameNumber > NUMBER_GAMES) {
            System.out.println("Invalid game number");
            valid = false;
        }

        if (playerNumber < 1 || playerNumber > NUMBER_PLAYERS) {
            System.out.println("Invalid game number");
            valid = false;
        }

        if (valid) {
            //playerDetails[gameNumber - 1][playerNumber - 1]++;
            players[playerNumber - 1].setGoalsNumber(gameNumber-1);
        }

    }

    /**
     * Display player's scores
     *
     * @author BJ
     * @modified by Arthur Zuliani
     * @since 20220124
     */
    public static void showDetails() {

        for(Player currentPlayer : players) {
            currentPlayer.display();
        }
        
//        for (int i = 0; i < NUMBER_GAMES; i++) {
//            System.out.println("Game" + (i + 1));
//            for (int j = 0; j < NUMBER_PLAYERS; j++) {
//                if (playerDetails[i][j] > 0) {
//                    System.out.println("Player #" + (j + 1)
//                            + " scored " + playerDetails[i][j] + " goals");
//                }
//            }
//        }
    }
}
