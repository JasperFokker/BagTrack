package bagtrack;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Jasper & Jimmy
 */
public class Main extends Application {

    static BorderPane scherm = new BorderPane();
    static VBox menu = new VBox();

    //wissel scherm.
    public static void change(GridPane gridpane) {
        scherm.setCenter(gridpane);
    }

    public static void menu() {
        scherm.setLeft(menu);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane zoekScherm = Zoekscherm.returnScherm();
        GridPane helpScherm = Helpscherm.returnScherm();
        GridPane inlogScherm = Loginscherm.returnScherm();
        GridPane formulierScherm = Invoerscherm.returnScherm();
        GridPane welkomScherm = Welkomscherm.returnScherm();
        GridPane statistieken = Statistiekenscherm.returnScherm();

        Image Zoom = new Image("zoom_icon&48.png");
        Image Formulier = new Image("doc_edit_icon&48.png");
        Image Help = new Image("info_icon&48.png");
        Image Statistieken = new Image ("chart_line_icon&48.png");
        
        Button uitlogButton = new Button();
        uitlogButton.setText("Uitloggen");
        uitlogButton.setPrefSize(200, 112.5);
        uitlogButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Veranderd het huidige scherm naar het inlogscherm en maakt het menu onzichtbaar.
                scherm.setCenter(inlogScherm);
                scherm.setLeft(null);
            }
        });

        Button statistiekenButton = new Button();
        statistiekenButton.setText("Statistieken");
        statistiekenButton.setGraphic(new ImageView(Statistieken));
        statistiekenButton.setPrefSize(200, 112.5);
        statistiekenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(statistieken);
            }
        });

        
        
        Button zoekButton = new Button();
        //zoekButton.setText("Zoeken");
        zoekButton.setGraphic(new ImageView(Zoom));
        zoekButton.setPrefSize(200, 112.5);
        zoekButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(zoekScherm);
            }
        });

        Button helpButton = new Button();
        helpButton.setText("Help");
        helpButton.setGraphic(new ImageView(Help));
        helpButton.setPrefSize(200, 112.5);
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(helpScherm);
            }
        });

        Button formulierButton = new Button();
        formulierButton.setText("Formulier");
        formulierButton.setGraphic(new ImageView(Formulier));
        formulierButton.setPrefSize(200, 112.5);
        formulierButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(formulierScherm);
            }
        });

        menu.getChildren().addAll(zoekButton, formulierButton, helpButton, uitlogButton, statistiekenButton);

        scherm.setCenter(inlogScherm);

        Scene scene = new Scene(scherm, 1920, 1080);
        String css = Main.class.getResource("Theme.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setTitle("Main Screen");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setFullScreen(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
