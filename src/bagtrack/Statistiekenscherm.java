/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagtrack;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 *
 * @author Jason
 */
public class Statistiekenscherm extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        returnScherm();
    }
    
    public static GridPane returnScherm() {
        GridPane scherm = new GridPane();
        scherm.getStyleClass().add("root");
        scherm.setPrefSize(600, 450);
        
        /* 
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        =====================================================================
        HIERONDER WERK JE!!
        HIERONDER WERK JE!!
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        =====================================================================
        */
        
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Maand");

        final LineChart<String, Number> lineChart
                = new LineChart<String, Number>(xAxis, yAxis);

        lineChart.setTitle("Teruggevonden baggage");

        XYChart.Series series = new XYChart.Series();
        series.setName("Teruggevonden koffers");

        series.getData().add(new XYChart.Data("Jan", 23));
        series.getData().add(new XYChart.Data("Feb", 14));
        series.getData().add(new XYChart.Data("Mar", 15));
        series.getData().add(new XYChart.Data("Apr", 24));
        series.getData().add(new XYChart.Data("May", 34));
        series.getData().add(new XYChart.Data("Jun", 36));
        series.getData().add(new XYChart.Data("Jul", 22));
        series.getData().add(new XYChart.Data("Aug", 45));
        series.getData().add(new XYChart.Data("Sep", 43));
        series.getData().add(new XYChart.Data("Oct", 17));
        series.getData().add(new XYChart.Data("Nov", 29));
        series.getData().add(new XYChart.Data("Dec", 25));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Vermist gemeld");
        series2.getData().add(new XYChart.Data("Jan", 33));
        series2.getData().add(new XYChart.Data("Feb", 34));
        series2.getData().add(new XYChart.Data("Mar", 25));
        series2.getData().add(new XYChart.Data("Apr", 44));
        series2.getData().add(new XYChart.Data("May", 39));
        series2.getData().add(new XYChart.Data("Jun", 16));
        series2.getData().add(new XYChart.Data("Jul", 55));
        series2.getData().add(new XYChart.Data("Aug", 54));
        series2.getData().add(new XYChart.Data("Sep", 48));
        series2.getData().add(new XYChart.Data("Oct", 27));
        series2.getData().add(new XYChart.Data("Nov", 37));
        series2.getData().add(new XYChart.Data("Dec", 29));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Koffers kwijt");
        series3.getData().add(new XYChart.Data("Jan", 2));
        series3.getData().add(new XYChart.Data("Feb", 3));
        series3.getData().add(new XYChart.Data("Mar", 1));
        series3.getData().add(new XYChart.Data("Apr", 5));
        series3.getData().add(new XYChart.Data("May", 6));
        series3.getData().add(new XYChart.Data("Jun", 2));
        series3.getData().add(new XYChart.Data("Jul", 3));
        series3.getData().add(new XYChart.Data("Aug", 8));
        series3.getData().add(new XYChart.Data("Sep", 5));
        series3.getData().add(new XYChart.Data("Oct", 4));
        series3.getData().add(new XYChart.Data("Nov", 12));
        series3.getData().add(new XYChart.Data("Dec", 1));
        
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                    new PieChart.Data("Samsonite", 13),
                    new PieChart.Data("Hema huismerk", 25),
                    new PieChart.Data("AH Basic Koffer", 10),
                    new PieChart.Data("Dora's rugzak", 22),
                    new PieChart.Data("overig", 30)
                        
                );
        
        final PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Verloren merken");
        pieChart.setVisible(false);
                 
        ComboBox statistiekenKeuze = new ComboBox();
        statistiekenKeuze.getItems().addAll("Line Chart", "Graph Chart");
        statistiekenKeuze.setPromptText("Line Chart");
        statistiekenKeuze.setStyle("-fx-font: 15px \"Arial\";");
        
        statistiekenKeuze.valueProperty().addListener(new ChangeListener<String>() {
                @Override 
                public void changed(ObservableValue ov, String s, String s1) {
                    if ("Line Chart".equals(s1))
                    {
                        lineChart.setVisible(true);
                        pieChart.setVisible(false);
                    } else {
                        lineChart.setVisible(false);
                        pieChart.setVisible(true);
                    }

                }    
         });
         
        GridPane.setHgrow(lineChart, Priority.ALWAYS);
        GridPane.setVgrow(lineChart, Priority.ALWAYS);
        GridPane.setHalignment(statistiekenKeuze, HPos.RIGHT);
        GridPane.setValignment(statistiekenKeuze, VPos.TOP);
        
        lineChart.getData().addAll(series, series2, series3);
        scherm.getChildren().addAll(lineChart, pieChart, statistiekenKeuze);
        
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
}
