package cis1232_lab_20170111;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bjmaclean
 */
public class ArrayProcessingUnitTests {

    private int[] testIntArray = {1, 3, 5, 7, 9};
    private int[] testIntArray2 = {1, 3, 5, 3, 1};

    @Test
    public void testGetAverage1() {
        double average = ArrayProcessing.getAverage(testIntArray);
        assert average == 5;
    }

    @Test
    public void testGetTotal1() {
        int total = ArrayProcessing.getTotal(testIntArray);
        assert total == 25;
    }

    @Test
    public void testGetTotal2() {
        int total = ArrayProcessing.getTotal(testIntArray2);
        assert total == 13;
    }

    @Test
    public void testNumberOfEvenNumbers() {
        int numberOfEvenNumbers = ArrayProcessing.getNumberOfEvenNumbers(testIntArray2);
        assert numberOfEvenNumbers == 0;
    }

    @Test
    public void testNumberOfEvenNumbers2() {
        int[] test = {4, 5, 6, 7, 8, 9};
        int numberOfEvenNumbers = ArrayProcessing.getNumberOfEvenNumbers(test);
        assert numberOfEvenNumbers == 3;
    }

    @Test
    public void testNumberDivisible() {
        int[] test = {4, 5, 6, 7, 8, 9};
        int numberOfEvenNumbers = ArrayProcessing.getNumberDivisible(test, 2);
        assert numberOfEvenNumbers == 3;
    }

    @Test
    public void testNumberDivisible2() {
        int[] test = {4, 5, 6, 7, 8, 9};
        int numberOfEvenNumbers = ArrayProcessing.getNumberDivisible(test, 3);
        assert numberOfEvenNumbers == 2;
    }

    @Test
    public void testGetMostPopular() {
        int[] test = {4, 5, 5, 6, 7, 8, 9};
        int result = ArrayProcessing.getMostPopular(test);
        assert result == 5;
    }
    
    @Test
    public void testIfHasDuplicates() {
        int[] test = {4, 5, 5, 6, 7, 8, 9};
        boolean result = ArrayProcessing.getIfHasDuplicates(test);
        assert result == true;
    }

    @Test
    public void testIfHasDuplicates2() {
        int[] test = {4, 5, 6, 7, 8, 9};
        boolean result = ArrayProcessing.getIfHasDuplicates(test);
        assert result == false;
    }
    
    
}
