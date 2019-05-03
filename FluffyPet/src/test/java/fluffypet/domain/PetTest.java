/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluffypet.domain;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Aubergine
 */
public class PetTest {
    
    String[] statTestValues = {"Stat A", "Stat B"};
    Pet pet;
    
    @Before
    public void setUp() throws Exception {
        pet = new Pet(statTestValues);
    }
    
    @Test
    public void initialize() throws Exception {
        assertTrue(pet.getAge() == 0);
    }
    
    @Test
    public void ageIncrease() {
        pet.advanceTime(new CarePlan(new String[]{"Stat A"}));
        assertTrue(pet.getAge() == 1);
        assertTrue(pet.isLiving());
        
    }
    
    @Test
    public void noEmptyList() throws Exception {
        try {
            Pet pet2 = new Pet(new String[]{});
        }
        catch (Exception e) {
            assertTrue(e.getMessage().equals("Pet cannot be initialized wit an empty stat list"));
        }
        
    }
    
}
