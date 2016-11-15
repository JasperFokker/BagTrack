/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagtrack;

import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author jimmy
 */
public class Helpscherm extends Application {

    @Override
    public void start(Stage primaryStage) {
        returnScherm();
    }

    public static GridPane returnScherm() {
        GridPane scherm = new GridPane();
        scherm.setPrefSize(600, 450);
        scherm.setHgap(10);
        scherm.setVgap(10);
        scherm.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Veelgestelde vragen:");
        scenetitle.setFont(Font.font("Verdana", FontWeight.BOLD, 36));
        scherm.add(scenetitle, 0, 0, 2, 1);

        

        Text t = new Text();
        t.setText("Waarom kan ik geen koffers invoeren?");
        t.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        Text t1 = new Text();
        t1.setText("Omdat je niet goed genoeg kijkt.");
        Text t2 = new Text();
        t2.setText("Hoe log ik uit?");
        t2.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        Text t3 = new Text();
        t3.setText("Klik op de \"uitloggen\" knop.");
        
        scherm.add(t, 0, 3);
        scherm.add(t1, 0, 4);
        scherm.add(t2, 0, 5);
        scherm.add(t3, 0, 6);

        return scherm;
    }
}
