package com.ru.hugb;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class to keep instances of TicTacToe games and players
 */
public class Scoreboard implements Serializable {
    private ArrayList<TicTacToe> gamesPlayed;
    private ArrayList<Player> players;
    String path = new File("src/main/resources/public/players.ser").getAbsolutePath();
    File file = new File(path);

    public Scoreboard() {
        gamesPlayed = new ArrayList<>();
        players = new ArrayList<>();
    }

    /**
     * Writes the contents of the Arraylist players to players.ser
     */
    public void writeFile(){
            try (FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (Player player:players) {
                    oos.writeObject(player);
                }
            } catch (IOException ignored) {
            }
    }

    /**
     * Reads the information stored in players.ser into the Arraylist players
     */
    public void readFile() {
        try(FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            Player player;
            while((player = (Player) ois.readObject()) != null){
                players.add(player);
            }
        } catch (IOException | ClassNotFoundException ignored) {
        }
    }

    /**
     * Method to get the current number of players stored
     * @return the size of the players ArrayList
     */
    public int getNumberOfGamesPlayed(){
        return gamesPlayed.size();
    }

    /**
     * Method to add a new player to the scoreboard
     * @param player the player that should be added
     * @return true if the add is successful, false if it fails
     */
    public boolean addNewPlayer(Player player) {
        if (!playerAlreadyRegistered(player)){
            return players.add(player);
        } else {
            return false;
        }
    }

    /**
     * Method to check if a player is already stored in the ArrayList players
     * @apiNote two players are considered equal if they have the same name
     * @param player the player to to the check on
     * @return true if there is an equal Player in the ArrayList players
     */
    private boolean playerAlreadyRegistered(Player player) {
        for (Player playerObject : players) {
            if (player.equals(playerObject)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds the results of a given game to the Scoreboard
     * Increments the win or loss variable for the players when applicable
     * @param game an instance of TicTacToe
     */
    public void addResult(TicTacToe game) {
        gamesPlayed.add(game);
        addNewPlayer(game.getPlayerO());
        addNewPlayer(game.getPlayerX());
        if (game.getWinner() != null) {
            players.get(players.indexOf(game.getWinner())).addWin();
            players.get(players.indexOf(game.getLoser())).addLoss();
        }
    }

    /**
     * Sorts the players in the ArrayList players by the number of wins they have in decreasing order
     */
    private void sortPlayers() {
        players.sort(Comparator.comparingInt(Player::getNumberOfWins).reversed());
    }

    /**
     * Prints all the players according to the sortPlayers() method
     * @return a String
     */
    public String toString() {
        sortPlayers();
        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            sb.append(player).append("\n");
        }
        return sb.toString();
    }


}
