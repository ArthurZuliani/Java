package info.hccis.pizza.bo;

import info.hccis.util.CisUtility;

/**
 * Represents a pizza order
 *
 * @author Arthur Zuliani
 * @since 2021-11-23
 */
public class Order {

    public static final int SIZE_SMALL = 1;
    public static final int SIZE_MEDIUM = 2;
    public static final int SIZE_LARGE = 3;

    public static final double SMALL_CRUST = 5;
    public static final double MEDIUM_CRUST = 7;
    public static final double LARGE_CRUST = 9;

    public static final double REGULAR_INGREDIENTS = 0.50;
    public static final double PREMIUM_INGREDIENTS = 1;
    public static final double STUDENT_DISCOUNT = 0.25;

    private int size;
    private int numberOfRegularIngredients;
    private int numberOfPremiumIngredients;
    private boolean student;
    private double cost;

    private String regularIngredients = "";
    private String premiumIngredients = "";

    public static final String INGREDIENTS_REGULAR = "Ham, Meatballs, Beef, Jalapeno, Black olives, Spinach, Green olives";
    public static final String INGREDIENTS_PREMIUM = "Pepperoni, Mushroom, Extra cheese, Sausage, Onion, Green pepper, Fresh garlic, Tomato, Fresh basil";

    /**
     * Default constructor
     *
     * @author Arthur Zuliani
     * @since 2021-11-23
     */
    public Order() {

    }

    /**
     * Custom constructor that accepts size, number of regular and premium
     * ingredients and if the user is a student
     *
     * @author Arthur Zuliani
     * @since 2021-11-23
     * @param size
     * @param numberOfRegularIngredients
     * @param numberOfPremiumIngredients
     * @param student
     */
    public Order(int size, int numberOfRegularIngredients, int numberOfPremiumIngredients, boolean student) {
        this.size = size;
        this.numberOfRegularIngredients = numberOfRegularIngredients;
        this.numberOfPremiumIngredients = numberOfPremiumIngredients;
        this.student = student;
        calculateCost();
    }

    /**
     * This method will collect information from the user
     *
     * @author Arthur Zuliani
     * @since 2021-11-23
     */
    public void getInformation() {

        System.out.println("Order a pizza");

        numberOfPremiumIngredients = CisUtility.getInputInt("How many premium ingredients do you want?");
        premiumToppingMenu();

        numberOfRegularIngredients = CisUtility.getInputInt("How many regular ingredients do you want?");
        regularToppingMenu();

        size = CisUtility.getInputInt("What is the size of the pizza (1-Small 2-Medium 3-Large)?");
        student = CisUtility.getInputBoolean("Are you a student?");
    }

    /**
     * This method will handle user`s regular toppings choice
     *
     * @author Arthur Zuliani
     * @since 2021-11-23
     * @return the regular toppings string
     */
    public String premiumToppingMenu() {

        String option;
        String bufPremium = INGREDIENTS_PREMIUM;    //Just to preserve original data
        String premiumTopping;  //Chosen option with correct Case

        int startIndex;
        int endIndex;
        int endIndexDynamicToppings;
        int lengthDynamicToppings;

        for (int i = 1; i <= numberOfPremiumIngredients; i++) {

            System.out.print("Please enter premium ingredient " + i + "(");
            option = CisUtility.getInputString(bufPremium + ")");
            option = option.toUpperCase();

            if (premiumIngredients.toUpperCase().contains(option)) {
                System.out.println("Already entered this topping, enter another one...");
                i--;
            } else if (INGREDIENTS_REGULAR.toUpperCase().contains(option)) {
                System.out.println("That is a regular ingredient");
                i--;
            } else if (INGREDIENTS_PREMIUM.toUpperCase().contains(option)) {

                startIndex = INGREDIENTS_PREMIUM.toUpperCase().indexOf(option);
                endIndex = INGREDIENTS_PREMIUM.toUpperCase().indexOf(option) + option.length();
                premiumTopping = INGREDIENTS_PREMIUM.substring(startIndex, endIndex);

                if (i == 1) {
                    premiumIngredients += premiumTopping;
                } else {
                    premiumIngredients += ", " + premiumTopping;
                }

                lengthDynamicToppings = bufPremium.length();
                endIndexDynamicToppings = bufPremium.indexOf(premiumTopping) + premiumTopping.length();

                if (lengthDynamicToppings == endIndexDynamicToppings) {
                    bufPremium = bufPremium.replace(", " + premiumTopping, "");
                } else {
                    bufPremium = bufPremium.replace(premiumTopping + ", ", "");
                }
            } else {
                System.out.println("Invalid option");
                i--;
            }
        }

        return premiumIngredients;
    }

