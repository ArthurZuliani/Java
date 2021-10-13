/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.milestofeet;
//import java.util.Scanner;
import java.text.DecimalFormat;
//import java.math.RoundingMode;

/**
 * Exercise #1 - Lab Activity - Feet to mile converter
 * @author zulianideoliveiraa
 * @since 20211409
 */
public class Controller {
    
    public static final int FEET_IN_MILE = 5280;
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    
    public static void main(String[] args) {
        
        double distanceInMiles = 10.358;
        double totalDistanceFeet = distanceInMiles * FEET_IN_MILE;
                
        System.out.println("The distance to my uncle's house is " + distanceInMiles + " miles or " 
                                + df2.format(totalDistanceFeet) + " feet.");
    }
            
}
