/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluffypet.ui;

import fluffypet.domain.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author Aubergine
 */
public class FluffyFXUI extends Application {

    private FluffyGame game;

    FlowPane root = new FlowPane();

    @Override
    public void start(Stage primaryStage) throws Exception {
        game = new FluffyGame();
        game.createPet();

        for (int i = 0; i < game.planCount(); i++) {
            Button btn = new Button();
            btn.setText("Care plan #" + (i + 1));
            final int id = i;
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    game.careForPet(id);
                    System.out.print(game.statInfo());
                }
            });
            root.getChildren().add(btn);
        }
        
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Fluffy Pet");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
