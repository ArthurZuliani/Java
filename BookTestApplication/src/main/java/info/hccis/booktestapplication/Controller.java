/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.booktestapplication;
import info.hccis.booktestapplication.bo.Book;

/**
 * Exercise for understand overload constructor, setters and getters
 * @author zulianideoliveiraa
 * @since 20211012
 */
public class Controller {
    
    public static void main(String[] args) {
        Book newBook1 = new Book();
        newBook1.setTitle("Star Wars");
        newBook1.setNumberOfPages(250);
        newBook1.display();
        
        Book newBook2 = new Book("Star Trek",500);
        newBook2.display();
    }
}