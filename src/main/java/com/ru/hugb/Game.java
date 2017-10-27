package com.ru.hugb;

import java.util.Scanner;

public class Game {

    public static void launch() {
        Scanner scan = new Scanner(System.in);
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.readFile();
        boolean gameSession = true;
        do {
            boolean exit = false;
            boolean x = true;
            boolean draw = false;
            boolean quittedGame = false;
            System.out.println(scoreboard.toString());
            TicTacToe game = null;

            do {
                System.out.println("Enter name player X:");
                Player playerX = new Player(scan.next());
                System.out.println("Enter name player O");
                Player playerO = new Player(scan.next());
                try {
                    game = new TicTacToe(playerX, playerO);
                } catch (IllegalArgumentException e){
                    System.out.println(e);
                }
            }while (game == null);
            while (!exit) {
                System.out.println(game.toString());
                if (x) {
                    boolean xMove = false;
                    do {
                        System.out.print("Select x pos: ");
                        if (!scan.hasNextInt()) {

                            if (scan.next().equals("q")) {

                                exit = true;
                                quittedGame = true;
                                break;
                            }

                            System.out.println("Enter a valid position!");
                            continue;
                        }
                        int xPos = scan.nextInt();
                        try {
                            xMove = game.setXboardPos(xPos);
                        } catch (Exception e) {
                            System.out.println("Enter a valid position!");
                            continue;
                        }

                        if (!xMove) {
                            System.out.println("Invalid move! Try again!");
                        } else {
                            exit = game.checkStateX();
                            if (!exit) {
                                x = false;
                            }
                        }
                        if (!exit && !game.movesAvailable()) {

                            draw = true;
                            exit = true;
                        }
                    } while (!xMove);
                } else {
                    boolean oMove = false;
                    do {
                        System.out.print("Select O pos: ");
                        if (!scan.hasNextInt()) {

                            if (scan.next().equals("q")) {

                                exit = true;
                                quittedGame = true;
                                break;
                            }

                            System.out.println("Enter a valid position!");
                            continue;
                        }
                        int oPos = scan.nextInt();
                        try {
                            oMove = game.setOboardPos(oPos);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Enter a valid position!");
                            continue;
                        }

                        if (!oMove) {
                            System.out.println("Invalid move! Try again!");
                        } else {
                            exit = game.checkStateO();
                            if (!exit) {
                                x = true;
                            }
                        }
                    } while (!oMove);
                }
            }

            System.out.println(game.toString());
            System.out.println("");

            if (draw || quittedGame) {
                System.out.println("Draw!");
            } else {
                if (x) {

                    System.out.println("Winner is X!");

                } else {

                    System.out.println("Winner is O!");
                }
            }
            scoreboard.addResult(game);
            System.out.println("Current standings: \n" + scoreboard.toString());
            System.out.println("Play another game? Enter y for yes.");
            if (!scan.next().equalsIgnoreCase("y")) {
                gameSession = false;
            }
        } while (gameSession);
        scoreboard.writeFile();
    }

    public static void main(String[] args) {
        Game.launch();
    }
}

