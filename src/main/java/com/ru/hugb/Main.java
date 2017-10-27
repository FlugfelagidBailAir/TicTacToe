package com.ru.hugb;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.QueryParamsMap;

public class Main {
    public static void main(String[] args) {

    	TicTacToe game = new TicTacToe();

    	staticFileLocation("/public");

        put("/:pos", (req, res) -> {

            String turn = game.setPosition(req.params("pos"));

			return turn;
        });

        get("/get/:pos", (req, res) -> { 

        	return game.getPosition(req.params("pos")); 
        });

        get("/check/", (req, res) -> { 

        	return game.checkStatus(); 
        });
	}
}
