package fluffypet.domain;

import java.util.HashMap;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aubergine
 */
public class CarePlan {

    private final HashMap<String, Double> statIncreases;

    /**
     *Creates a new randomized CarePlan
     * 
     * @param stats List of stats that are affected by the CarePlan
     */
    public CarePlan(String[] stats) {
        statIncreases = new HashMap<>();
        Random random = new Random();
        for (String stat : stats) {
            statIncreases.put(stat, random.nextDouble());
        }
    }

    public HashMap getStatIncreases() {
        return statIncreases;
    }
}
