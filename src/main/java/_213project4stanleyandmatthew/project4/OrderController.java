package _213project4stanleyandmatthew.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class OrderController {
    private MainController mainController;

    private Order currentOrder;


    public void setMainController(MainController controller) {
        this.mainController = controller;
        this.currentOrder = this.mainController.getOrder();
        for (int i = 0; i < currentOrder.getNumItems(); i++) {
            menuItemsList.getItems().add(currentOrder.getItem(i).toString());
        }
    }

    @FXML
    private ListView<String> menuItemsList;

    @FXML
    private TextField salesTax;

    @FXML
    private TextField subTotal;

    @FXML
    private TextField totalCost;


    @FXML
    void placeOrder(ActionEvent event) {

    }

    @FXML
    void removeItems(ActionEvent event) {

    }

}
