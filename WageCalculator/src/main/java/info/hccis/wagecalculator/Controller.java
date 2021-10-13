/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.wagecalculator;
import java.util.Scanner;

/**
 * Exercise #4 - Lab Activity - Wage Calculator
 *
 * @author zulianideoliveiraa
 * @since 20211409
 */
public class Controller {

    public static final double OVERTIME_COST = 1.5;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        //Initial prompts to the user
        System.out.println("What's your name?");
        String name = input.nextLine();
        
        System.out.println("How many hours have you worked?");
        int numberOfHoursWorked = input.nextInt();
        
        System.out.println("How many overtime hours have you worked?");
        int numberOfOvertimeHours = input.nextInt();
        
        System.out.println("What's your hourly rate?");
        double hourlyRate = input.nextDouble();
        
        //Calculations time
        double regularPayment = numberOfHoursWorked * hourlyRate;
        double overtimePayment = numberOfOvertimeHours * (hourlyRate * OVERTIME_COST);
        int totalWorkedHours = numberOfHoursWorked + numberOfOvertimeHours;
        double totalPayment = regularPayment + overtimePayment;
        
        //System printouts to the user
        System.out.println("---------- Paystub Summary ------------");
        System.out.println("Employee name: " + name);  
        System.out.println("Total worked hours: " + totalWorkedHours);  
        System.out.println();
        System.out.println("Payment for regular hours: $" + regularPayment);
        System.out.println("Payment for overtime hours: $" + overtimePayment);
        System.out.println("Total payment: $" + totalPayment);
        System.out.println("---------------------------------------");
    }
}
