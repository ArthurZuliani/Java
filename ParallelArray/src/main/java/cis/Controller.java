/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis;

import cis.entity.Course;

/**
 *
 * @author Arthur
 */
public class Controller {

    public static void main(String[] args) {

        Course cis = new Course();
        
        cis.display();
        cis.getInformation();
        cis.findStudent();
    }

}
