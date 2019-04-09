/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluffypet.domain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Aubergine
 */
public class FluffyGame {

    private ArrayList<CarePlan> plans;
    private Pet pet;

    public FluffyGame() throws Exception {
        plans = new ArrayList<CarePlan>();
        for (int i = 0; i < Settings.DefaultCarePlanCount; i++) {
            plans.add(new FluffyService().newCarePlan());
        }
    }

    public void createPet() throws Exception {
        pet = new FluffyService().newPet();
    }

    public int planCount() {
        return plans.size();
    }

    public Pet getPet() {
        return pet;
    }

    public void careForPet(int planId) {
        pet.AdvanceTime(plans.get(planId));
    }

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
