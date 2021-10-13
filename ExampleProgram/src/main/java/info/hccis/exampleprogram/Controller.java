/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.exampleprogram;

import java.util.Scanner;

/**
 * Review example
 * @author Arthur
 * @since 20210913
 */
public class Controller {
    
    public static void main (String[] args){
        
        
        Scanner input = new Scanner(System.in);
        
        //Collects the user name
        System.out.println("Enter your name:");
        String name = input.nextLine();
        //Collects the user age
        System.out.println("Enter your age:");
        Integer age = Integer.parseInt(input.nextLine()); //A different way to get the integer value
        //Show the years until retirement as demand in the task
        System.out.println(name + " you have " + (65 - age) +  " years until retirement.");
    }
    
}
