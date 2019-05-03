package fluffypet.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import fluffypet.domain.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aubergine
 */
public class FluffyPetTest {

    public FluffyPetTest() {
    }

    @Test
    public void carePlanHasValues() throws Exception {
        CarePlan cp = new CarePlan(new String[]{"test"});
        assertTrue(cp.getStatIncreases() != null && !cp.getStatIncreases().isEmpty());
    }

    @Test
    public void initialize() throws Exception {
        FluffyGame game = new FluffyGame();
        assertTrue(game.planCount() > 0);
    }

    @Test
    public void statsInfoTest() throws Exception {
        FluffyGame game = new FluffyGame();
        assertTrue(game.statInfo().equals(""));
        game.createPet();
        assertFalse(game.statInfo().equals(""));
    }

    @Test
    public void care() throws Exception {
        FluffyGame game = new FluffyGame();
        game.createPet();
        int i = game.getPet().getAge();
        game.careForPet(0);
        assertTrue(game.getPet().getAge() - i == 1);
    }

    @Test
    public void score() throws Exception {
        FluffyGame game = new FluffyGame();
        game.createPet();
        int i = game.getPet().getScore();
        game.careForPet(0);
        assertTrue(game.getPet().getScore() != i);
    }
}
