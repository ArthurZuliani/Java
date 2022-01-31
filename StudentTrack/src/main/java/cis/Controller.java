package cis;

import cis.util.CisUtility;
import cis.bo.Student;

/**
 * A starting project which we can use for applications that need a menu driven
 * program. Note that the name of the project should be modified to reflect the
 * specific requirements.
 *
 * @author bjmaclean
 * @since 20181115
 */
public class Controller {

    public static final String EXIT = "X";
    public static Student[] students = new Student[20];
    public static int studentId = 0;

    private static final String MENU
            = "\n-------------------------\n"
            + "- CIS Menu\n"
            + "- A-Show all students grades\n"
            + "- B-Lookup for a student\n"
            + "- X-eXit\n"
            + "-------------------------\n"
            + "Option-->";

    public static void main(String[] args) {

        students[0] = new Student("Mike", 100, 98, 98);
        students[1] = new Student("Joe", 75, 75, 80);
        students[2] = new Student("John", 85, 75, 63);
        students[3] = new Student("Mac", 90, 65, 85);

        //Add a loop below to continuously promput the user for their choice 
        //until they choose to exit.
        String option = "";

        CisUtility.display("Today is: " + CisUtility.getCurrentDate(null));

        do {
            option = CisUtility.getInputString(MENU, "Green");
            processMenuOption(option);
        } while (!option.equalsIgnoreCase(EXIT));

    }

    /**
     * This method will process the menu option specified in the input
     * parameter. It will call appropriate functionality based on its value.
     *
     * @param option The menu option
     * @since 20171102
     * @author cis1201b
     *
     */
    public static void processMenuOption(String option) {
        //Add a switch to process the option
        switch (option.toUpperCase()) {
            case "A":
                showAllAverages();
                break;
            case "B":
                lookupStudent();
                break;
            default:
                break;
        }
    }

    /**
     * Show all students average
     *
     * @author Arthur Zuliani
     * @since 20220117
     */
    public static void showAllAverages() {

        for (Student student : students) {

            if (student != null) {
                student.display();
            }
        }
    }

    /**
     * Lookup for a student by name
     * 
     * @author Arthur Zuliani
     * @since 20220117
     */
    public static void lookupStudent() {

        boolean isNameValid = false;
        String studentName = CisUtility.getInputString("Enter student name: ");

        for (Student student : students) {

            if (student != null) {

                if (student.getName().equalsIgnoreCase(studentName)) {
                    student.display();
                    isNameValid = true;
                    break;
                } 
            }
        }
        
        if(!isNameValid) {
            System.out.println("This name does not exist!");
        }
    }

}
