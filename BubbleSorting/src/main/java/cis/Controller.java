package cis;

import cis.util.CisUtility;
import java.util.Arrays;
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

    public static void main(String[] args) {

        sort();
    }

    /**
     * THis method sort arrays using Bubble Sort algorithm
     * 
     * @author Arthur Zuliani
     * @since 20220126
     */
    public static void sort() {

        //int[] tempBuf = new int [assortedElements.length];
        int[] assorteds = {84, 69, 76, 86, 94, 91};
        int tempBuf = 0;

        //Outer loop controls passes times
        for (int j = assorteds.length - 1; j > 0; j--) {
            System.out.print("Pass #" + (assorteds.length - j) + " ");

            //Inner loop controls verification among elements
            for (int i = 0; i < j; i++) {

                if (assorteds[i] < assorteds[i + 1]) {
                    tempBuf = assorteds[i];
                    assorteds[i] = assorteds[i + 1];
                    assorteds[i + 1] = tempBuf;
                }
            }

            System.out.println(Arrays.toString(assorteds));
        }

    }

}
