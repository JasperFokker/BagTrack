package bagtrack;

import javafx.scene.control.Button;
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
        scherm.setVgap(4);
        scherm.setPadding(new Insets(5, 5, 5, 5));
        scherm.setAlignment(Pos.TOP_CENTER);

        Label titel = new Label("Veelgestelde vragen:");
        titel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        
        TitledPane vraag1 = new TitledPane();
        vraag1.setText("Het zoeken naar koffers.");
        vraag1.setContent(new Text("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\nbbbbbbbbbbbbbbbbbbbbbbbbb"
                + "\ncccccccccccccccccccccccccccccccccccc\n\ndddddddddddddddddddddddddddddddddddddd"
                + "\neeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
        vraag1.setExpanded(false);
        
        TitledPane vraag2 = new TitledPane();
        vraag2.setText("Het invoeren van koffers");
        vraag2.setContent(new Text("\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\\nbbbbbbbbbbbbbbbbbbbbbbbbb\"\n" +
"                + \"\\ncccccccccccccccccccccccccccccccccccc\\n\\ndddddddddddddddddddddddddddddddddddddd\"\n" +
"                + \"\\neeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee\""));
        vraag2.setExpanded(false);
        
        TitledPane vraag3 = new TitledPane();
        vraag3.setText("Het spelen van kofferclicker");
        vraag3.setContent(new Text("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\nbbbbbbbbbbbbbbbbbbbbbbbbb"
                + "\ncccccccccccccccccccccccccccccccccccc\n\ndddddddddddddddddddddddddddddddddddddd"
                + "\neeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
        vraag3.setExpanded(false);
        
        TitledPane vraag4 = new TitledPane();
        vraag4.setText("De Statistieken.");
        vraag4.setContent(new Text("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\nbbbbbbbbbbbbbbbbbbbbbbbbb"
                + "\ncccccccccccccccccccccccccccccccccccc\n\ndddddddddddddddddddddddddddddddddddddd"
                + "\neeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
        vraag4.setExpanded(false);
        
        scherm.add(titel, 0, 4);
        scherm.add(vraag1, 0, 5);
        scherm.add(vraag2, 0, 6);
        scherm.add(vraag3, 0, 7);
        scherm.add(vraag4, 0, 8);

        return scherm;
    }
}
