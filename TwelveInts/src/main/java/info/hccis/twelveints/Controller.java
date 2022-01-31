/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.twelveints;

import info.hccis.twelveints.util.CisUtility;
/**
 *
 * @author Arthur
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] test = new int[12];
        
        for (int i = 0; i < 12; i++) {
            test[i] = CisUtility.getInputInt("Enter a number");
        }
        
        for (int i = 0; i < 12; i++) {
            System.out.println(test[i]);
        }
        
        System.out.println("");
        
        for (int i = 11; i >= 0; i--) {
            System.out.println(test[i]);
        }
    }
    
}
