package _213project4stanleyandmatthew.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class DonutController{

    private MainController mainController;

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
        ObservableList<String> quantities = FXCollections.observableArrayList("1","2","3","4","5");
        quantitySelect.getItems().addAll(quantities);
    }

    public void setMainController(MainController controller){
        mainController = controller;
    }

    @FXML
    void donutChosen(ActionEvent event) {
        flavorList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<String> yeastFlavors = FXCollections.observableArrayList("jelly","glazed","chocolate frosted","strawberry frosted","sugar","lemon filled");
        ObservableList<String> cakeFlavors = FXCollections.observableArrayList("cinnamon sugar","old fashion","blueberry");
        ObservableList<String> holeFlavors = FXCollections.observableArrayList("glazed holes","jelly holes","cinnamon sugar holes");
        if(donutSelect.getSelectionModel().getSelectedItem().equals("Yeast Donut")){
            flavorList.setItems(yeastFlavors);
        } else if(donutSelect.getSelectionModel().getSelectedItem().equals("Cake Donut")){
            flavorList.setItems(cakeFlavors);
        } else{
            flavorList.setItems(holeFlavors);
        }
        flavorList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    void addDonuts(ActionEvent event) {

    }

    @FXML
    void orderDonuts(ActionEvent event) {

    }

    @FXML
    void removeDonuts(ActionEvent event) {

    }

}
