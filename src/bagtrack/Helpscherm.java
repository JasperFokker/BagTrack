package bagtrack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Thom
 */
public class Helpscherm extends Application {

    @Override
    public void start(Stage primaryStage) {
        returnScherm();
    }

    public static GridPane returnScherm() {
        GridPane scherm = new GridPane();
        scherm.setPrefSize(600, 450);

        GridPane faq = new GridPane();
        faq.setStyle("-fx-background-color:#333333;");
        faq.setPrefSize(600, 450);
        faq.setAlignment(Pos.TOP_CENTER);

        faq.setVgap(4);
        faq.setPadding(new Insets(5, 5, 5, 5));

        Label titel = new Label("Informatie over:");
        titel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        titel.setAlignment(Pos.CENTER);

        //vraag 1
        TitledPane vraag1 = new TitledPane();
        GridPane grid1 = new GridPane();
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25, 25, 25, 25));
        Text text1 = new Text("Klik op de knop \"Zoeken\" en vul de invoervelden in waarop u wilt zoeken.\n"
                + "Druk vervolgens op \"Zoek\" en er wordt een lijst met koffers weergegeven die voldoen aan de informatie"
                + "\ndie u ingevuld heeft in de invoervelden.");
        grid1.add(text1, 0, 0);
        vraag1.setText("Het zoeken naar koffers.");
        vraag1.setContent(grid1);
        vraag1.setExpanded(false);

        //vraag 2
        TitledPane vraag2 = new TitledPane();
        GridPane grid2 = new GridPane();
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));
        Text text2 = new Text("Klik op de knop \"Invoer\" en vul de invoer velden in waarvan u beschikt over de juiste informatie"
                + "\nVelden waar u geen informatie over heeft, kunt u leeglaten. Klik vervolgens op \"Opslaan\" en \nde door u ingevulde"
                + " invoervelden worden opgeslagen in de database.");
        grid2.add(text2, 0, 0);
        vraag2.setText("Het invoeren van koffers.");
        vraag2.setContent(grid2);
        vraag2.setExpanded(false);

        //vraag 3
        TitledPane vraag3 = new TitledPane();
        GridPane grid3 = new GridPane();
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(25, 25, 25, 25));
        Text text3 = new Text("Als u als manager bent inglogd, kunt u de statistieken inzien."
        + "Klik op de knop \"Statistieken\" om naar de statistieken \nte gaan. Hier vindt u verschillende grafieken"
        + "die informatie verschaffen over het aantal gevonden koffers, waar de koffers \ngevonden en verloren zijn en andere statistieken");
        grid3.add(text3, 0, 0);
        vraag3.setText("Het inzien van de statistieken.");
        vraag3.setContent(grid3);
        vraag3.setExpanded(false);

        //vraag 4
        TitledPane vraag4 = new TitledPane();
        vraag4.setText("Het matchen van verloren bagage.");
        vraag4.setContent(new Text("Klik"));
        vraag4.setExpanded(false);

        TitledPane vraag5 = new TitledPane();
        vraag5.setText("De Statistieken inzien.");
        vraag5.setContent(new Text("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\nbbbbbbbbbbbbbbbbbbbbbbbbb"
                + "\ncccccccccccccccccccccccccccccccccccc\n\ndddddddddddddddddddddddddddddddddddddd"
                + "\neeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
        vraag5.setExpanded(false);

        TitledPane vraag6 = new TitledPane();
        vraag6.setText("De Statistieken inzien.");
        vraag6.setContent(new Text("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\nbbbbbbbbbbbbbbbbbbbbbbbbb"
                + "\ncccccccccccccccccccccccccccccccccccc\n\ndddddddddddddddddddddddddddddddddddddd"
                + "\neeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
        vraag6.setExpanded(false);

        faq.addRow(0, new Text(""));
        faq.addRow(1, new Text(""));
        faq.addRow(2, new Text(""));
        faq.addRow(3, new Text(""));
        faq.addRow(8, new Text(""));
        faq.addRow(15, new Text(""));
        faq.addRow(16, new Text(""));

        faq.add(titel, 0, 4);
        faq.add(vraag1, 0, 9);
        faq.add(vraag2, 0, 10);
        faq.add(vraag3, 0, 11);
        faq.add(vraag4, 0, 12);
        faq.add(vraag5, 0, 13);
        faq.add(vraag6, 0, 14);

        ScrollPane scrollpane = new ScrollPane();

        scrollpane.setContent(faq);
        scrollpane.setFitToWidth(true);
        scrollpane.setFitToHeight(true);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        scherm.getColumnConstraints().add(column1);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100);
        scherm.getRowConstraints().add(row1);

        scherm.add(scrollpane, 0, 0);

        return scherm;
    }
}
