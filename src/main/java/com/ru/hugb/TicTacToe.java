package com.ru.hugb;

public class TicTacToe {

    private Player playerX;
    private Player playerO;
    private int moves;
    private boolean isX;

    public TicTacToe(Player playerX, Player playerO) {
        if (playerX.equals(playerO)) {
            throw new IllegalArgumentException("Players must have different names!");
        }

        this.playerX = playerX;
        this.playerO = playerO;
        moves = 0;
        isX = true;
    }

    public Player getPlayerX() {
        return playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }

    public boolean setBoardPos(int pos, Player player) {
        int[] posTuple = convertPos(pos);
        return setBoardPos(posTuple[0], posTuple[1], player);
    }

    public String setPosition(int pos) {

        int[] posTuple = convertPos(pos);

        if (setBoardPos(posTuple[0], posTuple[1])) {

            if (isX) {

                isX = false;

                return "X";

            } else {

                isX = true;

                return "O";
            }
        }

        return "Failed to set move!";
    }

    private boolean setBoardPos(int i, int j) {

        if (!movesAvailable() && validMove(i, j)) {

            return false;
        }

        if(isX) {

            playerX.setBoard(i, j);
            moves++;
            
            return true;

        } else {

            playerO.setBoard(i, j);
            moves++;            

            return true;
        }
    }

    private boolean setBoardPos(int i, int j, Player player){
        return movesAvailable() && executeMove(i,j, player);
    }

    public boolean getBoardPos(int i, int j, Player player) {
        validateIndex(i,j);
        return player.getBoardPos(i, j);
    }

    public boolean getPosition(int pos) {

        int [] posTuple = convertPos(pos);
        int i = posTuple[0];
        int j = posTuple[1];

        validateIndex(i, j);

        return playerX.getBoardPos(i, j) || playerO.getBoardPos(i, j);
    }

        

    public boolean movesAvailable() {
        return moves < 9;
    }

    public boolean checkState(Player player){
        if (moves < 5) {
            return false;
        }
        return checkWin(player.getBoard());
    }

    private boolean executeMove(int i, int j,Player player) {
        if (validMove(i, j)) {
            player.setBoard(i, j);
            moves++;
            return true;
        } else {
            return false;
        }
    }

    public String checkStatus() {

        if (checkRowsAndColumns(playerX.getBoard()) || checkDiagonal(playerX.getBoard())) {

            return "x";

        } else if (checkRowsAndColumns(playerO.getBoard()) || checkDiagonal(playerO.getBoard())) {

            return "O";

        } else if (movesAvailable() == false) {

            return "draw";

        } else {

            return "";
        }
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
        return checkRowsAndColumns(board) || checkDiagonal(board);

    }

    private boolean checkRowsAndColumns(boolean[][] board){
        for (int i = 0; i < 3; i++) {
            if (board[i][0] && board[i][1] && board[i][2]) {
                return true;
            }
            if (board[0][i] && board[1][i] && board[2][i]) {
                return true;
            }
        }
        return false;
   }

   private boolean checkDiagonal(boolean[][] board){
           if (board[1][1]) {
               if (board[0][0] && board[2][2]) {
                   return true;
               }
               if (board[0][2] && board[2][0]) {
                   return true;
               }
           }
           return false;
   }


    // checks if the move is valid, false at i, j in both X and O boards
    private boolean validMove(int i, int j) {
        validateIndex(i, j);
        return !getBoardPos(i, j, playerX) && !getBoardPos(i, j, playerO);
    }

    public Player getWinner() {
        if (checkState(playerX)) {
            return playerX;
        } else if (checkState(playerO)) {
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

                if (getBoardPos(i, j, playerX)) {

                    sb.append("X").append(' ');

                } else if (getBoardPos(i, j, playerO)) {

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
