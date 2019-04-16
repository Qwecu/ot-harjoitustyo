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
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Aubergine
 */
public class FluffyFXUI extends Application {

    private FluffyGame game;

    FlowPane root = new FlowPane();
    HBox statbox = new HBox();

    Image image;

    XYChart.Series series1;
    XYChart.Series series2;
    XYChart.Series series3;
    XYChart.Series series4;

    HashMap<String, XYChart.Series> statdata;

    public FluffyFXUI() {
        try {
            this.image = new Image("http://huukka.sarjakuvablogit.com/files/2010/10/krplouhi.jpg");
        }
        catch (Exception e) {

        }
/*
        series1 = new XYChart.Series();
        series2 = new XYChart.Series();
        series3 = new XYChart.Series();
        series4 = new XYChart.Series();*/

        statdata = new HashMap<String, XYChart.Series>();

    }

    public void updateGraph(int age, HashMap<String, Double> statValues) {
        /*series1.getData().add(new XYChart.Data(age, statValues.get(0)));
        series2.getData().add(new XYChart.Data(age, statValues.get(1)));
        series3.getData().add(new XYChart.Data(age, statValues.get(2)));
        series4.getData().add(new XYChart.Data(age, statValues.get(3)));*/
        for(String s : statValues.keySet()){
            statdata.get(s).getData().add(new XYChart.Data(age, statValues.get(s)));
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        game = new FluffyGame();
        game.createPet();
        
        for (String stat : Settings.DefaultStats){
            statdata.put(stat, new XYChart.Series());
        }

        for (int i = 0; i < game.planCount(); i++) {
            Button btn = new Button();
            btn.setText("Care plan #" + (i + 1));
            final int id = i;
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    game.careForPet(id);
                    updateGraph(game.getPet().getAge(), game.getPet().getStats());
                    System.out.print(game.statInfo());
                }
            });
            root.getChildren().add(btn);
        }
        ImageView imageView = new ImageView(image);

        root.getChildren().add(statbox);
        root.getChildren().add(imageView);

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Päivät");

        LineChart linechart = new LineChart(xAxis, yAxis);

        for(XYChart.Series xy : statdata.values()){
            linechart.getData().add(xy);
        }
        /*
        linechart.getData().add(series1);
        linechart.getData().add(series2);
        linechart.getData().add(series3);
        linechart.getData().add(series4);*/

        root.getChildren().add(linechart);

        Scene scene = new Scene(root, 600, 650);

        primaryStage.setTitle("Fluffy Pet");
        primaryStage.setScene(scene);
        //primaryStage.setScene(scene2);

        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
