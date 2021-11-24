/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.starting.bo;

import info.hccis.util.CisUtility;

/**
 * This class will handle babysitting job
 *
 * @author Arthur Zuliani
 * @since 2021-11-23
 */
public class BabysittingJob {

    private static final int NUMBER_CINDY = 1;
    private static final int NUMBER_GREG = 2;
    private static final int NUMBER_MARCIA = 3;

    private static final double RATE_CINDY = 7;
    private static final double RATE_FIRST_CHILD_GREG_MARCIA = 9;
    private static final double RATE_ADDITIONAL_CHILD_GREG_MARCIA = 4;
    
    private static final int MINIMUM_NUMBER_OF_CHILDREN = 1;
    private static final int MAXIMUM_NUMBER_OF_CHILDREN = 9;
    
    private static final int MINIMUM_NUMBER_OF_HOURS = 1;
    private static final int MAXIMUM_NUMBER_OF_HOURS = 12;
    
    private static final int MINIMUM_YEAR = 2013;
    private static final int MAXIMUM_YEAR = 2025;
    
    private static final int MINIMUM_JOB_SEQ_NUMBER = 1;
    private static final int MAXIMUM_JOB_SEQ_NUMBER = 9999;
    

    private static final String CINDY = "Cindy";
    private static final String GREG = "Greg";
    private static final String MARCIA = "Marcia";
    
    private static final int YEAR_BASE = 2000;
    private static final int JOB_NUMBER_BASE = 10000;

    private int numberOfChildren;
    private int numberOfHours;
    private int jobNumber;
    private int babySitterCode;
    private String babySitterName = "";
    private double jobCost;
    private double hourRate;
    private int year;
    private int jobSequenceNumber;

    /**
     * Default constructor
     *
     * @author Arthur Zuliani
     * @since 2021-11-23
     */
    public BabysittingJob() {

    }

    /**
     * Custom contructor
     *
     * @author Arthur Zuliani
     * @since 2021-11-23
     * @param jobNumber
     * @param babySitterCode
     * @param numberOfChildren
     * @param numberOfHours
     */
    public BabysittingJob(int jobNumber, int babySitterCode, int numberOfChildren, int numberOfHours) {
        this.jobNumber = jobNumber;
        this.numberOfChildren = numberOfChildren;
        this.numberOfHours = numberOfHours;

        setBabySitterCode(babySitterCode);
        
        calculateCost();
    }

    /**
     * This method will collect information from the user
     *
     * @author Arthur Zuliani
     * @since 2021-11-23
     */
    public void getInformation() {
        
        do {
            year = CisUtility.getInputInt("Enter the current year (Between 2013 and 2025)(Format - YYYY):");
        } while (!(year >= MINIMUM_YEAR && year <= MAXIMUM_YEAR));
        
        do {
            jobSequenceNumber = CisUtility.getInputInt("Enter a job sequence number (Between 1 and 9999):");
        } while (!(jobSequenceNumber >= MINIMUM_JOB_SEQ_NUMBER && jobSequenceNumber <= MAXIMUM_JOB_SEQ_NUMBER));
        
        jobNumber = (year - YEAR_BASE) * JOB_NUMBER_BASE + jobSequenceNumber; //Job number under the requirements
        
        do {
            babySitterCode = CisUtility.getInputInt("Enter the babysitter code (1-Cindy 2-Greg 3-Marcia):");
        } while (!(babySitterCode >= NUMBER_CINDY && babySitterCode <= NUMBER_MARCIA));
        
        setBabySitterCode(babySitterCode); //To assign the babysitter name to string variable
        
        do {
            numberOfChildren = CisUtility.getInputInt("Enter the number of children (1 to 9):");
        } while (!(numberOfChildren >= MINIMUM_NUMBER_OF_CHILDREN && numberOfChildren <= MAXIMUM_NUMBER_OF_CHILDREN));
        
        do {
            numberOfHours = CisUtility.getInputInt("Enter the number of hours (1 to 12):");
        } while (!(numberOfHours >= MINIMUM_NUMBER_OF_HOURS && numberOfHours <= MAXIMUM_NUMBER_OF_HOURS));
        
        calculateCost();
    }

    /**
     * This method calculates the total cost for the service
     * 
     * @author Arthur Zuliani
     * @since 2021-11-23
     * @return jobCost
     */
    public final double calculateCost() {

        jobCost = 0;
        hourRate = 0;
        
        if (NUMBER_CINDY == babySitterCode) {
            jobCost = numberOfHours * RATE_CINDY * numberOfChildren;
        } else {
            jobCost = numberOfHours * ((numberOfChildren - 1) * RATE_ADDITIONAL_CHILD_GREG_MARCIA + RATE_FIRST_CHILD_GREG_MARCIA);
        }
        
        hourRate = jobCost / numberOfHours;

        return jobCost;
    }

    //Setters and getters
    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public int getBabySitterCode() {        
        return babySitterCode;
    }

    public final void setBabySitterCode(int babySitterCode) {
        this.babySitterCode = babySitterCode;
        
        switch (babySitterCode) {
            case NUMBER_CINDY:
                babySitterName = CINDY;
                break;
            case NUMBER_GREG:
                babySitterName = GREG;
                break;
            case NUMBER_MARCIA:
                babySitterName = MARCIA;
                break;
        }
    }

    public String getBabySitterName() {
        return babySitterName;
    }

    public void setBabySitterName(String babySitterName) {
        this.babySitterName = babySitterName;
    }

    /**
     * This method printout the string to standard output
     *
     * @author Arthur Zuliani
     * @since 2021-11-23
     */
    public void display() {
        System.out.println(toString());
    }

    /**
     * This method constructs the output string for the object
     *
     * @author Arthur Zuliani
     * @since 2021-11-23
     * @return output string
     */
    @Override
    public String toString() {
        return  System.lineSeparator()
                + "--------------------" + System.lineSeparator()
                + "Job summary" + System.lineSeparator()
                + "Job number: " + jobNumber + System.lineSeparator()
                + "Babysitter: " + babySitterName + System.lineSeparator()
                + "Number of hours: " + numberOfHours + System.lineSeparator()
                + "Number of children: " + numberOfChildren + System.lineSeparator()
                + "Hour rate: " + CisUtility.toCurrency(hourRate) + System.lineSeparator()
                + "Job total cost: " + CisUtility.toCurrency(jobCost) + System.lineSeparator()
                + "--------------------" + System.lineSeparator();
    }
}
