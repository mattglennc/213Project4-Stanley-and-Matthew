package _213project4stanleyandmatthew.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    void coffeeView(ActionEvent event) throws IOException{
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
    void orderingView(ActionEvent event) throws IOException{

    }

    @FXML
    void storeOrdersView(ActionEvent event) throws IOException{

    }

}
