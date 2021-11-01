package info.hccis.condosales.bo;

import info.hccis.util.CisUtility;

/**
 * Class responsible to handles the student information
 *
 * @author Arthur Zuliani
 * @since 20211026
 */
public class CondoSales {

    //Constants declaration
    public static final int CONDO_VIEW_PARK = 1;
    public static final int CONDO_VIEW_GOLF_COURSE = 2;
    public static final int CONDO_VIEW_LAKE = 3;

    public static final double PRICE_CONDO_PARK_VIEW = 150000;
    public static final double PRICE_CONDO_GOLF_COURSE_VIEW = 170000;
    public static final double PRICE_CONDO_LAKE_VIEW = 210000;
    public static final double PRICE_DEFAULT = 0;

    public static final double COST_PER_PARKING_LOT = 5000;

    //Private attributes declaration
    private int condoView;
    private double totalPrice;
    private int parkingSpace;
    private boolean garage;
    private boolean validView;

    /**
     * Default constructor
     *
     * @author Arthur Zuliani
     * @since 20211026
     */
    public CondoSales() {

    }

    /**
     * Custom constructor
     *
     * @author Arthur Zuliani
     * @since 20211026
     * @param condoView
     * @param garage
     */
    public CondoSales(int condoView, boolean garage) {
        this.condoView = condoView;
        this.garage = garage;
    }

    /**
     * Method responsible to get user information
     *
     * @author Arthur Zuliani
     * @since 20211026
     */
    public void getInformation() {
        condoView = CisUtility.getInputInt("Choose the condo view type" + System.lineSeparator()
                + "(1)Park  (2)Golf course  (3)Lake");

        if (condoView > CONDO_VIEW_PARK && condoView < CONDO_VIEW_LAKE) {
            validView = true;
            String garageResponse = CisUtility.getInputString("With garage? (Y/N)").toUpperCase();
            garage = garageResponse.equals("Y");
        }
    }

    /**
     * Method responsible to calculate the total price of the condo
     *
     * @author Arthur Zuliani
     * @since 20211026
     * @return the total price
     */
    public String calculateCondoPrice() {
        String outputString = "Chosen view: ";

        if (!validView) {
            totalPrice = PRICE_DEFAULT;
            outputString += "Incorrect view choice - Total price $" + totalPrice;
        } else {
            if (condoView == CONDO_VIEW_PARK) {
                totalPrice = PRICE_CONDO_PARK_VIEW;
                outputString += "Park ";
            } else if (condoView == CONDO_VIEW_GOLF_COURSE) {
                totalPrice = PRICE_CONDO_GOLF_COURSE_VIEW;
                outputString += "Golf course ";
            } else if (condoView == CONDO_VIEW_LAKE) {
                totalPrice = PRICE_CONDO_LAKE_VIEW;
                outputString += "Lake ";
            }

            if (garage) {
                parkingSpace = CisUtility.getInputInt("Enter how many parking lots desired:");

                if (parkingSpace < 1) {
                    outputString += System.lineSeparator() + "Invalid parking space choice, considering condo without garage"
                            + System.lineSeparator();
                    parkingSpace = 0;
                }
            }
            totalPrice += COST_PER_PARKING_LOT * parkingSpace;
            outputString += "Total price $" + totalPrice;
        }

        return outputString;
    }

    //Setters and getters
    public int getCondoView() {
        return condoView;
    }

    public void setCondoView(int condoView) {
        this.condoView = condoView;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(int parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public boolean isValidView() {
        return validView;
    }

    public void setValidView(boolean validView) {
        this.validView = validView;
    }
    

    /**
     * Method responsible to print out the object string
     *
     * @author Arthur Zuliani
     * @since 20211026
     */
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String outputString = "Condo Sales Summary" + System.lineSeparator()
                + calculateCondoPrice();

        return outputString;
    }

}
