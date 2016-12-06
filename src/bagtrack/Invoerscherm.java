package bagtrack;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Floris Wichers
 */
public class Invoerscherm extends Application {

    @Override
    public void start(Stage primaryStage) {
        returnScherm();
    }

    public static StackPane returnScherm() {
        TabPane invoerTabs = new TabPane();
        StackPane stack = new StackPane();
        GridPane popupGrid = new GridPane();
        popupGrid.setAlignment(Pos.CENTER);
        
        popupGrid.setHgap(10);
        popupGrid.setVgap(10);
        popupGrid.setPadding(new Insets(25, 25, 25, 25));
        
        GridPane kofferGegevensGrid = new GridPane();
        GridPane persoonGegevensGrid = new GridPane();

        kofferGegevensGrid.setHgap(10);
        kofferGegevensGrid.setVgap(10);
        kofferGegevensGrid.setPadding(new Insets(25, 25, 25, 25));

        persoonGegevensGrid.setHgap(10);
        persoonGegevensGrid.setVgap(10);
        persoonGegevensGrid.setPadding(new Insets(25, 25, 25, 25));

        //datum
        Label dateLabel = new Label("Datum");
        GridPane.setHalignment(dateLabel, HPos.RIGHT);
        kofferGegevensGrid.add(dateLabel, 0, 0);

        LocalDate date = LocalDate.now();
        DatePicker dp = new DatePicker(date);
        GridPane.setHalignment(dp, HPos.RIGHT);
        kofferGegevensGrid.add(dp, 1, 0);

        //luchthaven
        Label airportLabel = new Label("Luchthaven");
        GridPane.setHalignment(airportLabel, HPos.RIGHT);
        kofferGegevensGrid.add(airportLabel, 0, 1);

        ObservableList<String> airport
                = FXCollections.observableArrayList(
                        "LHR",
                        "CDG",
                        "FRA",
                        "AMS",
                        "IST",
                        "MAD",
                        "MUC",
                        "FMC",
                        "LGW",
                        "BCN",
                        "DPS",
                        "HRG",
                        "CUR"
                );
        final ComboBox airportBox = new ComboBox(airport);
        kofferGegevensGrid.add(airportBox, 1, 1);

        //combobox soort
        Label typeBagLabel = new Label("Soort");
        GridPane.setHalignment(typeBagLabel, HPos.RIGHT);
        kofferGegevensGrid.add(typeBagLabel, 0, 2);

        ObservableList<String> typeBag
                = FXCollections.observableArrayList(
                        "Koffer",
                        "Trolley",
                        "Tas",
                        "Zak"
                );
        final ComboBox typeBagBox = new ComboBox(typeBag);
        kofferGegevensGrid.add(typeBagBox, 1, 2);

        //invoer merk
        Label brandLabel = new Label("Merk");
        GridPane.setHalignment(brandLabel, HPos.RIGHT);
        kofferGegevensGrid.add(brandLabel, 0, 3);

        TextField brandField = new TextField();
        kofferGegevensGrid.add(brandField, 1, 3);

        //comboboxes kleur
        Label color1Label = new Label("Kleur 1");
        GridPane.setHalignment(color1Label, HPos.RIGHT);
        kofferGegevensGrid.add(color1Label, 0, 4);

        ObservableList<String> color
                = FXCollections.observableArrayList(
                        "Zwart",
                        "Wit",
                        "Grijs",
                        "Bruin",
                        "Rood",
                        "Blauw",
                        "Groen",
                        "Geel",
                        "Oranje",
                        "Paars",
                        "Roze"
                );
        final ComboBox color1Box = new ComboBox(color);
        color1Box.setVisibleRowCount(12);
        kofferGegevensGrid.add(color1Box, 1, 4);

        Label color2Label = new Label("Kleur 2");
        GridPane.setHalignment(color2Label, HPos.RIGHT);
        kofferGegevensGrid.add(color2Label, 2, 4);

        final ComboBox color2Box = new ComboBox(color);
        color2Box.setVisibleRowCount(12);
        kofferGegevensGrid.add(color2Box, 3, 4);

        //combobox opdruk
        Label graphicLabel = new Label("Opdruk");
        GridPane.setHalignment(graphicLabel, HPos.RIGHT);
        kofferGegevensGrid.add(graphicLabel, 0, 5);

        ObservableList<String> graphic
                = FXCollections.observableArrayList(
                        "Effen kleur",
                        "Afbeelding",
                        "Patroon"
                );
        final ComboBox graphicBox = new ComboBox(graphic);
        kofferGegevensGrid.add(graphicBox, 1, 5);

        //invoer labelnummer
        Label numberLabel = new Label("Labelnummer");
        GridPane.setHalignment(numberLabel, HPos.RIGHT);
        kofferGegevensGrid.add(numberLabel, 0, 6);

        TextField numberField = new TextField();
        kofferGegevensGrid.add(numberField, 1, 6);

        //invoer opmerkingen
        Label commentLabel = new Label("Opmerkingen");
        GridPane.setHalignment(commentLabel, HPos.RIGHT);
        kofferGegevensGrid.add(commentLabel, 0, 7);

        TextField commentField = new TextField();
        kofferGegevensGrid.add(commentField, 1, 7);

        //opslaan
        Button save = new Button();
        save.setText("Opslaan");
        GridPane.setHalignment(save, HPos.RIGHT);
        kofferGegevensGrid.add(save, 0, 8);

        //melding1
        Text melding1 = new Text();
        melding1.setText("Niet alle velden zijn ingevuld.");
        melding1.setFill(Color.RED);
        melding1.setVisible(false);
        kofferGegevensGrid.add(melding1, 0, 9);
        
        //succesMelding2
        Text succesMelding = new Text();
        succesMelding.setText("Succesvol ingevoerd!");
        succesMelding.setFill(Color.LIGHTGREEN);
        succesMelding.setVisible(false);
        kofferGegevensGrid.add(succesMelding, 0, 10);
        
        Rectangle popupRect = new Rectangle(300, 100);

        popupRect.setArcHeight(30);
        popupRect.setArcWidth(30);
        popupRect.setFill(Color.rgb(120, 120, 120));
        
        Label sureLabel = new Label("Weet je zeker dat je dit wilt toevoegen?");
        popupGrid.add(sureLabel, 0, 0);
        
        Button yesButton = new Button("Ja");
        popupGrid.add(yesButton, 0, 1);
        
        Button noButton = new Button("Nee");
        GridPane.setHalignment(noButton, HPos.RIGHT);
        popupGrid.add(noButton, 0, 1);
        
        Group popup = new Group();
        popup.getChildren().addAll(popupRect, popupGrid);
        popup.setVisible(false);
        
        //Voornaam
        Label voornaamLabel = new Label("Voornaam");
        GridPane.setHalignment(voornaamLabel, HPos.RIGHT);
        persoonGegevensGrid.add(voornaamLabel, 0, 0);

        TextField voornaamField = new TextField();
        persoonGegevensGrid.add(voornaamField, 1, 0);

        //Voorletters
        Label voorlettersLabel = new Label("Voorletters");
        GridPane.setHalignment(voorlettersLabel, HPos.RIGHT);
        persoonGegevensGrid.add(voorlettersLabel, 0, 1);

        TextField voorlettersField = new TextField();
        persoonGegevensGrid.add(voorlettersField, 1, 1);

        //achternaam
        Label achternaamLabel = new Label("Achternaam");
        GridPane.setHalignment(achternaamLabel, HPos.RIGHT);
        persoonGegevensGrid.add(achternaamLabel, 0, 2);

        TextField achternaamField = new TextField();
        persoonGegevensGrid.add(achternaamField, 1, 2);

        //adress
        Label adressLabel = new Label("Adres");
        GridPane.setHalignment(adressLabel, HPos.RIGHT);
        persoonGegevensGrid.add(adressLabel, 0, 3);

        TextField adressField = new TextField();
        persoonGegevensGrid.add(adressField, 1, 3);

        //vakantieadress
        Label vakantieAdressLabel = new Label("Vakantieadres");
        GridPane.setHalignment(vakantieAdressLabel, HPos.RIGHT);
        persoonGegevensGrid.add(vakantieAdressLabel, 0, 4);

        TextField vakantieAdressField = new TextField();
        persoonGegevensGrid.add(vakantieAdressField, 1, 4);

        //telefoon1
        Label phoneLabel = new Label("Telefoon 1");
        GridPane.setHalignment(phoneLabel, HPos.RIGHT);
        persoonGegevensGrid.add(phoneLabel, 0, 5);

        TextField phoneField = new TextField();
        persoonGegevensGrid.add(phoneField, 1, 5);

        //telefoon2
        Label phone2Label = new Label("Telefoon 2");
        GridPane.setHalignment(phone2Label, HPos.RIGHT);
        persoonGegevensGrid.add(phone2Label, 0, 6);

        TextField phone2Field = new TextField();
        persoonGegevensGrid.add(phone2Field, 1, 6);

        //email
        Label emailLabel = new Label("Email");
        GridPane.setHalignment(emailLabel, HPos.RIGHT);
        persoonGegevensGrid.add(emailLabel, 0, 7);

        TextField emailField = new TextField();
        persoonGegevensGrid.add(emailField, 1, 7);

        //vluchtnummer
        Label vluchtnummerLabel = new Label("Vluchtnummer");
        GridPane.setHalignment(vluchtnummerLabel, HPos.RIGHT);
        persoonGegevensGrid.add(vluchtnummerLabel, 0, 8);

        TextField vluchtnummerField = new TextField();
        persoonGegevensGrid.add(vluchtnummerField, 1, 8);

        //opmerkingen
        Label persoonCommentLabel = new Label("Opmerkingen");
        GridPane.setHalignment(persoonCommentLabel, HPos.RIGHT);
        persoonGegevensGrid.add(persoonCommentLabel, 0, 9);

        TextField persoonCommentField = new TextField();
        persoonGegevensGrid.add(persoonCommentField, 1, 9);

        Button save2 = new Button();
        save2.setText("Opslaan");
        GridPane.setHalignment(save2, HPos.RIGHT);
        persoonGegevensGrid.add(save2, 0, 10);
        
        //melding2
        Text melding2 = new Text();
        melding2.setText("Niet alle velden zijn ingevuld.");
        melding2.setFill(Color.RED);
        melding2.setVisible(false);
        persoonGegevensGrid.add(melding2, 0, 11);
        
        //succesMelding2
        Text succesMelding2 = new Text();
        succesMelding2.setText("Succesvol ingevoerd!");
        succesMelding2.setFill(Color.LIGHTGREEN);
        succesMelding2.setVisible(false);
        persoonGegevensGrid.add(succesMelding2, 0, 12);
        
        
        yesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                invoerTabs.setDisable(false);
                if (invoerTabs.getSelectionModel().getSelectedItem().getText().equals("Koffergegevens"))
            {
                System.out.println(dp.getValue());

                    String date1 = dp.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    String merk = brandField.getText();

                    System.out.println(date1);
                    ResultSet idget = sql.select("SELECT * FROM bagage ORDER BY idbagage DESC LIMIT 1;");
                    int id = 0;
                    try {
                        if (idget.next()) {
                            id = idget.getInt("idbagage");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    System.out.println("INSERT INTO bagtrack.bagage (idbagage,merk,kleur1,kleur2,soort,opdruk,luchthaven,datum,labelnummer,opmerkingen) VALUES ('" + 50 + "','" + date1 + "','"
                            + merk + "','" + color1Box.getValue() + "','" + color2Box.getValue() + "','" + typeBagBox.getValue()
                            + "','" + graphicBox.getValue() + "','" + airportBox.getValue() + "','" + date1 + "','" + numberField.getText()
                            + "','" + commentField.getText() + "');");

                    sql.insert("INSERT INTO bagtrack.bagage (idbagage,merk,kleur1,kleur2,soort,opdruk,luchthaven,datum,labelnummer,opmerkingen) VALUES ('" + (id + 1) + "','"
                            + merk + "','" + color1Box.getValue() + "','" + color2Box.getValue() + "','" + typeBagBox.getValue()
                            + "','" + graphicBox.getValue() + "','" + airportBox.getValue() + "','" + date1 + "','" + numberField.getText()
                            + "','" + commentField.getText() + "');");
                    
                    Statistiekenscherm.addPieData();
            }
                if (invoerTabs.getSelectionModel().getSelectedItem().getText().equals("Persoongegevens"))
            {
                System.out.println(dp.getValue());

                ResultSet idget = sql.select("SELECT * FROM persoonsgegevens ORDER BY idpersoonsgegevens DESC LIMIT 1;");
                int id = 0;
                try {
                    if (idget.next()) {
                        id = idget.getInt("idpersoonsgegevens");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

                System.out.println("INSERT INTO bagtrack.persoonsgegevens (idpersoonsgegevens,voornaam,voorletter,achternaam,adress,vakantieadress,telefoon1,telefoon2,email,vluchtnummer,opmerkingen,idbagage) VALUES ('" + (id + 1) + "','"
                        + voornaamField.getText() + "','" + voorlettersField.getText() + "','" + achternaamField.getText() + "','" + adressField.getText()
                        + "','" + vakantieAdressField.getText() + "','" + phoneField.getText() + "','" + phone2Field.getText() + "','" + emailField.getText()
                        + "','" + vluchtnummerField.getText() + "','" + persoonCommentField.getText() + "','" + "" + "');");

                sql.insert("INSERT INTO bagtrack.persoonsgegevens (idpersoonsgegevens,voornaam,voorletter,achternaam,adress,vakantieadress,telefoon1,telefoon2,email,vluchtnummer,opmerkingen,idbagage) VALUES ('" + (id + 1) + "','"
                        + voornaamField.getText() + "','" + voorlettersField.getText() + "','" + achternaamField.getText() + "','" + adressField.getText()
                        + "','" + vakantieAdressField.getText() + "','" + phoneField.getText() + "','" + phone2Field.getText() + "','" + emailField.getText()
                        + "','" + vluchtnummerField.getText() + "','" + persoonCommentField.getText() + "','" + "" + "');");

            }

                    
                popup.setVisible(false);
                succesMelding.setVisible(true);
            }
        });
        
        noButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popup.setVisible(false);
                invoerTabs.setDisable(false);
            }
        });

        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (dp.getValue() == null) {
                    dp.setStyle("-fx-background-color: tomato;");
                    melding1.setVisible(true);
                } else {
                    dp.setStyle("");
                }

                if (airportBox.getValue() == null) {
                    airportBox.setStyle("-fx-background-color: tomato;");
                    melding1.setVisible(true);
                } else {
                    airportBox.setStyle("");
                }

                if (typeBagBox.getValue() == null) {
                    typeBagBox.setStyle("-fx-background-color: tomato;");
                    melding1.setVisible(true);
                } else {
                    typeBagBox.setStyle("");
                }

                if (brandField.getText().trim().equals("")) {
                    brandField.setStyle("-fx-background-color: tomato;");
                    melding1.setVisible(true);
                } else {
                    brandField.setStyle("");
                }

                if (color1Box.getValue() == null) {
                    color1Box.setStyle("-fx-background-color: tomato;");
                    melding1.setVisible(true);
                } else {
                    color1Box.setStyle("");
                }

                if (graphicBox.getValue() == null) {
                    graphicBox.setStyle("-fx-background-color: tomato;");
                    melding1.setVisible(true);
                } else {
                    graphicBox.setStyle("");
                }

                if (dp.getValue() != null && airportBox.getValue() != null && typeBagBox.getValue() != null && !brandField.getText().trim().equals("") && color1Box.getValue() != null && graphicBox.getValue() != null) {
                    melding1.setVisible(false);
                    popup.setVisible(true);
                    invoerTabs.setDisable(true);
                    
                }
            }
        });

        
        
        //clear
        Button clear = new Button();
        clear.setText("Leegmaken");
        kofferGegevensGrid.add(clear, 1, 8);
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                dp.setValue(date);
                airportBox.setValue(null);
                typeBagBox.setValue(null);
                brandField.setText(null);
                color1Box.setValue(null);
                color2Box.setValue(null);
                graphicBox.setValue(null);
                commentField.setText(null);
                numberField.setText(null);
            }
        });

        
        
        
        save2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (voornaamField.getText().trim().equals("")) {
                    voornaamField.setStyle("-fx-background-color: tomato;");
                    melding2.setVisible(true);
                } else {
                    voornaamField.setStyle("");
                }

                if (voorlettersField.getText().trim().equals("")) {
                    voorlettersField.setStyle("-fx-background-color: tomato;");
                    melding2.setVisible(true);
                } else {
                    voorlettersField.setStyle("");
                }

                if (achternaamField.getText().trim().equals("")) {
                    achternaamField.setStyle("-fx-background-color: tomato;");
                    melding2.setVisible(true);
                } else {
                    achternaamField.setStyle("");
                }

                if (adressField.getText().trim().equals("")) {
                    adressField.setStyle("-fx-background-color: tomato;");
                    melding2.setVisible(true);
                } else {
                    adressField.setStyle("");
                }

                if (phoneField.getText().trim().equals("")) {
                    phoneField.setStyle("-fx-background-color: tomato;");
                    melding2.setVisible(true);
                } else {
                    phoneField.setStyle("");
                }

                if (emailField.getText().trim().equals("")) {
                    emailField.setStyle("-fx-background-color: tomato;");
                    melding2.setVisible(true);
                } else {
                    emailField.setStyle("");
                }
                
                if (!voornaamField.getText().trim().equals("") && !voorlettersField.getText().trim().equals("") && !achternaamField.getText().trim().equals("") && !adressField.getText().trim().equals("") && !phoneField.getText().trim().equals("") && !phone2Field.getText().trim().equals("") && !phoneField.getText().trim().equals("")) {

                    melding2.setVisible(false);
                    popup.setVisible(true);
                    invoerTabs.setDisable(true);
                
            }}
        });
        //clear
        Button clearPersoon = new Button();
        clearPersoon.setText("Leegmaken");
        persoonGegevensGrid.add(clearPersoon, 1, 10);
        clearPersoon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                voornaamField.setText(null);
                voorlettersField.setText(null);
                achternaamField.setText(null);
                adressField.setText(null);
                vakantieAdressField.setText(null);
                phoneField.setText(null);
                phone2Field.setText(null);
                emailField.setText(null);
                vluchtnummerField.setText(null);
                persoonCommentField.setText(null);
            }
        });

        

        Tab kofferGegevens = new Tab();
        kofferGegevens.setText("Koffergegevens");
        kofferGegevens.setClosable(false);
        Tab persoonGegevens = new Tab();
        persoonGegevens.setText("Persoongegevens");
        persoonGegevens.setClosable(false);

        kofferGegevens.setContent(kofferGegevensGrid);
        persoonGegevens.setContent(persoonGegevensGrid);
        invoerTabs.getTabs().addAll(kofferGegevens, persoonGegevens);
        
        
        stack.getChildren().addAll(invoerTabs, popup);
        return stack;
    }
    
    public static GridPane matchPersoon(String idbagage){
         
        GridPane persoonGegevensGrid = new GridPane();
        
        Label lblid = new Label(idbagage);
        persoonGegevensGrid.add(lblid, 0, 20);
        
        //Voornaam
        Label voornaamLabel = new Label("Voornaam");
        GridPane.setHalignment(voornaamLabel, HPos.RIGHT);
        persoonGegevensGrid.add(voornaamLabel, 0, 0);
        
        TextField voornaamField = new TextField();
        persoonGegevensGrid.add(voornaamField, 1, 0);
        
        //Voorletters
        Label voorlettersLabel = new Label("Voorletters");
        GridPane.setHalignment(voorlettersLabel, HPos.RIGHT);
        persoonGegevensGrid.add(voorlettersLabel, 0, 1);
        
        TextField voorlettersField = new TextField();
        persoonGegevensGrid.add(voorlettersField, 1, 1);
        
        //achternaam
        Label achternaamLabel = new Label("Achternaam");
        GridPane.setHalignment(achternaamLabel, HPos.RIGHT);
        persoonGegevensGrid.add(achternaamLabel, 0, 2);
        
        TextField achternaamField = new TextField();
        persoonGegevensGrid.add(achternaamField, 1, 2);
        
        //adress
        Label adressLabel = new Label("Adres");
        GridPane.setHalignment(adressLabel, HPos.RIGHT);
        persoonGegevensGrid.add(adressLabel, 0, 3);
        
        TextField adressField = new TextField();
        persoonGegevensGrid.add(adressField, 1, 3);
        
        //vakantieadress
        Label vakantieAdressLabel = new Label("Vakantieadres");
        GridPane.setHalignment(vakantieAdressLabel, HPos.RIGHT);
        persoonGegevensGrid.add(vakantieAdressLabel, 0, 4);
        
        TextField vakantieAdressField = new TextField();
        persoonGegevensGrid.add(vakantieAdressField, 1, 4);
        
        //telefoon1
        Label phoneLabel = new Label("Telefoon 1");
        GridPane.setHalignment(phoneLabel, HPos.RIGHT);
        persoonGegevensGrid.add(phoneLabel, 0, 5);
        
        TextField phoneField = new TextField();
        persoonGegevensGrid.add(phoneField, 1, 5);
        
        //telefoon2
        Label phone2Label = new Label("Telefoon 2");
        GridPane.setHalignment(phone2Label, HPos.RIGHT);
        persoonGegevensGrid.add(phone2Label, 0, 6);
        
        TextField phone2Field = new TextField();
        persoonGegevensGrid.add(phone2Field, 1, 6);
        
        //email
        Label emailLabel = new Label("Email");
        GridPane.setHalignment(emailLabel, HPos.RIGHT);
        persoonGegevensGrid.add(emailLabel, 0, 7);
        
        TextField emailField = new TextField();
        persoonGegevensGrid.add(emailField, 1, 7);
        
        //vluchtnummer
        Label vluchtnummerLabel = new Label("Vluchtnummer");
        GridPane.setHalignment(vluchtnummerLabel, HPos.RIGHT);
        persoonGegevensGrid.add(vluchtnummerLabel, 0, 8);
        
        TextField vluchtnummerField = new TextField();
        persoonGegevensGrid.add(vluchtnummerField, 1, 8);
        
        
        //opmerkingen
        Label persoonCommentLabel = new Label("Opmerkingen");
        GridPane.setHalignment(persoonCommentLabel, HPos.RIGHT);
        persoonGegevensGrid.add(persoonCommentLabel, 0, 9);
        
        TextField persoonCommentField = new TextField();
        persoonGegevensGrid.add(persoonCommentField, 1, 9);
                
        //melding2
        Text melding2 = new Text();
        melding2.setText("Niet alle velden zijn ingevuld.");
        melding2.setFill(Color.RED);
        melding2.setVisible(false);
        persoonGegevensGrid.add(melding2, 0, 11);
        
        //succesMelding2
        Text succesMelding2 = new Text();
        succesMelding2.setText("Succesvol ingevoerd!");
        succesMelding2.setFill(Color.LIGHTGREEN);
        succesMelding2.setVisible(false);
        persoonGegevensGrid.add(succesMelding2, 0, 12);
        
        Button save2 = new Button();
        save2.setText("Opslaan");
        GridPane.setHalignment(save2, HPos.LEFT);
        persoonGegevensGrid.add(save2, 0, 10);
        save2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if (voornaamField.getText().trim().equals("")) {
                    voornaamField.setStyle("-fx-background-color: tomato;");
                    melding2.setVisible(true);
                } else {
                    voornaamField.setStyle("");
                }

                if (voorlettersField.getText().trim().equals("")) {
                    voorlettersField.setStyle("-fx-background-color: tomato;");
                    melding2.setVisible(true);
                } else {
                    voorlettersField.setStyle("");
                }

                if (achternaamField.getText().trim().equals("")) {
                    achternaamField.setStyle("-fx-background-color: tomato;");
                    melding2.setVisible(true);
                } else {
                    achternaamField.setStyle("");
                }

                if (adressField.getText().trim().equals("")) {
                    adressField.setStyle("-fx-background-color: tomato;");
                    melding2.setVisible(true);
                } else {
                    adressField.setStyle("");
                }

                if (phoneField.getText().trim().equals("")) {
                    phoneField.setStyle("-fx-background-color: tomato;");
                    melding2.setVisible(true);
                } else {
                    phoneField.setStyle("");
                }

                if (emailField.getText().trim().equals("")) {
                    emailField.setStyle("-fx-background-color: tomato;");
                    melding2.setVisible(true);
                } else {
                    emailField.setStyle("");
                }
                
                if (!voornaamField.getText().trim().equals("") && !voorlettersField.getText().trim().equals("") && !achternaamField.getText().trim().equals("") && !adressField.getText().trim().equals("") && !phoneField.getText().trim().equals("") && !phone2Field.getText().trim().equals("") && !phoneField.getText().trim().equals("")) {
                    
               
                ResultSet idget = sql.select("SELECT * FROM persoonsgegevens ORDER BY idpersoonsgegevens DESC LIMIT 1;");
                int id = 0;
                try {
                    if (idget.next()) {
                        id = idget.getInt("idpersoonsgegevens");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                
                System.out.println("INSERT INTO bagtrack.persoonsgegevens (idpersoonsgegevens,voornaam,voorletter,achternaam,adress,vakantieadress,telefoon1,telefoon2,email,vluchtnummer,opmerkingen,idbagage) VALUES ('"+ (id+1) +"','" + 
                        voornaamField.getText() + "','" + voorlettersField.getText() + "','"+ achternaamField.getText() + "','"+ adressField.getText() +
                        "','"+ vakantieAdressField.getText() + "','"+ phoneField.getText() + "','" + phone2Field.getText() + "','"+ emailField.getText() +
                        "','"+ vluchtnummerField.getText()+ "','" + persoonCommentField.getText() + "','"+ ""+"');");

              
                
                sql.insert("INSERT INTO bagtrack.persoonsgegevens (idpersoonsgegevens,voornaam,voorletter,achternaam,adress,vakantieadress,telefoon1,telefoon2,email,vluchtnummer,opmerkingen,idbagage) VALUES ('"+ (id+1) +"','" + 
                        voornaamField.getText() + "','" + voorlettersField.getText() + "','"+ achternaamField.getText() + "','"+ adressField.getText() +
                        "','"+ vakantieAdressField.getText() + "','"+ phoneField.getText() + "','" + phone2Field.getText() + "','"+ emailField.getText() +
                        "','"+ vluchtnummerField.getText()+ "','" + persoonCommentField.getText() + "','"+ idbagage +"');");
                
               }
            }
        });
        //clear
        Button clearPersoon = new Button();
        clearPersoon.setText("Leegmaken");
        persoonGegevensGrid.add(clearPersoon, 1, 10);
        clearPersoon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                voornaamField.setText(null);
                voorlettersField.setText(null);
                achternaamField.setText(null);
                adressField.setText(null);
                vakantieAdressField.setText(null);
                phoneField.setText(null);
                phone2Field.setText(null);
                emailField.setText(null);
                vluchtnummerField.setText(null);
                persoonCommentField.setText(null);
            }
        });
        
        return persoonGegevensGrid;
    }
}
