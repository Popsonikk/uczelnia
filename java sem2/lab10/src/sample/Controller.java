package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    @FXML
    private TextField result;

    @FXML
    private ChoiceBox<String> choisbox;

    @FXML
    private Button button;

    public void initialize(){
        choisbox.getItems().add("+");
        choisbox.getItems().add("-");
        choisbox.getItems().add("*");
        choisbox.getItems().add("/");
        choisbox.setValue(choisbox.getItems().get(0));
        button.setOnAction(actionEvent -> {
            double a = Double.parseDouble(text1.getText());
            double b = Double.parseDouble(text2.getText());
            double res = 0;
            switch (choisbox.getValue()){
                case "+" -> res = a+b;
                case "-" -> res = a-b;
                case "*" -> res = a*b;
                case "/" -> {
                    if (b!=0)res = a / b;
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Dzielienie przez zero");
                        alert.showAndWait();
                    }
                }
            }
            result.setText(String.valueOf(res));
        });
    }

}