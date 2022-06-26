module editor.text_editor {
    requires javafx.controls;
    requires javafx.fxml;


    opens editor.text_editor to javafx.fxml;
    exports editor.text_editor;
}