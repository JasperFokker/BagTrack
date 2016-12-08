/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagtrack;

import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Jason
 */
public class Instellingenscherm extends Application {

    @Override
    public void start(Stage primaryStage) {
        returnScherm();
    }

    public static GridPane returnScherm() {

        Button btn = new Button();
        btn.setText("SQL TEST");
        btn.setPrefSize(300, 20);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ResultSet results;
                results = sql.select("SELECT * FROM bagage;");
                try {
                    if (results.next()) {
                        System.out.println(results.getString("naam"));
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        GridPane scherm = new GridPane();
        scherm.setPrefSize(600, 450);

        scherm.add(btn, 0, 1);

        return scherm;
    }
}
