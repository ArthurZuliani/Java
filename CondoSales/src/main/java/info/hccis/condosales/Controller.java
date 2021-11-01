package info.hccis.condosales;

import info.hccis.condosales.bo.CondoSales;

/**
 * Class Oct 26, Condo Sales exercise
 *
 * @author Arthur Zuliani
 * @since 20211026
 */
public class Controller {

    public static void main(String[] args) {

        CondoSales condo1 = new CondoSales();

        condo1.getInformation();
        condo1.display();
    }

}
