package bagtrack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Team Twee
 */
public class Helpscherm extends Application {

    @Override
    public void start(Stage primaryStage) {
        returnScherm();
    }

    public static GridPane returnScherm() {

        //titel
        Label vragenTitel = new Label("Informatie over:");
        vragenTitel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        vragenTitel.setAlignment(Pos.CENTER);

        //vraag 1
        TitledPane kofferZoek = new TitledPane();
        GridPane kofferZoekPane = new GridPane();
        kofferZoekPane.setHgap(10);
        kofferZoekPane.setVgap(10);
        kofferZoekPane.setPadding(new Insets(25, 25, 25, 25));
        Text kofferZoekText = new Text("Klik op de knop \"Zoeken\" en vul de"
                + "invoervelden in waarop u wilt zoeken.\n"
                + "Druk vervolgens op \"Zoek\" en er wordt een lijst met"
                + "koffers weergegeven die voldoen aan de informatie\n"
                + "die u ingevuld heeft in de invoervelden.");
        kofferZoekPane.add(kofferZoekText, 0, 0);
        kofferZoek.setText("Het zoeken naar koffers.");
        kofferZoek.setContent(kofferZoekPane);
        kofferZoek.setExpanded(false);

        //vraag 2
        TitledPane kofferInvoer = new TitledPane();
        GridPane kofferInvoerPane = new GridPane();
        kofferInvoerPane.setHgap(10);
        kofferInvoerPane.setVgap(10);
        kofferInvoerPane.setPadding(new Insets(25, 25, 25, 25));
        Text kofferInvoerText = new Text("Klik op de knop \"Invoer\" en vul de"
                + " invoer velden in waarvan u beschikt over de juiste"
                + " informatie\n"
                + "Velden waar u geen informatie over heeft, kunt u leeglaten."
                + " Klik vervolgens op \"Opslaan\" en \n"
                + "de door u ingevulde invoervelden worden opgeslagen in de"
                + "database.");
        kofferInvoerPane.add(kofferInvoerText, 0, 0);
        kofferInvoer.setText("Het invoeren van koffers.");
        kofferInvoer.setContent(kofferInvoerPane);
        kofferInvoer.setExpanded(false);

        //vraag 3
        TitledPane statistiekenInzien = new TitledPane();
        GridPane statistiekenInzienPane = new GridPane();
        statistiekenInzienPane.setHgap(10);
        statistiekenInzienPane.setVgap(10);
        statistiekenInzienPane.setPadding(new Insets(25, 25, 25, 25));
        Text statistiekenInzienText = new Text("Als u als manager bent inglogd,"
                + " kunt u de statistieken inzien.\n"
                + "Klik op de knop \"Statistieken\" om naar de statistieken\n"
                + "te gaan. Hier vindt u verschillende grafieken die informatie"
                + " verschaffen over het aantal gevonden koffers, waar de"
                + "koffers\n"
                + "gevonden en verloren zijn en andere statistieken");
        statistiekenInzienPane.add(statistiekenInzienText, 0, 0);
        statistiekenInzien.setText("Het inzien van de statistieken.");
        statistiekenInzien.setContent(statistiekenInzienPane);
        statistiekenInzien.setExpanded(false);

        //vraag 4
        TitledPane kofferMatchen = new TitledPane();
        GridPane kofferMatchenPane = new GridPane();
        kofferMatchenPane.setHgap(10);
        kofferMatchenPane.setVgap(10);
        kofferMatchenPane.setPadding(new Insets(25, 25, 25, 25));
        Text kofferMatchenText = new Text("Als u een verloren koffer gevonden"
                + "heeft, kunt u in de kolom \"Status\" de status veranderen"
                + "naar \n"
                + "gevonden. ");
        kofferMatchenPane.add(kofferMatchenText, 0, 0);
        kofferMatchen.setText("Het matchen van koffers.");
        kofferMatchen.setContent(kofferMatchenPane);
        kofferMatchen.setExpanded(false);

        //vraag 5
        TitledPane kofferVerwijderen = new TitledPane();
        GridPane kofferVerwijderenPane = new GridPane();
        kofferVerwijderenPane.setHgap(10);
        kofferVerwijderenPane.setVgap(10);
        kofferVerwijderenPane.setPadding(new Insets(25, 25, 25, 25));
        Text kofferVerwijderenText = new Text("Als er een foute invoer is, kunt"
                + "u de koffer verwijderen door bij \"Home\" of via \"Zoeken\""
                + "\n"
                + "de koffer te selecteren en op de \"Verwijderen\" knop te"
                + "drukken.");
        kofferVerwijderenPane.add(kofferVerwijderenText, 0, 0);
        kofferVerwijderen.setText("Het verwijderen van koffers.");
        kofferVerwijderen.setContent(kofferVerwijderenPane);
        kofferVerwijderen.setExpanded(false);

        //scherm
        GridPane scherm = new GridPane();
        scherm.setPrefSize(600, 450);
        scherm.setAlignment(Pos.TOP_CENTER);
        scherm.setVgap(4);
        scherm.setPadding(new Insets(5, 5, 5, 5));

        scherm.add(vragenTitel, 0, 0);
        scherm.add(kofferZoek, 0, 1);
        scherm.add(kofferInvoer, 0, 2);
        scherm.add(statistiekenInzien, 0, 3);
        scherm.add(kofferMatchen, 0, 4);
        scherm.add(kofferVerwijderen, 0, 5);

        return scherm;
    }
}
