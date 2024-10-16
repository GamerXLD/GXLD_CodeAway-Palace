package bd.edu.seu.seucash4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    public static void change(String filename)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(filename+".fxml"));

        try {
          Scene  scene = new Scene(fxmlLoader.load(), 600, 400);

          stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}