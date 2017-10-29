package com.ru.hugb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MainTest {

	@Test
	public void testNewGame() {

		Main main = new Main();

		assertEquals(0, main.newGame("PlayerX", "PlayerO"));
		assertEquals(1, main.newGame("PlayerX", "PlayerO"));
		assertEquals(2, main.newGame("PlayerX", "PlayerO"));
	}

	@Test
	public void testRemoveGame() {

		Main main = new Main();

		assertEquals(0, main.newGame("PlayerX", "PlayerO"));
		assertEquals(1, main.newGame("PlayerX", "PlayerO"));
		assertEquals(2, main.newGame("PlayerX", "PlayerO"));
		assertEquals(3, main.getNumberOfInstances());
		main.quitGame("0");
		main.quitGame("1");
		main.quitGame("2");
		assertEquals(0, main.getNumberOfInstances());
	}

	@Test
	public void testXwin() {

		Main main = new Main();

		assertEquals(0, main.newGame("PlayerX", "PlayerO"));
		assertEquals("X", main.setPositionAt("0", "1"));
		assertEquals("O", main.setPositionAt("0", "2"));
		assertEquals("X", main.setPositionAt("0", "4"));
		assertEquals("O", main.setPositionAt("0", "3"));
		assertEquals("X", main.setPositionAt("0", "7"));
		assertEquals("x", main.checkStatusAt("0"));
		main.quitGame("0");
	}

	@Test
	public void testOwin() {

		Main main = new Main();

		assertEquals(0, main.newGame("PlayerX", "PlayerO"));
		assertEquals("X", main.setPositionAt("0", "2"));
		assertEquals("O", main.setPositionAt("0", "1"));
		assertEquals("X", main.setPositionAt("0", "4"));
		assertEquals("O", main.setPositionAt("0", "5"));
		assertEquals("X", main.setPositionAt("0", "7"));
		assertEquals("O", main.setPositionAt("0", "9"));
		assertEquals("o", main.checkStatusAt("0"));
		main.quitGame("0");
	}

	@Test
	public void testDraw() {

		Main main = new Main();

		assertEquals(0, main.newGame("PlayerX", "PlayerO"));
		assertEquals("X", main.setPositionAt("0", "8"));
		assertEquals("O", main.setPositionAt("0", "4"));
		assertEquals("X", main.setPositionAt("0", "1"));
		assertEquals("O", main.setPositionAt("0", "7"));
		assertEquals("X", main.setPositionAt("0", "5"));
		assertEquals("O", main.setPositionAt("0", "3"));
		assertEquals("X", main.setPositionAt("0", "3"));
		assertEquals("O", main.setPositionAt("0", "9"));
		assertEquals("X", main.setPositionAt("0", "6"));
		assertEquals("draw", main.checkStatusAt("0"));
		main.quitGame("0");
	}	
}