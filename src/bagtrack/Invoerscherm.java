package bagtrack;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Floris Wichers
 */
public class Invoerscherm extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        returnScherm();
    }
    
    public static GridPane returnScherm() {
        GridPane scherm = new GridPane();
        scherm.setPrefSize(600, 450);
        
        //scherm.setAlignment(Pos.CENTER);
        scherm.setHgap(10);
        scherm.setVgap(10);
        scherm.setPadding(new Insets(25, 25, 25, 25));
        
        
        //datum
        Label dateLabel = new Label("Datum");
        GridPane.setHalignment(dateLabel, HPos.RIGHT);
        scherm.add(dateLabel, 0, 0);
        
        
        LocalDate date = LocalDate.now();
        DatePicker dp = new DatePicker(date);
        scherm.add(dp, 1, 0);

        //luchthaven
        Label airportLabel = new Label("Luchthaven");
        GridPane.setHalignment(airportLabel, HPos.RIGHT);
        scherm.add(airportLabel, 0, 1);
        
        ObservableList<String> airport
                = FXCollections.observableArrayList(
                        "AMS",
                        "ADA",
                        "KYA"
                );
        final ComboBox airportBox = new ComboBox(airport);
        scherm.add(airportBox, 1, 1);

        //combobox soort
        Label typeBagLabel = new Label("Soort");
        GridPane.setHalignment(typeBagLabel, HPos.RIGHT);
        scherm.add(typeBagLabel, 0, 2);

        ObservableList<String> typeBag
                = FXCollections.observableArrayList(
                        "Tas",
                        "Koffer",
                        "Zak"
                );
        final ComboBox typeBagBox = new ComboBox(typeBag);
        scherm.add(typeBagBox, 1, 2);

        //invoer merk
        Label brandLabel = new Label("Merk");
        GridPane.setHalignment(brandLabel, HPos.RIGHT);
        scherm.add(brandLabel, 0, 3);

        TextField brandField = new TextField();
        scherm.add(brandField, 1, 3);

        //comboboxes kleur
        Label color1Label = new Label("Kleur 1");
        GridPane.setHalignment(color1Label, HPos.RIGHT);
        scherm.add(color1Label, 0, 4);
        
        ObservableList<String> color
                = FXCollections.observableArrayList(
                        "Rood",
                        "Blauw",
                        "Geel"
                );
        final ComboBox color1Box = new ComboBox(color);
        scherm.add(color1Box, 1, 4);
        
        Label color2Label = new Label("Kleur 2");
        GridPane.setHalignment(color2Label, HPos.RIGHT);
        scherm.add(color2Label, 2, 4);
        
        final ComboBox color2Box = new ComboBox(color);
        scherm.add(color2Box, 3, 4);
        
        //combobox opdruk
        Label graphicLabel = new Label ("Opdruk");
        GridPane.setHalignment(graphicLabel, HPos.RIGHT);
        scherm.add(graphicLabel, 0, 5);
        
        ObservableList<String> graphic
                = FXCollections.observableArrayList(
                        "Effen kleur",
                        "Afbeelding",
                        "Patroon"
                );
        final ComboBox graphicBox = new ComboBox(graphic);
        scherm.add(graphicBox, 1, 5);
        
        //invoer labelnummer
        Label numberLabel = new Label("Labelnummer");
        GridPane.setHalignment(numberLabel, HPos.RIGHT);
        scherm.add(numberLabel, 0, 6);
        
        TextField numberField = new TextField();
        scherm.add(numberField, 1, 6);
        
        //invoer opmerkingen
        Label commentLabel = new Label("Opmerkingen");
        GridPane.setHalignment(commentLabel, HPos.RIGHT);
        scherm.add(commentLabel, 0, 7);
        
        TextField commentField = new TextField();
        scherm.add(commentField, 1, 7);

        //opslaan
        Button save = new Button();
        save.setText("Opslaan");
        scherm.add(save, 0,8);
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event){
                System.out.println(dp.getValue());
               
                String date1 = dp.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String merk = brandField.getText();
                
                System.out.println(date1);
                ResultSet idget = sql.select("SELECT * FROM bagage ORDER BY idbagage DESC LIMIT 1;");
                int id = 0;
                try{
                    if(idget.next()){
                        id = idget.getInt("idbagage");
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
                
                System.out.println("INSERT INTO bagtrack.bagage (idbagage,merk,kleur1,kleur2,soort,opdruk,luchthaven,datum,labelnummer,opmerkingen) VALUES ('"+ 50 +"','" + date1 + "','" +
                        merk + "','" + color1Box.getValue() + "','"+ color2Box.getValue() + "','"+ typeBagBox.getValue() +
                        "','"+ graphicBox.getValue() + "','"+ airportBox.getValue() + "','" + date1 + "','"+ numberField.getText() +
                        "','"+ commentField.getText() +"');");
                
                sql.insert("INSERT INTO bagtrack.bagage (idbagage,merk,kleur1,kleur2,soort,opdruk,luchthaven,datum,labelnummer,opmerkingen) VALUES ('"+ (id+1) +"','" + 
                        merk + "','" + color1Box.getValue() + "','"+ color2Box.getValue() + "','"+ typeBagBox.getValue() +
                        "','"+ graphicBox.getValue() + "','"+ airportBox.getValue() + "','" + date1 + "','"+ numberField.getText() +
                        "','"+ commentField.getText() +"');");
                
            }
        });

        //clear
        Button clear = new Button();
        clear.setText("Leegmaken");
        scherm.add(clear, 1,8);
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
                
                
                
                dp.setValue(null);
                airportBox.setValue(null);
                typeBagBox.setValue(null);
                brandField.setText(null);
                color1Box.setValue(null);
                color2Box.setValue(null);
                graphicBox.setValue(null);
                commentField.setText(null);
            }
        });
        
        return scherm;
    }
}
