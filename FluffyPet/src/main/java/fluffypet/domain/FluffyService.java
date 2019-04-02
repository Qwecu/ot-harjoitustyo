/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluffypet.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Aubergine
 */
public class FluffyService {

    
    public static void main(String[] args) throws Exception {
        ArrayList<CarePlan> plans = new ArrayList<CarePlan>();
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < Settings.DefaultCarePlanCount; i++){
            plans.add(new FluffyService().newCarePlan());
        }
        Pet pet = new FluffyService().newPet();
        while (pet.isLiving()) {
            System.out.println("Mitä hoito-ohjelmaa sovelletaan tänään? (1-" + plans.size() + ")" );
            String planstring = sc.nextLine();
            try{
                int planint = Integer.parseInt(planstring);
                CarePlan selectedPlan = plans.get(planint -1);
                pet.AdvanceTime(selectedPlan);
            }
            catch(Exception e){
                System.out.println("Yritä uudelleen");
            }
            printStats(pet);
        }
        System.out.println("Kuolit! Pisteesi: " + pet.getAge());
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
