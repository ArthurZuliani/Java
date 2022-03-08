package cis.entity;

import cis.util.CisUtility;

/**
 * Represents a fifty/fifty ticket
 *
 * @author bjmac
 * @since 7-Mar-2022
 */
public class Ticket {

    public static final int TICKET_COST = 2;
    public static int maxTicketNumber = 0; //This one should be public?

    private int ticketNumber;
    private String name;
    private String phoneNumber;

    public Ticket() {
        this.ticketNumber = ++maxTicketNumber;
    }

    public Ticket(String name, String phoneNumber) {
        this.ticketNumber = ++maxTicketNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void getInformation() {

        this.name = CisUtility.getInputString("Name");
        this.phoneNumber = CisUtility.getInputString("Phone number");

    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String output = "Name: " + name + "\n"
                + "Phone number: " + phoneNumber + "\n"
                + "Ticket number: " + ticketNumber + "\n";
        return output;
    }

}
