package cis;

import cis.entity.Cup;
import cis.util.CisUtility;
import java.util.ArrayList;
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

    public static final int NUMBER_OF_CUPS = 1000;
    
    public static void main(String[] args) {

        ArrayList<Cup> theCups = new ArrayList();

        int winnersAmount = 0;
        for (int currentCup = 0; currentCup < NUMBER_OF_CUPS; currentCup++) {
            
            theCups.add(new Cup());
            theCups.get(currentCup).display();
            
            if(theCups.get(currentCup).isWinner()) {
                winnersAmount++;
            }
        }
        
        System.out.println("Total amount of winners is: " + winnersAmount);
    }


}
