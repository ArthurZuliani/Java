package info.hccis.starting.bo;

import info.hccis.util.CisUtility;
/**
 * This class is responsible for Counting by any number
 * 
 * @author Arthur Zuliani
 * @since 2021-11-16
 */
public class Counter {
    
    private int counterValue = 0;
    private int userNumber = 0;
    private int indexValue = 0;
    
    /**
     * Default constructor
     * 
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public Counter(){
        
    }
    
    /**
     * This method gets user`s number
     * 
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public void getInformation(){
        userNumber = CisUtility.getInputInt("Enter a number to count by: ");
        counterValue = userNumber;
    }
    
    /**
     * This method is responsible to count by five
     * 
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public void countFromFive (){
        
        while(counterValue >= 5 && counterValue < 200){
            counterValue += 5;
            display();
            
            if(counterValue % 50 == 0){
                System.out.println("");
            }
        }
    }
    
    /**
     * This method is responsible to count by user`s number
     * 
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public void countByAnyNumber(){
        
        while(counterValue > 0 && counterValue <= 200){
            display();
            indexValue++;
            counterValue += userNumber;
            
            if(indexValue > 9){
                System.out.println("");
                indexValue = 0;
            }
        }
    }
    
    /**
     * This method is responsible to show off the count result
     * 
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public void display(){
        System.out.print(toString());
    }

    /**
     * This method is construct the output string
     * 
     * @author Arthur Zuliani
     * @since 2021-11-16
     * @return the output string for the object
     */
    @Override
    public String toString(){
        return counterValue + " ";
    }
}
