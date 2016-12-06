package bagtrack;

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.scene.control.Button;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Jasper & Jimmy
 */
public class Main extends Application {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int h = (int) screenSize.getHeight();
    int w = (int) screenSize.getWidth();
    int menuwidth = (int) (w * 0.10);

    static BorderPane scherm = new BorderPane();
    static VBox menu = new VBox();
    static HBox topmenu = new HBox();
    static HBox logo = new HBox();

    //wissel scherm.
    public static void change(GridPane gridpane) {
        scherm.setCenter(gridpane);
    }

    public static void menu() {
        scherm.setLeft(menu);
    }

    public static void topmenu() {
        scherm.setTop(topmenu);
    }

    @Override
    public void start(Stage primaryStage) {
        TabPane zoekScherm = Zoekscherm.returnScherm();
        GridPane helpScherm = Helpscherm.returnScherm();
        StackPane inlogScherm = Loginscherm.returnScherm();
        TabPane formulierScherm = Invoerscherm.returnScherm();
        GridPane statistieken = Statistiekenscherm.returnScherm();
        GridPane instellingen = Instellingenscherm.returnScherm();
        GridPane homeScherm = Homescherm.returnScherm();

        Image Zoom = new Image("zoom_icon&48.png");
        Image Home = new Image("home_icon&48[1].png");
        Image Formulier = new Image("doc_edit_icon&48.png");
        Image Help = new Image("info_icon&48.png");
        Image Statistieken = new Image("chart_line_icon&48.png");
        Image Instellingen = new Image("cog_icon&48.png");
        Image Logo = new Image("titel_simpel.png", menuwidth * 1.50, w * 0.04, false, false);

        Button statistiekenButton = new Button();
        Button zoekButton = new Button();
        Button instellingenButton = new Button();
        Button helpButton = new Button();
        Button formulierButton = new Button();
        Button homeButton = new Button();

        statistiekenButton.setText("Statistieken");
        statistiekenButton.getStyleClass().add("leftmenubuttons");
        statistiekenButton.setGraphic(new ImageView(Statistieken));
        statistiekenButton.setContentDisplay(ContentDisplay.TOP);
        statistiekenButton.setPrefSize(menuwidth, 112.5);
        statistiekenButton.setPrefSize(200, 112.5);
        statistiekenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(statistieken);
//                statistiekenButton.setStyle("-fx-background-color: #ff0000; ");
//                zoekButton.setStyle("-fx-background-color: #d81e05; ");
//                instellingenButton.setStyle("-fx-background-color: #d81e05; ");
//                helpButton.setStyle("-fx-background-color: #d81e05; ");
//                formulierButton.setStyle("-fx-background-color: #d81e05; ");
            }
        });

        zoekButton.setText("Zoeken");
        zoekButton.getStyleClass().add("leftmenubuttons");
        zoekButton.setGraphic(new ImageView(Zoom));
        zoekButton.setContentDisplay(ContentDisplay.TOP);
        zoekButton.setPrefSize(menuwidth, 112.5);
        zoekButton.setPrefSize(200, 112.5);
        zoekButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(zoekScherm);

//                zoekButton.setStyle("-fx-background-color: #ff0000; ");
//                statistiekenButton.setStyle("-fx-background-color: #d81e05; ");
//                instellingenButton.setStyle("-fx-background-color: #d81e05; ");
//                helpButton.setStyle("-fx-background-color: #d81e05; ");
//                formulierButton.setStyle("-fx-background-color: #d81e05; ");
            }
        });

        homeButton.setText("Home");
        homeButton.getStyleClass().add("leftmenubuttons");
        homeButton.setGraphic(new ImageView(Home));
        homeButton.setContentDisplay(ContentDisplay.TOP);
        homeButton.setPrefSize(menuwidth, 112.5);
        homeButton.setPrefSize(200, 112.5);
        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(Zoekscherm.returnScherm2("SELECT * FROM bagage;", 1, ""));

