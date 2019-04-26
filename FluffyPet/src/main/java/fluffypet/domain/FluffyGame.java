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
 *
 * @author Aubergine
 */
public class FluffyGame {
    
    private final ArrayList<CarePlan> plans;
    private Pet pet;
    private IHighScores highScores;

    /**
     * Creates a new game using the default Settings
     *
     * @throws Exception
     */
    public FluffyGame() throws Exception {
        plans = new ArrayList<>();
        highScores = new FileHighScores(Settings.highScoreFilename);
        for (int i = 0; i < Settings.DefaultCarePlanCount; i++) {
            plans.add(new FluffyService().newCarePlan());
        }
    }

    /**
     * Creates a new Pet with full health and age 0, replacing the old one
     *
     * @throws Exception
     */
    public void createPet() throws Exception {
        pet = new FluffyService().newPet();
    }

    /**
     *
     * @return Count of different CarePlans in the game
     */
    public int planCount() {
        return plans.size();
    }
    
    public Pet getPet() {
        return pet;
    }
    
    public void addScore(String player, int score) {
        highScores.addScore(new Score(player, score));
    }
    
    public List<Score> getHighScores(){
        return highScores.getAll();
    }

    /**
     * Applies the selected CarePlan to the pet and adds +1 to the pet's age
     *
     * @param planId The id of the selected plan
     */
    public void careForPet(int planId) {
        pet.AdvanceTime(plans.get(planId));
    }

    /**
     * Returns verbal info about the pet
     *
     * @return
     */
    public String statInfo() {
        String info = "";
        
        HashMap<String, Double> stats = pet.getStats();
        for (String stat : stats.keySet()) {
            info += stat + " on " + stats.get(stat) + "\n";
        }
        info += "Lemmikkisi on " + pet.getAge() + " päivää vanha. \n";
        info += "Pitäydy arvojen " + Settings.LethalDeviationAmount + " ja " + Settings.LethalDeviationAmount * -1.0 + " välissä, niin lemmikkisi pysyy elossa!";
        return info;
    }
}
