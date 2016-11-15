/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagtrack;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Jason
 */

public class Kofferklikker extends Application
{
    static Thread thread = null;
    static int amountx = 0;
    
    @Override
    public void start(Stage primaryStage)
    {
        returnScherm();
    }
    
    
    
    public static GridPane returnScherm() {
        GridPane scherm = new GridPane();
        scherm.setPrefSize(600, 450);
        
        /* 
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        =====================================================================
        HIERONDER WERK JE!!
        HIERONDER WERK JE!!
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        =====================================================================
        */
        
        
        
        Label label = new Label();
        label.setText("Kofferklikker demo");
        label.getStyleClass().add("label-kofferklik");
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        
        Button kofferButton = new Button();
        Image koffer = new Image("randjerandje.png");
        int amount = 0;
        
        
        final long timeInterval = 1000;
        Runnable runnable = new Runnable(){
            int check = 0;
            public void run(){
                while(true){
                    System.out.println("yo" + ++check);
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {
                            label.setText(Integer.toString(AddAmount(20)));
                        }
                    });
                    
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }             
            }
        };
        
        thread = new Thread(runnable);              
        thread.setDaemon(true);
        
        
        kofferButton.setText("");
        kofferButton.setGraphic(new ImageView(koffer));
        kofferButton.setContentDisplay(ContentDisplay.TOP);
        kofferButton.setPrefSize(200, 112.5);
        kofferButton.setPrefSize(200, 112.5);
        kofferButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public  void handle(ActionEvent event) {
                System.out.println("noice"); 
                label.setText(Integer.toString(AddAmount(1)));
            }
        });
        
        Button bagagemedewerker = new Button();
        bagagemedewerker.setText("Huur een bagagemedewerker");
        //bagagemedewerker.setGraphic(new ImageView(koffer));
        //bagagemedewerker.setContentDisplay(ContentDisplay.TOP);
        bagagemedewerker.setPrefSize(200, 112.5);
        bagagemedewerker.setPrefSize(200, 112.5);
        bagagemedewerker.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public  void handle(ActionEvent event) {
                System.out.println("noice"); 
                thread.start();
            }
        });
        
        
        
        
        
        scherm.add(label,2,1);
        scherm.add(kofferButton, 1,1);
        scherm.add(bagagemedewerker, 1, 2);
        
        
        
        
        
        
        
        /* 
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        =====================================================================
        HIERONDER WERK JE NIET!!
        HIERONDER WERK JE NIET!!
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        =====================================================================
        */
        return scherm;
    }
    
    protected static int AddAmount(int a){
        amountx = amountx + a;
        return amountx;
    }
}
