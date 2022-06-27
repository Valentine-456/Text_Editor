package editor.text_editor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class Controller {
    private Stage stage;
    @FXML
    private HTMLEditor htmlEditor;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void openFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        String filePath = selectedFile.getAbsolutePath();
        htmlEditor.setHtmlText(FileUtils.readFile(filePath));
    }

    @FXML
    public void saveFile(ActionEvent event) {
    }

    @FXML
    public void saveAsFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        String filePath = selectedFile.getAbsolutePath();
        FileUtils.writeToFile(filePath, htmlEditor.getHtmlText());
    }
}