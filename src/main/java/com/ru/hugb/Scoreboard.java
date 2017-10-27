package com.ru.hugb;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Scoreboard implements Serializable {
    private ArrayList<TicTacToe> gamesPlayed;
    private ArrayList<Player> players;
    String path = new File("src/main/resources/public/players.ser").getAbsolutePath();
    File file = new File(path);

    public Scoreboard() {
        gamesPlayed = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void writeFile(){
            try (FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (Player player:players) {
                    oos.writeObject(player);
                }
            } catch (IOException ignored) {
            }
    }

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

    public int getNumberOfGamesPlayed(){
        return gamesPlayed.size();
    }


    public boolean addNewPlayer(Player player) {
        if (!playerAlreadyRegistered(player)){
            return players.add(player);
        } else {
            return false;
        }
    }

    private boolean playerAlreadyRegistered(Player player) {
        for (Player playerObject : players) {
            if (player.equals(playerObject)) {
                return true;
            }
        }
        return false;
    }


    public void addResult(TicTacToe game) {
        gamesPlayed.add(game);
        addNewPlayer(game.getPlayerO());
        addNewPlayer(game.getPlayerX());
        if (game.getWinner() != null) {
            players.get(players.indexOf(game.getWinner())).addWin();
            players.get(players.indexOf(game.getLoser())).addLoss();
        }
    }

    private void sortPlayers() {
        players.sort(Comparator.comparingInt(Player::getNumberOfWins).reversed());
    }

    public String toString() {
        sortPlayers();
        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            sb.append(player).append("\n");
        }
        return sb.toString();
    }


}
