package cis;

import cis.util.CisUtility;

/**
 * Enumeration sandbox
 *
 * @author Arthur Zuliani
 * @since 20220207
 */
public class Controller {

    public enum Major {
        ACC, CHEM, CIS, ENG, HIS, PHYS
    };

    public static void main(String[] args) {

        String promptMajors = "Major list: ";

        //Individually access each value of Major enum
        for (Major currentMajor : Major.values()) {
            promptMajors += currentMajor.toString() + " ";
        }

        System.out.println(promptMajors);

        boolean isValid = false;
        Major userMajor;

        while (!isValid) {
            String userInput = CisUtility.getInputString("Select a major from list above");

            for (Major currentMajor : Major.values()) {
                if (String.valueOf(currentMajor).compareTo(userInput) == 0) {   //Compare a String input with a String value of current enum Major
                    userMajor = Major.valueOf(userInput);
                    isValid = true;

                    //Check in which divison a Major falls
                    switch (userMajor) {
                        case CIS:
                        case ACC:
                            System.out.println(userMajor.toString() + " falls to Business division");
                            break;
                        case PHYS:
                        case CHEM:
                            System.out.println(userMajor.toString() + " falls to Science division");
                            break;
                        case HIS:
                        case ENG:
                            System.out.println(userMajor.toString() + " falls to Humanities division");
                            break;
                    }

                    break;
                }
            }

            //Print out the error message
            if (!isValid) {
                System.out.println("Invalid input!!!");
            }
        }

    }
}
