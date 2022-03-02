package cis;

import cis.bo.Sale;
import cis.bo.Vehicle;
import cis.util.CisUtility;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * CIS Auto Application. Provides tracking for auto sales company.
 *
 * @author BJ MacLean
 * @since Mar 1, 2022
 */
public class Controller {

    //DATA STRUCTURES
    private static HashMap<Integer, Vehicle> inventory = new HashMap();
    private static ArrayList<Sale> sales = new ArrayList();

    public static final String NAME_OF_BUSINESS = "CIS Auto Sales";
    public static final String MENU = "\n----------------------\n" + NAME_OF_BUSINESS + "\n"
            + "Choose one  of the following options:\n"
            + "A - Add a vehicle\n"
            + "S - Sell a vehicle\n"
            + "R - Reports\n"
            + "C - Clear sold vehicles\n"
            + "L - Lookup a vehicle\n"
            + "Q – Quit";

    public static final String SALES_REPORT_HEADING = "SALES REPORT";
    public static final String INVENTORY_COUNT_OUTPUT_1 = NAME_OF_BUSINESS + "";
    public static final String INVENTORY_COUNT_OUTPUT_2 = "Number of cars:  #";
    public static final String INVENTORY_COUNT_OUTPUT_3 = "Number of trucks:  #";
    public static final String INVENTORY_COUNT_OUTPUT_4 = "Number of other:  #";

    /**
     * Main method which controls program flow.
     *
     * @since 20170228
     * @author CIS1232
     */
    public static void main(String[] args) {

        loadTestData();

        String userOption = null;

        do {
            userOption = processOption();
        } while (!userOption.equalsIgnoreCase("Q"));

    }

    /**
     * Process option method controls the main menu.
     *
     * @since 20170228
     * @author CIS1232
     */
    public static String processOption() {
        String userOption = CisUtility.getInputString(MENU).toUpperCase();

        if (CisUtility.DEBUGGING) {
            System.out.println("Processing for " + userOption);
        }
        switch (userOption) {
            case "A":
                Vehicle newVehicle = new Vehicle();
                newVehicle.getInformation();
                inventory.put(newVehicle.getVehicleId(), newVehicle);
                if (CisUtility.DEBUGGING) {
                    System.out.println("Added:" + newVehicle);
                }
                break;
            case "S":
                sell();
                break;
            case "Q":
                System.out.println("Goodbye");
                break;
            case "R":
                processReports();
                break;
            case "C":
                clearSoldVehicles(inventory);
                break;
            case "L":
                lookupVehicle();
                break;
            default:
                System.out.println("Invalid option");
        }
        return userOption;
    }

    /**
     * Process reports
     *
     * @since 20170228
     * @author CIS1232
     */
    public static void processReports() {
        String MENU_REPORTS = "\nReports"
                + "\n1) Summary for a given salesperson"
                + "\n2) total sales by make of vehicle"
                + "\n3) Day sales"
                + "\n4) Show inventory"
                + "\n5) Display number of vehicles in inventory"
                + "\n6) Show inventory by type"
                + "\n7) Show all sales";

        System.out.println(MENU_REPORTS);
        String option = CisUtility.getInputString(MENU_REPORTS);
        if (CisUtility.DEBUGGING) {
            System.out.println("User entered:" + option);
        }
        switch (option) {
            case "1":
                getSalesPersonForYear();
                break;
            case "3":
                getDaySales();
                break;
            case "4":
                showInventory();
                break;
            case "5":
                showInventoryCounts();
                break;
            case "6":
                showInventoryByType();
                break;
            case "7":
                showAllSales();
                break;
        }

    }

    /**
     * Loop through the sales and show all of the sales.
     *
     * @since 20220301
     * @author Arthur Zuliani
     */
    public static void showAllSales() {
        //TODO 1 Code to show all sales
        sales.forEach(sale -> {
            System.out.println(sale.toString());
        });
    }

    /**
     * Allow user to enter a vehicle id and show the details to the console.
     *
     * @since 20220301
     * @author Arthur Zuliani
     */
    public static void lookupVehicle() {
        //TODO 2 Lookup a vehicle

        int id = CisUtility.getInputInt("Enter vehicle ID:");

        Vehicle resultVehicle = inventory.get(id);
        resultVehicle.display();
    }

    /**
     * This method will clear the sold vehicles from the HashMap.Note that the
     * sales reports will not like it if the vehicles are gone from the
     * inventory!
     *
     * @param theInventory The map of the inventory
     * @since 20210301
     * @author Arthur Zuliani
     */
    public static void clearSoldVehicles(HashMap<Integer, Vehicle> theInventory) {

        //TODO 5 Clear Sold Vehicles
        for (int currentItem = 1; currentItem <= theInventory.size(); currentItem++) {
            
            if(theInventory.get(currentItem).getStatusType() == Vehicle.StatusType.SOLD) {
                theInventory.remove(currentItem);
            }
        }
    }

