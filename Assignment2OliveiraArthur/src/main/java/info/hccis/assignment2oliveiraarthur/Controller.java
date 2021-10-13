/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.assignment2oliveiraarthur;

/**
 * Assignment 2 - Java Program - Will's Summer Services
 * 
 * @author BJ McLean
 * @since 20211006
 *
 * @modified by Arthur Zuliani to be accordingly with assignment 2
 */
public class Controller {
    
    public static void main(String[] args) {

        Job job = new Job();        

        //Bussiness information to be prompt to the user
        System.out.println();   //This blank line is just to layout be equal to the "Expected I/O"
        System.out.println("---------------------------------");
        System.out.println("- Welcome to " + Job.BUSINESS_NAME);
        System.out.println("---------------------------------");
        System.out.println("");

        job.getInformation();
        job.calculateCost();
        job.display();        
    }    
}


  