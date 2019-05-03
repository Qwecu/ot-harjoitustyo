package fluffypet.domain;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aubergine
 */
public class ScoreTest {

    @Test
    public void newScore() {
        Score score = new Score("a", 13);
        assertTrue(score.getPlayerName().equals("a") & score.getScore() == 13);
    }

    @Test
    public void compare() {
        Score score1 = new Score("a", 13);
        Score score2 = new Score("a", 14);
        assertTrue(score1.compare(score1, score2) == 1);
    }
    
}
