package cis.bo;

import cis.bo.base.RoomBase;
import cis.util.CisUtility;

/**
 *
 * @author sryan
 */
public class ComputerLab extends RoomBase {

    private int numberOfComputers;

    public ComputerLab() {

    }

    public ComputerLab(String roomNumber, int numberOfSeats, int numberOfComputers) {
        super(roomNumber, numberOfSeats);
        this.numberOfComputers = numberOfComputers;
    }

    @Override
    public void getInformation() {
        super.getInformation();
        numberOfComputers = CisUtility.getInputInt("Number of computers");
    }

    public int getNumberOfComputers() {
        return numberOfComputers;
    }

    public void setNumberOfComputers(int numberOfComputers) {
        this.numberOfComputers = numberOfComputers;
    }

    @Override
    public void showQuickSummary() {
        System.out.println("room #"+roomNumber+" computers="+numberOfComputers);
    }
    
    public void display() {
        System.out.println(this.toString());
    }

    public String toString() {
        String output = super.toString();
        output += "Number of computers: "+numberOfComputers+"\n";
        return output;

    }

    
    
}
