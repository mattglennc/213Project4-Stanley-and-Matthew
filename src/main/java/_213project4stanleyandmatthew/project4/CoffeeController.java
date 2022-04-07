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
        String size = sizeSelect.getValue();
        String quantity = quantitiesSelect.getValue();
        int quant = Integer.parseInt(quantity);
        Coffee coffee = new Coffee(quant, size);
        if(syrupBox.isSelected()){
            coffee.add("Syrup");
        }
        if(wcBox.isSelected()){
            coffee.add("Whipped Cream");
        }
        if(milkBox.isSelected()){
            coffee.add("Milk");
        }

        if(creamBox.isSelected()){
            coffee.add("Cream");
        }
        if(caramelBox.isSelected()){
           coffee.add("Caramel");
        }
        Double totalPrice = coffee.itemPrice();
        String total = "$" + String.format("%.2f", totalPrice);
        subTotal.setText(total);
        Order order = this.mainController.getOrder();
        order.add(coffee);
        this.mainController.setOrder(order);
    }

}

