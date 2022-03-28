package cis.bo.comparator;

import cis.bo.base.RoomBase;
import java.util.Comparator;

/**
 * Comparator to allow sorting by room Number
 * 
 * @author Arthur Zuliani
 * @since 20220328
 */
public class ComparatorRoomBaseRoomNumber implements Comparator<RoomBase>{

    @Override
    public int compare(RoomBase thisRoom, RoomBase thatRoom) {
        
        return thisRoom.getRoomNumber().compareTo(thatRoom.getRoomNumber());        
        
    }
    
}
