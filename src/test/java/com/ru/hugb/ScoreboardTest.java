package com.ru.hugb;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreboardTest {
    Player X = new Player("X");
    Player O = new Player("O");
    @Test
    public void testAddNewPlayer() throws Exception {
        Scoreboard sb = new Scoreboard();
        assertTrue(sb.addNewPlayer(X));
        assertFalse(sb.addNewPlayer(X));
        assertTrue(sb.addNewPlayer(O));
        assertFalse(sb.addNewPlayer(O));
    }

    @Test
    public void testAddResult() throws Exception {
        TicTacToe game = new TicTacToe(X, O);
        Scoreboard sb = new Scoreboard();
        sb.addResult(game);
        assertEquals(1, sb.getNumberOfGamesPlayed());
    }

}
