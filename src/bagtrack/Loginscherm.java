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
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
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

    public static StackPane returnScherm() {
        //log in scherm
        GridPane scherm = new GridPane();
        StackPane stack = new StackPane();
        stack.setPrefSize(800, 450);
        scherm.setAlignment(Pos.CENTER);
        scherm.setHgap(30);
        scherm.setVgap(30);
        scherm.setPadding(new Insets(25, 25, 25, 25));
<<<<<<< HEAD
        
        Image Logo = new Image ("titel_simpel.png", 250, 68, false, false);
        Label logoDingetje = new Label();
        logoDingetje.setGraphic(new ImageView(Logo));
        scherm.add(logoDingetje, 0, 0);

        TextField userTextField = new TextField();
        userTextField.setPromptText("Gebruikersnaam");
        scherm.add(userTextField, 0, 1);

        PasswordField pwBox = new PasswordField();
        pwBox.setPromptText("Wachtwoord");
        scherm.add(pwBox, 0, 2);

=======

        //welkomstekst
        Text scenetitle = new Text("Welkom");
        scenetitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        scherm.add(scenetitle, 1, 0, 2, 1);
       
        //invoer gebruikersnaam
        Label userName = new Label("Gebruikersnaam:");
        userName.getStyleClass().add("label-inlog");
        scherm.add(userName, 0, 1);
        TextField userTextField = new TextField();
        scherm.add(userTextField, 1, 1);
        
        //invoer wachtwoord
        Label pw = new Label("Wachtwoord:");
        pw.getStyleClass().add("label-inlog");
        scherm.add(pw, 0, 2);
        PasswordField pwBox = new PasswordField();
        scherm.add(pwBox, 1, 2);
        
        //log in button
>>>>>>> f212ba4324923ad09dfcecc0ad8ee583fb583c63
        Button btn = new Button("Log in");
        HBox hbBtn = new HBox();
        btn.setPrefSize(200, 20);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(btn);
        scherm.add(hbBtn, 0, 3);

        // new Image(url)
        Image image = new Image("background.jpg");
        // new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        //// new BackgroundImage(image, repeatX, repeatY, position, size)
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        //// new Background(images...)
        Background background = new Background(backgroundImage);

        stack.setBackground(background);

        Rectangle rect = new Rectangle(300, 300);

        rect.setArcHeight(30);
        rect.setArcWidth(30);
        rect.setStroke(Color.BLACK);
        rect.setFill(Color.rgb(120,120,120));

        stack.getChildren().addAll(rect, scherm);

        //Enter button
        scherm.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
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

        return stack;
    }
}
