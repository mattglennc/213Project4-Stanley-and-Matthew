package _213project4stanleyandmatthew.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * This StoreOrderController class provides functionality for order-view.xml, allowing
 * users to modify the list of orders and export it to a text file.  Private helper methods are included.
 *
 * @author Matthew Carrascoso & Stanley Chou
 */
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


    /**
     * References the MainController in this DonutController instance.
     *
     * @param controller MainController to be referenced in this view.
     */
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
