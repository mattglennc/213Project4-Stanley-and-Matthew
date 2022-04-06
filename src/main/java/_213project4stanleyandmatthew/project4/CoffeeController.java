package _213project4stanleyandmatthew.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CoffeeController {

    private MainController mainController;

    public void initialize() {
        ObservableList<String> sizes = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
        sizeSelect.getItems().addAll(sizes);
        ObservableList<String> quantities = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        quantitiesSelect.getItems().addAll(quantities);
    }

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @FXML
    private CheckBox caramelBox;

    @FXML
    private CheckBox creamBox;

    @FXML
    private CheckBox milkBox;

    @FXML
    private ComboBox<String> quantitiesSelect;

    @FXML
    private ComboBox<String> sizeSelect;

    @FXML
    private TextField subTotal;

    @FXML
    private CheckBox syrupBox;

    @FXML
    private CheckBox wcBox;

    @FXML
    void orderCoffee(ActionEvent event) {

    }

}

