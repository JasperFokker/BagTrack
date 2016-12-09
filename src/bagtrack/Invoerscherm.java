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

        LocalDate datum = LocalDate.now();
        DatePicker datumKiezer = new DatePicker(datum);

        //datum
        Label datumLabel = new Label("Datum");

        //luchthaven
        Label luchthavenLabel = new Label("Luchthaven");

        ObservableList<String> luchthaven
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
        final ComboBox luchthavenComboBox = new ComboBox(luchthaven);

        //combobox soort
        Label kofferSoortLabel = new Label("Soort");

        ObservableList<String> kofferSoort
                = FXCollections.observableArrayList(
                        "Koffer",
                        "Trolley",
                        "Tas",
                        "Zak"
                );
        final ComboBox kofferSoortComboBox = new ComboBox(kofferSoort);

        //invoer merk
        Label kofferMerk = new Label("Merk");

        TextField kofferMerkField = new TextField();

        //comboboxes kleur
        Label kofferKleur1Label = new Label("Kleur 1");

        ObservableList<String> kofferKleur
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
        final ComboBox kofferKleur1ComboBox = new ComboBox(kofferKleur);
        kofferKleur1ComboBox.setVisibleRowCount(12);

        Label KofferKleur2Label = new Label("Kleur 2");

        final ComboBox kofferKleur2ComboBox = new ComboBox(kofferKleur);
        kofferKleur2ComboBox.setVisibleRowCount(12);

        //combobox opdruk
        Label kofferOpdrukLabel = new Label("Opdruk");

        ObservableList<String> kofferOpdruk
                = FXCollections.observableArrayList(
                        "Effen kleur",
                        "Afbeelding",
                        "Patroon"
                );
        final ComboBox kofferOpdrukComboBox = new ComboBox(kofferOpdruk);

        //invoer labelnummer
        Label kofferLabelnummerLabel = new Label("Labelnummer");

        TextField kofferLabelnummerField = new TextField();

        //invoer opmerkingen
        Label kofferOpmerkingenLabel = new Label("Opmerkingen");

        TextField kofferOpmerkingenField = new TextField();

        //melding1
        Text foutMelding = new Text();
        foutMelding.setText("Niet alle velden zijn ingevuld.");
        foutMelding.setFill(Color.RED);
        foutMelding.setVisible(false);

        //succesMelding2
        Text succesMelding = new Text();
        succesMelding.setText("Succesvol ingevoerd!");
        succesMelding.setFill(Color.LIGHTGREEN);
        succesMelding.setVisible(false);

        Label bevestigLabel = new Label("Weet je zeker dat je dit wilt toevoegen?");

        //Voornaam
        Label voornaamLabel = new Label("Voornaam");

        TextField voornaamField = new TextField();

        //Voorletters
        Label voorlettersLabel = new Label("Voorletters");

        TextField voorlettersField = new TextField();

        //achternaam
        Label achternaamLabel = new Label("Achternaam");

        TextField achternaamField = new TextField();

        //adress
        Label adresLabel = new Label("Adres");

        TextField adresField = new TextField();

        //vakantieadress
        Label vakantieAdresLabel = new Label("Vakantieadres");

        TextField vakantieAdresField = new TextField();

        //telefoon1
        Label telefoon1Label = new Label("Telefoon 1");

        TextField telefoon1Field = new TextField();

        //telefoon2
        Label telefoon2Label = new Label("Telefoon 2");

        TextField telefoon2Field = new TextField();

        //email
        Label emailLabel = new Label("Email");

        TextField emailField = new TextField();

        //vluchtnummer
        Label vluchtnummerLabel = new Label("Vluchtnummer");

        TextField vluchtnummerField = new TextField();

        //opmerkingen
        Label persoonOpmerkingenLabel = new Label("Opmerkingen");

        TextField persoonOpmerkingenField = new TextField();

        //melding2
        Text foutMelding2 = new Text();
        foutMelding2.setText("Niet alle velden zijn ingevuld.");
        foutMelding2.setFill(Color.RED);
        foutMelding2.setVisible(false);

        //succesMelding2
        Text succesMelding2 = new Text();
        succesMelding2.setText("Succesvol ingevoerd!");
        succesMelding2.setFill(Color.LIGHTGREEN);
        succesMelding2.setVisible(false);

        //koffer clear knop
        Button kofferGegevensWisButton = new Button();
        kofferGegevensWisButton.setText("Leegmaken");
        kofferGegevensWisButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                datumKiezer.setValue(datum);
                luchthavenComboBox.setValue(null);
                kofferSoortComboBox.setValue(null);
                kofferMerkField.setText(null);
                kofferKleur1ComboBox.setValue(null);
                kofferKleur2ComboBox.setValue(null);
                kofferOpdrukComboBox.setValue(null);
                kofferOpmerkingenField.setText(null);
                kofferLabelnummerField.setText(null);
            }
        });

        //persoon clear
        Button persoonWissenButton = new Button();
        persoonWissenButton.setText("Leegmaken");
        persoonWissenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                voornaamField.setText(null);
                voorlettersField.setText(null);
                achternaamField.setText(null);
                adresField.setText(null);
                vakantieAdresField.setText(null);
                telefoon1Field.setText(null);
                telefoon2Field.setText(null);
                emailField.setText(null);
                vluchtnummerField.setText(null);
                persoonOpmerkingenField.setText(null);
            }
        });

        Group popup = new Group();
        TabPane invoerTabs = new TabPane();

        //koffer opslaan knop
        Button kofferOpslaanButton = new Button();
        kofferOpslaanButton.setText("Opslaan");
        kofferOpslaanButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (datumKiezer.getValue() == null) {
                    datumKiezer.setStyle("-fx-background-color: tomato;");
                    foutMelding.setVisible(true);
                } else {
                    datumKiezer.setStyle("");
                }

                if (luchthavenComboBox.getValue() == null) {
                    luchthavenComboBox.setStyle(
                            "-fx-background-color: tomato;");
                    foutMelding.setVisible(true);
                } else {
                    luchthavenComboBox.setStyle("");
                }

                if (kofferSoortComboBox.getValue() == null) {
                    kofferSoortComboBox.setStyle(
                            "-fx-background-color: tomato;");
                    foutMelding.setVisible(true);
                } else {
                    kofferSoortComboBox.setStyle("");
                }

                if (kofferMerkField.getText().trim().equals("")) {
                    kofferMerkField.setStyle("-fx-background-color: tomato;");
                    foutMelding.setVisible(true);
                } else {
                    kofferMerkField.setStyle("");
                }

                if (kofferKleur1ComboBox.getValue() == null) {
                    kofferKleur1ComboBox.setStyle(
                            "-fx-background-color: tomato;");
                    foutMelding.setVisible(true);
                } else {
                    kofferKleur1ComboBox.setStyle("");
                }

                if (kofferOpdrukComboBox.getValue() == null) {
                    kofferOpdrukComboBox.setStyle(
                            "-fx-background-color: tomato;");
                    foutMelding.setVisible(true);
                } else {
                    kofferOpdrukComboBox.setStyle("");
                }

                if (datumKiezer.getValue() != null
                        && luchthavenComboBox.getValue() != null
                        && kofferSoortComboBox.getValue() != null
                        && !kofferMerkField.getText().trim().equals("")
                        && kofferKleur1ComboBox.getValue() != null
                        && kofferOpdrukComboBox.getValue() != null) {
                    foutMelding.setVisible(false);
                    popup.setVisible(true);
                    invoerTabs.setDisable(true);

                }
            }
        });

        //persoon opslaan knop
        Button persoonOpslaanButton = new Button();
        persoonOpslaanButton.setText("Opslaan");
        GridPane.setHalignment(persoonOpslaanButton, HPos.RIGHT);
        persoonOpslaanButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (voornaamField.getText().trim().equals("")) {
                    voornaamField.setStyle("-fx-background-color: tomato;");
                    foutMelding2.setVisible(true);
                } else {
                    voornaamField.setStyle("");
                }

                if (voorlettersField.getText().trim().equals("")) {
                    voorlettersField.setStyle("-fx-background-color: tomato;");
                    foutMelding2.setVisible(true);
                } else {
                    voorlettersField.setStyle("");
                }

                if (achternaamField.getText().trim().equals("")) {
                    achternaamField.setStyle("-fx-background-color: tomato;");
                    foutMelding2.setVisible(true);
                } else {
                    achternaamField.setStyle("");
                }

                if (adresField.getText().trim().equals("")) {
                    adresField.setStyle("-fx-background-color: tomato;");
                    foutMelding2.setVisible(true);
                } else {
                    adresField.setStyle("");
                }

                if (telefoon1Field.getText().trim().equals("")) {
                    telefoon1Field.setStyle("-fx-background-color: tomato;");
                    foutMelding2.setVisible(true);
                } else {
                    telefoon1Field.setStyle("");
                }

                if (emailField.getText().trim().equals("")) {
                    emailField.setStyle("-fx-background-color: tomato;");
                    foutMelding2.setVisible(true);
                } else {
                    emailField.setStyle("");
                }

                if (!voornaamField.getText().trim().equals("")
                        && !voorlettersField.getText().trim().equals("")
                        && !achternaamField.getText().trim().equals("")
                        && !adresField.getText().trim().equals("")
                        && !telefoon1Field.getText().trim().equals("")
                        && !telefoon2Field.getText().trim().equals("")) {

                    foutMelding2.setVisible(false);
                    popup.setVisible(true);
                    invoerTabs.setDisable(true);

                }
            }
        });

        GridPane kofferGegevensPane = new GridPane();
        kofferGegevensPane.setHgap(10);
        kofferGegevensPane.setVgap(10);
        kofferGegevensPane.setPadding(new Insets(25, 25, 25, 25));

        kofferGegevensPane.add(datumLabel, 0, 0);
        kofferGegevensPane.add(datumKiezer, 1, 0);
        kofferGegevensPane.add(luchthavenLabel, 0, 1);
        kofferGegevensPane.add(luchthavenComboBox, 1, 1);
        kofferGegevensPane.add(kofferSoortLabel, 0, 2);
        kofferGegevensPane.add(kofferSoortComboBox, 1, 2);
        kofferGegevensPane.add(kofferMerk, 0, 3);
        kofferGegevensPane.add(kofferMerkField, 1, 3);
        kofferGegevensPane.add(kofferKleur1Label, 0, 4);
        kofferGegevensPane.add(kofferKleur1ComboBox, 1, 4);
        kofferGegevensPane.add(KofferKleur2Label, 2, 4);
        kofferGegevensPane.add(kofferKleur2ComboBox, 3, 4);
        kofferGegevensPane.add(kofferOpdrukLabel, 0, 5);
        kofferGegevensPane.add(kofferOpdrukComboBox, 1, 5);
        kofferGegevensPane.add(kofferLabelnummerLabel, 0, 6);
        kofferGegevensPane.add(kofferLabelnummerField, 1, 6);
        kofferGegevensPane.add(kofferOpmerkingenLabel, 0, 7);
        kofferGegevensPane.add(kofferOpmerkingenField, 1, 7);
        kofferGegevensPane.add(kofferOpslaanButton, 0, 8);
        kofferGegevensPane.add(foutMelding, 0, 9);
        kofferGegevensPane.add(succesMelding, 0, 10);
        kofferGegevensPane.add(kofferGegevensWisButton, 1, 8);

        GridPane persoonGegevensPane = new GridPane();
        persoonGegevensPane.setHgap(10);
        persoonGegevensPane.setVgap(10);
        persoonGegevensPane.setPadding(new Insets(25, 25, 25, 25));

        persoonGegevensPane.add(voornaamLabel, 0, 0);
        persoonGegevensPane.add(voornaamField, 1, 0);
        persoonGegevensPane.add(voorlettersLabel, 0, 1);
        persoonGegevensPane.add(voorlettersField, 1, 1);
        persoonGegevensPane.add(achternaamLabel, 0, 2);
        persoonGegevensPane.add(achternaamField, 1, 2);
        persoonGegevensPane.add(adresLabel, 0, 3);
        persoonGegevensPane.add(adresField, 1, 3);
        persoonGegevensPane.add(vakantieAdresLabel, 0, 4);
        persoonGegevensPane.add(vakantieAdresField, 1, 4);
        persoonGegevensPane.add(telefoon1Label, 0, 5);
        persoonGegevensPane.add(telefoon1Field, 1, 5);
        persoonGegevensPane.add(telefoon2Label, 0, 6);
        persoonGegevensPane.add(telefoon2Field, 1, 6);
        persoonGegevensPane.add(emailLabel, 0, 7);
        persoonGegevensPane.add(emailField, 1, 7);
        persoonGegevensPane.add(vluchtnummerLabel, 0, 8);
        persoonGegevensPane.add(vluchtnummerField, 1, 8);
        persoonGegevensPane.add(persoonOpmerkingenLabel, 0, 9);
        persoonGegevensPane.add(persoonOpmerkingenField, 1, 9);
        persoonGegevensPane.add(foutMelding2, 0, 11);
        persoonGegevensPane.add(succesMelding2, 0, 12);

        Tab kofferGegevens = new Tab();
        kofferGegevens.setText("Koffergegevens");
        kofferGegevens.setClosable(false);
        kofferGegevens.setContent(kofferGegevensPane);

        Tab persoonGegevens = new Tab();
        persoonGegevens.setText("Persoongegevens");
        persoonGegevens.setClosable(false);
        persoonGegevens.setContent(persoonGegevensPane);

        persoonGegevensPane.add(persoonWissenButton, 1, 10);
        persoonGegevensPane.add(persoonOpslaanButton, 0, 10);

        invoerTabs.getTabs().addAll(kofferGegevens, persoonGegevens);

        Rectangle popupVeld = new Rectangle(300, 100);
        popupVeld.setArcHeight(30);
        popupVeld.setArcWidth(30);
        popupVeld.setFill(Color.rgb(120, 120, 120));

        Button jaButton = new Button("Ja");
        jaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                invoerTabs.setDisable(false);
                if (invoerTabs.getSelectionModel().getSelectedItem().getText()
                        .equals("Koffergegevens")) {
                    System.out.println(datumKiezer.getValue());

                    String date1 = datumKiezer.getValue()
                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    String merk = kofferMerkField.getText();

                    System.out.println(date1);
                    ResultSet idget = sql.select("SELECT * FROM bagage ORDER "
                            + "BY idbagage DESC LIMIT 1;");
                    int id = 0;
                    try {
                        if (idget.next()) {
                            id = idget.getInt("idbagage");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    System.out.println("INSERT INTO bagtrack.bagage (idbagage,"
                            + "merk,kleur1,kleur2,soort,opdruk,luchthaven,"
                            + "datum,labelnummer,opmerkingen) VALUES ('" + 50
                            + "','" + date1 + "','" + merk + "','"
                            + kofferKleur1ComboBox.getValue() + "','"
                            + kofferKleur2ComboBox.getValue() + "','"
                            + kofferSoortComboBox.getValue() + "','"
                            + kofferOpdrukComboBox.getValue() + "','"
                            + luchthavenComboBox.getValue() + "','" + date1
                            + "','" + kofferLabelnummerField.getText() + "','"
                            + kofferOpmerkingenField.getText() + "');");

                    sql.insert("INSERT INTO bagtrack.bagage (idbagage,merk,"
                            + "kleur1,kleur2,soort,opdruk,luchthaven,datum,"
                            + "labelnummer,opmerkingen) VALUES ('" + (id + 1)
                            + "','" + merk + "','"
                            + kofferKleur1ComboBox.getValue() + "','"
                            + kofferKleur2ComboBox.getValue() + "','"
                            + kofferSoortComboBox.getValue() + "','"
                            + kofferOpdrukComboBox.getValue() + "','"
                            + luchthavenComboBox.getValue() + "','" + date1
                            + "','" + kofferLabelnummerField.getText() + "','"
                            + kofferOpmerkingenField.getText() + "');");
                    succesMelding.setVisible(true);
                    Statistiekenscherm.addPieData();
                }

                if (invoerTabs.getSelectionModel().getSelectedItem().getText()
                        .equals("Persoongegevens")) {
                    System.out.println(datumKiezer.getValue());

                    ResultSet idget = sql.select("SELECT * FROM "
                            + "persoonsgegevens ORDER BY idpersoonsgegevens "
                            + "DESC LIMIT 1;");
                    int id = 0;
                    try {
                        if (idget.next()) {
                            id = idget.getInt("idpersoonsgegevens");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    System.out.println("INSERT INTO bagtrack.persoonsgegevens ("
                            + "idpersoonsgegevens,voornaam,voorletter,"
                            + "achternaam,adress,vakantieadress,telefoon1,"
                            + "telefoon2,email,vluchtnummer,opmerkingen,"
                            + "idbagage) VALUES ('" + (id + 1) + "','"
                            + voornaamField.getText() + "','"
                            + voorlettersField.getText() + "','"
                            + achternaamField.getText() + "','"
                            + adresField.getText() + "','"
                            + vakantieAdresField.getText() + "','"
                            + telefoon1Field.getText() + "','"
                            + telefoon2Field.getText()
                            + "','" + emailField.getText() + "','"
                            + vluchtnummerField.getText() + "','"
                            + persoonOpmerkingenField.getText() + "','" + ""
                            + "');");

                sql.insert("INSERT INTO bagtrack.persoonsgegevens ("
                            + "idpersoonsgegevens,voornaam,voorletter,"
                            + "achternaam,adress,vakantieadress,telefoon1,"
                            + "telefoon2,email,vluchtnummer,opmerkingen)"
                            + " VALUES ('" + (id + 1) + "','"
                            + voornaamField.getText() + "','"
                            + voorlettersField.getText() + "','"
                            + achternaamField.getText() + "','"
                            + adresField.getText() + "','"
                            + vakantieAdresField.getText() + "','"
                            + telefoon1Field.getText() + "','"
                            + telefoon2Field.getText()
                            + "','" + emailField.getText() + "','"
                            + vluchtnummerField.getText() + "','"
                            + persoonOpmerkingenField.getText() + "');");
                    succesMelding2.setVisible(true);

                }

                popup.setVisible(false);
            }
        });

        Button neeButton = new Button("Nee");
        neeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popup.setVisible(false);
                invoerTabs.setDisable(false);
            }
        });

        GridPane popupPane = new GridPane();
        popupPane.setAlignment(Pos.CENTER);
        popupPane.setHgap(10);
        popupPane.setVgap(10);
        popupPane.setPadding(new Insets(25, 25, 25, 25));

        popupPane.add(bevestigLabel, 0, 0);
        popupPane.add(jaButton, 0, 1);
        popupPane.add(neeButton, 0, 1);

        popup.getChildren().addAll(popupVeld, popupPane);
        popup.setVisible(false);

        GridPane.setHalignment(datumLabel, HPos.RIGHT);
        GridPane.setHalignment(datumKiezer, HPos.RIGHT);
        GridPane.setHalignment(luchthavenLabel, HPos.RIGHT);
        GridPane.setHalignment(kofferSoortLabel, HPos.RIGHT);
        GridPane.setHalignment(kofferMerk, HPos.RIGHT);
        GridPane.setHalignment(kofferKleur1Label, HPos.RIGHT);
        GridPane.setHalignment(KofferKleur2Label, HPos.RIGHT);
        GridPane.setHalignment(kofferOpdrukLabel, HPos.RIGHT);
        GridPane.setHalignment(kofferLabelnummerLabel, HPos.RIGHT);
        GridPane.setHalignment(kofferOpmerkingenLabel, HPos.RIGHT);
        GridPane.setHalignment(kofferOpslaanButton, HPos.RIGHT);
        GridPane.setHalignment(neeButton, HPos.RIGHT);
        GridPane.setHalignment(voornaamLabel, HPos.RIGHT);
        GridPane.setHalignment(voorlettersLabel, HPos.RIGHT);
        GridPane.setHalignment(achternaamLabel, HPos.RIGHT);
        GridPane.setHalignment(adresLabel, HPos.RIGHT);
        GridPane.setHalignment(vakantieAdresLabel, HPos.RIGHT);
        GridPane.setHalignment(telefoon1Label, HPos.RIGHT);
        GridPane.setHalignment(telefoon2Label, HPos.RIGHT);
        GridPane.setHalignment(emailLabel, HPos.RIGHT);
        GridPane.setHalignment(vluchtnummerLabel, HPos.RIGHT);
        GridPane.setHalignment(persoonOpmerkingenLabel, HPos.RIGHT);

        StackPane stack = new StackPane();
        stack.getChildren().addAll(invoerTabs, popup);

        return stack;
    }

    public static GridPane matchPersoon(String idbagage) {

        Label bagageID = new Label(idbagage);

        //Voornaam
        Label voornaamLabel = new Label("Voornaam");

        TextField voornaamField = new TextField();

        //Voorletters
        Label voorlettersLabel = new Label("Voorletters");

        TextField voorlettersField = new TextField();

        //achternaam
        Label achternaamLabel = new Label("Achternaam");

        TextField achternaamField = new TextField();

        //adress
        Label adressLabel = new Label("Adres");

        TextField adressField = new TextField();

        //vakantieadress
        Label vakantieAdressLabel = new Label("Vakantieadres");

        TextField vakantieAdressField = new TextField();

        //telefoon1
        Label telefoon1Label = new Label("Telefoon 1");

        TextField telefoon1Field = new TextField();

        //telefoon2
        Label telefoon2Label = new Label("Telefoon 2");

        TextField telefoon2Field = new TextField();

        //email
        Label emailLabel = new Label("Email");

        TextField emailField = new TextField();

        //vluchtnummer
        Label vluchtnummerLabel = new Label("Vluchtnummer");

        TextField vluchtnummerField = new TextField();

        //opmerkingen
        Label persoonCommentLabel = new Label("Opmerkingen");

        TextField persoonCommentField = new TextField();

        //melding2
        Text foutMelding = new Text();
        foutMelding.setText("Niet alle velden zijn ingevuld.");
        foutMelding.setFill(Color.RED);
        foutMelding.setVisible(false);

        //succesMelding2
        Text succesMelding = new Text();
        succesMelding.setText("Succesvol ingevoerd!");
        succesMelding.setFill(Color.LIGHTGREEN);
        succesMelding.setVisible(false);

        //opslaan
        Button persoonOpslaan = new Button();
        persoonOpslaan.setText("Opslaan");
        GridPane.setHalignment(persoonOpslaan, HPos.LEFT);
        persoonOpslaan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (voornaamField.getText().trim().equals("")) {
                    voornaamField.setStyle("-fx-background-color: tomato;");
                    foutMelding.setVisible(true);
                } else {
                    voornaamField.setStyle("");
                }

                if (voorlettersField.getText().trim().equals("")) {
                    voorlettersField.setStyle("-fx-background-color: tomato;");
                    foutMelding.setVisible(true);
                } else {
                    voorlettersField.setStyle("");
                }

                if (achternaamField.getText().trim().equals("")) {
                    achternaamField.setStyle("-fx-background-color: tomato;");
                    foutMelding.setVisible(true);
                } else {
                    achternaamField.setStyle("");
                }

                if (adressField.getText().trim().equals("")) {
                    adressField.setStyle("-fx-background-color: tomato;");
                    foutMelding.setVisible(true);
                } else {
                    adressField.setStyle("");
                }

                if (telefoon1Field.getText().trim().equals("")) {
                    telefoon1Field.setStyle("-fx-background-color: tomato;");
                    foutMelding.setVisible(true);
                } else {
                    telefoon1Field.setStyle("");
                }

                if (emailField.getText().trim().equals("")) {
                    emailField.setStyle("-fx-background-color: tomato;");
                    foutMelding.setVisible(true);
                } else {
                    emailField.setStyle("");
                }

                if (!voornaamField.getText().trim().equals("")
                        && !voorlettersField.getText().trim().equals("")
                        && !achternaamField.getText().trim().equals("")
                        && !adressField.getText().trim().equals("")
                        && !telefoon1Field.getText().trim().equals("")
                        && !telefoon2Field.getText().trim().equals("")
                        && !telefoon1Field.getText().trim().equals("")) {

                    ResultSet idget = sql.select("SELECT * FROM "
                            + "persoonsgegevens ORDER BY idpersoonsgegevens "
                            + "DESC LIMIT 1;");
                    int id = 0;
                    try {
                        if (idget.next()) {
                            id = idget.getInt("idpersoonsgegevens");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    System.out.println("INSERT INTO bagtrack.persoonsgegevens "
                            + "(idpersoonsgegevens,voornaam,voorletter,"
                            + "achternaam,adress,vakantieadress,telefoon1,"
                            + "telefoon2,email,vluchtnummer,opmerkingen,"
                            + "idbagage) VALUES ('" + (id + 1) + "','"
                            + voornaamField.getText() + "','"
                            + voorlettersField.getText() + "','"
                            + achternaamField.getText() + "','"
                            + adressField.getText() + "','"
                            + vakantieAdressField.getText() + "','"
                            + telefoon1Field.getText() + "','"
                            + telefoon2Field.getText() + "','"
                            + emailField.getText() + "','"
                            + vluchtnummerField.getText() + "','"
                            + persoonCommentField.getText() + "','" + ""
                            + "');");

                    sql.insert("INSERT INTO bagtrack.persoonsgegevens "
                            + "(idpersoonsgegevens,voornaam,voorletter,"
                            + "achternaam,adress,vakantieadress,telefoon1,"
                            + "telefoon2,email,vluchtnummer,opmerkingen,"
                            + "idbagage) VALUES ('" + (id + 1) + "','"
                            + voornaamField.getText() + "','"
                            + voorlettersField.getText() + "','"
                            + achternaamField.getText() + "','"
                            + adressField.getText() + "','"
                            + vakantieAdressField.getText() + "','"
                            + telefoon1Field.getText() + "','"
                            + telefoon2Field.getText() + "','"
                            + emailField.getText() + "','"
                            + vluchtnummerField.getText() + "','"
                            + persoonCommentField.getText() + "','" + ""
                            + "');");

                }
            }
        });

        //clear
        Button persoonLegen = new Button();
        persoonLegen.setText("Leegmaken");
        persoonLegen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                voornaamField.setText(null);
                voorlettersField.setText(null);
                achternaamField.setText(null);
                adressField.setText(null);
                vakantieAdressField.setText(null);
                telefoon1Field.setText(null);
                telefoon2Field.setText(null);
                emailField.setText(null);
                vluchtnummerField.setText(null);
                persoonCommentField.setText(null);
            }
        });

        GridPane persoonGegevensPane = new GridPane();
        persoonGegevensPane.add(bagageID, 0, 20);
        persoonGegevensPane.add(voornaamLabel, 0, 0);
        persoonGegevensPane.add(voornaamField, 1, 0);
        persoonGegevensPane.add(voorlettersLabel, 0, 1);
        persoonGegevensPane.add(voorlettersField, 1, 1);
        persoonGegevensPane.add(achternaamLabel, 0, 2);
        persoonGegevensPane.add(achternaamField, 1, 2);
        persoonGegevensPane.add(adressLabel, 0, 3);
        persoonGegevensPane.add(adressField, 1, 3);
        persoonGegevensPane.add(vakantieAdressLabel, 0, 4);
        persoonGegevensPane.add(vakantieAdressField, 1, 4);
        persoonGegevensPane.add(telefoon1Label, 0, 5);
        persoonGegevensPane.add(telefoon1Field, 1, 5);
        persoonGegevensPane.add(telefoon2Label, 0, 6);
        persoonGegevensPane.add(telefoon2Field, 1, 6);
        persoonGegevensPane.add(emailLabel, 0, 7);
        persoonGegevensPane.add(emailField, 1, 7);
        persoonGegevensPane.add(vluchtnummerLabel, 0, 8);
        persoonGegevensPane.add(vluchtnummerField, 1, 8);
        persoonGegevensPane.add(persoonCommentLabel, 0, 9);
        persoonGegevensPane.add(persoonCommentField, 1, 9);
        persoonGegevensPane.add(foutMelding, 0, 11);
        persoonGegevensPane.add(succesMelding, 0, 12);
        persoonGegevensPane.add(persoonOpslaan, 0, 10);
        persoonGegevensPane.add(persoonLegen, 1, 10);

        GridPane.setHalignment(voornaamLabel, HPos.RIGHT);
        GridPane.setHalignment(voorlettersLabel, HPos.RIGHT);
        GridPane.setHalignment(achternaamLabel, HPos.RIGHT);
        GridPane.setHalignment(adressLabel, HPos.RIGHT);
        GridPane.setHalignment(vakantieAdressLabel, HPos.RIGHT);
        GridPane.setHalignment(telefoon1Label, HPos.RIGHT);
        GridPane.setHalignment(telefoon2Label, HPos.RIGHT);
        GridPane.setHalignment(emailLabel, HPos.RIGHT);
        GridPane.setHalignment(vluchtnummerLabel, HPos.RIGHT);
        GridPane.setHalignment(persoonCommentLabel, HPos.RIGHT);

        return persoonGegevensPane;
    }
}
