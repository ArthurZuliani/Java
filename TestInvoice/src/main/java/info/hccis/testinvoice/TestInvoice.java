package info.hccis.testinvoice;

import info.hccis.testinvoice.bo.Invoice;
/**
 * This is the main class for the Practical exam 2
 * @author zulianideoliveiraa
 * @since 20211012
 */
public class TestInvoice {
    
    public static void main (String args[]){
        
        Invoice invoice1 = new Invoice();
        Invoice invoice2 = new Invoice();
        Invoice invoice3 = new Invoice(3,"Invoice3",10,100);
        
        invoice1.setItemNumber(1);
        invoice1.setItemName("Invoice1");
        invoice1.setItemQuantity(10);
        invoice1.setItemPrice(50);
                
        invoice2.getInformation();
        
        invoice1.display();
        invoice2.display();
        invoice3.display();
    }
}
