package info.hccis.scholarship.bo;

import info.hccis.util.CisUtility;

/**
 * Class responsible to handles the student information
 *
 * @author Arthur Zuliani
 * @since 20211026
 */
public class Student {

    private double highSchoolGpa;
    private double highSchoolExtracurricular;
    private double highSchoolNumberOfService;

    /**
     * Default Constructor
     *
     * @author Arthur Zuliani
     * @since 20211026
     */
    public Student() {

    }

    /**
     * Custom constructor
     *
     * @author Arthur Zuliani
     * @since 20211026
     * @param highSchoolGpa
     * @param highSchoolExtracurricular
     * @param highSchoolNumberOfService
     */
    public Student(double highSchoolGpa, double highSchoolExtracurricular, double highSchoolNumberOfService) {
        this.highSchoolGpa = highSchoolGpa;
        this.highSchoolExtracurricular = highSchoolExtracurricular;
        this.highSchoolNumberOfService = highSchoolNumberOfService;
    }

    /**
     * Method responsible to get user information
     *
     * @author Arthur Zuliani
     * @since 20211026
     */
    public void getInformation() {
        highSchoolGpa = CisUtility.getInputDouble("Enter the high school GPA average: ");
        highSchoolExtracurricular = CisUtility.getInputDouble("Enter the number of extracurricular activities: ");
        highSchoolNumberOfService = CisUtility.getInputDouble("Enter the number of service activities: ");
    }

    /**
     * Method responsible to analyze the student condition
     *
     * @author Arthur Zuliani
     * @since 20211026
     * @return The analyzed string for the candidate
     */
    public String analyze() {
        String outputString;

        if ((highSchoolGpa < 0 || highSchoolGpa > 4.0) || (highSchoolExtracurricular < 0) || (highSchoolNumberOfService < 0)) {
            outputString = "ERROR - Incorrect input values";
        } else if (highSchoolGpa >= 3.8) {
            outputString = "Scholarship candidate";
        } else if (((highSchoolGpa >= 3.4) && (highSchoolGpa < 3.8)) && ((highSchoolExtracurricular + highSchoolNumberOfService) >= 3)) {
            outputString = "Scholarship candidate";
        } else if (((highSchoolGpa >= 3.0) && (highSchoolGpa < 3.4)) && ((highSchoolExtracurricular >= 2) && (highSchoolNumberOfService >= 3))) {
            outputString = "Scholarship candidate";
        } else {
            outputString = "Not a candidate";
        }

        return outputString;
    }

    //Setters and getters
    public double getHighSchoolGpa() {
        return highSchoolGpa;
    }

    public void setHighSchoolGpa(double highSchoolGpa) {
        this.highSchoolGpa = highSchoolGpa;
    }

    public double getHighSchoolExtracurricular() {
        return highSchoolExtracurricular;
    }

    public void setHighSchoolExtracurricular(double highSchoolExtracurricular) {
        this.highSchoolExtracurricular = highSchoolExtracurricular;
    }

    public double getHighSchoolNumberOfService() {
        return highSchoolNumberOfService;
    }

    public void setHighSchoolNumberOfService(double highSchoolNumberOfService) {
        this.highSchoolNumberOfService = highSchoolNumberOfService;
    }

    /**
     * Method responsible to print out the standard string to the console
     *
     * @author Arthur Zuliani
     * @since 20211026
     */
    public void display() {
        System.out.println(toString());
    }

    /**
     * Method responsible to construct the output string for the object
     *
     * @author Arthur Zuliani
     * @since 20211026
     * @return The output string to be printed out
     */
    @Override
    public String toString() {
        String outputString = "Williamsburg Women's Club scholarships program" + System.lineSeparator()
                + "" + System.lineSeparator()
                + "Student GPA: " + highSchoolGpa + System.lineSeparator()
                + "Student number of extracurricular activities: " + highSchoolExtracurricular + System.lineSeparator()
                + "Student number of service activities: " + highSchoolNumberOfService + System.lineSeparator()
                + "" + System.lineSeparator()
                + "Analysis: " + analyze() + System.lineSeparator();

        return outputString;
    }

}
