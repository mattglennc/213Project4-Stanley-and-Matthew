package _213project4stanleyandmatthew.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StoreOrderController {
    private MainController mainController;


    @FXML
    private ListView<String> orderList;

    @FXML
    private ComboBox<String> orderNumSelect;

    @FXML
    private TextField totalCost;

    public void initialize() {

    }


    public void setMainController(MainController controller) {
        mainController = controller;
    }


    @FXML
    void cancelOrders(ActionEvent event) {

    }

    @FXML
    void exportOrders(ActionEvent event) {

    }
}
