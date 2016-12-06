/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagtrack;

import java.sql.ResultSet;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Thom
 */
public class Loginscherm extends Application {
    
    static String username;
    static int privilege;

    public static String getUsername() {
        return username;
    }
    
    public static int getPrivilege() {
//        System.out.println(privilege);
        return privilege;
    }    
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
        scherm.setPrefSize(80, 80);

        Image Logo = new Image("titel_simpel.png", 275, 75, false, false);
        Label logoDingetje = new Label();
        logoDingetje.setGraphic(new ImageView(Logo));
        scherm.add(logoDingetje, 0, 0);

        TextField userTextField = new TextField();
        userTextField.setPromptText("Gebruikersnaam");
        scherm.add(userTextField, 0, 1);

        PasswordField pwBox = new PasswordField();
        pwBox.setPromptText("Wachtwoord");
        scherm.add(pwBox, 0, 2);

        Text melding = new Text();
        melding.setText("Onjuiste combinatie gebruikersnaam en wachtwoord.");
        melding.setFill(Color.RED);
        melding.setVisible(false);
        
        scherm.add(melding, 0, 4);

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
        rect.setFill(Color.rgb(0, 0, 0, .50));

        
        Button uitlogbutton = new Button();
        uitlogbutton.setText("Afsluiten");
        uitlogbutton.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        uitlogbutton.setPrefSize(140, 40);
        uitlogbutton.setAlignment(Pos.TOP_RIGHT);
        uitlogbutton.setStyle("-fx-background-color: transparent;");
        uitlogbutton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        GridPane uitlogpane = new GridPane();
        
        Rectangle uitknopveld = new Rectangle(130, 40);        
        uitlogpane.setAlignment(Pos.TOP_RIGHT);
        
        uitknopveld.setArcHeight(30);
        uitknopveld.setArcWidth(30);
        uitknopveld.setFill(Color.rgb(0, 0, 0, .50));
        
        stack.getChildren().addAll(rect, uitlogpane, scherm, uitknopveld, uitlogbutton);
        
        stack.setAlignment(uitknopveld, Pos.TOP_RIGHT);
        stack.setAlignment(uitlogbutton, Pos.TOP_RIGHT);
        
        //Enter button
        scherm.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                username = userTextField.getText();
                String password = pwBox.getText();
                ResultSet getUser = sql.select("SELECT loginnaam, wachtwoord, privilege FROM users WHERE BINARY loginnaam = '" + username + "' AND BINARY wachtwoord = '"
                        + password + "'");
                
                try {                                        
                    if (getUser.next()) {
                        privilege = getUser.getInt("privilege");
                        Main.change(Welkomscherm.returnScherm());
                        Main.menu();
                        Main.topmenu();
                        melding.setVisible(false);
                        userTextField.setText(null);
                        pwBox.setText(null);
                        if (privilege == 1) {
                            Main.statistiekenButton.setDisable(true);
                        } else {
                            Main.statistiekenButton.setDisable(false);
                        }
                    } else {
                        melding.setVisible(true);
                    }
                } catch (Exception r) {
                    System.out.println(r);
                }
                }
            }
        });

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                username = userTextField.getText();
                String password = pwBox.getText();
                ResultSet getUser = sql.select("SELECT loginnaam, wachtwoord, privilege FROM users WHERE BINARY loginnaam = '" + username + "' AND BINARY wachtwoord = '" + password + "'");
                
                try {                                        
                    if (getUser.next()) {
                        privilege = getUser.getInt("privilege");
                        Main.change(Welkomscherm.returnScherm());
                        Main.menu();
                        Main.topmenu();
                        melding.setVisible(false);
                        userTextField.setText(null);
                        pwBox.setText(null);
                        if (privilege == 1) {
                            Main.statistiekenButton.setDisable(true);
                        } else {
                            Main.statistiekenButton.setDisable(false);
                        }
                    } else {
                        melding.setVisible(true);
                    }
                } catch (Exception r) {
                    System.out.println(r);
                }
            }
        });
        

        return stack;
    }
}