//                zoekButton.setStyle("-fx-background-color: #ff0000; ");
//                statistiekenButton.setStyle("-fx-background-color: #d81e05; ");
//                instellingenButton.setStyle("-fx-background-color: #d81e05; ");
//                helpButton.setStyle("-fx-background-color: #d81e05; ");
//                formulierButton.setStyle("-fx-background-color: #d81e05; ");
            }
        });

        instellingenButton.setText("Instellingen");
        instellingenButton.getStyleClass().add("leftmenubuttons");
        instellingenButton.setGraphic(new ImageView(Instellingen));
        instellingenButton.setContentDisplay(ContentDisplay.TOP);
        instellingenButton.setPrefSize(menuwidth, 112.5);
        instellingenButton.setPrefSize(200, 112.5);
        instellingenButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(instellingen);
//                instellingenButton.setStyle("-fx-background-color: #ff0000; ");
//                zoekButton.setStyle("-fx-background-color: #d81e05; ");
//                statistiekenButton.setStyle("-fx-background-color: #d81e05; ");
//                helpButton.setStyle("-fx-background-color: #d81e05; ");
//                formulierButton.setStyle("-fx-background-color: #d81e05; ");
            }
        });

        helpButton.setText("Help");
        helpButton.getStyleClass().add("leftmenubuttons");
        helpButton.setGraphic(new ImageView(Help));
        helpButton.setContentDisplay(ContentDisplay.TOP);
        helpButton.setPrefSize(menuwidth, 112.5);
        helpButton.setPrefSize(200, 112.5);
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(helpScherm);
//                helpButton.setStyle("-fx-background-color: #ff0000; ");
//                zoekButton.setStyle("-fx-background-color: #d81e05; ");
//                statistiekenButton.setStyle("-fx-background-color: #d81e05; ");
//                instellingenButton.setStyle("-fx-background-color: #d81e05; ");
//                formulierButton.setStyle("-fx-background-color: #d81e05; ");
            }
        });

        formulierButton.setText("Invoer");
        formulierButton.getStyleClass().add("leftmenubuttons");
        formulierButton.setGraphic(new ImageView(Formulier));
        formulierButton.setContentDisplay(ContentDisplay.TOP);
        formulierButton.setPrefSize(menuwidth, 112.5);
        formulierButton.setPrefSize(200, 112.5);
        formulierButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(formulierScherm);
//                formulierButton.setStyle("-fx-background-color: #ff0000; ");               
//                zoekButton.setStyle("-fx-background-color: #d81e05; ");
//                statistiekenButton.setStyle("-fx-background-color: #d81e05; ");
//                instellingenButton.setStyle("-fx-background-color: #d81e05; ");
//                helpButton.setStyle("-fx-background-color: #d81e05; ");

            }
        });

        Label placeholder = new Label();
        placeholder.setVisible(true);
        placeholder.setPrefSize(w - menuwidth, 60);
        placeholder.setGraphic(new ImageView(Logo));
        placeholder.setContentDisplay(ContentDisplay.LEFT);
        placeholder.setDisable(false);

        Button uitlogButton = new Button();
        uitlogButton.setText("Uitloggen");
        uitlogButton.setContentDisplay(ContentDisplay.RIGHT);
        uitlogButton.setPrefSize(menuwidth, 55);
        uitlogButton.setFont(Font.font("Verdana", 18));
        uitlogButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Veranderd het huidige scherm naar het inlogscherm en maakt het menu onzichtbaar.
                scherm.setCenter(inlogScherm);
                scherm.setLeft(null);
                scherm.setTop(null);
                zoekButton.setDisable(false);
                statistiekenButton.setDisable(false);
                instellingenButton.setDisable(false);
                helpButton.setDisable(false);
                formulierButton.setDisable(false);
                homeButton.setDisable(false);
            }
        });

        menu.getChildren().addAll(homeButton, zoekButton, formulierButton, helpButton, statistiekenButton,
                instellingenButton);
        topmenu.getChildren().addAll(logo, uitlogButton);
        logo.getChildren().addAll(placeholder);

        scherm.setCenter(inlogScherm);

        Scene scene = new Scene(scherm, w, h);
        String css = Main.class.getResource("Theme.css").toExternalForm();
        scene.getStylesheets().add(css);
        logo.setStyle("-fx-background-color: #c10b0b;");
        logo.setPrefWidth(menuwidth + 200);
        topmenu.setSpacing(w - menuwidth - 300);

        primaryStage.setTitle("Main Screen");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setFullScreen(true);
    }

    public static void main(String[] args) {

        launch(args);
    }
}
