/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagtrack;

import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static bagtrack.Main.scherm;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Thom
 */
public class Loginscherm extends Application {

    @Override
    public void start(Stage primaryStage) {
        returnScherm();
    }

    public static GridPane returnScherm() {

        GridPane scherm = new GridPane();
        scherm.setPrefSize(800, 450);
        scherm.setAlignment(Pos.CENTER);
        scherm.setHgap(10);
        scherm.setVgap(10); 
        scherm.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welkom");
        scenetitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        scherm.add(scenetitle, 1, 0, 2, 1);

        Label userName = new Label("Gebruikersnaam:");
        scherm.add(userName, 0, 1);

        TextField userTextField = new TextField();
        scherm.add(userTextField, 1, 1);

        Label pw = new Label("Wachtwoord:");
        scherm.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        scherm.add(pwBox, 1, 2);

        Button btn = new Button("Log in");
        HBox hbBtn = new HBox();
        btn.setPrefSize(200, 20);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(btn);
        scherm.add(hbBtn, 1, 4);
        
        //Enter button
        scherm.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)){
                Main.change(Welkomscherm.returnScherm());
                Main.menu();
                Main.topmenu();            
            }
            }
            
        });
        
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main.change(Welkomscherm.returnScherm());
                Main.menu();
                Main.topmenu();
                
            
            }
        });
        
        return scherm;
    }
}
