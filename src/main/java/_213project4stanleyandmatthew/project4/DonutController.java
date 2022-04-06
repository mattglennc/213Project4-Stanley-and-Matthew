package _213project4stanleyandmatthew.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class DonutController {
    private static final ObservableList<String> YEASTFLAVORS = FXCollections.observableArrayList("jelly", "glazed", "chocolate frosted", "strawberry frosted", "sugar", "lemon filled");
    private static final ObservableList<String> CAKEFLAVORS = FXCollections.observableArrayList("cinnamon sugar", "old fashion", "blueberry");
    private static final ObservableList<String> HOLEFLAVORS = FXCollections.observableArrayList("glazed holes", "jelly holes", "cinnamon sugar holes");

    private MainController mainController;

    private Order donutsOrdered;

    @FXML
    private ComboBox<String> donutSelect = new ComboBox<>();

    @FXML
    private ListView<String> donutList;

    @FXML
    private ListView<String> flavorList;

    @FXML
    private ComboBox<String> quantitySelect;

    @FXML
    private TextField subTotalText;

    public void initialize() {
        ObservableList<String> donuts = FXCollections.observableArrayList("Cake Donut", "Donut Hole", "Yeast Donut");
        donutSelect.getItems().addAll(donuts);
        ObservableList<String> quantities = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        quantitySelect.getItems().addAll(quantities);
        donutsOrdered = new Order();
    }

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @FXML
    void donutChosen(ActionEvent event) {
        if (donutSelect.getSelectionModel().getSelectedItem().equals("Yeast Donut")) {
            flavorList.setItems(YEASTFLAVORS);
        } else if (donutSelect.getSelectionModel().getSelectedItem().equals("Cake Donut")) {
            flavorList.setItems(CAKEFLAVORS);
        } else {
            flavorList.setItems(HOLEFLAVORS);
        }
    }

    @FXML
    void addDonuts(ActionEvent event) {
        String SelectedDonut = flavorList.getSelectionModel().getSelectedItem();
        String quantity = quantitySelect.getValue();
        String newTotal = subTotalText.getText();
        int numQuantity = Integer.parseInt(quantity);
        int numDonuts = donutsOrdered.getNumItems();
        Donut d = null;
        if (donutSelect.getSelectionModel().getSelectedItem().equals("Yeast Donut")) {
            d = new YeastDonut(SelectedDonut, numQuantity);
            donutsOrdered.add(d);
        } else if (donutSelect.getSelectionModel().getSelectedItem().equals("Cake Donut")) {
            d = new CakeDonut(SelectedDonut, numQuantity);
            donutsOrdered.add(d);
        } else {
            d = new DonutHole(SelectedDonut, numQuantity);
            donutsOrdered.add(d);
        }
        if (numDonuts != donutsOrdered.getNumItems()) {
            String addToOrder = d.toSubString();
            donutList.getItems().add(addToOrder);
        } else {
            donutList.getItems().clear();
            for (int i = 0; i < donutsOrdered.getNumItems(); i++) {
                donutList.getItems().add(((Donut)donutsOrdered.getItem(i)).toSubString());
            }
        }

        double finalTotal = donutsOrdered.finalCost();
        newTotal = "$" + String.format("%.2f", finalTotal);
        subTotalText.setText(newTotal);
    }

    @FXML
    void orderDonuts(ActionEvent event) {
        Order order = this.mainController.getOrder();
        for (int i = 0; i < donutsOrdered.getNumItems(); i++) {
            order.add(donutsOrdered.getItem(i));
        }
        this.mainController.setOrder(order);
    }

    @FXML
    void removeDonuts(ActionEvent event) {
        int index = donutList.getSelectionModel().getSelectedIndex();
        donutList.getItems().remove(index);
        Donut removeDonut = (Donut) donutsOrdered.getItem(index);
        donutsOrdered.remove(removeDonut);
        double finalTotal = donutsOrdered.finalCost();
        String newTotal = "$" + String.format("%.2f", finalTotal);
        subTotalText.setText(newTotal);
    }

}
