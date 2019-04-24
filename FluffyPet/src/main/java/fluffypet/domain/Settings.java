package fluffypet.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aubergine
 */
public class Settings {

    /**
     * Default stat names
     */
    public static String[] DefaultStats = {"Kylläisyys", "Uni", "Liikunta", "Akateemiset virikkeet"};
    /**
     * Default count of different CarePlans available
     */
    public static int DefaultCarePlanCount = 4;

    /**
     * Default for lethal stat value away from zero
     */
    public static double LethalDeviationAmount = 2.0;

    /**
     * Default for the amount that stats decrease daily
     */
    public static double StatDepletionDaily = 0.5;
}
