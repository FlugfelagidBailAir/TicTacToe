package com.ru.hugb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MainTest {

	@Test
	public void testNewGame() {

		Main main = new Main();

		assertEquals(0, main.newGame());
		assertEquals(1, main.newGame());
		assertEquals(2, main.newGame());
	}

	@Test
	public void testRemoveGame() {

		Main main = new Main();

		assertEquals(0, main.newGame());
		assertEquals(1, main.newGame());
		assertEquals(2, main.newGame());
		assertEquals(3, main.getNumberOfInstances());
		main.quitGame("0");
		main.quitGame("1");
		main.quitGame("2");
		assertEquals(0, main.getNumberOfInstances());
	}
}