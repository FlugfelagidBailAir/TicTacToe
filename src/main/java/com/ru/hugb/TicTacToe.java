package com.ru.hugb;

import java.lang.Exception;
import java.util.Scanner;

public class TicTacToe {
    private boolean[][] xBoard;
    private boolean[][] oBoard;
    private int moves;

    public TicTacToe() {

        xBoard = new boolean[3][3];
        oBoard = new boolean[3][3];
        moves = 0;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                xBoard[i][j] = false;
                oBoard[i][j] = false;
            }
        }
    }

    //Board getters and setters:

    public boolean[][] getXboard() {

        return xBoard;
    }

    public boolean getXboardPos(int pos) {

    	int [] posTuple = convertPos(pos);

    	return getXboardPos(posTuple[0], posTuple[1]);
    }

    public boolean getXboardPos(int i, int j) {

        validateIndex(i, j);

        return xBoard[i][j];
    }

	//Put X at position 1-9, returns true if succesful play    
    public boolean setXboardPos(int pos) {

    	if (moves >= 9) {

    		return false;
    	}

    	int [] posTuple = convertPos(pos);

    	return setXboardPos(posTuple[0], posTuple[1]);
    }

    //Put X at position (i,j), returns true if succesful play
    public boolean setXboardPos(int i, int j) {

    	if (moves >= 9) {

    		return false;
    	}

        if (validMove(i,j)) {
            xBoard[i][j] = true;
            moves++;
            return true;
        } else {
            return false;
        }
    }

    public boolean[][] getOboard() {

        return oBoard;
    }

    public boolean getOboardPos(int pos) {

    	int [] posTuple = convertPos(pos);

    	return getOboardPos(posTuple[0], posTuple[1]);
    }

    public boolean getOboardPos(int i, int j) {

        validateIndex(i, j);

        return oBoard[i][j];
    }

    //Put O at position 1-9, returns true if succesful play    
    public boolean setOboardPos(int pos) {

    	if (moves >= 9) {

    		return false;
    	}

    	int [] posTuple = convertPos(pos);

    	return setOboardPos(posTuple[0], posTuple[1]);
    }

    //Put O at position (i,j), returns true if successful move
    public boolean setOboardPos(int i, int j) {

    	if (moves >= 9) {

    		return false;
    	}
    	
        if (validMove(i, j)) {
            oBoard[i][j] = true;
            moves++;
            return true;
        } else {
            return false;
        }
    }

    // checks if X has won
    public boolean checkStateX() {

    	if (moves < 5) {

    		return false;
    	}

        return checkWin(xBoard);
    }

    // checks if O has won
    public boolean checkStateO() {

    	if (moves < 5) {

    		return false;
    	}

        return checkWin(oBoard);
    }

    public int numberOfMoves() {

    	return moves;
    }

    public int[] convertPos(int pos) {

        int i;
        int j;

        if (pos >= 1 && pos <= 3) {

            i = 0;
            j = pos - 1;

        } else if (pos >= 4 && pos <= 6) {

            i = 1;
            j = pos - 4;

        } else if (pos >= 7 && pos <= 9) {

            i = 2;
            j = pos - 7;

        } else {

            throw new IndexOutOfBoundsException();
        }

        return new int[]{i, j};
    }

    private void validateIndex(int i, int j) {

        if (i < 0 || j < 0 || i >= 3 || j >= 3) {

            throw new IndexOutOfBoundsException();
        }
    }

    private boolean checkWin(boolean[][] board) {

        //Check vertical and horizontal
        for (int i = 0; i < 3; i++) {

            if (board[i][0] && board[i][1] && board[i][2]) {

                return true;

            } else if (board[0][i] && board[1][i] && board[2][i]) {

                return true;
            }
        }

        //Check across
        if (board[1][1]) {

            if (board[0][0] && board[2][2]) {

                return true;

            } else if (board[0][2] && board[2][0]) {

                return true;
            }
        }

        return false;
    }

    // checks if the move is valid, false at i, j in both X and O boards
    private boolean validMove(int i, int j){
        validateIndex(i, j);
        return !getXboardPos(i,j) && !getOboardPos(i, j);
    }

    /**
     * @return the current board as a string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (getXboardPos(i, j)) {

                    sb.append("X").append(' ');

                } else if (getOboardPos(i, j)) {

                    sb.append("O").append(' ');

                } else {

                    sb.append(String.valueOf((i * 3) + (j + 1))).append(' ');
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        boolean exit = false;
        boolean x = true;
        boolean draw = false;

        while (!exit) {
            System.out.println(game.toString());
            if (x) {
                boolean xMove = false;
                do {
                    System.out.print("Select x pos: ");
                    if (!scan.hasNextInt()) {
                        System.out.println("Enter a valid position!");
                        scan.next();
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
                    if (!exit && game.numberOfMoves() >= 9){

                    	draw = true;
                        exit = true;
                    }
                } while (!xMove);
            } else {
                boolean oMove = false;
                do {
                    System.out.print("Select O pos: ");
                    if (!scan.hasNextInt()) {
                        System.out.println("Enter a valid position!");
                        scan.next();
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

        if (draw){
            System.out.println("Draw!");
        }else {
            if (x) {

                System.out.println("Winner is X!");

            } else {

                System.out.println("Winner is O!");
            }
        }
    }
}
