package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;



public class Controller {
    @FXML
    BarChart<String, Double> chart;
    @FXML
    Button addButton;
    @FXML
    TextField xValue;
    @FXML
    TextField yValue;

    @FXML
    Button removeButton;

    @FXML
    CategoryAxis xAxis;

    @FXML
    NumberAxis yAxis;

    private XYChart.Series series = new XYChart.Series();
    private Boolean isAlreadyInChart = false;
    int removeIndex;

    public void initialize() {
        series.nameProperty().setValue("Histogram");
        chart.getData().add(series);
    }

    @FXML
    void typeStarted() {
        if (xValue.getText().equals("") || yValue.getText().equals("0.0")) {
            addButton.setDisable(true);
        } else {
            addButton.setDisable(false);
        }
    }

    @FXML
    void addButtonPressed() {
        for (Object chartData : series.getData()) {
            XYChart.Data data = (XYChart.Data) chartData;
            if (data.getXValue().equals(xValue.getText())) {
                System.out.println(data.getXValue());
                data.setYValue(Double.parseDouble(yValue.getText()));
                isAlreadyInChart = true;
                break;
            } else {
                isAlreadyInChart = false;
            }
        }
        if (!isAlreadyInChart) {
            XYChart.Data<String, Double> chartData = new XYChart.Data<String, Double>(xValue.getText(), Double.parseDouble(yValue.getText()));
            series.getData().add(chartData);
            chartData.getNode().setOnMousePressed((MouseEvent event) -> {
                yValue.setText(chartData.getYValue().toString());
                xValue.setText(chartData.getXValue());
                xValue.setDisable(true);
                removeButton.setDisable(false);
                addButton.setText("Edit");
                addButton.setDisable(false);
                removeIndex = series.getData().indexOf(chartData);
            });
        }
        addButton.setText("Add");
        xValue.setDisable(false);
        addButton.setDisable(true);
        xValue.setText("");
        yValue.setText("0.0");
        removeButton.setDisable(true);
    }


        @FXML
    void removeButtonPressed(){
        series.getData().remove(removeIndex);
        xValue.setText("");
        yValue.setText("0.0");
        xValue.setDisable(false);
        removeButton.setDisable(true);
        addButton.setText("Add");
        addButton.setDisable(true);
        }

}

