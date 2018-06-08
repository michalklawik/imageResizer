package kata;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Okno extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane stackPane = new StackPane();
        Button button = new Button("Przycisk");
        stackPane.getChildren().add(button);

        Scene scene = new Scene(stackPane, 400, 600);

        primaryStage.setScene(scene);

        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setOpacity(0.8);
        primaryStage.setTitle("Pierwsze okno");
        primaryStage.show();
    }
}
