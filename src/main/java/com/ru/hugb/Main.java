package com.ru.hugb;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import spark.Route;

public class Main {
    public static void main(String[] args) {
		Player O = new Player("temp");
		Player X = new Player("temp2");
    	TicTacToe game = new TicTacToe(X, O);

    	staticFileLocation("/public");

        get("/:pos", (req, res) -> game.setXboardPos(Integer.parseInt(":pos")));

	}
}
