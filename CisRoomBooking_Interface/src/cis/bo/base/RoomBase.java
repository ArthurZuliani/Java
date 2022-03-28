package cis.bo.base;

import cis.util.CisUtility;
import java.io.Serializable;

/**
 * Represents a Room (base)
 *
 * @author bjmac
 * @since 17-Mar-2021
 */
public abstract class RoomBase implements Reservable, Comparable<RoomBase>{

    protected String roomNumber;
    protected boolean available;
    protected int numberOfSeats;
    protected String reservedBy = "", reservedDateStart = "", reservedDateEnd = "";

    public RoomBase() {
        //default
    }

    public RoomBase(String roomNumber, int numberOfSeats) {
        this.roomNumber = roomNumber;
        this.available = true;
        this.numberOfSeats = numberOfSeats;
    }

    /**
     * Reserve this room.   Add the logic to reserve if the room is available.
     * @since 20210324
     * @author BJM
     */
    public void reserve() {
        if (available) {

            String name = CisUtility.getInputString("Name of booker");
            String startDate = CisUtility.getInputString("Start date (yyyymmdd)");
            String endDate = CisUtility.getInputString("End date (yyyymmdd)");

            setReservedBy(name);
            setReservedDateStart(startDate);
            setReservedDateEnd(endDate);
            setAvailable(false);

            System.out.println("The room is available and has been booked");

        } else {
            System.out.println("Sorry, that room is not available");
        }

    }

    /**
     * Allow the user to release the room.  This will set it to available and remove the 
     * booking attribute values.
     * @since 20210324
     * @author BJM
     */
    public void release() {
        if(available){
            System.out.println("Not currently booked, can't release.");
        }else{
            this.available = true;
            this.reservedBy = "";
            this.reservedDateStart = "";
            this.reservedDateEnd = "";
            System.out.println("Room#"+roomNumber+" was released");
        }
    }

    public abstract void showQuickSummary();

    public void getInformation() {
        this.roomNumber = CisUtility.getInputString("Room Number");
        this.available = true;

        //OR could do it this way... or other ways as long as we end up with 
        //a true/false in available attribute
//        String availableString = CisUtility.getInputString("Available (y.n)");
//        if(availableString.equals("y")){
//            available = true;
//        }else{
//            available = false;
//        }
        this.numberOfSeats = CisUtility.getInputInt("Number of seats");
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public String getReservedDateStart() {
        return reservedDateStart;
    }

    public void setReservedDateStart(String reservedDateStart) {
        this.reservedDateStart = reservedDateStart;
    }

    public String getReservedDateEnd() {
        return reservedDateEnd;
    }

    public void setReservedDateEnd(String reservedDateEnd) {
        this.reservedDateEnd = reservedDateEnd;
    }
    
    @Override
    public int compareTo(RoomBase that) {
        
        return this.roomNumber.compareToIgnoreCase(that.getRoomNumber());
         
    }

    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String output = "Room Number:" + roomNumber + "\n"
                + "Available: " + available + "\n"
                + "Number of Seats: " + numberOfSeats + "\n";

        //Show the reserved by information
        if (!available) {
            output += "Reserved by: " + reservedBy + " (" + reservedDateStart + "-" + reservedDateEnd + ")\n";
        }

        return output;
    }

}
