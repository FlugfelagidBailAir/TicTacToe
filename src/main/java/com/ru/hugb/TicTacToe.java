package com.ru.hugb;

public class TicTacToe {
	private char[][] board;

	public TicTacToe(){
		board = new char[3][3];
	}

	/**
	 * Populates the board with the characters in this pattern
	 * 1 2 3
	 * 4 5 6
	 * 7 8 9
	 */
	private void populateBoard(){
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j <= 3; j++) {
				board[i][j -1] = Character.forDigit(i *3 + j,10);
			}
		}
	}

	/**
	 *
	 */
	public void createNewGame(){
		populateBoard();
	}

	/**
	 *
	 * @return the current board as a string
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (char[] arr : board) {
			for (char s : arr) {
				sb.append(String.valueOf(s)).append(' ');
			}
			sb.append('\n');
		}
		return sb.toString();
	}

	public static void main(String[] args){
		TicTacToe game1 = new TicTacToe();
		game1.createNewGame();
		System.out.println(game1);

	}
}
