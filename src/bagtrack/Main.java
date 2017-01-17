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
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * @author Team Twee
 */
public class Main extends Application {

    //Opslaan van de dimensies van het scherm
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int h = (int) screenSize.getHeight();
    int w = (int) screenSize.getWidth();
    int menuwidth = (int) (w * 0.10);

    static BorderPane scherm = new BorderPane();
    static VBox menu = new VBox();
    static VBox privmenu = new VBox();
    static HBox topmenu = new HBox();
    static HBox logo = new HBox();
    static Button statistiekenButton = new Button();
    static Button uitlogButton = new Button();
    
    //wissel scherm.
    public static void change(GridPane gridpane) {
        scherm.setCenter(gridpane);
    }

    //initialiseer het navigatiemenu
    public static void menu() {
        scherm.setLeft(menu);
    }
    
    //initialiseer het navigatiemenu manager
    public static void privmenu() {
        scherm.setLeft(privmenu);
    }

    public static void topmenu() {
        scherm.setTop(topmenu);
    }

    @Override
    public void start(Stage primaryStage) {
        //initialiseer centerschermen
        TabPane zoekScherm = Zoekscherm.returnScherm();
        GridPane helpScherm = Helpscherm.returnScherm();
        StackPane inlogScherm = Loginscherm.returnScherm();
        StackPane formulierScherm = Invoerscherm.returnScherm();
        GridPane statistieken = Statistiekenscherm.returnScherm();
        GridPane instellingen = Instellingenscherm.returnScherm();
        

        
        //iconen knoppen initialiseren
        Image Zoom = new Image("zoom_icon&48.png");
        Image Home = new Image("home_icon&48[1].png");
        Image Formulier = new Image("doc_edit_icon&48.png");
        Image Help = new Image("info_icon&48.png");
        Image Statistieken = new Image("chart_line_icon&48.png");
        Image Instellingen = new Image("cog_icon&48.png");
        Image Uitloggen = new Image("export_icon&48.png", menuwidth * 0.25, w * 0.025, false ,false);
        Image Logo = new Image("titel_simpel.png", menuwidth * 1.50, w * 0.04, false, false);
 
        
        
        
        
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
        statistiekenButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                scherm.setCenter(statistieken);

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
                scherm.setCenter(Zoekscherm.returnScherm2("SELECT * FROM bagage;", 1, ""));//laat tabel zien met alle koffers er in


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


            }
        });

        
        //BagTrack icoon links boven 
        Label placeholder = new Label();
        placeholder.setVisible(true);
        placeholder.setPrefSize(w - menuwidth, 60);
        placeholder.setGraphic(new ImageView(Logo));
        placeholder.setContentDisplay(ContentDisplay.LEFT);
        placeholder.setDisable(false);

        
        uitlogButton.setText("Uitloggen");
        uitlogButton.setContentDisplay(ContentDisplay.LEFT);
        uitlogButton.setPrefSize(menuwidth * 1.5, 55);
        uitlogButton.setGraphic(new ImageView(Uitloggen));
        
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
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setFullScreen(true);
    }

    public static void main(String[] args) {

        launch(args);
    }
}
