package cis1232_lab_20170111;

import java.util.Arrays;

/**
 * This project will be used to work through the array practice activities for
 * week 1.
 *
 * @author bjmaclean
 * @since 20170111
 */
public class CIS1232_Lab_20170111 {

    private static int[] testIntArray = {1, 3, 5, 7, 9};
    private static int[] testIntArray2 = {1, 3, 5, 3, 1};
    private static int[] testIntArray3 = {1, 3, 4,6,5, 3, 1};

    public static void main(String[] args) {

        double average = ArrayProcessing.getAverage(testIntArray);
        System.out.println("Calling getAverage for " + Arrays.toString(testIntArray) + " average=" + average);

        int total = ArrayProcessing.getTotal(testIntArray);
        System.out.println("Calling getTotal for " + Arrays.toString(testIntArray) + " total=" + total);

        int numberOfEvenNumbers = ArrayProcessing.getNumberOfEvenNumbers(testIntArray3);
        System.out.println("Calling getNumberOfEvenNumbers for " + Arrays.toString(testIntArray3) + " #=" + numberOfEvenNumbers);

        int[] test = {4, 5, 6, 7, 8, 9};
        int numberOfNumbersDivisible = ArrayProcessing.getNumberDivisible(test, 3);
        System.out.println("Calling getNumberDivisible for " + Arrays.toString(test) + " #=" + numberOfNumbersDivisible);

        int[] test2 = {5, 1, 7, 5, 7, 7, 5};
        int result = ArrayProcessing.getMostPopular(test2);
        System.out.println("Calling getMostPopular for " + Arrays.toString(test2) + " #=" + result);
        
        int[] test3 = {4, 5, 5, 6, 7, 8, 9};
        boolean result2 = ArrayProcessing.getIfHasDuplicates(test3);
        System.out.println("Calling getIfHasDuplicates for " + Arrays.toString(test3) + " #=" + result2);

    }

}
