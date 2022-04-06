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
    public static final Double YEASTPRICE = 1.59;
    private static final Double CAKEPRICE= 1.79;
    private static final Double HOLEPRICE = 0.39;
    private static final ObservableList<String> YEASTFLAVORS = FXCollections.observableArrayList("jelly","glazed","chocolate frosted","strawberry frosted","sugar","lemon filled");
    private static final ObservableList<String> CAKEFLAVORS = FXCollections.observableArrayList("cinnamon sugar","old fashion","blueberry");
    private static final ObservableList<String> HOLEFLAVORS = FXCollections.observableArrayList("glazed holes","jelly holes","cinnamon sugar holes");

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
        String SelectedDonut = flavorList.getSelectionModel().getSelectedItem();
        String quantity= quantitySelect.getValue();
        String newTotal = subTotalText.getText();
        Double total = Double.parseDouble(newTotal.substring(1));
        int numQuantity = Integer.parseInt(quantity);
        String addToOrder = SelectedDonut + " (" +  quantity + ")";
        donutList.getItems().add(addToOrder);
        if(donutSelect.getSelectionModel().getSelectedItem().equals("Yeast Donut")){
            total = total + (numQuantity*YEASTPRICE);
        } else if(donutSelect.getSelectionModel().getSelectedItem().equals("Cake Donut")){
            total = total + (numQuantity*CAKEPRICE);
        } else{
            total = total + (numQuantity*HOLEPRICE);
        }
        newTotal = "$" + String.format("%.2f",total);
        subTotalText.setText(newTotal);
    }

    @FXML
    void orderDonuts(ActionEvent event) {
        Order order = this.mainController.getOrder();
        order.add(donutList.getItems());
        this.mainController.setOrder(order);
    }

    @FXML
    void removeDonuts(ActionEvent event) {
        int index = donutList.getSelectionModel().getSelectedIndex();
        String item = donutList.getItems().get(index);
        String quantity = Character.toString(item.charAt(item.length()-2));
        int numQuantity= Integer.parseInt(quantity);
        String donut = item.substring(0,item.length()-4);
        Double totalRemove = 0.0;
        String currentTotal = subTotalText.getText();
        Double total = Double.parseDouble(currentTotal.substring(1));
        donutList.getItems().remove(index);
        if(YEASTFLAVORS.contains(donut)){
            totalRemove = (numQuantity*YEASTPRICE);
        } else if(CAKEFLAVORS.contains(donut)){
            totalRemove = (numQuantity*CAKEPRICE);
        } else{
            totalRemove = (numQuantity*HOLEPRICE);
        }
        total = total - totalRemove;
        currentTotal = "$" + String.format("%.2f",total);
        subTotalText.setText(currentTotal);
    }

}
