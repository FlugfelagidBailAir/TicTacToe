package com.ru.hugb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TicTacToeTest {

	@Test
	public void testInitialBoard() {

		TicTacToe game = new TicTacToe();

		boolean comp[][] = new boolean[3][3];
		
		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				comp[i][j] = false;
			}
		}

		assertEquals(comp, game.getXboard());
		assertEquals(comp, game.getOboard());
	}

	@Test
	public void testXgettersAndSetters() {

		TicTacToe game = new TicTacToe();

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				assertTrue(game.setXboardPos(i, j));
				assertFalse(game.setOboardPos(i, j));

				assertTrue(game.getXboardPos(i, j));
				assertFalse(game.getOboardPos(i, j));
			}
		}
	}

	@Test
	public void testOgettersAndSetters() {

		TicTacToe game = new TicTacToe();

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				assertTrue(game.setOboardPos(i, j));
				assertFalse(game.setXboardPos(i, j));

				assertTrue(game.getOboardPos(i, j));
				assertFalse(game.getXboardPos(i, j));
			}
		}
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void testInvalidIndex() {

		TicTacToe game = new TicTacToe();

		game.getXboardPos(-1, 3);
	}

	@Test
	public void testWinningMoveVerticalO() {
		TicTacToe game = new TicTacToe();
		assertTrue(game.setOboardPos(1));
		assertTrue(game.setXboardPos(4));
		assertTrue(game.setOboardPos(2));
		assertFalse(game.checkStateO());
		assertTrue(game.setXboardPos(6));
		assertTrue(game.setOboardPos(3));
		assertTrue( game.checkStateO());

	}

	@Test
	public void testWinningMoveAcrossX() {

		TicTacToe game = new TicTacToe();

		assertTrue(game.setXboardPos(1));
		assertFalse(game.checkStateX());
		assertTrue(game.setOboardPos(4));
		assertTrue(game.setXboardPos(5));
		assertTrue(game.setOboardPos(6));
		assertTrue(game.setXboardPos(9));
		assertTrue(game.checkStateX());
	}

	@Test
	public void testWinningMoveHorizontalO() {

		TicTacToe game = new TicTacToe();

		assertTrue(game.setOboardPos(3));
		assertTrue(game.setXboardPos(2));
		assertTrue(game.setOboardPos(6));
		assertFalse(game.checkStateO());
		assertTrue(game.setOboardPos(1));
		assertTrue(game.setOboardPos(9));
		assertTrue(game.checkStateO());
	}

	@Test
	public void testDraw() {

		TicTacToe game = new TicTacToe();

		assertTrue(game.setXboardPos(2));
		assertTrue(game.setOboardPos(1));
		assertTrue(game.setXboardPos(5));
		assertTrue(game.setOboardPos(4));
		assertTrue(game.setXboardPos(6));
		assertTrue(game.setOboardPos(3));
		assertTrue(game.setXboardPos(9));
		assertTrue(game.setOboardPos(8));
		assertTrue(game.setXboardPos(7));
		assertFalse(game.movesAvailable());
		assertFalse(game.checkStateO());
		assertFalse(game.checkStateX());
	}
}
