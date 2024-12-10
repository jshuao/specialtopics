module jgoodman.Template {
    requires javafx.controls;
    requires javafx.fxml;

    opens template to javafx.fxml;
    exports template;
}
