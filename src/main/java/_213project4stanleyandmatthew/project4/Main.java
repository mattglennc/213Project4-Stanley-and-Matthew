package _213project4stanleyandmatthew.project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This Main class launches the GUI and loads its javfx file.
 * Afterwards operation and event handling is done in the MainController class
 *
 * @author Matthew Carrascoso & Stanley Chou
 */
public class Main extends Application {

    /**
     * Creates an FXMLLoader and loads the main-viwq.fxml file
     * afterwards the it sets the stage for the GUI
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 604, 549);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches the Javafx GUI
     */
    public static void main(String[] args) {
        launch();
    }
}