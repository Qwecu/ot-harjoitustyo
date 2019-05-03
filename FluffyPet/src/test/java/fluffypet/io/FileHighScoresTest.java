/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluffypet.io;

import fluffypet.domain.Score;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author Aubergine
 */
public class FileHighScoresTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File highScoreFile;
    Score dao;
    private String filename;
    
    @Before
    public void setUp() throws Exception {
        filename = "testfile_highScores.txt";
        highScoreFile = testFolder.newFile(filename);
        
        try (FileWriter file = new FileWriter(filename)) {
            file.write("test8;8\n"
                    + "test10;10\n"
                    + "test2;2\n");
        }
    }
    
    @Test
    public void scoresAreReadCorrectlyFromFile() {
        List<Score> scores;
        try {
            scores = new FileHighScores(filename).getAll();
        }
        catch (Exception e) {
            scores = new ArrayList<>();
        }
        assertEquals(3, scores.size());
        Score score = scores.get(0);
        assertEquals("test10", score.getPlayerName());
        assertEquals(10, score.getScore());
    }
    
    @Test
    public void listIsSorted() {
        List<Score> scores;
        try {
            scores = new FileHighScores(filename).getAll();
        }
        catch (Exception e) {
            scores = new ArrayList<>();
        }
        assertEquals(scores.get(0).getScore(), 10);
        assertEquals(scores.get(1).getScore(), 8);
        assertEquals(scores.get(2).getScore(), 2);
        
    }
    
    @Test
    public void save() throws Exception {
        FileHighScores hs = new FileHighScores(filename);
        hs.addScore(new Score("testitekijä", 55));
    }
    
    @After
    public void tearDown() {
        highScoreFile.delete();
    }
}
