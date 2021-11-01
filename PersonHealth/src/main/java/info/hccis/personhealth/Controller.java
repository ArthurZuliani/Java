package info.hccis.personhealth;

import info.hccis.personhealth.bo.PersonHealth;
/**
 * Class Oct 26, Personal Health exercise
 *
 * @author Arthur Zuliani
 * @since 20211026
 */
public class Controller {
    
    public static void main(String[] args) {
        
        PersonHealth person1 = new PersonHealth();
        PersonHealth person2 = new PersonHealth(1,2,3);
        
        person1.getInformation();
        person1.display();
        
        person2.display();
        
    }
    
}
