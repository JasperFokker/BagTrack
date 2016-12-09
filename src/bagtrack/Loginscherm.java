/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagtrack;

import static bagtrack.Main.scherm;
import static bagtrack.Welkomscherm.flip;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.ResultSet;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Team Twee
 */
public class Loginscherm extends Application {

    static String username;
    static String password;
    static int privilege;

    public static String getUsername() {
        return username;
    }
    
    private static String generateStrongPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt();
         
        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }
    
    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
    
    private static String toHex(byte[] array) throws NoSuchAlgorithmException
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }
    
    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException
    {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i<bytes.length ;i++)
        {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

    private static boolean validatePassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);
         
        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();
         
        int diff = hash.length ^ testHash.length;
        for(int i = 0; i < hash.length && i < testHash.length; i++)
        {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
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
                        + username + "';");
                try{
                    if(getUser.next()){
                        
                        String  originalPassword = wachtwoordField.getText();
                        String dbPassword = getUser.getString("wachtwoord");
                        boolean check = validatePassword(originalPassword, dbPassword);
                        System.out.println(check);
                        
                        try {
                            if (check) {
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

                                Timeline timeline = new Timeline(new KeyFrame(
                                        Duration.millis(2500),
                                        ae -> melding.setVisible(false)));

                                timeline.play();

                            }
                        } catch (Exception r) {
                            System.out.println(r);
                        }
                        
                        
                        
                    }
                }catch(Exception x){
                    System.out.println(e);
                }

                try {
                    if (getUser.next()) {
                        privilege = getUser.getInt("privilege");
                        //Main.change(Welkomscherm.returnScherm());
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

                        Timeline timeline = new Timeline(new KeyFrame(
                                Duration.millis(2500),
                                ae -> melding.setVisible(false)));

                        timeline.play();

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

                            Timeline timeline = new Timeline(new KeyFrame(
                                    Duration.millis(2500),
                                    ae -> melding.setVisible(false)));

                            timeline.play();
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
