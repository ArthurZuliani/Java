package info.hccis.starting;

import info.hccis.starting.bo.Counter;

/**
 * This is the main class of the application CountByAnything
 * 
 * @author Arthur Zuliani
 * @since 2021-11-16
 */
public class Controller {

    public static void main(String[] args) {
        Counter count1 = new Counter();
        
        count1.getInformation();
        count1.countByAnyNumber();
    }
}
