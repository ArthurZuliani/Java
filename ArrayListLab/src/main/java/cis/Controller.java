package cis;

import cis.util.CisUtility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * First practice with Array List
 *
 * @author Arthur Zuliani
 * @since 20220208
 */
public class Controller {

    public static double average = 0;
    
    public static final int USER_NUMBERS = 3;

    public static void main(String[] args) {

        getAverage();
    }

    /**
     * Gets user input and calculate average - Using Array List
     * 
     * @author Arthur Zuliani
     * @since 20220208
     */
    public static void getAverage() {
        
        ArrayList<Integer> userNumbers = new ArrayList();
       
        for (int currentInput = 0; currentInput < USER_NUMBERS; currentInput++) {
            userNumbers.add(CisUtility.getInputInt("Enter a number"));
        }

        average = 0;
        //1st option - regular For loop
        for (int currentValue = 0; currentValue < USER_NUMBERS; currentValue++) {
            average += userNumbers.get(currentValue);
        }
        
        System.out.println("The average is " + CisUtility.toFraction(average / USER_NUMBERS));
        
        //2nd option - For Enhanced loop
        average = 0;
        for (Integer currentNumber : userNumbers) {
            average += currentNumber;
        }
        
        System.out.println("The average is " + CisUtility.toFraction(average / userNumbers.size()));
        
        //3rd option - For Each - Note:  Is necessary that average variable is a global variable
        average = 0;
        userNumbers.forEach((currentNumber) -> average += currentNumber);
        
        System.out.println("The average is " + CisUtility.toFraction(average / userNumbers.size()));
    }
    
}
