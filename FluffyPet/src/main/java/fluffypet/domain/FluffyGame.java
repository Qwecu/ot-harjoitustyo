/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluffypet.domain;

import fluffypet.io.FileHighScores;
import fluffypet.io.IHighScores;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The game object.
 *
 * @author Aubergine
 */
public class FluffyGame {

    private final ArrayList<CarePlan> plans;
    private Pet pet;
    private IHighScores highScores;

    /**
     * Creates a new game using the default Settings.
     *
     * @throws Exception exeption
     */
    public FluffyGame() throws Exception {
        plans = new ArrayList<>();
        highScores = new FileHighScores(Settings.highScoreFilename);
        for (int i = 0; i < Settings.defaultCarePlanCount; i++) {
            plans.add(new FluffyService().newCarePlan());
        }
    }

    /**
     * Creates a new Pet with full health and age 0, replacing the old one.
     *
     * @throws Exception exeption
     */
    public void createPet() throws Exception {
        pet = new FluffyService().newPet();
    }

    /**
     * Count of different CarePlans in the game.
     *
     * @return Count of different CarePlans in the game.
     */
    public int planCount() {
        return plans.size();
    }

    /**
     * Pet.
     *
     * @return pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * Adds the score to the high score list if high enough.
     *
     * @param player Player name
     * @param score Player score
     */
    public void addScore(String player, int score) {
        highScores.addScore(new Score(player, score));
    }

    /**
     * Returns the high score list.
     *
     * @return The high score list
     */
    public List<Score> getHighScores() {
        return highScores.getAll();
    }

    /**
     * Applies the selected CarePlan to the pet and adds +1 to the pet's age.
     *
     * @param planId The id of the selected plan
     */
    public void careForPet(int planId) {
        pet.advanceTime(plans.get(planId));
    }

    /**
     * Returns verbal info about the pet.
     *
     * @return verbal info
     */
    public String statInfo() {
        String info = "";

        HashMap<String, Double> stats = pet.getStats();
        for (String stat : stats.keySet()) {
            info += stat + " on " + stats.get(stat) + "\n";
        }
        info += "Lemmikkisi on " + pet.getAge() + " päivää vanha. \n";
        info += "Pitäydy arvojen " + Settings.lethalDeviationAmount + " ja " + Settings.lethalDeviationAmount * -1.0 + " välissä, niin lemmikkisi pysyy elossa!";
        return info;
    }
}
