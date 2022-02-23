package cis.entity;

import cis.util.CisUtility;

/**
 * This class will handle cup information (i.e.: If it is a Winner or not)
 * 
 * @author Arthur
 * @since 20220214
 */
public class Cup {
    
    private int cupNumber;
    private boolean winner;
    private static int currentMax;
    
    public final int WINNIG_NUMBER = 3;
    
    /**
     * Default constructor
     * It will increment cup counter and check if cup is Winner or not
     * 
     * @author Arthur Zuliani
     * @since 20220214
     */
    public Cup() {
        this.cupNumber = ++currentMax;
        
        int randomNumberBetween1And6 = CisUtility.getRandom(6);
        if(randomNumberBetween1And6 == WINNIG_NUMBER) {
            winner = true;
        } else {
            winner = false;
        }
    }

    //Getters and Setters
    public int getCupNumber() {
        return cupNumber;
    }

    public void setCupNumber(int cupNumber) {
        this.cupNumber = cupNumber;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public static int getCurrentMax() {
        return currentMax;
    }

    public static void setCurrentMax(int currentMax) {
        Cup.currentMax = currentMax;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.cupNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cup other = (Cup) obj;
        if (this.cupNumber != other.cupNumber) {
            return false;
        }
        return true;
    }
    
    /**
     * This method displays the output String of the object
     * 
     * @author Arthur Zuliani
     * @since 20220214
     */
    public void display() {
        System.out.println(toString());
    }
    
    /**
     * This method creates the standard output String for the object
     * 
     * @author Arthur Zuliani
     * @since 20220214
     * 
     * @return output String
     */
    @Override
    public String toString() {
        String output = " is";
        
        if(!winner) {
            output += " not";
            
        }
        return "Cup #" + cupNumber + output + " a winner";
    }
}
