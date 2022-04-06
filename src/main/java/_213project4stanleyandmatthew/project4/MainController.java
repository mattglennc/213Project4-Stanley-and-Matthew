package _213project4stanleyandmatthew.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private StoreOrders orders;
    private Order currentOrder;

    public StoreOrders getOrders() {
        return this.orders;
    }

    public void setOrders() {
        this.orders.add(currentOrder);
        currentOrder = new Order();
        return;
    }

    public Order getOrder() {
        return this.currentOrder;
    }

    public void setOrder(Order newOrder) {
        this.currentOrder = newOrder;
        return;
    }

    public void initialize() {
        this.orders = new StoreOrders();
        this.currentOrder = new Order();
    }

    @FXML
    void coffeeView(ActionEvent event) throws IOException {
        FXMLLoader coffeeLoader = new FXMLLoader(Main.class.getResource("coffee-view.fxml"));
        Scene coffeeScene = new Scene((VBox) coffeeLoader.load(), 604, 549);
        Stage coffeeStage = new Stage();
        coffeeStage.setTitle("Coffee");
        coffeeStage.setScene(coffeeScene);
        coffeeStage.show();
        CoffeeController CoffeeController = coffeeLoader.getController();
        CoffeeController.setMainController(this);
    }

    @FXML
    void donutsView(ActionEvent event) throws IOException {
        FXMLLoader donutLoader = new FXMLLoader(Main.class.getResource("donut-view.fxml"));
        Scene donutScene = new Scene((VBox) donutLoader.load(), 604, 549);
        Stage donutStage = new Stage();
        donutStage.setTitle("Donuts");
        donutStage.setScene(donutScene);
        donutStage.show();
        DonutController donutController = donutLoader.getController();
        donutController.setMainController(this);
    }

    @FXML
    void orderingView(ActionEvent event) throws IOException {
        FXMLLoader orderLoader = new FXMLLoader(Main.class.getResource("order-view.fxml"));
        Scene orderScene = new Scene((VBox) orderLoader.load(), 604, 549);
        Stage orderStage = new Stage();
        orderStage.setTitle("Your Order");
        orderStage.setScene(orderScene);
        orderStage.show();
        OrderController orderController = orderLoader.getController();
        orderController.setMainController(this);
    }

    @FXML
    void storeOrdersView(ActionEvent event) throws IOException {
        FXMLLoader storeLoader = new FXMLLoader(Main.class.getResource("storeOrders-view.fxml"));
        Scene storeScene = new Scene((VBox) storeLoader.load(), 604, 549);
        Stage storeStage = new Stage();
        storeStage.setTitle("Store Orders");
        storeStage.setScene(storeScene);
        storeStage.show();
        StoreOrderController storeOrdersController = storeLoader.getController();
        storeOrdersController.setMainController(this);
    }

}
