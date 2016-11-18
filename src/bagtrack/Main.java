package bagtrack;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Button;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.geometry.Pos.TOP_LEFT;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @author Jasper & Jimmy
 */
public class Main extends Application {

    static BorderPane scherm = new BorderPane();
    static VBox menu = new VBox();

    static HBox topmenu = new HBox();
    

    //wissel scherm.
    public static void change(GridPane gridpane) {
        scherm.setCenter(gridpane);
    }

    public static void menu() {
        scherm.setLeft(menu);
    }

    
    public static void topmenu(){
        scherm.setTop(topmenu);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane zoekScherm = Zoekscherm.returnScherm();
        GridPane helpScherm = Helpscherm.returnScherm();
        GridPane inlogScherm = Loginscherm.returnScherm();
        GridPane formulierScherm = Invoerscherm.returnScherm();
        GridPane welkomScherm = Welkomscherm.returnScherm();
        GridPane statistieken = Statistiekenscherm.returnScherm();
        GridPane instellingen = Kofferklikker.returnScherm();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int h = (int) screenSize.getHeight();
        int w = (int) screenSize.getWidth();
        int menuwidth = (int)(w*0.10);
        Image Zoom = new Image("zoom_icon&48.png");
        Image Formulier = new Image("doc_edit_icon&48.png");
        Image Help = new Image("info_icon&48.png");
        Image Statistieken = new Image ("chart_line_icon&48.png");
        Image Instellingen = new Image ("cog_icon&48.png");
        Image Logo = new Image ("logo.png", menuwidth * 1.40, w*0.04, false, false);
                
        Button placeholder = new Button();
        placeholder.setVisible(true);
        placeholder.setPrefSize(w-menuwidth, 48);
        placeholder.setGraphic(new ImageView(Logo));
        placeholder.setContentDisplay(ContentDisplay.LEFT);
        placeholder.setAlignment(TOP_LEFT);
        
        placeholder.setDisable(true);
        
        Button uitlogButton = new Button();
        uitlogButton.setText("Uitloggen");
        uitlogButton.setPrefSize(menuwidth, 48);
        uitlogButton.setAlignment(TOP_LEFT);
        uitlogButton.setFont(Font.font("Verdana", 26));
        uitlogButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Veranderd het huidige scherm naar het inlogscherm en maakt het menu onzichtbaar.
                scherm.setCenter(inlogScherm);
                scherm.setLeft(null);
                scherm.setTop(null);
            }
        });
        
        Button statistiekenButton = new Button();
        Button zoekButton = new Button();
        Button instellingenButton = new Button();
        Button helpButton = new Button();
        Button formulierButton = new Button();
        
        
        statistiekenButton.setText("Statistieken");
        statistiekenButton.setGraphic(new ImageView(Statistieken));
        statistiekenButton.setContentDisplay(ContentDisplay.TOP);
        statistiekenButton.setPrefSize(menuwidth, 112.5);
        statistiekenButton.setPrefSize(200, 112.5);
        statistiekenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(statistieken);
                zoekButton.setDisable(false);
                statistiekenButton.setDisable(true);
                instellingenButton.setDisable(false);
                helpButton.setDisable(false);
                formulierButton.setDisable(false);
            }
        });

        
        
        
        zoekButton.setText("Zoeken");
        zoekButton.setGraphic(new ImageView(Zoom));
        zoekButton.setContentDisplay(ContentDisplay.TOP);
        zoekButton.setPrefSize(menuwidth, 112.5);
        zoekButton.setPrefSize(200, 112.5);
        zoekButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(zoekScherm);
                zoekButton.setDisable(true);
                statistiekenButton.setDisable(false);
                instellingenButton.setDisable(false);
                helpButton.setDisable(false);
                formulierButton.setDisable(false);
            }
        });
        
        
        instellingenButton.setText("Instellingen");
        instellingenButton.setGraphic(new ImageView(Instellingen));
        instellingenButton.setContentDisplay(ContentDisplay.TOP);
        instellingenButton.setPrefSize(menuwidth, 112.5);
        instellingenButton.setPrefSize(200, 112.5);
        instellingenButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(instellingen);
                zoekButton.setDisable(false);
                statistiekenButton.setDisable(false);
                instellingenButton.setDisable(true);
                helpButton.setDisable(false);
                formulierButton.setDisable(false);
            }
        });

        
        helpButton.setText("Help");
        helpButton.setGraphic(new ImageView(Help));
        helpButton.setContentDisplay(ContentDisplay.TOP);
        helpButton.setPrefSize(menuwidth, 112.5);
        helpButton.setPrefSize(200, 112.5);
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(helpScherm);
                zoekButton.setDisable(false);
                statistiekenButton.setDisable(false);
                instellingenButton.setDisable(false);
                helpButton.setDisable(true);
                formulierButton.setDisable(false);
            }
        });

        
        formulierButton.setText("Invoer");
        formulierButton.setGraphic(new ImageView(Formulier));
        formulierButton.setContentDisplay(ContentDisplay.TOP);
        formulierButton.setPrefSize(menuwidth, 112.5);
        formulierButton.setPrefSize(200, 112.5);
        formulierButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(formulierScherm);
                zoekButton.setDisable(false);
                statistiekenButton.setDisable(false);
                instellingenButton.setDisable(false);
                helpButton.setDisable(false);
                formulierButton.setDisable(true);
            }
        });

        
        menu.getChildren().addAll(zoekButton,formulierButton,helpButton, statistiekenButton,
                instellingenButton);
        topmenu.getChildren().addAll(placeholder, uitlogButton);
        

        scherm.setCenter(inlogScherm);

        Scene scene = new Scene(scherm, 1920, 1080);
        String css = Main.class.getResource("Theme.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setTitle("Main Screen");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setFullScreen(true);
    }


    

    
    public static ResultSet sqlquery(String stat){
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        
        String url = "jdbc:mysql://localhost:3306/bagtrack";
        String user = "java";
        String password = "password";
        
        try{
            System.out.println("connecting..");
            con = DriverManager.getConnection(url,user,password);
            System.out.println("Creating statement");
            st = (Statement) con.createStatement();
            rs = st.executeQuery("SELECT idkoffers;");
            System.out.println("Sending query");
            
            if(rs.next()) {
                System.out.println(rs.getString(1));
            }
            
            
        }catch(SQLException e){
            System.out.println(e);            
        } finally {
            
            try {
                
                if (rs != null) {
                    rs.close();
                }
                
                if (st != null) {
                    st.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                
                System.out.println(ex);
                
            }
            
        }

        return rs;
    }
    
    public static void main(String[] args)
    {

        launch(args);
    }
}
