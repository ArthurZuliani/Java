package info.hccis.musicproject;

import info.hccis.musicproject.bo.Student;

/**
 * Exercise to work with POJO
 *
 * @author Arthur
 * @since 20211018
 */
public class Controller {

    private static double totalDonated = 0.0;

    public static void main(String args[]) {

        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        Student student5 = new Student();

        student1.getInformation();
        student2.getInformation();
        student3.getInformation();
        student4.getInformation();
        student5.getInformation();

        totalDonated = student1.getAmountDonated()
                + student2.getAmountDonated()
                + student3.getAmountDonated()
                + student4.getAmountDonated()
                + student5.getAmountDonated();

        display(student1, student2, student3, student4, student5);

    }

    /**
     * This method is responsible to print out the information about the class
     * (students and donation)
     *
     * @author Arthur Zulaini
     * @since 20211018
     * @param student1
     * @param student2
     * @param student3
     * @param student4
     * @param student5
     */
    public static void display(Student student1, Student student2, Student student3, Student student4, Student student5) {

        student1.display();
        student2.display();
        student3.display();
        student4.display();
        student5.display();

        System.out.println("Total donated (CDN): " + totalDonated);
    }
}
