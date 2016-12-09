/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagtrack;

import static bagtrack.Main.scherm;
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
 * @author Team Twee
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

        Image logoPath = new Image("titel_simpel.png", 275, 75, false, false);

        Label logo = new Label();
        logo.setGraphic(new ImageView(logoPath));

        TextField gebruikersnaamField = new TextField();
        gebruikersnaamField.setPromptText("Gebruikersnaam");

        PasswordField wachtwoordField = new PasswordField();
        wachtwoordField.setPromptText("Wachtwoord");

        Text melding = new Text();
        melding.setText("Onjuiste combinatie gebruikersnaam en wachtwoord.");
        melding.setFill(Color.RED);
        melding.setVisible(false);

        Button inlogButton = new Button("Log in");
        inlogButton.setPrefSize(200, 20);
        inlogButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                username = gebruikersnaamField.getText();
                ResultSet getUser = sql.select("SELECT loginnaam, wachtwoord, "
                        + "privilege FROM users WHERE BINARY loginnaam = '"
                        + username + "' AND BINARY wachtwoord = '"
                        + wachtwoordField.getText() + "'");

                try {
                    if (getUser.next()) {
                        privilege = getUser.getInt("privilege");
                        Main.change(Welkomscherm.returnScherm());
                        scherm.setLeft(null);
                        Main.topmenu();
                        melding.setVisible(false);
                        gebruikersnaamField.setText(null);
                        wachtwoordField.setText(null);

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

        Button uitlogButton = new Button("Afsluiten");
        uitlogButton.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        uitlogButton.setPrefSize(140, 40);
        uitlogButton.setAlignment(Pos.TOP_RIGHT);
        uitlogButton.setStyle("-fx-background-color: transparent;");
        uitlogButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.exit(0);
            }
        });

        Image achtergrondImagePath = new Image("background.jpg");

        BackgroundSize achtergrondGrootte = new BackgroundSize(100, 100, true,
                true, true, false);
        
        BackgroundImage achtergrondImage = new BackgroundImage(
                achtergrondImagePath, BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                achtergrondGrootte);
        
        Background achtergrond = new Background(achtergrondImage);

        Rectangle inlogVeld = new Rectangle(300, 300);
        inlogVeld.setArcHeight(30);
        inlogVeld.setArcWidth(30);
        inlogVeld.setFill(Color.rgb(0, 0, 0, .50));

        Rectangle uitknopVeld = new Rectangle(130, 40);
        uitknopVeld.setArcHeight(30);
        uitknopVeld.setArcWidth(30);
        uitknopVeld.setFill(Color.rgb(0, 0, 0, .50));

        HBox inlogButtonPane = new HBox();
        inlogButtonPane.setAlignment(Pos.BOTTOM_CENTER);
        inlogButtonPane.getChildren().add(inlogButton);

        GridPane scherm = new GridPane();
        scherm.setAlignment(Pos.CENTER);
        scherm.setHgap(30);
        scherm.setVgap(30);
        scherm.setPadding(new Insets(25, 25, 25, 25));
        scherm.setPrefSize(80, 80);
        //enter knop
        scherm.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    username = gebruikersnaamField.getText();
                    ResultSet getUser = sql.select("SELECT loginnaam, "
                            + "wachtwoord, privilege FROM users WHERE BINARY "
                            + "loginnaam = '" + username + "' AND BINARY "
                            + "wachtwoord = '" + wachtwoordField.getText()
                            + "'");

                    try {
                        if (getUser.next()) {
                            privilege = getUser.getInt("privilege");
                            Main.change(Welkomscherm.returnScherm());
                            Main.topmenu();
                            melding.setVisible(false);
                            gebruikersnaamField.setText(null);
                            wachtwoordField.setText(null);

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

        scherm.add(logo, 0, 0);
        scherm.add(gebruikersnaamField, 0, 1);
        scherm.add(wachtwoordField, 0, 2);
        scherm.add(melding, 0, 4);
        scherm.add(inlogButtonPane, 0, 3);

        StackPane stack = new StackPane();
        stack.setPrefSize(800, 450);
        stack.setBackground(achtergrond);
        StackPane.setAlignment(uitknopVeld, Pos.TOP_RIGHT);
        StackPane.setAlignment(uitlogButton, Pos.TOP_RIGHT);

        stack.getChildren().addAll(inlogVeld, scherm, uitknopVeld,
                uitlogButton);

        return stack;
    }
}
