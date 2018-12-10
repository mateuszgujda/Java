import PhotoSort.PhotoSort;
import io.indico.api.utils.IndicoException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.util.Callback;

import java.io.File;


public class Controller {

    @FXML
    Button sortButton;
    @FXML
    Button folderButton;

    @FXML
    TreeView<File> folderView;

    @FXML
    TextField apiKey;

    @FXML
    TextField folderPath;

    @FXML
    Pane window;

    @FXML
    ImageView pictureView;

    @FXML
    Pane pictureWindow;

    public void initialize(){
        folderView.setCellFactory(new Callback<TreeView<File>, TreeCell<File>>() {

            public TreeCell<File> call(TreeView<File> tv) {
                return new TreeCell<File>() {

                    @Override
                    protected void updateItem(File item, boolean empty) {
                        super.updateItem(item, empty);

                        setText((empty || item == null) ? "" : item.getName());
                    }

                };
            }});
    }

    public void sortPressed(){
        String dir = folderPath.getText();
        PhotoSort sorter = new PhotoSort();
        try{
                sorter.dir_sort(apiKey.getText(), dir);
        }catch(IndicoException e){
            apiKey.setText("Wrong API KEY");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        //printTree(dir);
        }

    public void checkForText(){
        if(apiKey.getText().equals("") || folderPath.getText().equals("")){
            sortButton.setDisable(true);
        }
        else{
            sortButton.setDisable(false);
        }
    }

    public void folderButtonPressed(){
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Choose Directory to sort photos");
        chooser.setInitialDirectory(new File("c:/"));
        File directory = chooser.showDialog(null);
        if(directory != null){
            String dir = directory.getPath();
            folderPath.setText(dir);
            printTree(dir);

        }
    }

    public void printTree(String directory){
        TreeItem<File> rootItem = new TreeItem<File>(new File(directory));
        rootItem.setExpanded(true);
        File imageList[] = rootItem.getValue().listFiles();
        if(imageList != null) {
            for (File file : imageList){
                    TreeItem<File> childerItem = new TreeItem<File>(file);
                    rootItem.getChildren().add(childerItem);
                    if(file.isDirectory()){
                        File[] children = file.listFiles();
                        if(children != null) {
                            for (File file_child : children) {
                                TreeItem<File> secondGen = new TreeItem<File>(file_child);
                                childerItem.getChildren().add(secondGen);
                            }
                        }
                        }
            }
        }
        folderView.setRoot(rootItem);


    }


}
