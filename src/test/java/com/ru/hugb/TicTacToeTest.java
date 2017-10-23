package com.ru.hugb;

import static org.junit.Assert.assertEquals;
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

				game.setXboardPos(i, j);
				game.setOboardPos(i, j);

				assertEquals(true, game.getXboardPos(i, j));
				assertEquals(false, game.getOboardPos(i, j));
			}
		}
	}

	@Test
	public void testOgettersAndSetters() {

		TicTacToe game = new TicTacToe();

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				game.setOboardPos(i, j);
				game.setXboardPos(i, j);

				assertEquals(true, game.getOboardPos(i, j));
				assertEquals(false, game.getXboardPos(i, j));
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

		assertEquals(false, game.setOboardPos(0, 0));
		assertEquals(false, game.setOboardPos(0, 1));
		assertEquals(true, game.setOboardPos(0, 2));
	}

	@Test
	public void testWinningMoveAcrossX() {

		TicTacToe game = new TicTacToe();

		assertEquals(false, game.setXboardPos(0, 0));
		assertEquals(false, game.setXboardPos(1, 1));
		assertEquals(true, game.setXboardPos(2, 2));
	}

	@Test
	public void testWinningMoveHorizontalO() {

		TicTacToe game = new TicTacToe();

		assertEquals(false, game.setOboardPos(0, 2));
		assertEquals(false, game.setOboardPos(1, 2));
		assertEquals(true, game.setOboardPos(2, 2));
	}
}
