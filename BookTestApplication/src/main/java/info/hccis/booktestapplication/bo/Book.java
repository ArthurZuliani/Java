/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.booktestapplication.bo;

/**
 * This class is responsible to handle the Books information
 * @author zulianideoliveiraa
 * @since 20211012
 */
public class Book {
    
    private String title;
    private int numberOfPages;
    
    public static final int DEFAULT_NUMBER_OF_PAGES = 100;
    
    /**
     * Default constructor that uses a default number of pages
     * @author Arthur Zuliani
     * @since 20211012
     */
    public Book(){
        this.numberOfPages = DEFAULT_NUMBER_OF_PAGES;
    }
    
    /**
     * Constructor that accept a title, but the number of pages will be the default value
     * @author Arthur Zuliani
     * @since 20211012
     * @param title
     */
    public Book(String title){
        this.title = title;
        this.numberOfPages = DEFAULT_NUMBER_OF_PAGES;
    }
    
    /**
     * Constructor that accept a title and the number of pages
     * @author Arthur Zuliani
     * @since 20211012
     * @param title
     * @param numberOfPages
     */
    public Book(String title, int numberOfPages){
        this.numberOfPages = numberOfPages;
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    
    /**
     * Method responsible to print outs the object title and number of pages
     * @author Arthur Zuliani
     * @since 20211012
     */
    public void display(){
        System.out.println(toString());
    }
    
    /**
     * Method responsible to create the output string
     * @author Arthur Zuliani
     * @since 20211012
     * @return String that contains the object information
     */
    @Override
    public String toString(){
        return "Title: " + title + System.lineSeparator() + "Number of pages: " + numberOfPages;
    }
}
//Create a toString() method for this class.