/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.scholarship;

import info.hccis.scholarship.bo.Student;
/**
 * Class Oct 26, Scholarship exercise
 *
 * @author Arthur Zuliani
 * @since 20211026
 */
public class Controller {

    public static void main(String[] args) {
        
        Student student1 = new Student();
        
        student1.getInformation();
        student1.display();
        
        Student student2 = new Student(5,0,0);
        student2.display();
    }
    
}
