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

        TitledPane vraag1 = new TitledPane();
        vraag1.setText("Het zoeken naar koffers.");
        vraag1.setContent(new Text("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\nbbbbbbbbbbbbbbbbbbbbbbbbb"
                + "\ncccccccccccccccccccccccccccccccccccc\n\ndddddddddddddddddddddddddddddddddddddd"
                + "\neeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
        vraag1.setExpanded(false);

        TitledPane vraag2 = new TitledPane();
        vraag2.setText("Het invoeren van koffers");
        vraag2.setContent(new Text("\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\\nbbbbbbbbbbbbbbbbbbbbbbbbb\"\n"
                + "                + \"\\ncccccccccccccccccccccccccccccccccccc\\n\\ndddddddddddddddddddddddddddddddddddddd\"\n"
                + "                + \"\\neeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee\""));
        vraag2.setExpanded(false);

        TitledPane vraag3 = new TitledPane();
        vraag3.setText("Het spelen van kofferclicker");
        vraag3.setContent(new Text("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\nbbbbbbbbbbbbbbbbbbbbbbbbb"
                + "\ncccccccccccccccccccccccccccccccccccc\n\ndddddddddddddddddddddddddddddddddddddd"
                + "\neeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
        vraag3.setExpanded(false);

        TitledPane vraag4 = new TitledPane();
        vraag4.setText("De Statistieken inzien.");
        vraag4.setContent(new Text("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\nbbbbbbbbbbbbbbbbbbbbbbbbb"
                + "\ncccccccccccccccccccccccccccccccccccc\n\ndddddddddddddddddddddddddddddddddddddd"
                + "\neeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
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
        faq.addRow(5, new Text(""));
        faq.addRow(6, new Text(""));
        faq.addRow(7, new Text(""));
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


