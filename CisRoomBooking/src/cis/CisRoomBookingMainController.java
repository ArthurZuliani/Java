package cis;

import cis.bo.BoardRoom;
import cis.bo.ComputerLab;
import cis.util.CisUtility;
import java.util.HashMap;
import cis.bo.Room;

/**
 * CIS Room Booking application
 *
 * @author Arthur Zuliani
 * @since 20220321
 */
public class CisRoomBookingMainController {

    public static final String EXIT = "X";

    private static final String MENU
            = "-------------------------\n"
            + "- CIS Menu\n"
            + "- A-Add A Room\n"
            + "- B-Reserve A Room\n"
            + "- C-View All Rooms\n"
            + "- X-eXit\n"
            + "-------------------------\n"
            + "Option-->";

    private static HashMap<String, Room> rooms = new HashMap();

    public static void main(String[] args) {

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
     * @author Arthur Zuliani
     * @since 20220321
     *
     * @param option The menu option
     */
    public static void processMenuOption(String option) {
        //Add a switch to process the option
        switch (option.toUpperCase()) {
            case "A":
                addRoom();
                break;
            case "B":
                reserveRoom();
                break;
            case "C":
                showAllRooms();
                break;
            case "X":
                System.out.println("Goodbye");
                break;
            default:
                CisUtility.display("Invalid entry");
        }
    }

    /**
     * Adds a room to the application
     * 
     * @author Arthur Zuliani
     * @since 20220321
     */
    public static void addRoom() {

        int roomType;
        do {
            roomType = CisUtility.getInputInt("Which room do you want to add(0-Room 1-ComputerLab 2-BoardRoom)");
        } while (roomType < 0 || roomType > 2);

        Room room;

        switch (roomType) {
            case 0:
                room = new Room();
                break;
            case 1:
                room = new ComputerLab();
                break;
            case 2:
                room = new BoardRoom();
                break;
            default:
                room = new Room();
                break;
        }

        room.getInformation();

        rooms.put(room.getRoomNumber(), room);
    }

    /**
     * Book an available room
     * 
     * @author Arthur Zuliani
     * @since 20220321
     */
    public static void reserveRoom() {
        
        //Ensures that entered string is not null
        String roomNumber;
        do {
            roomNumber = CisUtility.getInputString("What is the room number?");
        } while (roomNumber == null);

        Room roomToBook = rooms.get(roomNumber);

        //Checks if the room is available before book it
        if (roomToBook.isAvailable()) {
            roomToBook.setAvailable(false);
            roomToBook.display();
            rooms.put(roomNumber, roomToBook);
        } else {
            System.out.println("This room is not available!");
        }
    }
    
    /**
     * Show all rooms
     * 
     * @author Arthur Zuliani
     * @since 20220321
     */
    public static void showAllRooms() {
        
        rooms.values().forEach(currentRoom -> {
            currentRoom.display();
        });
    }

}
