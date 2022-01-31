/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis.entity;

import cis.util.CisUtility;
import java.util.Arrays;

/**
 *
 * @author Arthur
 */
public class Game {

    public static final String OPTION_1 = "Java";
    public static final String OPTION_2 = "JavaScript";
    public static final String OPTION_3 = "C#";

    public static final int NUMBER_OF_LINES = 3;
    public static final int NUMBER_OF_COLUMNS = 3;

    public static final int[] betChances = {1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};

    private int[][] spinOutput = new int[NUMBER_OF_LINES][NUMBER_OF_COLUMNS];
    private boolean[] lineTotals = new boolean[NUMBER_OF_LINES];

    private double startAmount = 0;
    private double betAmount = 10;
    private int linesToBet = 0;
    private int betNumber = 0;
    private double pay = 0;

    public Game() {

    }

    /**
     * Get user start money amount
     *
     * @author Arthur Zuliani
     * @since 20220127
     */
    public void getInformation() {

        startAmount = CisUtility.getInputDouble("Enter initial amount");

        betAmount = CisUtility.getInputDouble("Enter bet amount");

        linesToBet = CisUtility.getInputInt("Enter how many lines to bet");
    }

    /**
     * Spin and get random values for all places
     *
     * @author Arthur Zuliani
     * @since 20220127
     * @return spinned number
     */
    public void spinMachine() {

        int spinNumber = 0;
        int previous = 0;

        //Flush array
        for (int k = 0; k < NUMBER_OF_LINES; k++) {
            lineTotals[k] = true;
        }

        //Draw random numbers for spin machine
        for (int j = 0; j < NUMBER_OF_LINES; j++) {

            boolean flagFirstTime = true;

            for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {

                int spinTimes = CisUtility.getRandom(20);

                for (int randomIndex = 0; randomIndex < spinTimes; randomIndex++) {
                    spinNumber = CisUtility.getRandom(20);
                }
                spinOutput[j][i] = betChances[spinNumber];

                if (flagFirstTime) {
                    previous = spinOutput[j][i];
                    flagFirstTime = false;
                } else {
                    if (previous != spinOutput[j][i]) {
                        lineTotals[j] = false;
                    }
                }

            }
        }
    }

    /**
     * Display spin result
     *
     * @author Arthur Zuliani
     * @since 20220127
     */
    public void showResult() {

        String outputString = "";

        for (int[] currentLine : spinOutput) {

            for (int i = 0; i < currentLine.length; i++) {

                switch (currentLine[i]) {
                    case 1:
                        outputString += OPTION_1 + " ";
                        break;
                    case 2:
                        outputString += OPTION_2 + " ";
                        break;
                    case 3:
                        outputString += OPTION_3 + " ";
                        break;
                }
            }
            System.out.println(outputString);
            outputString = "";
        }

    }

    public void calculatePay() {

        for (int i = 0; i < NUMBER_OF_LINES; i++) {

            if (lineTotals[i] == true) {

                switch (spinOutput[i][0]) {
                    case 1:
                        pay = betAmount * 15;
                        break;
                    case 2:
                        pay = betAmount * 6;
                        break;
                    case 3:
                        pay = betAmount * 3;
                        break;
                }

            }

            System.out.println("Line #" + i + " won " + "$" + pay);
            pay = 0;
        }
    }
}
