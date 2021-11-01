package info.hccis.temperatureoo;

import info.hccis.temperatureoo.bo.Temperature;

/**
 * Class Oct 26, Temperature OO exercise
 *
 * @author Arthur Zuliani
 * @since 20211026
 */
public class Controller {

    public static void main(String[] args) {

        Temperature temp1 = new Temperature();

        temp1.getInformation();
        temp1.display();
    }

}
