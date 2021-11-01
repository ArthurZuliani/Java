package info.hccis.personhealth.bo;

import info.hccis.util.CisUtility;

/**
 * Class PersonalHealth, responsible to handle the information related to person
 * dietary
 *
 * @author Arthur Zuliani
 * @since 20211026
 */
public class PersonHealth {

    //Private attributes declaration
    private int dailyDiet;
    private int activityLevel;
    private int sleepAmount;

    //Constants declaration
    public static final int DIET_TERRIBLE = 1;
    public static final int DIET_OK = 2;
    public static final int DIET_GREAT = 3;

    public static final int ACTIVITY_NONE = 1;
    public static final int ACTIVITY_SOME = 2;
    public static final int ACTIVITY_VERY = 3;

    public static final int SLEEP_VERY_LITTLE = 1;
    public static final int SLEEP_NOT_QUITE_ENOUGH = 2;
    public static final int SLEEP_ENOUGH = 3;

    /**
     * Default constructor
     *
     * @author Arthur Zuliani
     * @since 20211026
     */
    public PersonHealth() {

    }

    /**
     * Custom constructor
     *
     * @author Arthur Zuliani
     * @since 20211026
     * @param dailyDiet
     * @param activityLevel
     * @param sleepAmount
     */
    public PersonHealth(int dailyDiet, int activityLevel, int sleepAmount) {
        this.dailyDiet = dailyDiet;
        this.activityLevel = activityLevel;
        this.sleepAmount = sleepAmount;
    }

    /**
     * This method is responsible to get users information
     *
     * @author Arthur Zuliani
     * @since 20211026
     */
    public void getInformation() {
        dailyDiet = CisUtility.getInputInt("Enter the daily diet:");
        activityLevel = CisUtility.getInputInt("Enter the activity level:");
        sleepAmount = CisUtility.getInputInt("Enter the sleep amount:");
    }

    /**
     * Method responsible to analyze the user health 
     * 
     * @author Arthur Zuliani
     * @since 20211026
     * @return String which contains the analysis from the user health
     */
    public String analyze() {
        String outputString = "";

        if (dailyDiet < DIET_GREAT && activityLevel == ACTIVITY_NONE) {
            outputString += " I am sluggish";
        }

        if (activityLevel > ACTIVITY_NONE) {
            outputString += " I did something today";
        }

        if (sleepAmount < SLEEP_ENOUGH) {
            outputString += " I am tired";
        }

        if (dailyDiet == DIET_TERRIBLE && activityLevel == ACTIVITY_NONE && sleepAmount == SLEEP_VERY_LITTLE) {
            outputString += " Things have to change";
        }

        if (dailyDiet == DIET_GREAT && activityLevel == ACTIVITY_VERY && sleepAmount == SLEEP_ENOUGH) {
            outputString += " Things are going great";
        }

        if (dailyDiet != DIET_GREAT || activityLevel != ACTIVITY_VERY || sleepAmount != SLEEP_ENOUGH) {
            outputString += " Things are not perfect";
        }

        return outputString;
    }

    //Setters and getters
    public int getDailyDiet() {
        return dailyDiet;
    }

    public void setDailyDiet(int dailyDiet) {
        this.dailyDiet = dailyDiet;
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(int activityLevel) {
        this.activityLevel = activityLevel;
    }

    public int getSleepAmount() {
        return sleepAmount;
    }

    public void setSleepAmount(int sleepAmount) {
        this.sleepAmount = sleepAmount;
    }
    
    /**
     * Method responsible to printout the output String for the object
     * 
     * @author Arthur Zuliani
     * @since 20211026
     */
    public void display(){
        System.out.println(toString());
    }
            
    /**
     * Method responsible to construct the standard output string for the object
     * 
     * @author Arthur Zuliani
     * @since 20211026
     * @return String to be printed out
     */
    @Override
    public String toString(){
        String outputString = "Person Health Analysis" + System.lineSeparator()
                              + "Daily diet: " + dailyDiet + " Activity level: " + activityLevel 
                              + " Sleep amount: " + sleepAmount + System.lineSeparator()
                              + "Analysis" + analyze();        
        return outputString;
    }

}
