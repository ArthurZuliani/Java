/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.hccis.evenoddenhanced;

import java.util.Scanner;
/**
 * Activity 5.1 Enhanced - Topic 4 - Selection 
 * @author Arthur Zuliani
 * @since 20211019
 */
public class Controller {

    private static int numberEntered1;
    private static int numberEntered2;
    private static boolean number1Type;
    private static boolean number2Type;
    
    public static void main (String args[]){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number 1:");
        numberEntered1 = input.nextInt();
        input.nextLine();
        
        System.out.println("Enter the number 2:");
        numberEntered2 = input.nextInt();
        input.nextLine();
        
        if((numberEntered1 % 2) > 0){
            number1Type = true;
        }
        else{
            number1Type = false;
        }
        
        if((numberEntered2 % 2) > 0){
            number2Type = true;
        }
        else{
            number2Type = false;
        }
        
        if(!number1Type && !number2Type){
            System.out.println("Both numbers are even");
        }
        else if(number1Type && number2Type){
            System.out.println("Both numbers are odd");            
        }
        else if(!number1Type && number2Type){
            System.out.println("The first is even, the second is odd");
        }
        else{
            System.out.println("The first is odd, the second is even");
        }
    
    }
}
