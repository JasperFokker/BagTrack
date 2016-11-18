/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagtrack;

import java.awt.Dimension;
import java.awt.Toolkit;
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
    static Thread threadMedewerker = null;
    static Thread threadLoopband = null;
    static Thread threadBagagekar = null;
    static long amountx = 0;
    static int medewerkerAdd = 0;
    static int aantalMedewerkers = 0;
    static int loopbandAdd = 0;
    static int aantalLoopbanden = 0;
    static int aantalBagagekarren = 0;
    static int bagagekarAdd = 0;
    
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
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int h = (int) screenSize.getHeight();
        int w = (int) screenSize.getWidth();
        
        Label label = new Label();
        label.setText("<- Klik de koffer om te beginnen.");
        label.getStyleClass().add("label-kofferklik");
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        
        
        
        Label lblaantalMedewerkers = new Label();
        lblaantalMedewerkers.setText("Aantal medewerkers is: " + aantalMedewerkers);
        lblaantalMedewerkers.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        
        Label lblaantalLoopbanden = new Label();
        lblaantalLoopbanden.setText("Aantal loopbanden is: " + aantalLoopbanden);
        lblaantalLoopbanden.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        
        Label lblaantalBagagekarren = new Label();
        lblaantalLoopbanden.setText("Aantal loopbanden is: " + aantalBagagekarren);
        lblaantalLoopbanden.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        
        Button kofferButton = new Button();
        Image koffer = new Image("randjerandje.png", h*0.3,h*0.3, false, false);
        int amount = 0;
        
        final int MEDEWERKER_KOSTEN = 30;
        final int LOOPBAND_KOSTEN = 800;
        final int BAGAGEKAR_KOSTEN = 80000;
        final long INTERVAL_MEDEWERKER = 3000;
        final long INTERVAL_LOOPBAND = 6000;
        final long INTERVAL_BAGAGEKAR = 10000;
        
        Runnable runnableMedewerker = new Runnable(){
            int check = 0;
            public void run(){
                while(true){
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {
                            label.setText(Long.toString(AddAmount(medewerkerAdd)));
                        }
                    });
                    
                    try {
                        Thread.sleep(INTERVAL_MEDEWERKER);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }             
            }
        };
        
        Runnable runnableLoopband = new Runnable(){
            int check = 0;
            public void run(){
                while(true){
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {
                            label.setText(Long.toString(AddAmount(loopbandAdd)));
                        }
                    });
                    
                    try {
                        Thread.sleep(INTERVAL_LOOPBAND);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }             
            }
        };
        
        Runnable runnableBagagekar = new Runnable(){
            int check = 0;
            public void run(){
                while(true){
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {
                            label.setText(Long.toString(AddAmount(bagagekarAdd)));
                        }
                    });
                    
                    try {
                        Thread.sleep(INTERVAL_BAGAGEKAR);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }             
            }
        };
        
        threadMedewerker = new Thread(runnableMedewerker);              
        threadMedewerker.setDaemon(true);
        threadMedewerker.start();
        
        threadLoopband = new Thread(runnableLoopband);
        threadLoopband.setDaemon(true);
        threadLoopband.start();
        
        threadBagagekar = new Thread(runnableBagagekar);
        threadBagagekar.setDaemon(true);
        threadBagagekar.start();
        
        kofferButton.setText("");
        kofferButton.setGraphic(new ImageView(koffer));
        kofferButton.setContentDisplay(ContentDisplay.TOP);
        kofferButton.setPrefSize(200, 35);
        
        kofferButton.getStyleClass().add("button-kofferklik");
        kofferButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public  void handle(ActionEvent event) {
                label.setText(Long.toString(AddAmount(1)));
            }
        });
        
        Button bagagemedewerker = new Button();
        bagagemedewerker.setText("Huur een bagagemedewerker in. Kost " + MEDEWERKER_KOSTEN + " Koffers");
        
        bagagemedewerker.setPrefSize(350, 35);
        bagagemedewerker.getStyleClass().add("button-kofferklik-medewerker");
        bagagemedewerker.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public  void handle(ActionEvent event) {
                if(amountx > MEDEWERKER_KOSTEN){
                    amountx = amountx - MEDEWERKER_KOSTEN;
                    label.setText(Long.toString(amountx));
                    aantalMedewerkers++;                    
                    medewerkerAdd = medewerkerAdd + 20;
                    lblaantalMedewerkers.setText("Aantal medewerkers is: " + aantalMedewerkers + 
                            " Dit geeft " + medewerkerAdd + " koffers per seconde");
                } 
                
                
            }
        });
        
        Button bagageLoopband = new Button();
        bagageLoopband.setText("Koop een bagageloopband. Kost " + LOOPBAND_KOSTEN + " Koffers");
        
        bagageLoopband.setPrefSize(350, 35);
        bagageLoopband.getStyleClass().add("button-kofferklik-medewerker");
        bagageLoopband.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public  void handle(ActionEvent event) {
                if(amountx > LOOPBAND_KOSTEN){
                    amountx = amountx - LOOPBAND_KOSTEN;
                    label.setText(Long.toString(amountx));
                    aantalLoopbanden++;
                    loopbandAdd = loopbandAdd + 500;
                    lblaantalLoopbanden.setText("Aantal loopbanden is: " + aantalLoopbanden + 
                            " Dit geeft " + loopbandAdd + " koffers per seconde");
                    
                } 
                
                
            }
        });
        
        Button bagageKar = new Button();
        bagageKar.setText("Koop een bagagekar. Kost " + BAGAGEKAR_KOSTEN  + " Koffers");
        
        bagageKar.setPrefSize(350, 35);
        bagageKar.getStyleClass().add("button-kofferklik-medewerker");
        bagageKar.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public  void handle(ActionEvent event) {
                if(amountx > BAGAGEKAR_KOSTEN){
                    amountx = amountx - BAGAGEKAR_KOSTEN;
                    label.setText(Long.toString(amountx));
                    aantalBagagekarren++;
                    bagagekarAdd = bagagekarAdd + 50000;
                    lblaantalLoopbanden.setText("Aantal bagagekarren is: " + aantalBagagekarren + 
                            " Dit geeft " + bagagekarAdd + " koffers per seconde");
                    
                } 
                
                
            }
        });
        
        
        
        scherm.add(label,2,1);
        scherm.add(kofferButton, 1,1);
        scherm.add(bagagemedewerker, 1, 2);
        scherm.add(lblaantalMedewerkers, 2, 2);
        scherm.add(bagageLoopband, 1, 3);
        scherm.add(lblaantalLoopbanden, 2, 3);
        scherm.add(bagageKar, 1, 4);
        scherm.add(lblaantalBagagekarren, 2, 4);
        
        
        
        
        
        
        
        
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
    
    protected static long AddAmount(int a){
        amountx = amountx + a;
        return amountx;
    }
}
