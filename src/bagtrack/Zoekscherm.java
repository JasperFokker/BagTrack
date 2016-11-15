package bagtrack;

import java.util.Objects;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;

/**
 *
 * @author Rick
 */
public class Zoekscherm extends Application {

    @Override
    public void start(Stage primaryStage) {

        returnScherm();
    }

    public static GridPane returnScherm() {

        //Zoekscherm met dropdown boxen en textfield
        GridPane scherm = new GridPane();
        scherm.setPrefSize(600, 450);
        scherm.setHgap(1);
        scherm.setVgap(10);
        scherm.setPadding(new Insets(25, 25, 25, 25));

        //Inhoud 1e combobox
        ObservableList<String> kleuren = FXCollections.observableArrayList(
                "Blauw",
                "Rood",
                "Zwart",
                "Bruin",
                "Paars"
        );
        //Inhoud 2e combobox
        ObservableList<String> luchthaven = FXCollections.observableArrayList(
                "AMS",
                "ADA",
                "KYA"
        );
        //Inhoud 3e combobox
        ObservableList<String> soort = FXCollections.observableArrayList(
                "Tas",
                "Koffer",
                "Zak"
        );
        //Inhoud 4e combobox
        ObservableList<String> opdruk = FXCollections.observableArrayList(
                "Effen kleur",
                "Afbeelding",
                "Patroon"
        );

        //Labels, Textvelden, buttons en comboboxen.
        final ComboBox comboBoxKleur = new ComboBox(kleuren);
        final ComboBox comboBoxLuchthaven = new ComboBox(luchthaven);
        final ComboBox comboBoxSoort = new ComboBox(soort);
        final ComboBox comboBoxOpdruk = new ComboBox(opdruk);

        TextField textveldNaam = new TextField();
        TextField textveldMerk = new TextField();
        TextField textveldGewicht = new TextField();
        textveldGewicht.setPromptText("In Kilogrammen");

        Label label = new Label();
        label.setText("Naam:");

        Label label2 = new Label();
        label2.setText("Merk:");

        Label label3 = new Label();
        label3.setText("Kleur:");

        Label label4 = new Label();
        label4.setText("Luchthaven: ");

        Label label5 = new Label();
        label5.setText("Gewicht:");

        Label label6 = new Label();
        label6.setText("Soort:");

        Label label7 = new Label("Opdruk");

        Button btn = new Button("Zoek");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textveldNaam.setText(null);
                textveldMerk.setText(null);
                comboBoxKleur.setValue(null);
                comboBoxLuchthaven.setValue(null);
                textveldGewicht.setText(null);
                comboBoxSoort.setValue(null);
                comboBoxOpdruk.setValue(null);

                Main.change(Zoekscherm.returnScherm2());

            }
        });

        //Dit kan korter, geen idee hoe.
        scherm.add(label, 0, 0);
        scherm.add(label2, 0, 1);
        scherm.add(label3, 0, 2);
        scherm.add(label4, 0, 3);
        scherm.add(label5, 0, 4);
        scherm.add(label6, 0, 5);
        scherm.add(label7, 0, 6);
        scherm.add(textveldNaam, 1, 0);
        scherm.add(textveldMerk, 1, 1);
        scherm.add(comboBoxKleur, 1, 2);
        scherm.add(comboBoxLuchthaven, 1, 3);
        scherm.add(textveldGewicht, 1, 4);
        scherm.add(comboBoxSoort, 1, 5);
        scherm.add(comboBoxOpdruk, 1, 6);
        scherm.add(btn, 1, 7);

        return scherm;

    }

    public static GridPane returnScherm2() {
        //Tabelscherm dat linkt naar Tabeldata.java 
        GridPane scherm2 = new GridPane();
        scherm2.setPrefSize(600, 450);

        ObservableList<Tabeldata> data = FXCollections.observableArrayList(
                new Tabeldata("Anna de Bruin", "Samsonite", "Blauw", "AMS", "17 KG", "Tas", "Effen Kleur"),
                new Tabeldata("Johann Visser", "Visconti", "Zwart", "ADA", "21 KG", "Koffer", "Geen"),
                new Tabeldata("Robin van Dijk", "Lacoste", "Rood", "AMS", "24 KG", "Zak", "Geen"),
                new Tabeldata("Melissa Watergang", "SuperTrash", "Paars", "KYA", "15 KG", "Koffer", "Patroon"),
                new Tabeldata("Dennis Bakker", "Converse", "Bruin", "ADA", "12 KG", "Tas", "Geen")
        );

        final Label label = new Label("Zoekresultaten");
        label.setFont(new Font("Arial", 18));
        GridPane.setHalignment(label, HPos.CENTER);

        final TableView table = new TableView();
        table.setEditable(true);
        table.setPrefWidth(1170);
        table.setPrefHeight(680);

        //Dit werkt, vraag me niet hoe.
        TableColumn naamCol = new TableColumn("Naam");
        naamCol.setCellValueFactory(new PropertyValueFactory<Tabeldata, String>("Naam"));

        TableColumn merkCol = new TableColumn("Merk");
        merkCol.setCellValueFactory(new PropertyValueFactory<Tabeldata, String>("Merk"));

        TableColumn kleurCol = new TableColumn("Kleur");
        kleurCol.setCellValueFactory(new PropertyValueFactory<Tabeldata, String>("Kleur"));

        TableColumn luchthavenCol = new TableColumn("Luchthaven");
        luchthavenCol.setCellValueFactory(new PropertyValueFactory<Tabeldata, String>("Luchthaven"));

        TableColumn gewichtCol = new TableColumn("Gewicht");
        gewichtCol.setCellValueFactory(new PropertyValueFactory<Tabeldata, String>("Gewicht"));

        TableColumn soortCol = new TableColumn("Soort");
        soortCol.setCellValueFactory(new PropertyValueFactory<Tabeldata, String>("Soort"));

        TableColumn opdrukCol = new TableColumn("Opdruk");
        opdrukCol.setCellValueFactory(new PropertyValueFactory<Tabeldata, String>("Opdruk"));

        //Verdeeld de colommen gelijk over de gridpane.
        naamCol.prefWidthProperty().bind(table.widthProperty().multiply(0.14));
        merkCol.prefWidthProperty().bind(table.widthProperty().multiply(0.14));
        kleurCol.prefWidthProperty().bind(table.widthProperty().multiply(0.14));
        luchthavenCol.prefWidthProperty().bind(table.widthProperty().multiply(0.14));
        gewichtCol.prefWidthProperty().bind(table.widthProperty().multiply(0.14));
        soortCol.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        opdrukCol.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        table.setItems(data);
        table.getColumns().addAll(naamCol, merkCol, kleurCol, luchthavenCol, gewichtCol, soortCol, opdrukCol);

        scherm2.add(label, 0, 0);
        scherm2.add(table, 0, 1);

        return scherm2;

    }

}
