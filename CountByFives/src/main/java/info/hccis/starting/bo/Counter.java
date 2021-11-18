package info.hccis.starting.bo;

/**
 * This class is responsible for
 *
 * @author Arthur Zuliani
 * @since 2021-11-16
 */
public class Counter {

    private int counterValue = 0;

    /**
     * Default constructor
     * 
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public Counter() {
        this.counterValue = 5;
    }

    /**
     * This method is responsible to count by five
     * 
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public void countFromFive() {

        while (counterValue >= 5 && counterValue < 200) {
            counterValue += 5;
            display();

            if (counterValue % 50 == 0) {
                System.out.println("");
            }
        }
    }

    /**
     * This method is responsible to show off the count result
     * 
     * @author Arthur Zuliani
     * @since 2021-11-16
     */
    public void display() {
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
    public String toString() {
        return counterValue + " ";
    }
}
