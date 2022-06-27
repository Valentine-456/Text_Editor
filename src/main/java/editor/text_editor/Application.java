package editor.text_editor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("editor.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Text Editor");
        stage.getIcons().add(new Image("file:src/main/resources/editor/text_editor/icon.png"));
        stage.setScene(scene);
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("ESC"));

        Controller controller = fxmlLoader.getController();
        controller.setStage(stage);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}