package bagtrack;

import java.awt.Dimension;
import java.awt.Toolkit;
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
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.util.Callback;

/**
 *
 * @author Rick
 */
public class Zoekscherm extends Application {
    
    static boolean currTable;
    
    @Override
    public void start(Stage primaryStage) {

        returnScherm();
    }
public static GridPane returnScherm3(String idbagage) {
GridPane scherm3 = new GridPane();
        scherm3.setPrefSize(600, 450);
        scherm3.setHgap(1);
        scherm3.setVgap(10);
        scherm3.setPadding(new Insets(25, 25, 25, 25));
        //scherm.setGridLinesVisible(true);
        ColumnConstraints column = new ColumnConstraints(100);
        scherm3.getColumnConstraints().add(column);
        RowConstraints row = new RowConstraints(50);
        scherm3.getRowConstraints().add(row);

        
        
        
        //Labels, Textvelden, buttons en comboboxen.
        final int textWidth = 200;
        final int boxWidth = 200;
        

        //TextField textveldNaam = new TextField();
        //textveldNaam.setPrefWidth(textWidth);
        TextField textveldVoornaam = new TextField();
        textveldVoornaam.setPrefWidth(textWidth);
        TextField textveldVoorletters = new TextField();
        textveldVoorletters.setPrefWidth(textWidth);
        TextField textveldAchternaam = new TextField();
        textveldAchternaam.setPrefWidth(textWidth);
        TextField textveldAdres = new TextField();
        textveldAdres.setPrefWidth(textWidth);
        TextField textveldVakantieadres = new TextField();
        textveldVakantieadres.setPrefWidth(textWidth);
        TextField textveldTelefoon1 = new TextField();
        textveldTelefoon1.setPrefWidth(textWidth);
        TextField textveldTelefoon2 = new TextField();
        textveldTelefoon2.setPrefWidth(textWidth);
        TextField textveldEmail = new TextField();
        textveldEmail.setPrefWidth(textWidth);
        TextField textveldVluchtnummer = new TextField();
        textveldVluchtnummer.setPrefWidth(textWidth);
        

        Label label = new Label();
        label.setText("Voornaam   ");
        GridPane.setHalignment(label, HPos.RIGHT);

        Label label2 = new Label();
        label2.setText("Voorletters   ");
        GridPane.setHalignment(label2, HPos.RIGHT);

        Label label3 = new Label();
        label3.setText("Achternaam   ");
        GridPane.setHalignment(label3, HPos.RIGHT);

        Label label4 = new Label();
        label4.setText("Adres   ");
        GridPane.setHalignment(label4, HPos.RIGHT);

        Label label5 = new Label();
        label5.setText("Vakantieadres   ");
        GridPane.setHalignment(label5, HPos.RIGHT);

        Label label6 = new Label();
        label6.setText("Telefoon1   ");
        GridPane.setHalignment(label6, HPos.RIGHT);

        Label label7 = new Label("Telefoon2   ");
        GridPane.setHalignment(label7, HPos.RIGHT);
        
        Label label8 = new Label("Email   ");
        GridPane.setHalignment(label8, HPos.RIGHT);
        
        Label label9 = new Label ("Vluchtnummer   ");
        GridPane.setHalignment(label9,HPos.RIGHT);

        Button btn = new Button("Zoek");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String query = "SELECT * FROM persoonsgegevens WHERE voornaam LIKE '%"+ textveldVoornaam.getText() +"%' AND voorletter LIKE '%"+
                        textveldVoorletters.getText() +"%' AND achternaam LIKE '%"+ textveldAchternaam.getText() +"%' AND adress LIKE '%"+
                        textveldAdres.getText() +"%' AND vakantieadress LIKE '%"+
                        textveldVakantieadres.getText() +"%' AND telefoon1 LIKE '%"+ textveldTelefoon1.getText() +"%' AND telefoon2 LIKE '%"+
                        textveldTelefoon1.getText() +"%' AND email LIKE '%"+ textveldEmail.getText() +"%' AND vluchtnummer LIKE '%"+ textveldVluchtnummer.getText() +"%';";
                ;
                

                if(idbagage == ""){
                    Main.change(Zoekscherm.returnScherm2(query, 3, ""));
                }else{
                    Main.change(Zoekscherm.returnScherm2(query, 2, idbagage));
                }
                

            }
        });

        //Dit kan korter, geen idee hoe.
        scherm3.add(label, 1, 1);
        scherm3.add(label2, 1, 2);
        scherm3.add(label3, 1, 3);
        scherm3.add(label4, 1, 4);
        scherm3.add(label5, 1, 5);
        scherm3.add(label6, 1, 6);
        scherm3.add(label7, 1, 7);
        scherm3.add(label8, 1, 8);
        scherm3.add(label9, 1, 9);
        
        scherm3.add(textveldVoornaam, 2, 1);
        scherm3.add(textveldVoorletters, 2, 2);
        scherm3.add(textveldAchternaam, 2, 3);
        scherm3.add(textveldAdres, 2, 4);
        scherm3.add(textveldVakantieadres, 2, 5);
        scherm3.add(textveldTelefoon1, 2, 6);
        scherm3.add(textveldTelefoon2, 2, 7);
        scherm3.add(textveldEmail, 2, 8);
        scherm3.add(textveldVluchtnummer, 2, 9);
        scherm3.add(btn, 2, 10);
        return scherm3;
}
    public static TabPane returnScherm() {

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
                "Zwart",
                "Wit",
                "Grijs",
                "Bruin",
                "Rood",
                "Blauw",
                "Groen",
                "Geel",
                "Oranje",
                "Paars",
                "Roze"

        );
        //Inhoud 2e combobox
        ObservableList<String> luchthaven = FXCollections.observableArrayList(
                "LHR",
                "CDG",
                "FRA",
                "AMS",
                "IST",
                "MAD",
                "MUC",
                "FMC",
                "LGW",
                "BCN",
                "DPS",
                "HRG",
                "CUR"

        );
        //Inhoud 3e combobox
        ObservableList<String> soort = FXCollections.observableArrayList(
                "Koffer",
                "Trolley",
                "Tas",
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
        comboBoxKleur1.setVisibleRowCount(12);
        final ComboBox comboBoxKleur2 = new ComboBox(kleuren);
        comboBoxKleur2.setPrefWidth(boxWidth);
        comboBoxKleur2.setVisibleRowCount(12);
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
        label.setText("Naam   ");
        GridPane.setHalignment(label, HPos.RIGHT);

        Label label2 = new Label();
        label2.setText("Merk   ");
        GridPane.setHalignment(label2, HPos.RIGHT);

        Label label3 = new Label();
        label3.setText("Kleur   ");
        GridPane.setHalignment(label3, HPos.RIGHT);

        Label label4 = new Label();
        label4.setText("Luchthaven   ");
        GridPane.setHalignment(label4, HPos.RIGHT);

        Label label5 = new Label();
        label5.setText("Labelnummer   ");
        GridPane.setHalignment(label5, HPos.RIGHT);

        Label label6 = new Label();
        label6.setText("Soort   ");
        GridPane.setHalignment(label6, HPos.RIGHT);

        Label label7 = new Label("Opdruk   ");
        GridPane.setHalignment(label7, HPos.RIGHT);
        
        Label label8 = new Label("      Kleur 2 ");
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

                Main.change(Zoekscherm.returnScherm2(query,1,""));

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
        
        

        TabPane ZoekTabs = new TabPane();
        

        Tab KoffersZoeken = new Tab();
        KoffersZoeken.setText("Koffergegevens");
        KoffersZoeken.setClosable(false);
        Tab PersoonZoeken = new Tab();
        PersoonZoeken.setText("Persoongegevens");
        PersoonZoeken.setClosable(false);
        
        
        
        //kofferGegevensBox.getChildren().add(kofferGegevensGrid);
        //persoonGegevensBox.getChildren().add(persoonGegevensGrid);
        KoffersZoeken.setContent(scherm);
        
        
        PersoonZoeken.setContent(returnScherm3(""));
        ZoekTabs.getTabs().addAll(KoffersZoeken, PersoonZoeken);
        
        
        

        return ZoekTabs;

    }

    public static GridPane returnScherm2(String query, int match, String id) {
        //Tabelscherm dat linkt naar Tabeldata.java 
        HBox hbox = new HBox();
        hbox.setPrefHeight(200);
        BorderPane border = new BorderPane();
        GridPane scherm2 = new GridPane();
        scherm2.setPrefSize(600, 450);

        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        
        
        
        final Label label = new Label("Zoekresultaten");
        label.setFont(new Font("Arial", 18));
        GridPane.setHalignment(label, HPos.CENTER);

        final TableView table = new TableView();
        table.setEditable(true);
        table.setPrefWidth(1920);
        table.setPrefHeight(1080);
        
        ResultSet rs = sql.select(query);
        
          
        currTable = false;
        
        try{
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;                
                System.out.println((String)rs.getMetaData().getColumnName(i+1));
                
                if(i == 0){
                    continue;
                }
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                if("idbagage".equals((String)rs.getMetaData().getColumnName(1)) ){
                    col.prefWidthProperty().bind(table.widthProperty().divide(11.1));
                    currTable = true;
                }
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
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int h = (int) screenSize.getHeight();
        int w = (int) screenSize.getWidth();
        
        Button matchNew = new Button();
        matchNew.setText("Match Nieuw");
        matchNew.setPrefSize(w*0.45, 50);
        matchNew.setFont(Font.font("Verdana", 20));
        matchNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int index = table.getSelectionModel().selectedIndexProperty().get();
                int idbagage = 0;
                System.out.println(index);
                
                try{
                    rs.absolute(index+1);
                    idbagage = rs.getInt("idbagage");
                    
                    Main.change(Invoerscherm.matchPersoon(Integer.toString(idbagage)));
                    
                }catch(Exception e){
                    System.out.println(e);
                }
                
            }
        });
        
        Button matchOld = new Button();
        matchOld.setText("Match Oud");
        matchOld.setPrefSize(w*0.30, 50);
        matchOld.setFont(Font.font("Verdana", 20));
        matchOld.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int index = table.getSelectionModel().selectedIndexProperty().get();
                int idbagage = 0;
                System.out.println(index);
                
                try{
                    rs.absolute(index+1);
                    idbagage = rs.getInt("idbagage");
                    
                    Main.change(returnScherm3(Integer.toString(idbagage)));
                    
                }catch(Exception e){
                    System.out.println(e);
                }
                
            }
        });
        

        Button matchFound = new Button();
        matchFound.setText("Match gevonden");
        matchFound.setPrefSize(w*0.30, 50);
        matchFound.setFont(Font.font("Verdana", 20));
        matchFound.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int index = table.getSelectionModel().selectedIndexProperty().get();
                int idpersoonsgegevens = 0;
                System.out.println(index);
                
                try{
                    rs.absolute(index+1);
                    idpersoonsgegevens = rs.getInt("idpersoonsgegevens");
                    System.out.println(idpersoonsgegevens);
                    sql.insert("UPDATE persoonsgegevens SET idbagage="+ id +" WHERE idpersoonsgegevens="+idpersoonsgegevens+";");
                    Main.change(returnScherm2(query, 3, ""));
                }catch(Exception e){
                    System.out.println(e);
                }
                
            }
        });
        
        Button delete = new Button();
        delete.setText("Verwijder Geselecteerd");
        delete.setPrefSize(w*0.30, 50);
        delete.setFont(Font.font("Verdana", 20));
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if(currTable == true){
                    int index = table.getSelectionModel().selectedIndexProperty().get();
                    int idbagage = 0;
                    System.out.println(index);
                
                    try{
                        rs.absolute(index+1);
                        idbagage = rs.getInt("idbagage");

                        sql.insert("DELETE FROM bagage WHERE idbagage=" + idbagage+";");

                        Main.change(returnScherm2(query, 1, ""));
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }else{
                    int index = table.getSelectionModel().selectedIndexProperty().get();
                    int idpersoonsgegevens = 0;
                    System.out.println(index);
                
                    try{
                        rs.absolute(index+1);
                        idpersoonsgegevens = rs.getInt("idpersoonsgegevens");

                        sql.insert("DELETE FROM persoonsgegevens WHERE idpersoonsgegevens=" + idpersoonsgegevens+";");

                        Main.change(returnScherm2(query, 1, ""));
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
                

                int index = table.getSelectionModel().selectedIndexProperty().get();
                int idbagage = 0;
                System.out.println(index);
                
                try{
                    rs.absolute(index+1);
                    idbagage = rs.getInt("idbagage");
                    
                    sql.insert("DELETE FROM bagage WHERE idbagage=" + idbagage+";");
                    
                    Main.change(returnScherm2(query, 1, ""));
                }catch(Exception e){
                    System.out.println(e);
                }
                
                
                
            }
        });
        VBox vbox = new VBox();
        
        Image vermistIcon = new Image("delete_icon&48.png");
        Image gevondenIcon = new Image("checkmark_icon&48.png");
        Image verzondenIcon = new Image("track_icon&48.png");
        
        
        Button vermist = new Button();
        vermist.setGraphic(new ImageView(vermistIcon));
        vermist.setPrefSize(w*0.30, 50);
        vermist.setFont(Font.font("Verdana", 20));
        vermist.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if(currTable == true){
                    
                }
                int index = table.getSelectionModel().selectedIndexProperty().get();
                int idbagage = 0;
                System.out.println(index);
                
                try{
                    rs.absolute(index+1);
                    idbagage = rs.getInt("idbagage");
                    System.out.println(idbagage);
                    sql.insert("UPDATE bagage SET status='Vermist' WHERE idbagage="+idbagage+";");
                    Main.change(returnScherm2(query, 1, ""));
                }catch(Exception e){
                    System.out.println(e);
                }

                
            }
        });
        Button gevonden = new Button();
        gevonden.setGraphic(new ImageView(gevondenIcon));
        gevonden.setPrefSize(w*0.30, 50);
        gevonden.setFont(Font.font("Verdana", 20));
        gevonden.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int index = table.getSelectionModel().selectedIndexProperty().get();
                int idbagage = 0;
                System.out.println(index);
                
                try{
                    rs.absolute(index+1);
                    idbagage = rs.getInt("idbagage");
                    System.out.println(idbagage);
                    sql.insert("UPDATE bagage SET status='Gevonden' WHERE idbagage="+idbagage+";");
                    Main.change(returnScherm2(query, 1, ""));
                }catch(Exception e){
                    System.out.println(e);
                }
                
            }
        });
        Button verzonden = new Button();
        verzonden.setGraphic(new ImageView(verzondenIcon));
        verzonden.setPrefSize(w*0.30, 50);
        verzonden.setFont(Font.font("Verdana", 20));
        verzonden.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int index = table.getSelectionModel().selectedIndexProperty().get();
                int idbagage = 0;
                System.out.println(index);
                
                try{
                    rs.absolute(index+1);
                    idbagage = rs.getInt("idbagage");
                    System.out.println(idbagage);
                    sql.insert("UPDATE bagage SET status='Verzonden' WHERE idbagage="+idbagage+";");
                    Main.change(returnScherm2(query, 1, ""));
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        });
        
        vbox.getChildren().addAll(gevonden,vermist,verzonden);
        
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);

        table.setItems(data);
        
        //scherm2.add(matchOld, 1, 3);
        scherm2.add(label, 0, 0);
        scherm2.add(table, 0, 1);
        scherm2.add(hbox, 0, 2);
        scherm2.add(vbox, 1,1);
        
        if(match == 1){
            hbox.getChildren().addAll(matchNew,separator,matchOld,delete);
        }
        if(match == 2){
            hbox.getChildren().addAll(matchFound);
        }
        if(match == 3){
            hbox.getChildren().addAll(delete);
        }
        
        
        
        border.setCenter(scherm2);
        

        return scherm2;

    }
    
    

}

