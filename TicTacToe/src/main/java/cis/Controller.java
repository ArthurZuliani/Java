package cis;

import cis.util.CisUtility;
import java.util.Arrays;

/**
 * Main class of TicTacToe game
 *
 * @author Arthur Zuliani
 * @since 20220201
 */
public class Controller {

    public static final int NUMBER_OF_COLUMN = 3;
    public static final int NUMBER_OF_ROW = 3;
    public static final int NUMBER_MAX_OF_PLAYS = 9;

    public static final String WINNER_STRING_X = "XXX";
    public static final String WINNER_STRING_O = "OOO";

    public static String[] columnOutput = new String[NUMBER_OF_COLUMN];
    public static String[] lineOutput = new String[NUMBER_OF_ROW];
    public static String[] diagonalOutput = new String[NUMBER_OF_ROW - 1];

    public static String[][] game = new String[NUMBER_OF_ROW][NUMBER_OF_COLUMN];

    public static final String EXIT = "X";

    private static final String MENU
            = "\n-------------------------\n"
            + "- CIS Menu\n"
            + "- A-Play TicTacToe\n"
            + "- X-eXit\n"
            + "-------------------------\n"
            + "Option-->";

    public static void main(String[] args) {

        //Initial board values
        game[0][0] = "1";
        game[0][1] = "2";
        game[0][2] = "3";

        game[1][0] = "4";
        game[1][1] = "5";
        game[1][2] = "6";

        game[2][0] = "7";
        game[2][1] = "8";
        game[2][2] = "9";
        
        //Add a loop below to continuously promput the user for their choice 
        //until they choose to exit.
        String option = "";

        CisUtility.display("Today is: " + CisUtility.getCurrentDate(null));

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
                game();
                break;
            case "X":
                break;
            default:
                CisUtility.display("Invalid entry");
        }
    }

    public static void game() {

        int positionNumber;
        String outputValue = "";

        //Allow the maximum playable turns
        for (int numberOfPlays = 0; numberOfPlays < (NUMBER_OF_COLUMN * NUMBER_OF_ROW); numberOfPlays++) {

            //Print current board state
            printBoard();

            //Check if the turn is for player X or O
            if (numberOfPlays % 2 > 0) {
                outputValue = "O";
            } else {
                outputValue = "X";
            }

            boolean isTurnValid;

            //This loop is to ensure that players just select available positions
            do {
                //Reset boolean variable
                isTurnValid = true;

                //Prompt user for next move
                positionNumber = CisUtility.getInputInt("Player " + outputValue + " - Enter the position number :");
                positionNumber--;

                if (game[(positionNumber / NUMBER_OF_ROW)][(positionNumber % NUMBER_OF_COLUMN)].equalsIgnoreCase("x")
                        || game[(positionNumber / NUMBER_OF_ROW)][(positionNumber % NUMBER_OF_COLUMN)].equalsIgnoreCase("o")) {
                    isTurnValid = false;
                    System.out.println("This position is not valid! PLay again");
                } else {
                    //Update board position
                    game[(positionNumber / NUMBER_OF_ROW)][(positionNumber % NUMBER_OF_COLUMN)] = outputValue;
                }
            } while (!isTurnValid);

            //Check if a victorious condition was achieved
            if (checkWinner(numberOfPlays + 1)) {
                printBoard();
                break;
            }
        }
    }

    /**
     * This method will check if there is a winner condition in the game
     *
     * @author Arthur Zuliani
     * @since 20220201
     */
    public static boolean checkWinner(int playsMade) {

        boolean isVictorious = false;

        //Ensures that output arrays are empty
        clearArrays();

        //This for loops are just to save results in one string for each type of possible victories
        for (int currentLine = 0; currentLine < game.length; currentLine++) {
            for (int currentColumn = 0; currentColumn < NUMBER_OF_COLUMN; currentColumn++) {

                //Stores line results
                lineOutput[currentLine] += game[currentLine][currentColumn];

                //Stores columns results
                columnOutput[currentColumn] += game[currentLine][currentColumn];

                //Stores diagonals results
                if (currentColumn == currentLine) {
                    diagonalOutput[0] += game[currentLine][currentColumn];
                    diagonalOutput[1] += game[currentLine][(NUMBER_OF_COLUMN - 1) - currentColumn];
                }
            }
        }

        //Just a control output to prevent debug use 
//        System.out.println("Columns " + Arrays.toString(columnOutput));
//        System.out.println("Lines " + Arrays.toString(lineOutput));
//        System.out.println("Diagonals " + Arrays.toString(diagonalOutput));
        //Tell when there is a victory condition
        for (int currentElement = 0; currentElement < NUMBER_OF_COLUMN; currentElement++) {

            if (lineOutput[currentElement].equalsIgnoreCase(WINNER_STRING_X) || lineOutput[currentElement].equalsIgnoreCase(WINNER_STRING_O)) {
                System.out.println("The " + lineOutput[currentElement].substring(0, 1).toUpperCase() + " is victorious");
                isVictorious = true;
                break;
            } else if (columnOutput[currentElement].equalsIgnoreCase(WINNER_STRING_X) || columnOutput[currentElement].equalsIgnoreCase(WINNER_STRING_O)) {
                System.out.println("The " + columnOutput[currentElement].substring(0, 1).toUpperCase() + " is victorious");
                isVictorious = true;
                break;
            } else if (currentElement < diagonalOutput.length) {
                if (diagonalOutput[currentElement].equalsIgnoreCase(WINNER_STRING_X) || diagonalOutput[currentElement].equalsIgnoreCase(WINNER_STRING_O)) {
                    System.out.println("The " + diagonalOutput[currentElement].substring(0, 1).toUpperCase() + " is victorious");
                    isVictorious = true;
                    break;
                }
            } else if (playsMade == NUMBER_MAX_OF_PLAYS) {
                System.out.println("Tied game!!!");
            }
        }

        return isVictorious;
    }

    /**
     * This method clear output arrays
     *
     * @author Arthur Zuliani
     * @since 20220201
     */
    public static void clearArrays() {

        //Initialize output results array with empty space
        for (int currentElement = 0; currentElement < NUMBER_OF_COLUMN; currentElement++) {
            columnOutput[currentElement] = "";
            lineOutput[currentElement] = "";
            if (currentElement < diagonalOutput.length) {
                diagonalOutput[currentElement] = "";
            }
        }
    }

    /**
     * This method printout the current board position
     *
     * @author Arthur Zuliani
     * @since 20220201
     */
    public static void printBoard() {
        System.out.println("Board position");
        for (String[] currentLine : game) {
            System.out.println(Arrays.toString(currentLine));
        }
    }
}
