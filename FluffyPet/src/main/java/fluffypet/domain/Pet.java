/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluffypet.domain;

import java.util.HashMap;

/**
 *
 * @author Aubergine
 */
public class Pet {

    private HashMap<String, Double> stats;
    private int age;

    public Pet(String[] statNames) throws Exception {
        stats = new HashMap<String, Double>();
        age = 0;
        if (statNames.length == 0) {
            throw new Exception("Pet cannot be initialized wit an empty stat list");
        }

        for (String statName : statNames) {
            stats.put(statName, 0.0);
        }
    }

    public void AdvanceTime(CarePlan carePlan) {
        depleteStats();
        applyPlan(carePlan);
        age++;
    }

    private void depleteStats() {
        for (String stat : stats.keySet()) {
            stats.put(stat, stats.get(stat) - Settings.StatDepletionDaily);
        }
    }

    private void applyPlan(CarePlan carePlan) {
        HashMap<String, Double> increases = carePlan.getStatIncreases();
        for (String increase : increases.keySet()) {
            if (stats.containsKey(increase)) {
                stats.put(increase, stats.get(increase) + increases.get(increase));
            }
        }
    }

    public boolean isLiving() {
        for (Double statValue : stats.values()) {
            if (Math.abs(statValue) > Settings.LethalDeviationAmount) {
                return false;
            }
        }
        return true;
    }

    public HashMap<String, Double> getStats() {
        return stats;
    }

    public int getAge() {
        return age;
    }
}
