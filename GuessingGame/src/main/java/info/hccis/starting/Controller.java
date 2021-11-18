package info.hccis.starting;

import info.hccis.starting.bo.Game;

/**
 *
 * @author bjmaclean
 * @since Oct 19, 2021
 */
public class Controller {

    public static void main(String[] args) {
        
        Game game = new Game(10);

        game.setWinnigRandomNumber();//This method will pick a random number which will be used as the winning number.

        game.getInformation();  //This method get the user to enter their guess

        System.out.println(game.determineTheWinner()); //This method will determine and show the winner.
        System.out.println(game.getWinnigRandomNumber());
    }
}
