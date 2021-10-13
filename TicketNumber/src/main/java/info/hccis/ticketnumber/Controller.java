/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.ticketnumber;

import java.util.Scanner;

/**
 * Exercise #5 - Lab Activity - Ticket Number
 *
 * @author zulianideoliveiraa
 * @since 20211409
 */
public class Controller {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Initial Prompts
        System.out.println("Enter the ticket number:");
        int ticketNumber = input.nextInt();

        //Calculations time
        int droppedDigit = ticketNumber % 10;
        int fiveDigitTicket = ticketNumber / 10;
        int reminderNumber = fiveDigitTicket % 7;

        boolean comparisonResult = (droppedDigit == reminderNumber);

        if (comparisonResult) {
            System.out.println("The ticket number entered is valid");
        } else {
            System.out.println("The ticket number entered is invalid");
        }
    }
}
