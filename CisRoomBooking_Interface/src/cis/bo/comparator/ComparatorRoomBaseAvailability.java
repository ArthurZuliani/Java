package cis.bo.comparator;

import cis.bo.base.RoomBase;
import java.util.Comparator;

/**
 * Comparator to allow sorting by availability
 * 
 * @author Arthur Zuliani
 * @since 20220328
 */
public class ComparatorRoomBaseAvailability implements Comparator<RoomBase>{
    
    @Override
    public int compare(RoomBase thisRoom, RoomBase thatRoom) {
        
        if(thisRoom.isAvailable() == thatRoom.isAvailable()) {
            return 0; //if they are the same return 0
        } else if (thisRoom.isAvailable()) {
            return 1; //if this is available it will sort to the end
        } else {
            return -1; //if this isn't it will sort to the first
        }     
        
    }
}
