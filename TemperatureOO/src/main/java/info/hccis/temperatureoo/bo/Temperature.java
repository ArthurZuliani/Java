package info.hccis.temperatureoo.bo;

import info.hccis.util.CisUtility;

/**
 * Class Temperature, responsible to handle the information related to
 * temperature
 *
 * @author Arthur Zuliani
 * @since 20211026
 */
public class Temperature {

    //Private attributes declaration
    private int high;
    private int low;

    //Constants declaration
    public static final int TEMPERATURE_SWING_AMOUNT = 40;
    public static final int TEMPERATURE_HEAT_WARNING = 90;
    public static final int TEMPERATURE_FREEZE_WARNING = 32;

    /**
     * Default constructor
     *
     * @author Arthur Zulinai
     * @since 20211026
     */
    public Temperature() {

    }

    /**
     * Custom constructor which accepts high and low temperatures
     *
     * @author Arthur Zuliani
     * @since 20211026
     * @param high
     * @param low
     */
    public Temperature(int high, int low) {
        this.high = high;
        this.low = low;
    }

    /**
     * This method asks the user for values of the attributes
     *
     * @author Arthur Zuliani
     * @since 20211026
     */
    public void getInformation() {
        high = CisUtility.getInputInt("Enter the higher temperature value (F):");
        low = CisUtility.getInputInt("Enter the lower temperature value (F):");
    }

    /**
     * This method will do the analysis and return a string which contains the
     * description of the analysis
     *
     * @author Arthur Zuliani
     * @since 20211026
     * @return String with description of the analysis
     */
    public String getResults() {
        String outputString = "";

        double temperatureDifference = high - low;

        if (high >= TEMPERATURE_HEAT_WARNING) {
            outputString += " Heat warninng";
        }
        if (low < TEMPERATURE_FREEZE_WARNING) {
            outputString += " Freeze warninng";
        }
        if (temperatureDifference > TEMPERATURE_SWING_AMOUNT) {
            outputString += " Large temperature swing";
        }

        return outputString;
    }

    //Setters and getters
    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    /**
     * This method will display the information to the standard output
     *
     * @author Arthur Zuliani
     * @since 20211026
     */
    public void display() {
        System.out.println(toString());
    }

    /**
     * This method will construct the output String for the class
     *
     * @author Arthur Zuliani
     * @since 20211026
     * @return String which is created from the getResults
     */
    @Override
    public String toString() {
        String outputString = "Temperature Analysis" + System.lineSeparator()
                + "High= " + high + " Low= " + low + System.lineSeparator()
                + "Analysis:" + getResults();

        return outputString;
    }

}
