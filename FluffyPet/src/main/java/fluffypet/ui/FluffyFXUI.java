/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluffypet.ui;

import fluffypet.domain.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Aubergine
 */
public class FluffyFXUI extends Application {

    private FluffyGame game;

    FlowPane root = new FlowPane();

    HBox statbox = new HBox();

    VBox startWindow = new VBox();

    Image image;

    Label lblHighScores;

    XYChart.Series series1;
    XYChart.Series series2;
    XYChart.Series series3;
    XYChart.Series series4;

    HashMap<String, XYChart.Series> statdata;

    private void fillHighScores(List<Score> scs) {
        String text = "";
        int i = 1;
        for (Score score : scs) {
            text += i + ". " + score.getPlayerName() + " " + score.getScore() + "\n";
            i++;
        }
        lblHighScores.setText(text);
    }

    /**
     * Constructor
     */
    public FluffyFXUI() {
        try {
            this.image = new Image("http://huukka.sarjakuvablogit.com/files/2010/10/krplouhi.jpg");
        }
        catch (Exception e) {

        }
        statdata = new HashMap<>();

    }

    /**
     * Updates the stat graph with new values
     * @param age new age to add
     * @param statValues new stat values to add
     */
    public void updateGraph(int age, HashMap<String, Double> statValues) {
        for (String s : statValues.keySet()) {
            statdata.get(s).getData().add(new XYChart.Data(age, statValues.get(s)));
        }
        statdata.get("Yliannostus").getData().add(new XYChart.Data(age, Settings.LethalDeviationAmount));
        statdata.get("Puutoskuolema").getData().add(new XYChart.Data(age, Settings.LethalDeviationAmount * -1.0));

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        game = new FluffyGame();
        game.createPet();

        lblHighScores = new Label();
        Button btnExitHighScores = new Button();
        btnExitHighScores.setText("Exit");
        btnExitHighScores.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        HBox hbHighScores = new HBox();
        hbHighScores.getChildren()
                .addAll(lblHighScores, btnExitHighScores);
        hbHighScores.setSpacing(
                10);
        hbHighScores.setAlignment(Pos.CENTER);
        Scene highScoresScene = new Scene(hbHighScores, 600, 650);

        Label lblPlayerName = new Label("Enter your name:");
        TextField txtPlayerName = new TextField();
        Button enterNameButton = new Button();
        enterNameButton.setText("Submit");
        enterNameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (game == null) {
                    return;
                }
                String name = txtPlayerName.getText();
                name = name.trim().replace(';', ':');
                if (name.length() > Settings.maxNameLength) {
                    name = name.substring(0, Settings.maxNameLength);
                }
                game.addScore(name, game.getPet().getScore());
                fillHighScores(game.getHighScores());
                game = null;
                primaryStage.setScene(highScoresScene);
            }
        });

        HBox hbEnterName = new HBox();

        hbEnterName.getChildren()
                .addAll(lblPlayerName, txtPlayerName, enterNameButton);
        hbEnterName.setSpacing(
                10);
        hbEnterName.setAlignment(Pos.CENTER);
        Scene enterNameScene = new Scene(hbEnterName, 600, 650);

        for (String stat : Settings.DefaultStats) {
            statdata.put(stat, new XYChart.Series());
        }

        statdata.put(
                "Yliannostus", new XYChart.Series());
        statdata.put(
                "Puutoskuolema", new XYChart.Series());

        for (int i = 0;
                i < game.planCount();
                i++) {
            Button btn = new Button();
            btn.setText("Care plan #" + (i + 1));
            final int id = i;
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    game.careForPet(id);
                    updateGraph(game.getPet().getAge(), game.getPet().getStats());
                    System.out.print(game.statInfo());
                    if (game.getPet().isLiving() == false) {
                        primaryStage.setScene(enterNameScene);
                    }
                }
            });
            root.getChildren().add(btn);
        }
        ImageView imageView = new ImageView(image);

        root.getChildren()
                .add(statbox);
        root.getChildren()
                .add(imageView);

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel(
                "Päivät");

        LineChart linechart = new LineChart(xAxis, yAxis);

        for (String s
                : statdata.keySet()) {

            linechart.getData().add(statdata.get(s));
            statdata.get(s).setName(s);
        }

        root.getChildren()
                .add(linechart);

        Scene scene = new Scene(root, 600, 650);

        Button startButton = new Button();

        startButton.setText(
                "New game");
        startButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event
                    ) {
                        primaryStage.setScene(scene);
                    }
                }
        );

        startWindow.setAlignment(Pos.CENTER);

        startWindow.getChildren()
                .add(startButton);
        Scene startScene = new Scene(startWindow, 600, 650);

        primaryStage.setTitle(
                "Fluffy Pet");
        primaryStage.setScene(startScene);

        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
