/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis.entity;

import cis.util.CisUtility;

/**
 * Class responsible to 
 * @author Arthur
 */
public class Course {

    private String userStudent = "";
    private String[] names = {"Darren", "Darcy", "Nic", "Wayne"};
    private int[] assignmentGrades = {90, 88, 75, 40};
    private int[] theoryGrades = {98, 60, 80, 90};
    private int[] practicalGrades = {32, 85, 80, 90};

    /**
     * Get user input for student name
     *
     * @author Arthur Zuliani
     * @since 20220112
     */
    public void getInformation() {
        userStudent = CisUtility.getInputString("Enter student name");
    }

    /**
     * Look up for a student name
     *
     * @author Arthur Zuliani
     * @since 20220112
     */
    public void findStudent() {

        boolean studentFound = false;

        for (int i = 0; i < names.length; i++) {
            if (userStudent.equalsIgnoreCase(names[i])) {
                studentFound = true;
                showStudentAverage(i);
            }
        }
        
        if(!studentFound) {
            System.out.println("Sorry, there is not a student with this name!");
        }
    }

    /**
     * Calculates and print out the students average
     *
     * @param student
     * @author Arthur Zuliani
     * @since 20220112
     */
    public void showStudentAverage(int student) {

        System.out.println("Student: " + names[student]);
        double average = (assignmentGrades[student] + theoryGrades[student] + practicalGrades[student]) / 3.0;
        System.out.println("Average: " + average);
    }

    /**
     * printout all students average
     *
     * @author Arthur Zuliani
     * @since 20220112
     */
    public void showStudentsAverages() {

        for (int i = 0; i < names.length; i++) {
            showStudentAverage(i);
        }
    }

    /**
     * Printout the standard output
     *
     * @author Arthur Zuliani
     * @since 20220112
     */
    public void display() {
        System.out.println(toString());
    }

    /**
     * Builds the object standard output
     *
     * @author Arthur Zuliani
     * @since 20220112
     * @return standard output string
     */
    @Override
    public String toString() {
        String outputString = "Names: ";

        for (String name : names) {
            outputString += name + " ";
        }

        return outputString;
    }
}
