package _213project4stanleyandmatthew.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class OrderController {
    private MainController mainController;

    private Order currentOrder;

    private static final Double SALESTAX = .06625;

    public void setMainController(MainController controller) {
        this.mainController = controller;
        this.currentOrder = this.mainController.getOrder();
        for (int i = 0; i < currentOrder.getNumItems(); i++) {
            menuItemsList.getItems().add(currentOrder.getItem(i).toString());
        }
        setCosts();
    }


    private void setCosts(){
        Double numSubtotal = this.currentOrder.finalCost();
        String price = "$" + String.format("%.2f", numSubtotal);
        subTotal.setText(price);
        Double tax = SALESTAX * numSubtotal;
        Double total = tax + numSubtotal;
        String strTax = "$" + String.format("%.2f", tax);
        String newTotal = "$" + String.format("%.2f", total);
        salesTax.setText(strTax);
        totalCost.setText(newTotal);
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
        if (currentOrder.getNumItems() == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("NO ITEMS ORDERED");
            alert.setHeaderText("You have 0 items ordered.");
            alert.setContentText("Order must have at least 1 item to be placed.");
            alert.showAndWait();
            return;
        }
        this.mainController.placeOrder();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Order Confirmed");
        alert.setHeaderText("Your order has been placed.");
        alert.setContentText("Check the store orders to view.");
        alert.showAndWait();
        return;
    }

    @FXML
    void removeItems(ActionEvent event) {
        if(currentOrder.getNumItems() == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("NO ITEMS ORDERED");
            alert.setHeaderText("You have 0 items chosen.");
            alert.setContentText("Must have at least 1 item to remove from order.");
            alert.showAndWait();
            return;
        }

        if(menuItemsList.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("NO ITEM SELECTED");
            alert.setHeaderText("You have not selected an item.");
            alert.setContentText("Please select an item to remove from the order.");
            alert.showAndWait();
            return;
        }
        int index = menuItemsList.getSelectionModel().getSelectedIndex();
        MenuItem remove = this.currentOrder.getMenuItem(index);
        this.currentOrder.remove(remove);
        menuItemsList.getItems().remove(index);
        setCosts();
    }

}
