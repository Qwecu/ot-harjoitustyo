/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluffypet.domain;

import java.util.Comparator;

/**
 * Contains a player name and score.
 * 
 * @author Aubergine
 */
public class Score implements Comparator<Score> {

    private final String player;
    private final int score;

    /**
     * Creates a new Score.
     *
     * @param playerName Player name
     * @param gameScore Game score
     */
    public Score(String playerName, int gameScore) {
        player = playerName;
        score = gameScore;
    }

    /**
     * Player name.
     *
     * @return Name of the player
     */
    public String getPlayerName() {
        return player;
    }

    /**
     * Score.
     *
     * @return Score
     */
    public int getScore() {
        return score;
    }

    /**
     * Compare two Scores.
     *
     * @param o1 score 1
     * @param o2 score 2
     * @return result of comparison
     */
    @Override
    public int compare(Score o1, Score o2) {
        return o2.score - o1.score;
    }
}
