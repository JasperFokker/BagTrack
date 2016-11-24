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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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

    public static TabPane returnScherm() {


        GridPane kofferGegevensGrid = new GridPane();
        GridPane persoonGegevensGrid = new GridPane();
        
        VBox kofferGegevensBox = new VBox();
        VBox persoonGegevensBox = new VBox();
        
        kofferGegevensGrid.setHgap(10);
        kofferGegevensGrid.setVgap(10);
        kofferGegevensGrid.setPadding(new Insets(40, 20, 0, 160));
        
        persoonGegevensGrid.setHgap(10);
        persoonGegevensGrid.setVgap(10);
        persoonGegevensGrid.setPadding(new Insets(40, 20, 0, 160));
        
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
                        "AMS",
                        "ADA",
                        "KYA"
                );
        final ComboBox airportBox = new ComboBox(airport);
        kofferGegevensGrid.add(airportBox, 1, 1);

        //combobox soort
        Label typeBagLabel = new Label("Soort");
        GridPane.setHalignment(typeBagLabel, HPos.RIGHT);
        kofferGegevensGrid.add(typeBagLabel, 0, 2);

        ObservableList<String> typeBag
                = FXCollections.observableArrayList(
                        "Tas",
                        "Koffer",
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
                        "Rood",
                        "Blauw",
                        "Geel"
                );
        final ComboBox color1Box = new ComboBox(color);
        kofferGegevensGrid.add(color1Box, 1, 4);

        Label color2Label = new Label("Kleur 2");
        GridPane.setHalignment(color2Label, HPos.RIGHT);
        kofferGegevensGrid.add(color2Label, 2, 4);

        final ComboBox color2Box = new ComboBox(color);
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
        GridPane.setHalignment(save, HPos.LEFT);
        kofferGegevensGrid.add(save, 0, 8);
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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

                
                
                
                System.out.println("INSERT INTO bagtrack.bagage (idbagage,merk,kleur1,kleur2,soort,opdruk,luchthaven,datum,labelnummer,opmerkingen) VALUES ('"+ 50 +"','" + date1 + "','" +
                        merk + "','" + color1Box.getValue() + "','"+ color2Box.getValue() + "','"+ typeBagBox.getValue() +
                        "','"+ graphicBox.getValue() + "','"+ airportBox.getValue() + "','" + date1 + "','"+ numberField.getText() +
                        "','"+ commentField.getText() +"');");
                
                sql.insert("INSERT INTO bagtrack.bagage (idbagage,merk,kleur1,kleur2,soort,opdruk,luchthaven,datum,labelnummer,opmerkingen) VALUES ('"+ (id+1) +"','" + 
                        merk + "','" + color1Box.getValue() + "','"+ color2Box.getValue() + "','"+ typeBagBox.getValue() +
                        "','"+ graphicBox.getValue() + "','"+ airportBox.getValue() + "','" + date1 + "','"+ numberField.getText() +
                        "','"+ commentField.getText() +"');");
                

            }
        });

        //clear
        Button clear = new Button();
        clear.setText("Leegmaken");
        kofferGegevensGrid.add(clear, 1, 8);
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                dp.setValue(null);
                airportBox.setValue(null);
                typeBagBox.setValue(null);
                brandField.setText(null);
                color1Box.setValue(null);
                color2Box.setValue(null);
                graphicBox.setValue(null);
                commentField.setText(null);
            }
        });
        
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
        persoonGegevensGrid.add(vakantieAdressLabel, 0, 3);
        
        TextField vakantieAdressField = new TextField();
        persoonGegevensGrid.add(vakantieAdressField, 1, 3);
        
        //telefoon1
        Label phoneLabel = new Label("Telefoon 1");
        GridPane.setHalignment(phoneLabel, HPos.RIGHT);
        persoonGegevensGrid.add(phoneLabel, 0, 4);
        
        TextField phoneField = new TextField();
        persoonGegevensGrid.add(phoneField, 1, 4);
        
        //telefoon2
        Label phone2Label = new Label("Telefoon 2");
        GridPane.setHalignment(phone2Label, HPos.RIGHT);
        persoonGegevensGrid.add(phone2Label, 0, 5);
        
        TextField phone2Field = new TextField();
        persoonGegevensGrid.add(phone2Field, 1, 5);
        
        //email
        Label emailLabel = new Label("Email");
        GridPane.setHalignment(emailLabel, HPos.RIGHT);
        persoonGegevensGrid.add(emailLabel, 0, 6);
        
        TextField emailField = new TextField();
        persoonGegevensGrid.add(emailField, 1, 6);
        
        //vluchtnummer
        Label vluchtnummerLabel = new Label("Vluchtnummer");
        GridPane.setHalignment(vluchtnummerLabel, HPos.RIGHT);
        persoonGegevensGrid.add(vluchtnummerLabel, 0, 7);
        
        TextField vluchtnummerField = new TextField();
        persoonGegevensGrid.add(vluchtnummerField, 1, 7);
        
        
        //opmerkingen
        Label persoonCommentLabel = new Label("Opmerkingen");
        GridPane.setHalignment(persoonCommentLabel, HPos.RIGHT);
        persoonGegevensGrid.add(persoonCommentLabel, 0, 8);
        
        TextField persoonCommentField = new TextField();
        persoonGegevensGrid.add(persoonCommentField, 1, 8);
        
        //clear
        Button clearPersoon = new Button();
        clearPersoon.setText("Leegmaken");
        kofferGegevensGrid.add(clearPersoon, 1, 8);
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
                persoonCommentField.setText(null);
            }
        });
        
        TabPane invoerTabs = new TabPane();
        BorderPane persoonBorderPane = new BorderPane();

        Tab kofferGegevens = new Tab();
        kofferGegevens.setText("Koffergegevens");
        kofferGegevens.setClosable(false);
        Tab persoonGegevens = new Tab();
        persoonGegevens.setText("Persoongegevens");
        persoonGegevens.setClosable(false);
        
        kofferGegevensBox.setStyle("-fx-background-color: #333333;");
        persoonGegevensBox.setStyle("-fx-background-color: #333333;");
        
        kofferGegevensBox.getChildren().add(kofferGegevensGrid);
        persoonGegevensBox.getChildren().add(persoonGegevensGrid);
        kofferGegevens.setContent(kofferGegevensBox);
        persoonGegevens.setContent(persoonGegevensBox);
        invoerTabs.getTabs().addAll(kofferGegevens, persoonGegevens);
        
        persoonBorderPane.setCenter(invoerTabs);
        kofferGegevensGrid.getChildren().add(persoonBorderPane);

        return invoerTabs;
    }
}