    /**
     * This method will handle user`s premium toppings choice
     *
     * @author Arthur Zuliani
     * @since 2021-11-23
     * @return the premium toppings string
     */
    public String regularToppingMenu() {

        String option;
        String bufRegular = INGREDIENTS_REGULAR;    //Just to preserve original data
        String regularTopping;  //Chosen option with correct Case

        int startIndex;
        int endIndex;
        int endIndexDynamicToppings;
        int lengthDynamicToppings;

        for (int i = 1; i <= numberOfRegularIngredients; i++) {

            System.out.print("Please enter premium ingredient " + i + "(");
            option = CisUtility.getInputString(bufRegular + ")");
            option = option.toUpperCase();

            if (regularIngredients.toUpperCase().contains(option)) {
                System.out.println("Already entered this topping, enter another one...");
                i--;
            } else if (INGREDIENTS_PREMIUM.toUpperCase().contains(option)) {
                System.out.println("That is a regular ingredient");
                i--;
            } else if (INGREDIENTS_REGULAR.toUpperCase().contains(option)) {

                startIndex = INGREDIENTS_REGULAR.toUpperCase().indexOf(option);
                endIndex = INGREDIENTS_REGULAR.toUpperCase().indexOf(option) + option.length();
                regularTopping = INGREDIENTS_REGULAR.substring(startIndex, endIndex);

                if (i == 1) {
                    regularIngredients += regularTopping;
                } else {
                    regularIngredients += ", " + regularTopping;
                }

                lengthDynamicToppings = bufRegular.length();
                endIndexDynamicToppings = bufRegular.indexOf(regularTopping) + regularTopping.length();

                if (lengthDynamicToppings == endIndexDynamicToppings) {
                    bufRegular = bufRegular.replace(", " + regularTopping, "");
                } else {
                    bufRegular = bufRegular.replace(regularTopping + ", ", "");
                }
            } else {
                System.out.println("Invalid option");
                i--;
            }
        }
        
        return regularIngredients;
    }

    /**
     * This method will calculate the order total cost
     *
     * @author Arthur Zuliani
     * @since 2021-11-23
     * @return the total cost
     */
    public final double calculateCost() {

        cost = 0; //Just to be sure that when calling it again won`t stack up the values

        cost = (numberOfRegularIngredients * REGULAR_INGREDIENTS) + (numberOfPremiumIngredients * PREMIUM_INGREDIENTS);

        switch (size) {
            case SIZE_SMALL:
                cost += SMALL_CRUST;
                break;
            case SIZE_MEDIUM:
                cost += MEDIUM_CRUST;
                break;
            case SIZE_LARGE:
                cost += LARGE_CRUST;
                break;
        }

        if (student) {
            cost *= (1 - STUDENT_DISCOUNT);
        }

        return cost;
    }

    //setters and getters
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumberOfRegularIngredients() {
        return numberOfRegularIngredients;
    }

    public void setNumberOfRegularIngredients(int numberOfRegularIngredients) {
        this.numberOfRegularIngredients = numberOfRegularIngredients;
    }

    public int getNumberOfPremiumIngredients() {
        return numberOfPremiumIngredients;
    }

    public void setNumberOfPremiumIngredients(int numberOfPremiumIngredients) {
        this.numberOfPremiumIngredients = numberOfPremiumIngredients;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public double getCost() {
        return cost;
    }

    /**
     * This method will display the default string to the standard output
     *
     * @author Arthur Zuliani
     * @since 2021-11-23
     */
    public void display() {
        System.out.println(toString());
    }

    /**
     * This method will assemble the object string
     *
     * @author Arthur Zuliani
     * @since 2021-11-23
     * @return the default string
     */
    @Override
    public String toString() {
        return "CIS Pizza Order" + System.lineSeparator()
                + "Size = " + (size == SIZE_SMALL ? "Small" : (size == SIZE_MEDIUM ? "Medium" : (size == SIZE_LARGE ? "Large" : "Invalid Size")))
                + System.lineSeparator()
                + "Number of regular ingredients: "
                + numberOfRegularIngredients + (numberOfRegularIngredients == 0 ? System.lineSeparator() : " (" + regularIngredients + ")" + System.lineSeparator())
                + "Number of premimum ingredients: "
                + numberOfPremiumIngredients + (numberOfPremiumIngredients == 0 ? System.lineSeparator() : " (" + premiumIngredients + ")" + System.lineSeparator())
                + "Student: " + (student ? "Yes" : "No") + System.lineSeparator()
                + "Cost: " + CisUtility.toCurrency(cost);
    }

}
