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
        if(selectedFile != null) {
            String filePath = selectedFile.getAbsolutePath();
            htmlEditor.setHtmlText(FileUtils.readFile(filePath));
            CurrentFile.setNewFile(filePath);
            stage.setTitle(CurrentFile.getFileName());
        }
    }

    @FXML
    public void saveFile(ActionEvent event) {
        if(CurrentFile.getFileName() == null) {
            File file = saveAsFile(event);
            CurrentFile.setNewFile(file.getAbsolutePath());
            stage.setTitle(CurrentFile.getFileName());
        } else {
            File currentFile = new File(CurrentFile.getFilePath());
            if(currentFile.exists()) {
                FileUtils.writeToFile(currentFile.getAbsolutePath(), htmlEditor.getHtmlText());
            }
        }
    }

    @FXML
    public File saveAsFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showSaveDialog(stage);
        if(selectedFile != null) {
            String filePath = selectedFile.getAbsolutePath();
            FileUtils.writeToFile(filePath, htmlEditor.getHtmlText());
        }
        return selectedFile;
    }

    @FXML
    public void close(ActionEvent event) {
        htmlEditor.setHtmlText("<html><head><style> p {margin: 0;}</style></head><body contenteditable=\"true\"></body></html>");
        CurrentFile.clearCurrentFile();
        stage.setTitle("Text Editor");
    }
}