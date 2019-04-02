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

    private HashMap<String, Double> statIncreases;

    public CarePlan(String[] stats) throws Exception {
        if (stats.length == 0) {
            throw new Exception("CarePlan cannot be initialized wit an empty stat list");
        }
        statIncreases = new HashMap<String, Double>();
        Random random = new Random();
        for (String stat : stats) {
            statIncreases.put(stat, random.nextDouble());
        }
    }
    
    public HashMap getStatIncreases() {
        return statIncreases;
    }
}
