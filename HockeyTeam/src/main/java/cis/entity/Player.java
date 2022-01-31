/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis.entity;

import cis.util.CisUtility;

/**
 *
 * @author Arthur
 */
public class Player {

    public static final int NUMBER_OF_GAMES = 3;
    private int playerNumber = 0;
    private int[] goalsNumber = new int[NUMBER_OF_GAMES];

    /**
     * Default constructor
     *
     * @author Arthur Zuliani
     * @since 20220125
     */
    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    //Setters and getters
    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int[] getGoalsNumber() {
        return goalsNumber;
    }

    public void setGoalsNumber(int[] goalsNumber) {
        this.goalsNumber = goalsNumber;
    }

    public void setGoalsNumber(int gameNumber) {
        this.goalsNumber[gameNumber]++;
    }

    /**
     * Display object output string
     *
     * @author Arthur Zuliani
     * @since 20220125
     */
    public void display() {
        System.out.println(toString());
    }

    /**
     * Construct the default output string
     * 
     * @author Arthur Zuliani
     * @since 20220125
     * @return output string
     */
    @Override
    public String toString() {
        
        //enhance the toString to say "No goals" if the player didn't score any goals
        
        //Control variable to check scored goals
        boolean playerScored = false;
        
        String outputString = "Player #" + playerNumber;
                
        //Player 1
        //goalsNumber[0] = 10 goals;
        //goalsNumber[1] = 5 goals;
        //goalsNumber[2] = 2 goals;
        
        
        
        
        for (int j = 0; j < NUMBER_OF_GAMES; j++) {
            if (this.goalsNumber[j] > 0) {
                playerScored = true;
                outputString += System.lineSeparator() + "Game #" + (j+1) + ": " + this.goalsNumber[j] + " goals";
            }
        }
        
        //Check if the player scored any goal
        if(!playerScored) {
            outputString += " has scored no goals";
        }
        
        return outputString;
    }

}
