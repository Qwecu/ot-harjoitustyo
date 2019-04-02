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
public class FluffyService {

    public static void main(String[] args) throws Exception {
        Pet pet = new FluffyService().newPet();
        while (pet.isLiving()) {
            pet.AdvanceTime(new FluffyService().newCarePlan());
            printStats(pet);
        }
        System.out.println("Kuolit!");
    }

    private static void printStats(Pet pet) {

        HashMap<String, Double> stats = pet.getStats();
        for (String stat : stats.keySet()) {
            System.out.println(stat + " on " + stats.get(stat));
        }
        System.out.println("Lemmikkisi on " + pet.getAge() + " päivää vanha");
    }

    public Pet newPet() throws Exception {
        return new Pet(Settings.DefaultStats);
    }

    public CarePlan newCarePlan() throws Exception {
        return new CarePlan(Settings.DefaultStats);
    }
}
