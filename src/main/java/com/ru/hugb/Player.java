package com.ru.hugb;

import java.io.Serializable;

/**
 * Class for handling instances of Player objects
 */
public class Player implements Serializable {

    private String name;
    private int numberOfWins;
    private int numberOfLosses;
    private boolean[][] board;

    public Player(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Player must be given a name!");
        }
        this.name = name.trim();
        board = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = false;
            }
        }
    }

    public boolean[][] getBoard(){
        return board;
    }

    public boolean getBoardPos(int i, int j){
        return board[i][j];
    }

    public void setBoard(int i, int j){
        board[i][j] = true;
    }


    /**
     * @return the number of losses stored in the numberOfLosses variable
     */
    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    /**
     * Increments the numberOfLosses variable by one
     */
    public void addLoss() {
        numberOfLosses++;
    }

    /**
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Increments the numberOfWind variable by one
     */
    public void addWin() {
        numberOfWins++;
    }

    /**
     * @return the number of wins stored in the numberOfWins variable
     */
    public int getNumberOfWins() {
        return numberOfWins;
    }

    /**
     * @return a String
     */
    public String toString() {
        return "Name: " +name + " | Wins: " + numberOfWins + " | Losses: " + numberOfLosses;
    }

    /**
     * Method to compare to Players
     * @param otherPlayer the player object to compare with
     * @return true if the names of the players are the same, false if not. Case insensitive.
     */
    public boolean equals(Object otherPlayer) {
        if (this == otherPlayer) {
            return true;
        }
        if (!(otherPlayer instanceof Player)) {
            return false;
        }
        return (this.getName().equalsIgnoreCase(((Player) otherPlayer).getName()));
    }
}
