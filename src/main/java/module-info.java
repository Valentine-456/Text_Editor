module editor.text_editor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens editor.text_editor to javafx.fxml;
    exports editor.text_editor;
}