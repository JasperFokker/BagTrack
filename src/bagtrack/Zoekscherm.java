package bagtrack;

import java.sql.ResultSet;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.util.Callback;

/**
 *
 * @author Rick
 */
public class Zoekscherm extends Application {

    @Override
    public void start(Stage primaryStage) {

        returnScherm();
    }

    public static GridPane returnScherm() {

        //Zoekscherm met dropdown boxen en textfield
        GridPane scherm = new GridPane();
        scherm.setPrefSize(600, 450);
        scherm.setHgap(1);
        scherm.setVgap(10);
        scherm.setPadding(new Insets(25, 25, 25, 25));
        //scherm.setGridLinesVisible(true);
        ColumnConstraints column = new ColumnConstraints(100);
        scherm.getColumnConstraints().add(column);
        RowConstraints row = new RowConstraints(50);
        scherm.getRowConstraints().add(row);

        //Inhoud 1e combobox
        ObservableList<String> kleuren = FXCollections.observableArrayList(
                "Blauw",
                "Rood",
                "Zwart",
                "Bruin",
                "Paars"
        );
        //Inhoud 2e combobox
        ObservableList<String> luchthaven = FXCollections.observableArrayList(
                "AMS",
                "ADA",
                "KYA"
        );
        //Inhoud 3e combobox
        ObservableList<String> soort = FXCollections.observableArrayList(
                "Tas",
                "Koffer",
                "Zak"
        );
        //Inhoud 4e combobox
        ObservableList<String> opdruk = FXCollections.observableArrayList(
                "Effen kleur",
                "Afbeelding",
                "Patroon"
        );
        
        
        //Labels, Textvelden, buttons en comboboxen.
        final int textWidth = 200;
        final int boxWidth = 200;
        final ComboBox comboBoxKleur1 = new ComboBox(kleuren);
        comboBoxKleur1.setPrefWidth(boxWidth);
        final ComboBox comboBoxKleur2 = new ComboBox(kleuren);
        comboBoxKleur2.setPrefWidth(boxWidth);
        final ComboBox comboBoxLuchthaven = new ComboBox(luchthaven);
        comboBoxLuchthaven.setPrefWidth(boxWidth);
        final ComboBox comboBoxSoort = new ComboBox(soort);
        comboBoxSoort.setPrefWidth(boxWidth);
        final ComboBox comboBoxOpdruk = new ComboBox(opdruk);
        comboBoxOpdruk.setPrefWidth(boxWidth);

        //TextField textveldNaam = new TextField();
        //textveldNaam.setPrefWidth(textWidth);
        TextField textveldMerk = new TextField();
        textveldMerk.setPrefWidth(textWidth);
        TextField textveldLabelnr = new TextField();
        textveldLabelnr.setPrefWidth(textWidth);
        

        Label label = new Label();
        label.setText("Naam:   ");
        GridPane.setHalignment(label, HPos.RIGHT);

        Label label2 = new Label();
        label2.setText("Merk:   ");
        GridPane.setHalignment(label2, HPos.RIGHT);

        Label label3 = new Label();
        label3.setText("Kleur:   ");
        GridPane.setHalignment(label3, HPos.RIGHT);

        Label label4 = new Label();
        label4.setText("Luchthaven:   ");
        GridPane.setHalignment(label4, HPos.RIGHT);

        Label label5 = new Label();
        label5.setText("Labelnummer:   ");
        GridPane.setHalignment(label5, HPos.RIGHT);

        Label label6 = new Label();
        label6.setText("Soort:   ");
        GridPane.setHalignment(label6, HPos.RIGHT);

        Label label7 = new Label("Opdruk:   ");
        GridPane.setHalignment(label7, HPos.RIGHT);
        
        Label label8 = new Label("      Kleur 2: ");
        GridPane.setHalignment(label8, HPos.RIGHT);

        Button btn = new Button("Zoek");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String query = null;
                
                String kleur1 = (String)comboBoxKleur1.getValue();
                String kleur2 = (String)comboBoxKleur2.getValue();
                String luchthaven = (String)comboBoxLuchthaven.getValue();
                String soort = (String)comboBoxSoort.getValue();
                String opdruk = (String)comboBoxOpdruk.getValue();
                String labelnr = (String)textveldLabelnr.getText();
                
                if(textveldLabelnr.getText() == null){
                    labelnr = "";
                }
                
                if(comboBoxKleur1.getValue() == null){
                    kleur1 = "";
                }
                
                if(comboBoxKleur2.getValue() == null){
                    kleur2 = "";
                }
                
                if(comboBoxLuchthaven.getValue() == null){
                    luchthaven = "";
                }
                
                if(comboBoxSoort.getValue() == null){
                    soort = "";
                }
                
                if(comboBoxOpdruk.getValue() == null){
                    opdruk = "";
                }
                
                System.out.println(kleur1);
                System.out.println("SELECT * FROM bagage WHERE merk LIKE '%"+ textveldMerk.getText() +"%' AND kleur1 LIKE '%"+
                        kleur1 +"%' AND kleur2 LIKE '%"+ kleur2 +"%' AND soort LIKE '%"+
                        soort +"%' AND opdruk LIKE '%"+
                        opdruk +"%' AND luchthaven LIKE '%"+ luchthaven +"%' AND labelnummer LIKE '%"+
                        textveldLabelnr.getText() +"%';");
                query = "SELECT * FROM bagage WHERE merk LIKE '%"+ textveldMerk.getText() +"%' AND kleur1 LIKE '%"+
                        kleur1 +"%' AND kleur2 LIKE '%"+ kleur2 +"%' AND soort LIKE '%"+
                        soort +"%' AND opdruk LIKE '%"+
                        opdruk +"%' AND luchthaven LIKE '%"+ luchthaven +"%' AND labelnummer LIKE '%"+
                        textveldLabelnr.getText() +"%';";
                
                //textveldNaam.setText(null);
                textveldMerk.setText("");
                comboBoxKleur1.setValue(null);
                comboBoxKleur2.setValue(null);
                comboBoxLuchthaven.setValue(null);
                textveldLabelnr.setText("");
                comboBoxSoort.setValue(null);
                comboBoxOpdruk.setValue(null);

                Main.change(Zoekscherm.returnScherm2(query));

            }
        });

        //Dit kan korter, geen idee hoe.
        //scherm.add(label, 1, 1);
        scherm.add(label2, 1, 3);
        scherm.add(label3, 1, 4);
        scherm.add(label4, 1, 1);
        scherm.add(label5, 1, 6);
        scherm.add(label6, 1, 2);
        scherm.add(label7, 1, 5);
        scherm.add(label8, 3, 4);
        //scherm.add(textveldNaam, 2, 1);
        scherm.add(textveldMerk, 2, 3);
        scherm.add(comboBoxKleur1, 2, 4);
        scherm.add(comboBoxKleur2, 4, 4);
        scherm.add(comboBoxLuchthaven, 2, 1);
        scherm.add(textveldLabelnr, 2, 6);
        scherm.add(comboBoxSoort, 2, 2);
        scherm.add(comboBoxOpdruk, 2, 5);
        scherm.add(btn, 2, 8);

        return scherm;

    }

    public static GridPane returnScherm2(String query) {
        //Tabelscherm dat linkt naar Tabeldata.java 
        GridPane scherm2 = new GridPane();
        scherm2.setPrefSize(600, 450);

        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        
        

        final Label label = new Label("Zoekresultaten");
        label.setFont(new Font("Arial", 18));
        GridPane.setHalignment(label, HPos.CENTER);

        final TableView table = new TableView();
        table.setEditable(true);
        table.setPrefWidth(1170);
        table.setPrefHeight(680);
        
        ResultSet rs = sql.select(query);
          
        
        try{
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                System.out.println((String)rs.getMetaData().getColumnName(i+1));
                if(i == 0){
                    continue;
                }
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                table.getColumns().addAll(col); 
                System.out.println("Column ["+i+"] ");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        try{
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        
        
        
        //Dit werkt, vraag me niet hoe.
        /*
        TableColumn naamCol = new TableColumn("Naam");
        naamCol.setCellValueFactory(new PropertyValueFactory<Tabeldata, String>("Naam"));

        TableColumn merkCol = new TableColumn("Merk");
        merkCol.setCellValueFactory(new PropertyValueFactory<Tabeldata, String>("Merk"));

        TableColumn kleurCol = new TableColumn("Kleur");
        kleurCol.setCellValueFactory(new PropertyValueFactory<Tabeldata, String>("Kleur"));

        TableColumn luchthavenCol = new TableColumn("Luchthaven");
        luchthavenCol.setCellValueFactory(new PropertyValueFactory<Tabeldata, String>("Luchthaven"));

        TableColumn gewichtCol = new TableColumn("Gewicht");
        gewichtCol.setCellValueFactory(new PropertyValueFactory<Tabeldata, String>("Gewicht"));

        TableColumn soortCol = new TableColumn("Soort");
        soortCol.setCellValueFactory(new PropertyValueFactory<Tabeldata, String>("Soort"));

        TableColumn opdrukCol = new TableColumn("Opdruk");
        opdrukCol.setCellValueFactory(new PropertyValueFactory<Tabeldata, String>("Opdruk"));
        
        */    

        //Verdeeld de colommen gelijk over de gridpane.
        /*
        naamCol.prefWidthProperty().bind(table.widthProperty().multiply(0.14));
        merkCol.prefWidthProperty().bind(table.widthProperty().multiply(0.14));
        kleurCol.prefWidthProperty().bind(table.widthProperty().multiply(0.14));
        luchthavenCol.prefWidthProperty().bind(table.widthProperty().multiply(0.14));
        gewichtCol.prefWidthProperty().bind(table.widthProperty().multiply(0.14));
        soortCol.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        opdrukCol.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        */
        table.setItems(data);
        //table.getColumns().addAll(naamCol, merkCol, kleurCol, luchthavenCol, gewichtCol, soortCol, opdrukCol);

        scherm2.add(label, 0, 0);
        scherm2.add(table, 0, 1);

        return scherm2;

    }

}
