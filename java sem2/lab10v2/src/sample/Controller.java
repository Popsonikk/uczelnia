package sample;


import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Controller {
    @FXML
    private MenuItem closeItem;

    @FXML
    private Pane mainPane;

    @FXML
    private TextArea textArea;
    @FXML
    private MenuItem openItem;
    private  void  fileShow(File f)
    {
        try {
            String text = new String(Files.readAllBytes(Paths.get(f.getPath())));
            textArea.setText(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void initialize(){
        closeItem.setOnAction(actionEvent -> {
            Stage stage = (Stage) mainPane.getScene().getWindow();
            stage.close();
        });
        openItem.setOnAction(actionEvent -> {
            FileChooser fileChooser= new FileChooser();
            File file= fileChooser.showOpenDialog(new Stage());
        fileShow(file);
        });

    }

}