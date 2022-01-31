/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis1232_lab_20170111;

/**
 *
 * @author bjmaclean
 */
public class ArrayProcessing {

    /**
     * ACTIVITY 1 This method should return the average of all of the number
     * provided in the inArray. The average should then be passed back from the
     * method.
     *
     * @since 20170111
     * @author CIS
     */
    public static double getAverage(int[] inArray) {
        int outputAverage = 0;

        for (int currentElement : inArray) {
            outputAverage += currentElement;
        }
        return (outputAverage / inArray.length);
    }

    /**
     * ACTIVITY 2 This method should return the total of all of the number
     * provided in the inArray. The total should then be passed back from the
     * method.
     *
     * @since 20170111
     * @author CIS
     */
    public static int getTotal(int[] inArray) {

        int output = 0;

        for (int currentElement : inArray) {
            output += currentElement;
        }

        return output;
    }

    /**
     * ACTIVITY 3 This method should return the number of elements from the
     * inArray that are even numbers.
     *
     * @since 20170111
     * @author CIS
     */
    public static int getNumberOfEvenNumbers(int[] inArray) {

        int outputEvenAmount = 0;

        for (int currentElement : inArray) {

            if ((currentElement % 2) == 0) {
                outputEvenAmount++;
            }
        }

        return outputEvenAmount;
    }

    /**
     * ACTIVITY 4 This method should return the number of elements from the
     * inArray that multiples of the divisor that is passed in as a parameter.
     *
     * @since 20170111
     * @author CIS
     */
    public static int getNumberDivisible(int[] inArray, int divisor) {

        int outputMultiples = 0;

        for (int currentElement : inArray) {

            if ((currentElement % divisor) == 0) {
                outputMultiples++;
            }
        }

        return outputMultiples;
    }

    /**
     * ACTIVITY 5 This method should return the most popular int. It can be
     * assumed that the elements in the inArray are between 1-10. If there is
     * more than one that is the most popular then the method should just return
     * the first one. Ie {1,3,3,4,4} would return 3.
     *
     * @since 20170111
     * @author CIS
     */
    public static int getMostPopular(int[] inArray) {

        //Arthur's solution
        int outputMostPopular = 0;
        int times = 0;
        int highest = 0;

        int[] tempTest = new int[inArray.length];

        //Test the positions, and save how many times the answer was true
        for (int i = 0; i < inArray.length; i++) {
            for (int j = 0; j < inArray.length; j++) {

                if ((inArray[j] / inArray[i] == 1) && (inArray[j] % inArray[i] == 0)) {
                    times++;
                }
            }
            tempTest[i] = times;
            times = 0;
        }
        
        //Once the repetition time is recorded, just verify which one repeat most
        for(int numbers : tempTest){
            if(numbers > highest) {
                highest = numbers;
            }
        }
        
        //Find the first position where the repetition number matches and show the number
        for (int i = 0; i < tempTest.length; i++) {
            if(tempTest[i] == highest) {
                outputMostPopular = inArray[i];
            }
        }
         
        return outputMostPopular;
        
        //BJ's solution
        
        /*
        int mostPopular = -999;
        String mostPopularString = "";
        int maxNumberOfTimesFound = 0;

        for (int currentNumber : inArray) {

            int numberOfTimesFound = 0;
            for (int numberToCheck : inArray) {
                if (numberToCheck == currentNumber) {
                    numberOfTimesFound++;
                }
            }
            if (numberOfTimesFound > maxNumberOfTimesFound) {
                mostPopular = currentNumber;
                mostPopularString = "" + currentNumber + ",";
                maxNumberOfTimesFound = numberOfTimesFound;

            } else if (numberOfTimesFound == maxNumberOfTimesFound) {
                mostPopular = currentNumber;
                if (!mostPopularString.contains("" + currentNumber + ",")) {
                    mostPopularString += "" + currentNumber + ",";
                }
                maxNumberOfTimesFound = numberOfTimesFound;
            }
        }

        System.out.println("The most popular number if " + mostPopularString + " which occured " + maxNumberOfTimesFound + " times");
        */
    }

    /**
     * ACTIVITY 6 This method should return true of false based on whether the
     * inArray contains any duplicates. If there are any duplicates then return
     * true otherwise return false.
     *
     * @since 20170111
     * @author CIS
     */
    public static boolean getIfHasDuplicates(int[] inArray) {

        boolean hasDuplicate = false;

        for (int i = 0; i < inArray.length; i++) {
            for (int j = i + 1; j < inArray.length; j++) {

                if (inArray[i] == inArray[j]) {
                    hasDuplicate = true;
                }
            }
        }

        return hasDuplicate;
    }

}
