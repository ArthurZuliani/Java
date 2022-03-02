package cis.bo;

import cis.util.CisUtility;
import java.util.Scanner;

/**
 * Vehicle class.
 *
 * @author BJ MacLean
 * @since Feb 27, 2015
 */
public class Vehicle {

    public enum StatusType {

        INSTOCK, SOLD
    }

    public static final int TYPE_CAR = 1;
    public static final int TYPE_TRUCK = 2;
    public static final int TYPE_OTHER = 3;
    
    public static final double LIST_PRICE_FEE = 1.1;

    public static final String[] VEHICLE_TYPE_DESCRIPTIONS = {"", "Car", "Truck", "Other"};

    private int vehicleId;
    private int vehicleTypeCode;
    private double costToDealer;
    private double listPrice;
    private String make;
    private String model;
    private int modelYear;
    private StatusType statusType;
    private static int currentMaxVehicleId;

    /**
     * Parameterized custom constructor to create a vehicle.
     *
     * @since 20170228
     * @author CIS1232
     *
     * @param vehicleTypeCode
     * @param costToDealer
     */
    public Vehicle(int vehicleTypeCode, double costToDealer) {
        this.vehicleTypeCode = vehicleTypeCode;
        this.costToDealer = costToDealer;
        setVehicleId();
        if (CisUtility.DEBUGGING) {
            System.out.println("Created a new vehicle");
            System.out.println(this.toString());
        }
    }

    /**
     * Parameterized custom constructor to create a vehicle.
     *
     * @since 20170228
     * @author CIS1232
     *
     * @param vehicleTypeCode vehicle type
     * @param costToDealer cost to dealer
     * @param price price
     * @param make make
     * @param model model
     * @param modelYear model year
     * @param statusType status type
     */
    public Vehicle(int vehicleTypeCode, double costToDealer, double price, String make, String model, int modelYear, StatusType statusType) {
        setVehicleId();
        this.vehicleTypeCode = vehicleTypeCode;
        this.costToDealer = costToDealer;
        setListPrice(price);
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
        this.statusType = statusType;
        if (CisUtility.DEBUGGING) {
            System.out.println("Created a new vehicle(passed in all attributes)");
            System.out.println(this.toString());
        }
    }

    /**
     * Default constructor
     *
     * @since 20170228
     * @author CIS1232
     *
     */
    public Vehicle() {
        setVehicleId();
        if (CisUtility.DEBUGGING) {
            System.out.println("Created a new vehicle(using default constructor)");
            System.out.println(this.toString());
        }
    }

    /**
     * This method will get the vehicle description prompt using the array
     * constant in this class. Note that this is static as it is not related to
     * any instance of a vehicle but rather is generic functionality associated
     * with the Vehicle class.
     *
     * @since 20170301
     * @author CIS1232/BJM
     */
    public static String getVehicleDescriptionPrompt() {
        String prompt = "What type of vehichle(";
        for (int i = 1; i < VEHICLE_TYPE_DESCRIPTIONS.length; i++) {
            prompt += i + "=" + VEHICLE_TYPE_DESCRIPTIONS[i];
        }
        prompt += ")?";
        return prompt;
    }

    /**
     * This method will prompt the user for the information required about this
     * vehicle.
     *
     * @return nothing
     * @since 20150227
     * @author cis1232
     */
    public void getInformation() {
        //type
        vehicleTypeCode = CisUtility.getInputInt(getVehicleDescriptionPrompt());

        //cost to dealer
        costToDealer = CisUtility.getInputDouble("What is the cost to dealer");

        //price
        setListPrice(CisUtility.getInputDouble("What is the list price (0 to use default)?"));

        //make
        make = CisUtility.getInputString("What is the make");

        //model
        model = CisUtility.getInputString("What is the model");

        //year
        modelYear = CisUtility.getInputInt("What is the year");

        statusType = statusType.INSTOCK;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    /**
     * This method will get the next vehicle id available. It will increment the
     * static currentMaxVehicleId and return it.
     *
     * @since 20170228
     * @author CIS1232
     *
     * @return
     */
    public static int getNextVehicleId() {
        currentMaxVehicleId++;
        return currentMaxVehicleId;
    }

    private synchronized void setVehicleId() {

        //Generate the vehicle id
        this.vehicleId = getNextVehicleId();
    }

    public int getVehicleTypeCode() {
        return vehicleTypeCode;
    }

    public void setVehicleTypeCode(int vehicleTypeCode) {
        this.vehicleTypeCode = vehicleTypeCode;
    }

    public double getCostToDealer() {
        return costToDealer;
    }

    public void setCostToDealer(double costToDealer) {
        this.costToDealer = costToDealer;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public double getListPrice() {
        return listPrice;
    }

    /**
     * Set the list price.  
     * 
     * @since 20220301 
     * @author TBD
     */
    public void setListPrice(double price) {

        /*  BJM Fix 20170301A
            If the list price entered is 0 then set the list price to 10% 
            above the cost to the dealer
         */
        //TODO 3 Set List Price
        if(price < (costToDealer * LIST_PRICE_FEE)) {
            this.listPrice = costToDealer * LIST_PRICE_FEE;
        } else {
            this.listPrice = price;
        }
        
    }

    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "\nVehicle details:\n"
                + "vehicleId:  " + vehicleId
                + "\nvehicleTypeCode:  " + VEHICLE_TYPE_DESCRIPTIONS[vehicleTypeCode]
                + "\ncostToDealer=" + costToDealer
                + "\nlistPrice=" + listPrice
                + "\nmake:  " + make
                + "\nmodel:  " + model
                + "\nmodelYear:  " + modelYear
                + "\nstatusTypeCode:" + statusType
                + "\n-----------------------------\n";
    }

}
