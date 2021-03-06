/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluffypet.io;

import fluffypet.domain.Score;
import fluffypet.domain.Settings;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * File access for high scores.
 * 
 * @author Aubergine
 */
public class FileHighScores implements IHighScores {

    private List<Score> highScores;
    private String file;

    @Override
    public List<Score> getAll() {
        Collections.sort(highScores, new Score(null, 0));
        return highScores;

    }

    /**
     * Reads the high scores from a file.
     *
     * @param file filename to use (.txt)
     * @throws Exception Any I/O Exception
     */
    public FileHighScores(String file) throws Exception {
        highScores = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                String user = parts[0];
                int score = Integer.parseInt(parts[1]);

                highScores.add(new Score(user, score));
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }

    }

    /**
     * Adds a new score to the high score list if the score is big enough.
     *
     * @param score Score to add
     */
    public void addScore(Score score) {
        highScores.add(score);
        highScores.sort(score);
        while (highScores.size() > Settings.highScoreListLength) {
            highScores.remove(highScores.size());
        }
        try {
            save();
        } catch (Exception e) {

        }
    }

    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Score s : highScores) {
                writer.write(s.getPlayerName() + ";" + s.getScore() + "\n");
            }
        }
    }
}
