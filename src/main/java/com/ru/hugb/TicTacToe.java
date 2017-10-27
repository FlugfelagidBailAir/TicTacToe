package com.ru.hugb;

public class TicTacToe {
    private boolean[][] xBoard;
    private boolean[][] oBoard;
    private int moves;
    private Player playerX;
    private Player playerO;

    public TicTacToe(Player playerX, Player playerO) {
        if (playerX.equals(playerO)) {
            throw new IllegalArgumentException("Players must have different names!");
        }
        xBoard = new boolean[3][3];
        oBoard = new boolean[3][3];
        moves = 0;
        this.playerX = playerX;
        this.playerO = playerO;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                xBoard[i][j] = false;
                oBoard[i][j] = false;
            }
        }
    }

    public Player getPlayerX() {
        return playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }

    //Board getters and setters:

    public boolean[][] getXboard() {

        return xBoard;
    }

    public boolean getXboardPos(int pos) {

        int[] posTuple = convertPos(pos);

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

        int[] posTuple = convertPos(pos);

        return setXboardPos(posTuple[0], posTuple[1]);
    }

    //Put X at position (i,j), returns true if succesful play
    public boolean setXboardPos(int i, int j) {

        return movesAvailable() && executeMove(i, j, xBoard);

    }

    public boolean[][] getOboard() {

        return oBoard;
    }

    public boolean getOboardPos(int pos) {

        int[] posTuple = convertPos(pos);

        return getOboardPos(posTuple[0], posTuple[1]);
    }

    public boolean getOboardPos(int i, int j) {

        validateIndex(i, j);

        return oBoard[i][j];
    }

    //Put O at position 1-9, returns true if succesful play    
    public boolean setOboardPos(int pos) {

        if (!movesAvailable()) {

            return false;
        }

        int[] posTuple = convertPos(pos);

        return setOboardPos(posTuple[0], posTuple[1]);
    }

    //Put O at position (i,j), returns true if successful move
    public boolean setOboardPos(int i, int j) {

        return movesAvailable() && executeMove(i, j, oBoard);

    }

    private boolean executeMove(int i, int j, boolean[][] board) {
        if (validMove(i, j)) {
            board[i][j] = true;
            moves++;
            return true;
        } else {
            return false;
        }
    }

    public boolean movesAvailable() {
        return moves < 9;
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

    private int[] convertPos(int pos) {

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
    private boolean validMove(int i, int j) {
        validateIndex(i, j);
        return !getXboardPos(i, j) && !getOboardPos(i, j);
    }

    public Player getWinner() {
        if (checkStateX()) {
            return playerX;
        } else if (checkStateO()) {
            return playerO;
        } else {
            return null;
        }
    }

    public Player getLoser() {
        if (getWinner().equals(playerX)){
            return playerO;
        }
        if (getWinner().equals(playerO)){
            return playerX;
        }
        else {
            return null;
        }
    }

    /**
     * @return the current board as a string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n### TicTacToe ###\n");
        sb.append("(press q to quit)\n\n");

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
}
