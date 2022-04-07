package _213project4stanleyandmatthew.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CoffeeController {

    private Coffee coffee;

    private MainController mainController;

    public void initialize() {
        ObservableList<String> sizes = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
        sizeSelect.getItems().addAll(sizes);
        ObservableList<String> quantities = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        quantitiesSelect.getItems().addAll(quantities);
        sizeSelect.getSelectionModel().selectFirst();
        quantitiesSelect.getSelectionModel().selectFirst();
        String size = sizeSelect.getValue();
        String quantity = quantitiesSelect.getValue();
        int quant = Integer.parseInt(quantity);
        coffee = new Coffee(quant, size);
        subTotal.setText(coffee.priceString());
        resetBoxes();
    }

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    private void resetBoxes(){
        caramelBox.setSelected(false);
        wcBox.setSelected(false);
        milkBox.setSelected(false);
        creamBox.setSelected(false);
        syrupBox.setSelected(false);
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
    void caramelCheck(ActionEvent event) {
        if(caramelBox.isSelected()){
            coffee.add("Caramel");
        }else{
            coffee.remove("Caramel");
        }
        subTotal.setText(coffee.priceString());
    }

    @FXML
    void creamCheck(ActionEvent event) {
        if(creamBox.isSelected()){
            coffee.add("Cream");
        }else{
            coffee.remove("Cream");
        }
        subTotal.setText(coffee.priceString());
    }

    @FXML
    void milkCheck(ActionEvent event) {
        if(milkBox.isSelected()){
            coffee.add("Milk");
        }else{
            coffee.remove("Milk");
        }
        subTotal.setText(coffee.priceString());
    }

    @FXML
    void sizeChosen(ActionEvent event) {
        coffee.setSize(sizeSelect.getValue());
        subTotal.setText(coffee.priceString());
    }

    @FXML
    void quantChosen(ActionEvent event) {
        int quant = Integer.parseInt(quantitiesSelect.getValue());
        coffee.update(quant - coffee.getQuantity());
        subTotal.setText(coffee.priceString());

    }

    @FXML
    void syrupCheck(ActionEvent event) {
        if(syrupBox.isSelected()){
            coffee.add("Syrup");
        }else{
            coffee.remove("Syrup");
        }
        subTotal.setText(coffee.priceString());
    }

    @FXML
    void wcCheck(ActionEvent event) {
        if(wcBox.isSelected()){
            coffee.add("Whipped Cream");
        }else{
            coffee.remove("Whipped Cream");
        }
        subTotal.setText(coffee.priceString());
    }

    @FXML
    void orderCoffee(ActionEvent event) {
        Order order = this.mainController.getOrder();
        order.add(coffee);
        initialize();
        this.mainController.setOrder(order);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText("Item has been added to your order.");
        alert.setContentText("Please check your order to view.");
        alert.showAndWait();
    }

}

