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
        CarePlan cp = new CarePlan(new String []{"test"});
        assertTrue(cp.getStatIncreases() != null && !cp.getStatIncreases().isEmpty());
    }

}
