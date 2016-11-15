package bagtrack;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.ImageObserver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JPanel;

/**
 * @author Jasper & Jimmy
 */
public class Main extends Application
{
    static BorderPane scherm = new BorderPane();
    static VBox menu = new VBox();
    static HBox topmenu = new HBox();
    
    //wissel scherm.
    public static void change(GridPane gridpane){
        scherm.setCenter(gridpane);
    }
    
    public static void menu(){
        scherm.setLeft(menu);
    }
    
    public static void topmenu(){
        scherm.setTop(topmenu);
    }
    
    @Override
    public void start(Stage primaryStage)
    {        
        GridPane zoekScherm = Zoekscherm.returnScherm();
        GridPane helpScherm = Helpscherm.returnScherm();
        GridPane inlogScherm = Loginscherm.returnScherm();
        GridPane formulierScherm = Invoerscherm.returnScherm();
        GridPane welkomScherm = Welkomscherm.returnScherm();
        GridPane statistieken = Statistiekenscherm.returnScherm();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int h = (int) screenSize.getHeight();
        int w = (int) screenSize.getWidth();
                
        Button placeholder = new Button();
        placeholder.setVisible(false);
        placeholder.setPrefSize(1720, 50);
        
        Button uitlogButton = new Button();
        uitlogButton.setText("Uitloggen");
        uitlogButton.setPrefSize(200, 50);
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
        statistiekenButton.setPrefSize(200, 112.5);
        statistiekenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scherm.setCenter(statistieken);
            }
        });
                
        
        Button zoekButton = new Button();
        zoekButton.setText("Zoeken");
        zoekButton.setPrefSize(200, 112.5);
        zoekButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
                scherm.setCenter(zoekScherm);
            }
        });
                    
        Button helpButton = new Button();
        helpButton.setText("Help");
        helpButton.setPrefSize(200, 112.5);
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
                scherm.setCenter(helpScherm);
            }
        });
        
        Button formulierButton = new Button();
        formulierButton.setText("Formulier");
        formulierButton.setPrefSize(200, 112.5);
        formulierButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
                scherm.setCenter(formulierScherm);
            }
        });
        
        menu.getChildren().addAll(zoekButton,formulierButton,helpButton, statistiekenButton);
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
