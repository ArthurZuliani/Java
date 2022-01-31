/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis.bo;

import cis.util.CisUtility;
/**
 *
 * @author Arthur
 */
public class Student {

    public static final int POS_ASSIGNMENT = 0;
    public static final int POS_THEORY = 1;
    public static final int POS_PRACTICAL = 2;
    
    private final double AVERAGE_NUMBER = 3;
    
    
    private String name;
    private int[] grades = new int[3];
    
    private int assignmentGrade, theoryGrade, practicalGrade;

    //Constructors
    public Student() {
    }

    public Student(String name, int assignmentGrade, int theoryGrade, int practicalGrade) {
        this.name = name;
        this.grades[POS_ASSIGNMENT] = assignmentGrade;
        this.grades[POS_THEORY] = theoryGrade;
        this.grades[POS_PRACTICAL] = practicalGrade;
    }

    public Student(String name) {
        this.name = name;
    }

    /**
     * Get user information
     *
     * @author Arthur Zuliani
     * @since 20220117
     */
    public void getInformation() {
        name = CisUtility.getInputString("Enter student name:", "red");
    }

    /**
     * Calculates the average grade of the student
     * 
     * @author Arthur Zuliani
     * @since 20220117
     * @return the average grade
     */
    public double getAverage() {
        return (grades[POS_ASSIGNMENT] + grades[POS_THEORY] + grades[POS_PRACTICAL]) / AVERAGE_NUMBER;
    }
    
    
    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAssignmentGrade() {
        return grades[POS_ASSIGNMENT];
    }

    public void setAssignmentGrade(int assignmentGrade) {
        this.grades[POS_ASSIGNMENT] = assignmentGrade;
    }

    public int getTheoryGrade() {
        return grades[POS_THEORY];
    }

    public void setTheoryGrade(int theoryGrade) {
        this.grades[POS_THEORY] = theoryGrade;
    }

    public int getPracticalGrade() {
        return grades[POS_PRACTICAL];
    }

    public void setPracticalGrade(int practicalGrade) {
        this.grades[POS_PRACTICAL] = practicalGrade;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }
    
    

    /**
     * Displays the default string to the console
     * 
     * @author Arthur Zuliani
     * @since 20220117
     */
    public void display() {
        System.out.println(toString());
    }
    
    /**
     * Constructs the default output string for the object
     * 
     * @author Arthur Zuliani
     * @since 20220117
     * @return the output string
     */
    @Override
    public String toString(){
        String outputString = "-- " + name + "'s attributes --" + System.lineSeparator()
                + "- Assignment grade: " + grades[POS_ASSIGNMENT] + System.lineSeparator()
                + "- Theory grade: " + grades[POS_THEORY] + System.lineSeparator()
                + "- Practical grade: " + grades[POS_PRACTICAL] + System.lineSeparator()
                + "- Average grade: " + getAverage() + System.lineSeparator();
        return outputString;
    }
}
