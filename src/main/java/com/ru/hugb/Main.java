package com.ru.hugb;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.Deque;
import java.util.ArrayDeque;
import org.json.JSONArray;
import org.json.JSONObject;

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

	//Retrive Heroku port
    static int getHerokuAssignedPort() {

        ProcessBuilder processBuilder = new ProcessBuilder();

        if (processBuilder.environment().get("PORT") != null) {

            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }

        return 4567;
    }

	public int newGame(String playerX, String playerO) {

		if (availableIds.isEmpty()) {

			resize();
		}

		int id = availableIds.remove();
		Player O = new Player(playerO);
		Player X = new Player(playerX);
		games[id] = new TicTacToe(X, O);
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

        String turn = games[Integer.parseInt(id)].setPosition(Integer.parseInt(pos));

		return turn;
	}

	public boolean getPositionAt(String id, String pos) {

    	return games[Integer.parseInt(id)].getPosition(Integer.parseInt(pos)); 		
	}

	public String checkStatusAt(String id) {

        return games[Integer.parseInt(id)].checkStatus(); 
	}

	public void resize() {

		TicTacToe [] newGames = new TicTacToe[this.games.length * 2];

		for (int i = 0; i < this.games.length; i++) {

			newGames[i] = games[i];
		}

		for (int i = this.games.length; i < newGames.length; i++) {

			availableIds.add(i);
		}
	}

    public static void main(String[] args) {

    	Main gameServer = new Main();
    	staticFileLocation("/public");
    	port(getHerokuAssignedPort());

    	post("/start/:playerOne/:playerTwo", (req, res) -> {

    		String playerOne = req.params("playerOne");
    		String playerTwo = req.params("playerTwo");

    		return gameServer.newGame(playerOne, playerTwo);
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