    /**
     * Get sales for a sales person for a year
     *
     * @since 20170228
     * @author CIS1232
     */
    public static void getSalesPersonForYear() {
        //Get the name of the person
        String name = CisUtility.getInputString("Enter name");
        String year = CisUtility.getInputString("Enter year");

        //********************************************************************
        //Loop through the sales arraylist and show any sales 
        //where the sales person name matches what they typed in.
        //********************************************************************
        double total = 0.0;
        for (Sale sale : sales) {
            if (sale.getSalesPersonName().equalsIgnoreCase(name)
                    && sale.getDateOfSale().startsWith(year)) {
                System.out.println(sale);
                total += sale.getSoldPrice();

                //get list price from hashmap...
                Vehicle vehicle = inventory.get(sale.getVehicleId());
                System.out.println(vehicle.getListPrice());

            }

        }
        System.out.println("total=$" + total);

    }

    /**
     * This will provide a report of sales for a given day.
     *
     * @since 20150303
     * @author cis1232
     */
    public static void getDaySales() {

        //Get the day for the report
        System.out.println("Enter date for sales(yyyymmdd):");
        String dateOfReport = CisUtility.getInputString("Enter date for sales(yyyymmdd)");
        if (CisUtility.DEBUGGING) {
            System.out.println("about to run report for:" + dateOfReport);
        }

        //Header information for report
        System.out.println("");
        System.out.println(SALES_REPORT_HEADING + ":  " + dateOfReport);

        double totalSales = 0;
        boolean foundASale = false;

        //for each sale
        for (Sale currentSale : sales) {
            String output = "";
            //If the date of sale if the desired report date, then proceed with it
            //in the report.
            if (currentSale.getDateOfSale().equalsIgnoreCase(dateOfReport)) {
                foundASale = true;
                totalSales += currentSale.getSoldPrice();

                if (CisUtility.DEBUGGING) {
                    System.out.println("Found a sale:" + currentSale.toString());
                }

                //Get the vehicle details for the vehicle id that is specified in 
                //the sale.
                Vehicle vehicleSold = inventory.get(currentSale.getVehicleId());

                //Show the details for this sale
                output = "Name:  " + currentSale.getSalesPersonName() + "\n"
                        + "Sold price:  $" + currentSale.getSoldPrice() + "\n"
                        + "Vehicle ID:  " + currentSale.getVehicleId() + "\n"
                        + "Make:  " + vehicleSold.getMake() + "\n"
                        + "Model:  " + vehicleSold.getModel() + "\n"
                        + "List Price:  $" + vehicleSold.getListPrice() + "\n\n";
                System.out.println(output);

            }
        }
        if (foundASale) {
            System.out.println("\nTotal sales:  $" + totalSales + "\n\n");
        } else {
            System.out.println("\nNo sales for this day.\n\n");
        }

    }

    /**
     * Sell a vehicle
     *
     * @author CIS1232
     * @since 20220301
     */
    public static void sell() {
        //System.out.println("Future functionality");
        System.out.println("Selling a vehicle:");
        int vehicleId = CisUtility.getInputInt("Enter the vehicle id");

        //Check to make sure the vehicle is in stock
        if ((!inventory.containsKey(vehicleId))
                || ((inventory.get(vehicleId).getStatusType() != Vehicle.StatusType.INSTOCK))) {
            System.out.println("Vehicle is not for sale");
        } else {
            //Get the remaining information
            String salesPersonName = CisUtility.getInputString("Enter sales person name");
            double soldPrice = CisUtility.getInputDouble("Enter sold price");
            System.out.println("Date of sale (yyyymmdd):");
            String dateOfSale = CisUtility.getInputString("Date of sale (yyyymmdd)");

            //Add the new sale to the collection of sales
            Sale newSale = new Sale(dateOfSale, soldPrice, vehicleId, salesPersonName);
            sales.add(newSale);
            inventory.get(vehicleId).setStatusType(Vehicle.StatusType.SOLD);
        }
    }

    /**
     * Show the inventory of vehicles
     *
     * @since 20220301
     * @author BJM
     */
    public static void showInventory() {
        //System.out.println("Future functionality");
        System.out.println("Inventory:");
        for (Integer i : inventory.keySet()) {
            System.out.println(inventory.get(i));
        }
    }

