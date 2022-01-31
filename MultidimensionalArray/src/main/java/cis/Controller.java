/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis;

import cis.entity.Course;

/**
 *
 * @author Arthur
 */
public class Controller {

    public static int[][] test = new int[3][3];

    public static void main(String[] args) {

        test[0][0] = 5;
        test[0][1] = 5;
        test[0][2] = 5;

        for (int[] currentElement1 : test) {
            for (int currentElement2 : currentElement1) {
                System.out.println(currentElement2);
            }
        }
    }

    

}
