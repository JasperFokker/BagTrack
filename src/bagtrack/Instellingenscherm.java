/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagtrack;

import static bagtrack.Zoekscherm.currTable;
import static bagtrack.Zoekscherm.returnScherm2;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Jason
 */
public class Instellingenscherm extends Application {

    @Override
    public void start(Stage primaryStage) {
        returnScherm();
    }

    public static GridPane returnScherm() {

        //Tabelscherm dat linkt naar Tabeldata.java 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int h = (int) screenSize.getHeight();
        int w = (int) screenSize.getWidth();
        int menuwidth = (int) (w * 0.10);
        int menuheight = (int) (h * 0.20);

        BorderPane border = new BorderPane();
        GridPane scherm2 = new GridPane();
        scherm2.setPrefSize(600, 450);

        ObservableList<ObservableList> data = FXCollections.observableArrayList();

        final Label label = new Label("Logingegevens:");
        label.setFont(new Font("Arial", 18));
        GridPane.setHalignment(label, HPos.CENTER);

        final TableView table = new TableView();
        table.setEditable(true);
        table.setPrefWidth(menuwidth * 2);
        table.setPrefHeight(menuheight * 2);

        String query = "SELECT loginnaam, privilege FROM bagtrack.users;";
        ResultSet rs = sql.select(query);

        currTable = false;

        try {
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                System.out.println((String) rs.getMetaData().getColumnName(i + 1));

                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        try {
                            return new SimpleStringProperty(param.getValue().get(j).toString());
                        } catch (Exception e) {
                            return null;
                        }
                    }
                });

                table.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: #333333;;");

        Group popup = new Group();

        Image vermistIcon = new Image("delete_icon&48.png");
        Image gevondenIcon = new Image("checkmark_icon&48.png");

        Button verwijderButton = new Button();
        verwijderButton.setStyle("-fx-background-color: #333333;;");
        verwijderButton.setGraphic(new ImageView(vermistIcon));
        verwijderButton.setPrefSize(w * 0.30, 50);
        verwijderButton.setFont(Font.font("Verdana", 20));
        verwijderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int index = table.getSelectionModel().selectedIndexProperty().get();
                    rs.absolute(index + 1);
                    String login = rs.getString("loginnaam");

                    sql.insert("DELETE FROM users WHERE loginnaam = " + login + ";");

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        Button aanmakenButton = new Button();
        aanmakenButton.setStyle("-fx-background-color: #333333;;");
        aanmakenButton.setGraphic(new ImageView(gevondenIcon));
        aanmakenButton.setPrefSize(w * 0.30, 50);
        aanmakenButton.setFont(Font.font("Verdana", 20));
        aanmakenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popup.setVisible(true);
                verwijderButton.setDisable(true);
                aanmakenButton.setDisable(true);
            }
        });

        GridPane popupPane = new GridPane();
        popupPane.setAlignment(Pos.CENTER);
        popupPane.setHgap(10);
        popupPane.setVgap(10);
        popupPane.setPadding(new Insets(25, 25, 25, 25));

        Label loginnaamLabel = new Label("Username");

        TextField loginnaamField = new TextField();

        Label wachtwoordLabel = new Label("Wachtwoord");

        TextField wachtwoordField = new TextField();

        Label privilegeLabel = new Label("Privilege");

        TextField privilegeField = new TextField();

        Button jaButton = new Button("Ja");
        jaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                sql.insert("INSERT INTO bagtrack.users (loginnaam, wachtwoord, privilege)"
                        + " VALUES ('" + loginnaamField.getText() + "','" + wachtwoordField.getText() + "','" + privilegeField.getText() + "');");

                popup.setVisible(false);
                verwijderButton.setDisable(false);
                aanmakenButton.setDisable(false);
                loginnaamField.setText(null);
                wachtwoordField.setText(null);
                privilegeField.setText(null);

            }
        });

        Button neeButton = new Button("Nee");
        neeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popup.setVisible(false);
                verwijderButton.setDisable(false);
                aanmakenButton.setDisable(false);
                loginnaamField.setText(null);
                wachtwoordField.setText(null);
                privilegeField.setText(null);
            }
        });

        popupPane.add(loginnaamLabel, 0, 0);
        popupPane.add(loginnaamField, 1, 0);
        popupPane.add(wachtwoordLabel, 0, 1);
        popupPane.add(wachtwoordField, 1, 1);
        popupPane.add(privilegeLabel, 0, 2);
        popupPane.add(privilegeField, 1, 2);

        popupPane.add(jaButton, 0, 3);
        popupPane.add(neeButton, 1, 3);

        Rectangle popupVeld = new Rectangle(300, 170);
        popupVeld.setArcHeight(30);
        popupVeld.setArcWidth(30);
        popupVeld.setFill(Color.rgb(120, 120, 120));

        popup.getChildren().addAll(popupVeld, popupPane);
        popup.setVisible(false);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(aanmakenButton, verwijderButton);
        vbox.getChildren().addAll(label, table, hbox);

        table.setItems(data);

        hbox.setPrefWidth(menuwidth);
        scherm2.add(vbox, 0, 0);
        scherm2.add(popup, 0, 0);
        border.setCenter(scherm2);

        return scherm2;
    }
}
