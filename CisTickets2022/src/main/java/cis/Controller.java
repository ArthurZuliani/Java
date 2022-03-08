package cis;

import cis.entity.Ticket;
import cis.util.CisUtility;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 * A starting project which we can use for applications that need a menu driven
 * program. Note that the name of the project should be modified to reflect the
 * specific requirements.
 *
 * @author bjmaclean
 * @since 20181115
 */
public class Controller {

    //Data structures
    private static ArrayList<Ticket> tickets = new ArrayList();
    private static HashMap<String, Ticket> winners = new HashMap();

    public static final String EXIT = "X";

    private static final String MENU
            = "\n-------------------------\n"
            + "1) Purchase a ticket\n"
            + "2) View all tickets\n"
            + "3) Pick the winner\n"
            + "4) Show all winners\n"
            + "5) Exit\n"
            + "-------------------------\n"
            + "Option-->";

    public static void main(String[] args) {

        //Add a loop below to continuously promput the user for their choice 
        //until they choose to exit.
        String option = "";

        CisUtility.display("Today is: " + CisUtility.getCurrentDate(null), "Red");

        do {
            option = CisUtility.getInputString(MENU, "Green");
            processMenuOption(option);
        } while (!option.equalsIgnoreCase(EXIT));

    }

    /**
     * This method will process the menu option specified in the input
     * parameter. It will call appropriate functionality based on its value.
     *
     * @param option The menu option
     * @since 20171102
     * @author cis1201b
     *
     */
    public static void processMenuOption(String option) {
        //Add a switch to process the option
        switch (option.toUpperCase()) {
            case "1":
                purchaseATicket();
                break;
            case "2":
                viewAllTickets();
                break;
            case "3":
                pickTheWinner();
                break;
            case "4":
                showAllWinners();
                break;
            case "5":
                System.out.println("Goodbye");
                System.exit(0);
                break;
            default:
                CisUtility.display("Invalid entry");
        }
    }

    /**
     * This method adds a ticket to tickets array list
     *
     * @author Arthur Zuliani
     * @since 20220307
     */
    public static void purchaseATicket() {

        String name = CisUtility.getInputString("Name");
        String phoneNumber = CisUtility.getInputString("Phone number");
        Ticket ticket = new Ticket(name, phoneNumber);

        tickets.add(ticket);
    }

    /**
     * This method prints out information about all purchased tickets
     *
     * @author Arthur Zuliani
     * @since 20220307
     */
    public static void viewAllTickets() {

        if (tickets.size() > 0) {
        for (Ticket currentTicket : tickets) {

            System.out.println(currentTicket.toString());
        }
        }  else {
            System.out.println("No ticket were sold so far");
        }
    }

    /**
     * This method draws a winner among all sold tickets
     *
     * @author Arthur Zuliani
     * @since 20220307
     */
    public static void pickTheWinner() {

        if (tickets.size() > 0) {
            int randomNumber = CisUtility.getRandom(Ticket.maxTicketNumber);

            Ticket winnerTicket = tickets.get(randomNumber - 1);
            winners.put(CisUtility.getCurrentDate(null), winnerTicket);

            System.out.println("The winner of $" + (Ticket.maxTicketNumber * Ticket.TICKET_COST) + " is " + winnerTicket.getName());
        } else {
            System.out.println("No ticket were sold so far, impossible to draw a winner!");
        }
    }

    /**
     * This method prints out all winners stored over the time
     * 
     * @author Arthur Zuliani
     * @since 20220307
     */
    public static void showAllWinners() {
       
        if (tickets.size() > 0) {
         winners.values().forEach(currentWinner -> currentWinner.display());
        } else {
            System.out.println("There is no winner so far!");
        }
    }

}
