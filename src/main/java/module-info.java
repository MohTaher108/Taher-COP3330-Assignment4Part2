module ucf.assignments {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens ucf.assignments to javafx.fxml;
    exports ucf.assignments;
}