/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagtrack;

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import static javafx.geometry.Pos.TOP_LEFT;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

        GridPane scherm = new GridPane();
        StackPane stack = new StackPane();
        stack.setPrefSize(800, 450);
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

        // new Image(url)
        Image image = new Image("background.jpg");
// new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
//// new BackgroundImage(image, repeatX, repeatY, position, size)
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
//// new Background(images...)
        Background background = new Background(backgroundImage);

        stack.setBackground(background);

        Rectangle rect = new Rectangle(400, 200);

        rect.setArcHeight(30);
        rect.setArcWidth(30);
        rect.setStroke(Color.BLACK);
        rect.setFill(Color.WHITE);

        stack.getChildren().addAll(rect, scherm);
        
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
