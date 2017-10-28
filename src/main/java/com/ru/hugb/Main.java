package com.ru.hugb;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {

	private TicTacToe [] games;
	private Deque<Integer> availableIds;
	private int numberOfInstances;

	public Main() {

		games = new TicTacToe[100];
		availableIds = new ArrayDeque<Integer>();
		numberOfInstances = 0;

    	for (int i = 0; i < games.length; i++) {

    		availableIds.add(i);
    	}
	}

	public int newGame() {

		if (availableIds.isEmpty()) {

			resize();
		}

		int id = availableIds.remove();
		games[id] = new TicTacToe();
		numberOfInstances++;

		return id;	
	}

	public void quitGame(String id) {

		int Id = Integer.parseInt(id);

		games[Id] = null;
		availableIds.add(Id);
		numberOfInstances--;
	}

	public int getNumberOfInstances() {

		return numberOfInstances;
	}

	public String setPositionAt(String id, String pos) {

        String turn = games[Integer.parseInt(id)].setPosition(pos);

		return turn;
	}

	public boolean getPositionAt(String id, String pos) {

    	return games[Integer.parseInt(id)].getPosition(pos); 		
	}

	public String checkStatusAt(String id) {

        return games[Integer.parseInt(id)].checkStatus(); 
	}

	public void resize() {

		TicTacToe [] newGames = new TicTacToe[this.games.length * 2];

		for (int i = 0; i < this.games.length; i++) {

			newGames[i] = games[i];
		}

		for (int i = this.games.length - 1; i < newGames.length; i++) {

			availableIds.add(i);
		}
	}

    public static void main(String[] args) {

    	Main gameServer = new Main();

    	staticFileLocation("/public");

    	put("/start/", (req, res) -> {

    		return gameServer.newGame();
    	});

    	put("/stop/:id", (req, res) -> {

    		gameServer.quitGame(req.params("id"));

    		return "";
    	});

        put("/id/:id/pos/:pos", (req, res) -> {

			return gameServer.setPositionAt(req.params("id"), req.params("pos"));
        });

        get("/id/:id/get/:pos", (req, res) -> { 

        	return gameServer.getPositionAt(req.params("id"), req.params("pos")); 
        });

        get("/check/:id", (req, res) -> {

        	return gameServer.checkStatusAt(req.params("id")); 
        });
	}
}
