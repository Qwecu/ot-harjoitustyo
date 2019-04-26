package fluffypet.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Default settings.
 *
 * @author Aubergine
 */
public class Settings {

    /**
     * Default stat names.
     */
    public static String[] defaultStats = {"Kylläisyys", "Uni", "Liikunta", "Akateemiset virikkeet"};
    /**
     * Default count of different CarePlans available.
     */
    public static int defaultCarePlanCount = 4;

    /**
     * Default for lethal stat value away from zero.
     */
    public static double lethalDeviationAmount = 2.0;

    /**
     * Default for the amount that stats decrease daily.
     */
    public static double statDepletionDaily = 0.5;

    /**
     * Amount of high scores stored.
     */
    public static int highScoreListLength = 20;

    /**
     * Filename of the high score list.
     */
    public static String highScoreFilename = "hiScore.txt";

    /**
     * Max length of player name.
     */
    public static int maxNameLength = 30;
}
