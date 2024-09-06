module fx.solo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens fx.solo to javafx.fxml;
    exports fx.solo;
    exports fx.solo.Uses;
    opens fx.solo.Uses to javafx.fxml;
    exports fx.solo.Controllers;
    opens fx.solo.Controllers to javafx.fxml;
}