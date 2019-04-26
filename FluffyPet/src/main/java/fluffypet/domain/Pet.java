/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluffypet.domain;

import java.util.HashMap;

/**
 * A pet that is alive/dead and has stat values.
 *
 * @author Aubergine
 */
public class Pet {

    private final HashMap<String, Double> stats;
    private int age;
    private double score;
    private int hitpoints;
    private boolean isAlive;

    /**
     * Creates a new Pet with the age of 0.
     *
     * @param statNames The names of the stats of the created pet
     * @throws Exception May throw Exception
     */
    public Pet(String[] statNames) throws Exception {
        stats = new HashMap<>();
        age = 0;
        hitpoints = 1;
        isAlive = true;

        if (statNames.length == 0) {
            throw new Exception("Pet cannot be initialized wit an empty stat list");
        }

        for (String statName : statNames) {
            stats.put(statName, 0.0);
        }
    }

    private double statScore() {
        return 0;
    }

    /**
     * Adjusts the pet's stats according to the CarePlan and increases age by 1.
     *
     * @param carePlan CarePlan to be applied
     */
    public void advanceTime(CarePlan carePlan) {
        if (!isAlive) {
            return;
        }
        depleteStats();
        applyPlan(carePlan);
        if (!isWithinHealthyLimits()) {
            hitpoints--;
        } else if (hitpoints < 1) {
            hitpoints++;
        }
        if (hitpoints < 0) {
            isAlive = false;
        }
        age++;
        score += age * stats.size() + statScore();
    }

    private void depleteStats() {
        for (String stat : stats.keySet()) {
            stats.put(stat, stats.get(stat) - Settings.statDepletionDaily);
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

    private boolean isWithinHealthyLimits() {
        for (Double statValue : stats.values()) {
            if (Math.abs(statValue) > Settings.lethalDeviationAmount) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the pet is alive.
     *
     * @return true = alive, false = dead
     */
    public boolean isLiving() {
        return isAlive;
    }

    /**
     * Stats.
     *
     * @return stats
     */
    public HashMap<String, Double> getStats() {
        return stats;
    }

    /**
     * Returns the age of the pet.
     *
     * @return Age of the pet
     */
    public int getAge() {
        return age;
    }

    /**
     * Score.
     *
     * @return score
     */
    public int getScore() {
        return (int) score;
    }
}
