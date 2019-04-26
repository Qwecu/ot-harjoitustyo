/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluffypet.io;

import fluffypet.domain.Score;
import java.util.List;

/**
 *
 * @author Aubergine
 */
public interface IHighScores {

    /**
     * Adds score to high score list if high enough
     * @param score Score to add
     */
    void addScore(Score score);

    /**
     *
     * @return High scores
     */
    List<Score> getAll();

}
