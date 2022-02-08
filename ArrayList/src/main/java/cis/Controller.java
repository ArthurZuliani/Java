package cis;

import cis.util.CisUtility;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * First practice with Array List
 * 
 * @author Arthur Zuliani
 * @since 20220208
 */
public class Controller {
        
    
    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList();
        ArrayList<String> tests = new ArrayList();
        
        tests.add("1");
        
        students.add("Arthur");
        students.add("Abdul");
        students.add("Cody");
        students.add("Qi");
        students.add("Miles");
        students.add("Gulang");
        
        //Adding item based in index position
        int index = students.indexOf("Cody") + 1;
        students.add(index, "New Student");
        
        System.out.println(students);
        
        //students AL is now pointing to same memory location as tests AL
        //If one of them is edited, both will retrieve the new value
        //Uncommented to test it
        //students = tests;
        
        //To avoid the problem shown above, is possible to use the method .addAll()
        //Uncommented to test it
        //students.addAll(tests);
        
        //This clone tests AL to students AL, but is necessary to TypeCast since .clone() returns an AL instance
        students = (ArrayList<String>) tests.clone();
        
        System.out.println(students);
    }
    
}
