package com.ru.hugb;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import spark.Route;

public class Main {
    public static void main(String[] args) {

    	TicTacToe game = new TicTacToe();

    	staticFileLocation("/public");

        get("/:pos", (req, res) -> game.setXboardPos(Integer.parseInt(":pos")));

	}
}