    /**
     * Show inventory by vehicle type.
     *
     * @author Arthur Zuliani
     * @since 20220301
     */
    public static void showInventoryByType() {

        int selectedType = CisUtility.getInputInt(Vehicle.getVehicleDescriptionPrompt());

        boolean hasVehicle = false, firstPrint = true;

        //TODO 4 Show inventory by type
        for (Vehicle currentVehicle : inventory.values()) {

            if (currentVehicle.getVehicleTypeCode() == selectedType) {
                hasVehicle = true;

                if (hasVehicle && firstPrint) {
                    firstPrint = false;
                    System.out.println("Inventory:");
                }
                currentVehicle.display();
            }
        }

        if (!hasVehicle) {
            System.out.println("There is none vehicle of this type");
        }
    }

    /**
     * This will show the inventory counts based on vehicle type
     *
     * @since 20150227
     * @author cis1232
     */
    public static void showInventoryCounts() {
        int countCars = 0;
        int countTrucks = 0;
        int countOther = 0;

        //Count the vehicles based on status and type.
        for (Integer i : inventory.keySet()) {
            //if they are instock then count them
            Vehicle vehicle = inventory.get(i);
            if (vehicle.getStatusType() == Vehicle.StatusType.INSTOCK) {
                switch (vehicle.getVehicleTypeCode()) {
                    case Vehicle.TYPE_CAR:
                        countCars++;
                        break;
                    case Vehicle.TYPE_TRUCK:
                        countTrucks++;
                        break;
                    case Vehicle.TYPE_OTHER:
                        countOther++;
                        break;

                }
            }
        }

        //Show the information
        String output = INVENTORY_COUNT_OUTPUT_1 + System.lineSeparator()
                + INVENTORY_COUNT_OUTPUT_2 + countCars + System.lineSeparator()
                + INVENTORY_COUNT_OUTPUT_3 + countTrucks + System.lineSeparator()
                + INVENTORY_COUNT_OUTPUT_4 + countOther + System.lineSeparator();

        System.out.println(output);

    }

    /**
     * Load the initial values into the collections
     *
     * @since 20220301
     * @author BJM
     */
    public static void loadTestData() {
        //*******************************************************************
        //LOAD SOME TEST DATA
        //*******************************************************************

        Vehicle testOne = new Vehicle(Vehicle.TYPE_CAR, 6000.0, 8000, "Honda", "Accord", 2009, Vehicle.StatusType.SOLD);
        Vehicle testTwo = new Vehicle(Vehicle.TYPE_CAR, 3000.0, 5000, "Ford", "Focus", 2007, Vehicle.StatusType.SOLD);
        Vehicle test3 = new Vehicle(Vehicle.TYPE_TRUCK, 4000.0, 0, "Ford", "F150", 2007, Vehicle.StatusType.INSTOCK);
        Vehicle test4 = new Vehicle(Vehicle.TYPE_CAR, 8000.0, 8800, "Toyota", "Camry", 2011, Vehicle.StatusType.INSTOCK);
        Vehicle test5 = new Vehicle(Vehicle.TYPE_CAR, 3000.0, 5000, "Hyundai", "Accent", 2012, Vehicle.StatusType.INSTOCK);

        inventory.put(testOne.getVehicleId(), testOne);
        inventory.put(testTwo.getVehicleId(), testTwo);
        inventory.put(test3.getVehicleId(), test3);
        inventory.put(test4.getVehicleId(), test4);
        inventory.put(test5.getVehicleId(), test5);

        testOne = new Vehicle(Vehicle.TYPE_CAR, 7000.0, 8000, "Honda", "Accord", 2009, Vehicle.StatusType.INSTOCK);
        testTwo = new Vehicle(Vehicle.TYPE_CAR, 2000.0, 5000, "Ford", "Focus", 2007, Vehicle.StatusType.INSTOCK);
        test3 = new Vehicle(Vehicle.TYPE_TRUCK, 3000.0, 0, "Ford", "F150", 2007, Vehicle.StatusType.INSTOCK);
        test4 = new Vehicle(Vehicle.TYPE_CAR, 6000.0, 8800, "Toyota", "Camry", 2011, Vehicle.StatusType.INSTOCK);
        test5 = new Vehicle(Vehicle.TYPE_CAR, 3250.0, 5000, "Hyundai", "Accent", 2012, Vehicle.StatusType.INSTOCK);

        inventory.put(testOne.getVehicleId(), testOne);
        inventory.put(testTwo.getVehicleId(), testTwo);
        inventory.put(test3.getVehicleId(), test3);
        inventory.put(test4.getVehicleId(), test4);
        inventory.put(test5.getVehicleId(), test5);

        sales.add(new Sale("20220227", 5000, 1, "Daniel"));
        sales.add(new Sale("20220227", 6000, 2, "Wyatt"));
        sales.add(new Sale("20220226", 5000, 3, "Daniel"));
        sales.add(new Sale("20220226", 8300, 6, "Wyatt"));

    }

}
