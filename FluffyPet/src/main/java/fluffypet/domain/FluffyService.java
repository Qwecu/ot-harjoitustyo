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
     * The Main method.
     *
     * @param args args
     * @throws Exception May throw Exception
     */
    public static void main(String[] args) throws Exception {
        game = new FluffyGame();
        Scanner sc = new Scanner(System.in);

        Pet pet = new FluffyService().newPet();
        while (game.getPet().isLiving()) {
            System.out.println("Mitä hoito-ohjelmaa sovelletaan tänään? (1-" + game.planCount() + ")");
            String planstring = sc.nextLine();
            try {
                int planint = Integer.parseInt(planstring);
                game.careForPet(planint - 1);
                System.out.println(game.statInfo());
            } catch (Exception e) {
                System.out.println("Yritä uudelleen");
            }
        }
        System.out.println("Kuolit! Pisteesi: " + pet.getAge());
    }

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
