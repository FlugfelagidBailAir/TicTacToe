package com.ru.hugb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TicTacToeTest {
	Player X = new Player("X");
	Player O = new Player("O");
	@Test
	public void testInitialBoard() {

		TicTacToe game = new TicTacToe(X, O);
		boolean comp[][] = new boolean[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				comp[i][j] = false;
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				assertTrue(comp[i][j] == game.getBoardPos(i,j, O) && comp[i][j] == game.getBoardPos(i,j, O));
				assertTrue(comp[i][j] == game.getBoardPos(i,j, X) && comp[i][j] == game.getBoardPos(i,j, X));
			}
		}
	}

	@Test
	public void testGettersAndSetters() {

		TicTacToe game = new TicTacToe(X, O);

		for (int i = 0; i < 3; i++) {

			for (int j = 1; j <= 3; j++) {

				assertTrue(game.setBoardPos((i*3) + j, O));
				assertFalse(game.setBoardPos((i*3) + j, X));

				assertTrue(game.getBoardPos(i, j - 1, O));
				assertFalse(game.getBoardPos(i, j - 1, X));
			}
		}
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void testInvalidIndex() {

		TicTacToe game = new TicTacToe(X, O);

		game.getBoardPos(-1, 3, X);
	}

	@Test
	public void testWinningMoveVerticalO() {
		TicTacToe game = new TicTacToe(X, O);
		assertTrue(game.setBoardPos(1, O));
		assertTrue(game.setBoardPos(4, X));
		assertTrue(game.setBoardPos(2, O));
		assertFalse(game.checkState(O));
		assertTrue(game.setBoardPos(6, X));
		assertTrue(game.setBoardPos(3, O));
		assertTrue( game.checkState(O));

	}

	@Test
	public void testWinningMoveAcrossX() {

		TicTacToe game = new TicTacToe(X, O);

		assertTrue(game.setBoardPos(1, X));
		assertFalse(game.checkState(X));
		assertTrue(game.setBoardPos(4, O));
		assertTrue(game.setBoardPos(5, X));
		assertTrue(game.setBoardPos(6, O));
		assertTrue(game.setBoardPos(9, X));
		assertTrue(game.checkState(X));
	}

	@Test
	public void testWinningMoveHorizontalO() {

		TicTacToe game = new TicTacToe(X, O);

		assertTrue(game.setBoardPos(3, O));
		assertTrue(game.setBoardPos(2, X));
		assertTrue(game.setBoardPos(6, O));
		assertFalse(game.checkState(X));
		assertTrue(game.setBoardPos(1, X));
		assertTrue(game.setBoardPos(9, O));
		assertTrue(game.checkState(O));
	}

	@Test
	public void testDraw() {

		TicTacToe game = new TicTacToe(X, O);

		assertTrue(game.setBoardPos(2, X));
		assertTrue(game.setBoardPos(1, O));
		assertTrue(game.setBoardPos(5, X));
		assertTrue(game.setBoardPos(4, O));
		assertTrue(game.setBoardPos(6, X));
		assertTrue(game.setBoardPos(3, O));
		assertTrue(game.setBoardPos(9, X));
		assertTrue(game.setBoardPos(8, O));
		assertTrue(game.setBoardPos(7, X));
		assertFalse(game.checkState(O));
		assertFalse(game.checkState(X));
	}

	@Test
	public void testGetWinner(){
		TicTacToe game = new TicTacToe(X, O);
		game.setBoardPos(1, X);
		game.setBoardPos(2, O);
		game.setBoardPos(5, X);
		game.setBoardPos(6, O);
		game.setBoardPos(9, X);
		assertEquals(game.getWinner(), X);
	}

	@Test
	public void testGetLoser(){
		TicTacToe game = new TicTacToe(X, O);
		game.setBoardPos(1, X);
		game.setBoardPos(2, O);
		game.setBoardPos(5, X);
		game.setBoardPos(6, O);
		game.setBoardPos(9, X);
		assertEquals(game.getLoser(), O);
	}
}
