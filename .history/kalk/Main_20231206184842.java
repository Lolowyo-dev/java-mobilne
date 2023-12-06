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

        FileInputStream fxmlStream = new FileInputStream("kalk\\asdqwe.fxml");
 
        // Tworzy panel z pliku fxml
        VBox root = (VBox) loader.load(fxmlStream);
 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("A simple FXML Example");
        stage.show();
    }

    public static void main(String[] args) 
    {
        Application.launch(args);
    }
}