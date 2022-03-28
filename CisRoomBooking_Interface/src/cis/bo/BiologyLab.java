package cis.bo;

import cis.bo.base.Reservable;
import cis.bo.base.RoomBase;
import cis.util.CisUtility;

/**
 *
 * @author panch
 */
public class BiologyLab extends RoomBase  {

    protected int numberOfFlasks;

    public BiologyLab() {

    }

    public BiologyLab(String roomNumber, int numberOfSeats, int numberOfFlasks) {
        super(roomNumber,  numberOfSeats);
        this.numberOfFlasks = numberOfFlasks;
    }

    public int getNumberOfFlasks() {
        return numberOfFlasks;
    }

    public void setNumberOfFlasks(int numberOfFlasks) {
        this.numberOfFlasks = numberOfFlasks;
    }


    @Override
    public void showQuickSummary() {
        System.out.println("room #"+roomNumber+" flasks="+numberOfFlasks);
    }
    
    
    @Override
    public void getInformation() {
        super.getInformation();
        numberOfFlasks = CisUtility.getInputInt("Number of flasks");
    }

    public String toString() {
        String output = super.toString();
        output += "Number of flasks: " + numberOfFlasks + "\n";
        return output;
    }

    @Override
    public void reserve() {
        
    }

    @Override
    public void release() {
        
    }

}
