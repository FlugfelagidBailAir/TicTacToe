package com.ru.hugb;

import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private int numberOfWins;
    private int numberOfLosses;

    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    public void addLoss() {
        numberOfLosses++;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addWin() {
        numberOfWins++;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public String toString() {
        return "Name: " +name + " | Wins: " + numberOfWins + " | Losses: " + numberOfLosses;
    }

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
