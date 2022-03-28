package cis;

import cis.bo.BiologyLab;
import cis.bo.BoardRoom;
import cis.bo.ComputerLab;
import cis.bo.base.RoomBase;
import cis.util.CisUtility;
import java.util.ArrayList;
import java.util.Collections;

import cis.bo.comparator.ComparatorRoomBaseAvailability;
import cis.bo.comparator.ComparatorRoomBaseNumberOfSeats;
import cis.bo.comparator.ComparatorRoomBaseRoomNumber;

/**
 * Cis Auto
 *
 * @author bjmaclean
 * @since 20181115
 */
public class Controller {

    public static final String EXIT = "X";

    private static ArrayList<RoomBase> rooms = new ArrayList();

    private static final String MENU
            = "-------------------------\n"
            + "- CIS Menu\n"
            + "- A-Add A Room\n"
            + "- B-Reserve A Room\n"
            + "- C-View All Rooms\n"
            + "- D-seat/computer counts\n"
            + "- E-booking summary\n"
            + "- X-eXit\n"
            + "-------------------------\n"
            + "Option-->";

    public static void main(String[] args) {

        //create some test data
        ComputerLab computerLab = new ComputerLab("205W", 15, 12);
        rooms.add(computerLab);

        computerLab = new ComputerLab("203W", 10, 8);
        rooms.add(computerLab);

        computerLab = new ComputerLab("201W", 15, 12);
        rooms.add(computerLab);

        RoomBase room = new BiologyLab("80E", 30, 10);
        rooms.add(room);

        room = new BiologyLab("70E", 20, 10);
        rooms.add(room);

        room = new BoardRoom("12E", 6, true);
        rooms.add(room);

        room = new BoardRoom("212W", 6, false);
        rooms.add(room);

        //Add a loop below to continuously promput the user for their choice 
        //until they choose to exit.
        String option = "";

        do {
            option = CisUtility.getInputString(MENU);
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
            case "A":
                CisUtility.display("Add a room to the list");
                addARoom();
                break;
            case "B":
                CisUtility.display("Reserve a room");
                reserveARoom();
                break;
            case "C":
                CisUtility.display("show all rooms");

                int sortOption;
                do {
                    sortOption = CisUtility.getInputInt("How do you want to sort? (0-roomNumber 1-availability 2-numberOfSeats)?");
                } while (sortOption < 0 || sortOption > 2);

                switch (sortOption) {
                    case 0:
                        Collections.sort(rooms, new ComparatorRoomBaseRoomNumber());
                        break;
                    case 1:
                        Collections.sort(rooms, new ComparatorRoomBaseAvailability());
                        break;
                    case 2:
                        Collections.sort(rooms, new ComparatorRoomBaseNumberOfSeats());
                        break;
                }

                for (RoomBase current : rooms) {
                    current.display();
                }
                break;

            case "D":
                showCountSummary();
                break;
            case "E":
                showBookingSummary();
                break;
            case "GV":
                CisUtility.display(CisUtility.getRandom());
                break;
            case "X":
                CisUtility.display("User picked x");
                break;
            default:
                CisUtility.display("Invalid entry");
        }
    }

    /**
     * Allow the user to reserve a room
     *
     * @since 20210322
     * @author BJM
     */
    public static void reserveARoom() {

        //to reserve a room will need to ask them for a room number.
        String roomDesired = CisUtility.getInputString("Room number");

        //Need to loop through looking for the room.
        boolean found = false;
        for (RoomBase current : rooms) {
            if (current.getRoomNumber().equalsIgnoreCase(roomDesired)) {
                found = true;
                //found a room with that room number
                current.reserve();
            }
        }

        if (!found) {
            System.out.println("Sorry, could not find that room number");
        }
        //when found 
        //   - Check if it is available
        //   - if it is set available to false
        //   - if it is not - give error message
        //if not found after looping through the whole list
        //   - give error message that room not found.

    }

    /**
     * Create a new room of the correct type and add to the list
     *
     * @since 20210322
     * @author BJM
     */
    public static void addARoom() {
        String type = CisUtility.getInputString("What kind of room(Biology Lab, Computer Lab, or Boardroom)?");
        RoomBase room = null;
        switch (type) {
            case "Biology Lab":
                room = new BiologyLab();
                break;
            case "Computer Lab":
                room = new ComputerLab();
                break;
            case "Boardroom":
                room = new BoardRoom();
                break;
        }
        room.getInformation();
        rooms.add(room); //add the new room to the list of rooms.

    }

    /**
     * give total # of computers and total number of seats available in all
     * classrooms.
     *
     * @since 20210323 
     * @author BJM
     */
    public static void showCountSummary() {
        int seatCount = 0;
        int computerCount = 0;

        for (RoomBase current : rooms) {
            seatCount += current.getNumberOfSeats();

            if (current instanceof ComputerLab) {
                ComputerLab currentComputerLab = (ComputerLab) current;
                computerCount += currentComputerLab.getNumberOfComputers();
            }

        }

        System.out.println("Number of seats: " + seatCount);
        System.out.println("Number of computers: " + computerCount);

    }

    /**
     * give total bookings for a name in a date range
     *
     * @since 20210323 
     * @author BJM
     */
    public static void showBookingSummary() {
        int count = 0;

        String reportName = CisUtility.getInputString("Name");
        String reportStart = CisUtility.getInputString("Start date for report");
        String reportEnd = CisUtility.getInputString("End date for report");

        /**
         * *******************************************************
         * compareTo thisRecord.compareTo(thatRecord) - value --> this is less
         * than that + value --> this is > that that 0 --> this is equal to that
         * *******************************************************
         */
//        String nameKarina = "Karina";
//        String nameAndres = "Andres";
//        System.out.println(nameKarina.compareTo(nameAndres));
        for (RoomBase current : rooms) {

            if (current.getReservedBy().equals(reportName)) {
                //name matches.
                if (reportStart.compareTo(current.getReservedDateEnd()) <= 0) {
                    //The start of range is before end of booking
                    if (reportEnd.compareTo(current.getReservedDateStart()) >= 0) {
                        count++;
                    }
                }

            }

        }

        System.out.println("Number of rooms booked by " + reportName + ": " + count);

    }

}
