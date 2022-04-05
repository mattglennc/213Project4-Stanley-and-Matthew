package _213project4stanleyandmatthew.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class OrderController {
    private MainController mainController;

    public void setMainController(MainController controller){
        mainController = controller;
    }

    public void initialize(){

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
