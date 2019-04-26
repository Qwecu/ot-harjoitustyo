/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluffypet.domain;

import java.util.Comparator;

/**
 *
 * @author Aubergine
 */
public class Score implements Comparator<Score> {

    private final String player;
    private final int score;

    /**
     *
     * @param playerName Player name
     * @param gameScore Game score
     */
    public Score(String playerName, int gameScore) {
        player = playerName;
        score = gameScore;
    }

    /**
     *
     * @return Name of the player
     */
    public String getPlayerName() {
        return player;
    }

    /**
     *
     * @return Score
     */
    public int getScore() {
        return score;
    }

    @Override
    public int compare(Score o1, Score o2) {
        return o1.score - o2.score;
    }
}
