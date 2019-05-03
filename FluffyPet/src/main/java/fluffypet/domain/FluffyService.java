/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluffypet.domain;

import java.util.Scanner;

/**
 * A text UI version for the game.
 *
 * @author Aubergine
 */
public class FluffyService {

    static FluffyGame game;

    /**
     * Returns a new pet with the default settings.
     *
     * @return A new pet with the default settings
     * @throws Exception May throw Exception
     */
    public Pet newPet() throws Exception {
        return new Pet(Settings.defaultStats);
    }

    /**
     * Returns a new CarePlan with the default settings.
     *
     * @return A new CarePlan with the default settings
     * @throws Exception May throw Exception
     */
    public CarePlan newCarePlan() throws Exception {
        return new CarePlan(Settings.defaultStats);
    }

}
