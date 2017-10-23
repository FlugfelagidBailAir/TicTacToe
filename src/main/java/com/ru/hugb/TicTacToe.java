package com.ru.hugb;

import java.lang.Exception;

public class TicTacToe {
	private boolean[][] xBoard;
	private boolean[][] oBoard;

	public TicTacToe(){

		xBoard = new boolean[3][3];
		oBoard = new boolean[3][3];

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

	public boolean getXboardPos(int i, int j) {

		validateIndex(i, j);

		return xBoard[i][j];
	}

	//Put X at position (i,j), returns true if winning move
	public boolean setXboardPos(int i, int j) {

		validateIndex(i, j);

		if (!getOboardPos(i, j)) {

			xBoard[i][j] = true;
		}

		return checkStatus('x');
	}

	public boolean[][] getOboard() {

		return oBoard;
	}

	public boolean getOboardPos(int i, int j) {

		validateIndex(i, j);

		return oBoard[i][j];
	}

	//Put O at position (i,j), returns true if winning move
	public boolean setOboardPos(int i, int j) {

		validateIndex(i, j);

		if (!getXboardPos(i, j)) {

			oBoard[i][j] = true;
		}

		return checkStatus('o');
	}

	private void validateIndex(int i, int j) {

		if (i < 0 || j < 0 || i >= 3 || j >= 3) {

			throw new IndexOutOfBoundsException();
		}
	}

	private boolean checkStatus(char xo) {

		if(xo == 'o') {

			//do something

		} else if (xo == 'x') {

			//do something else
		}

		return false;
	}

	/**
	 *
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

	public static void main(String[] args){

		TicTacToe game = new TicTacToe();

		System.out.println(game.toString());
	}
}
