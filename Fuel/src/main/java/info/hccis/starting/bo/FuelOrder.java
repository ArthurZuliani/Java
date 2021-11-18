package info.hccis.starting.bo;

import info.hccis.util.CisUtility;

/**
 * This class is responsible for handle the fuel order
 *
 * @author Arthur Zuliani
 * @since 2021-11-16
 */
public class FuelOrder {

    public static final double COST_SUPREME = 1.35;
    public static final double COST_CLEAN = 1.27;
    public static final double COST_REGULAR = 1.16;
    public static final double COST_CAR_WASH = 6;

    public static final int TYPE_SUPREME = 1;
    public static final int TYPE_CLEAN = 2;
    public static final int TYPE_REGULAR = 3;

    private int numberOfLiters;
    private int fuelType;
    private boolean carWashIndicator;
    private double costOfOrder;

    /**
     * Default Constructor
     *
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public FuelOrder() {

    }

    /**
     * Custom constructor
     *
     * @author Arthur Zuliani
     * @since 2021-11-16
     * @param numberOfLiters
     * @param fuelType
     * @param carWashIndicator
     */
    public FuelOrder(int numberOfLiters, int fuelType, boolean carWashIndicator) {
        this.numberOfLiters = numberOfLiters;
        this.fuelType = fuelType;
        this.carWashIndicator = carWashIndicator;
        
        processOrder();        
    }
    
    /**
     * This method is responsible to get user information
     * 
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public void getInformation(){
        
        carWashIndicator = CisUtility.getInputBoolean("Do you want a car wash?");
        numberOfLiters = CisUtility.getInputInt("Enter the number of liters to fill up the car");
        fuelType = CisUtility.getInputInt("Enter the fuel type (1-Supreme 2-Clean 3-Regular)");
        
        processOrder();
    }

    /**
     * This method will process order costs
     *
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public final void processOrder() {

        switch (fuelType) {
            case TYPE_SUPREME:
                costOfOrder = numberOfLiters * COST_SUPREME;
                break;
            case TYPE_CLEAN:
                costOfOrder = numberOfLiters * COST_CLEAN;
                break;
                
            case TYPE_REGULAR:
                costOfOrder = numberOfLiters * COST_REGULAR;
                break;
                
            default:
                System.out.println("Invalid fuel type chosen, setting default type value");
                fuelType = TYPE_REGULAR;
                costOfOrder = numberOfLiters * COST_REGULAR;
                break;
        }

        if (carWashIndicator) {
            costOfOrder += COST_CAR_WASH;
        }
    }
    
    //Getters and setters
    public int getNumberOfLiters() {
        return numberOfLiters;
    }

    public void setNumberOfLiters(int numberOfLiters) {
        this.numberOfLiters = numberOfLiters;
    }

    public int getFuelType() {
        return fuelType;
    }

    public void setFuelType(int fuelType) {
        this.fuelType = fuelType;
    }

    public boolean isCarWashIndicator() {
        return carWashIndicator;
    }

    public void setCarWashIndicator(boolean carWashIndicator) {
        this.carWashIndicator = carWashIndicator;
    }

    public double getCostOfOrder() {
        return costOfOrder;
    }

    public void setCostOfOrder(double costOfOrder) {
        this.costOfOrder = costOfOrder;
    }
    
    /**
     * This method display the information to the output
     * 
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public void display(){
        System.out.println(toString());
    }
    
    /**
     * This method constructs the standard output string for the object
     * 
     * @author Arthur Zuliani
     * @since 2021-11-16
     * @return the output string for the object
     */
    @Override
    public String toString(){
        return "Fuel type: " + fuelType + System.lineSeparator()
                + "Number of liters: " + numberOfLiters + System.lineSeparator()
                + "Car wash: " + carWashIndicator + System.lineSeparator()
                + "Cost: " + CisUtility.toCurrency(costOfOrder);
    }
}
