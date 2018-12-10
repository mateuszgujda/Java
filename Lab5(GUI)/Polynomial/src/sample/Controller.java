package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import sun.security.provider.ConfigFile;

import java.util.LinkedList;
import java.util.List;

public class Controller {

    @FXML
    Pane window;

    @FXML
    Spinner<Integer> degreeSpinner;

    @FXML
    VBox pointsBox;

    @FXML
    ScrollPane scrollPanel;

    @FXML
    LineChart<String, Double> chart;

    @FXML
    Spinner<Double> fromSpinner;

    @FXML
    Spinner<Double> toSpinner;

    @FXML
    Spinner<Double> frequencySpinner;

    @FXML
    Button drawButton;

    private SpinnerValueFactory<Integer> degreeValues = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,1);
    private SpinnerValueFactory<Double> fromValues = new SpinnerValueFactory.DoubleSpinnerValueFactory(-50000,50000,0,0.1);
    private  SpinnerValueFactory<Double> toValues = new SpinnerValueFactory.DoubleSpinnerValueFactory(-49999,50001,1,0.1);
    private SpinnerValueFactory<Double> frequencyValues = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.001,1000,1,0.1);

    public void initialize(){
        degreeSpinner.setValueFactory(degreeValues);
        frequencySpinner.setValueFactory(frequencyValues);
        toSpinner.setValueFactory(toValues);
        fromSpinner.setValueFactory(fromValues);
        printList(1);

        degreeSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                if(newValue != oldValue){
                    pointsBox.getChildren().remove(0,2*(oldValue+1));
                    printList(newValue);
                }
            }
        });
    }


    public void drawChart(){
        List<Double> polynomials = new LinkedList<Double>();
        for (Node child: pointsBox.getChildren()) {
            if(child instanceof Spinner){
                Spinner<Double> spinner = (Spinner<Double>)child;
                Double spinnerValue = Double.parseDouble(spinner.getEditor().getText());
                polynomials.add(spinnerValue);
            }
        }

        XYChart.Series series = new XYChart.Series();
        series.setName("wielomian");
        Double from = Double.parseDouble(fromSpinner.getEditor().getText());
        Double to = Double.parseDouble(toSpinner.getEditor().getText());
        Double frequency = Double.parseDouble(frequencySpinner.getEditor().getText());
        for(Double i = from; i<= to; i=i+frequency){
            series.getData().add(new XYChart.Data<String,Double>(Double.toString(i),poly(polynomials,i)));
        }
        chart.getData().add(series);


    }

    public void printList(Integer size){
        for(int i=0; i<size+1; i++){
            Spinner<Double> toAdd = new Spinner<Double>();
            toAdd.setEditable(true);
            SpinnerValueFactory<Double> valuesToAdd = new SpinnerValueFactory.DoubleSpinnerValueFactory(-2000,2000,0,0.1);
            toAdd.setValueFactory(valuesToAdd);
            pointsBox.getChildren().add(new Text("Dla x^" + i));
            pointsBox.getChildren().add(toAdd);
        }

    }

    public Double poly(List<Double> polynomials, Double point){
        Double result = polynomials.get(0);
        for(int i =1 ;i<polynomials.size();i++){
            result = result + (polynomials.get(i)*Math.pow(point,i));
        }
        return result;
    }

}
