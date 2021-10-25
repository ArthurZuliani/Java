/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.hccis.evenodd;

import java.util.Scanner;

/**
 * Activity 5.1 - Topic 4 - Selection 
 * @author Arthur Zuliani
 * @since 20211019
 */
public class Controller {

    public static void main (String args[]){
        Scanner input = new Scanner (System.in);
        
        System.out.println("Enter a integer number:");
        int numberEntered = input.nextInt();
        input.nextLine(); //Burn the line
        
        //If the modulo is different from 0, the number is odd
        if((numberEntered % 2) > 0){
            System.out.println("Number is odd");
        }
        else{
            System.out.println("Number is even");
        }
    }
}
