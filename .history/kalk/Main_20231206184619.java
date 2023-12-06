package kalk;

import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        // tworzenie FXMLLoader 
        FXMLLoader loader = new FXMLLoader();

        FileInputStream fxmlStream = new FileInputStream(asdqwe.fxml);
 
        // Create the Pane and all Details
        VBox root = (VBox) loader.load(fxmlStream);
 
        // Create the Scene
        Scene scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("A simple FXML Example");
        // Display the Stage
        stage.show();
    }

    public static void main(String[] args) 
    {
        Application.launch(args);
    }
}