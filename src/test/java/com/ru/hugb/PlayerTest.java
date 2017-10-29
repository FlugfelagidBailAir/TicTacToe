package com.ru.hugb;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player X = new Player("X");
    Player O = new Player("O");


    @Test
    public void testAddLossAndGetLosses() throws Exception {
        assertEquals(0, X.getNumberOfLosses());
        X.addLoss();
        assertEquals(1, X.getNumberOfLosses());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("X", X.getName());
    }

    @Test
    public void testAddWinAndGetWins() throws Exception {
        assertEquals(0, X.getNumberOfWins());
        X.addWin();
        assertEquals(1, X.getNumberOfWins());
    }

    @Test
    public void equals() throws Exception {
        assertFalse(X.equals(O));
        assertTrue(X.equals(X));
    }

}
