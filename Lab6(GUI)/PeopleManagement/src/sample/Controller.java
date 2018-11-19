package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.SetChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import pracownicy.Pracownik;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;


public class Controller {

    @FXML
    private ListView<Pracownik> valueList;
    @FXML
    private MenuBar menu;

    @FXML
    private MenuItem menuSave;

    @FXML
    private MenuItem menuLoad;

    @FXML
    private Button addButton;

    @FXML
    private  Button deleteButton;

    @FXML
    private TextField name;

    @FXML
    private Pane imageWindow;

    @FXML
    private ImageView imageViewer;

    @FXML
    private TextField surname;

    @FXML
    private TextField town;

    @FXML
    private Spinner<Integer> age;

    @FXML
    private Spinner<Double> salary;

    @FXML
    private Button loadImage;

    @FXML
    private TextField street;

    @FXML
    private TextField number;

    @FXML
    private Pane window;

    private SpinnerValueFactory<Integer> ageSpinValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(16,100, 18);
    private SpinnerValueFactory<Double> salarySpinValue = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,50000,1800);
    private Image img;
    private ObservableList<Pracownik> employerList = FXCollections.observableArrayList();
    private Integer indexToRmove;

    @FXML
    public void initialize() {
        age.setValueFactory(ageSpinValue);
        salary.setValueFactory(salarySpinValue);
        valueList.setItems(employerList);
        valueList.setCellFactory(param -> new ListCell<Pracownik>(){
            @Override
            protected  void updateItem(Pracownik item,boolean empty){
                super.updateItem(item,empty);
                if(empty || item == null){
                    setText(null);
                } else {
                    setText(item.getFullname());
                }
            }
     });
        valueList.getSelectionModel().selectedItemProperty().addListener( new ChangeListener<Pracownik>() {
            public void changed(ObservableValue<? extends Pracownik> ov,
                                Pracownik old_val, Pracownik new_val) {
                imageViewer.setImage(new_val.getImg());
                name.setText(new_val.getName());
                surname.setText(new_val.getSurname());
                town.setText(new_val.getTown());
                street.setText(new_val.getSurname());
                number.setText(new_val.getPhoneNumber());
                age.getValueFactory().setValue(new_val.getAge());
                salary.getValueFactory().setValue(new_val.getSalary());
                deleteButton.setDisable(false);
                indexToRmove = employerList.indexOf(new_val);
            }
        });

    }

    private FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files (*.jpg, *.png)", "*.jpg","*.png");

    @FXML
    public void typeStarted(){
        if(name.getText().isEmpty()||surname.getText().isEmpty()||street.getText().isEmpty()||number.getText().isEmpty()||town.getText().isEmpty()){
            addButton.setDisable(true);
        }
        else{
            addButton.setDisable(false);
        }
    }


    @FXML
    public void loadImg(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().add(extFilter);
        File pathFile = fileChooser.showOpenDialog(null);
        img = new Image(pathFile.toURI().toString());
        imageViewer.setImage(img);
        imageViewer.setPreserveRatio(false);
        imageViewer.setFitHeight(imageWindow.getHeight());
        imageViewer.setFitWidth(imageWindow.getWidth());
        imageViewer.setSmooth(true);
        imageViewer.setCache(true);
    }

    @FXML
    public void addPerson(){
        Pracownik toAdd = new Pracownik(img,name.getText(),surname.getText(),town.getText(),street.getText(),number.getText(),age.getValue(),salary.getValue());
        employerList.add(toAdd);
        imageViewer.setImage(null);
        name.setText("");
        surname.setText("");
        town.setText("");
        street.setText("");
        number.setText("");
        age.getValueFactory().setValue(18);
        salary.getValueFactory().setValue(1800.00);

    }

    @FXML
    public void removePerson(){
        valueList.getItems().remove(indexToRmove);
        employerList.remove(indexToRmove);
        valueList.getSelectionModel().clearSelection();
        valueList.refresh();
        imageViewer.setImage(null);
        name.setText("");
        surname.setText("");
        town.setText("");
        street.setText("");
        number.setText("");
        age.getValueFactory().setValue(18);
        salary.getValueFactory().setValue(1800.00);
        deleteButton.setDisable(true);
    }

}
