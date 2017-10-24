package com.ru.hugb;

import java.lang.Exception;
import java.util.Scanner;

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

		return checkStatus(xBoard);
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

		return checkStatus(oBoard);
	}

	private void validateIndex(int i, int j) {

		if (i < 0 || j < 0 || i >= 3 || j >= 3) {

			throw new IndexOutOfBoundsException();
		}
	}

	private boolean checkStatus(boolean[][] board) {

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

		Scanner scan = new Scanner(System.in);
		TicTacToe game = new TicTacToe();
		boolean exit = false;
		boolean x = true;

		while (!exit) {

			System.out.println(game.toString());
			int [] posTuple;

			if (x) {

				System.out.print("Select x pos: ");

				if (!scan.hasNextInt()) {

					System.out.println("Enter a valid position!");
					scan.next();
					continue;
				}

				int xPos = scan.nextInt();

				try {

					posTuple = game.convertPos(xPos);
						
				} catch (Exception e) {

					System.out.println("Enter a valid position!");
					continue;
				}
				
				exit = game.setXboardPos(posTuple[0], posTuple[1]);

				if (!exit) {

					x = false;
				}

			} else {

				System.out.print("Select O pos: ");

				if (!scan.hasNextInt()) {

					System.out.println("Enter a valid position!");
					scan.next();
					continue;
				}
				
				int oPos = scan.nextInt();

				try {

					posTuple = game.convertPos(oPos);
						
				} catch (IndexOutOfBoundsException e) {

					System.out.println("Enter a valid position!");
					continue;
				}
				
				exit = game.setOboardPos(posTuple[0], posTuple[1]);

				if (!exit) {

					x = true;
				}
			}
		}

		System.out.println(game.toString());

		System.out.println("");

		if (x) {

			System.out.println("Winner is X!");

		} else {

			System.out.println("Winner is O!");
		}
		
	}
}
