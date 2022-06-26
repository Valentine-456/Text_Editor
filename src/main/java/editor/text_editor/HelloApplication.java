package editor.text_editor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("editor.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Text Editor");
        stage.getIcons().add(new Image("file:src/main/resources/editor/text_editor/icon.png"));
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("ESC"));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}