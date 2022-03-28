package cis.bo;

import cis.bo.base.RoomBase;
import cis.util.CisUtility;

/**
 *
 * @author group 3
 * @since 17-03-21
 */
public class BoardRoom extends RoomBase {

    protected boolean coffeeMakerEnabled;

    public BoardRoom() {

    }

    public BoardRoom(String roomNumber, int numberOfSeats, boolean coffeeMakerEnabled) {
        super(roomNumber, numberOfSeats);
        this.coffeeMakerEnabled = coffeeMakerEnabled;
    }

    @Override
    public void getInformation() {
        super.getInformation();
        this.coffeeMakerEnabled = CisUtility.getInputString("Coffee maker enabled? (y/n)").equalsIgnoreCase("y");
    }

    public boolean isCoffeeMakerEnabled() {
        return coffeeMakerEnabled;
    }

    public void setCoffeeMakerEnabled(boolean coffeeMakerEnabled) {
        this.coffeeMakerEnabled = coffeeMakerEnabled;
    }

    @Override
    public String toString() {
        String output = super.toString() + coffeeMakerEnabled + "\n";
        return output;
    }

    @Override
    public void showQuickSummary() {
        System.out.println("room #"+roomNumber+" coffee?"+isCoffeeMakerEnabled());
    }

    
    
}
