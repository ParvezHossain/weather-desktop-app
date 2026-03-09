module com.parvez.weather {

    requires javafx.controls;
    requires javafx.fxml;

    requires java.net.http;

    requires com.fasterxml.jackson.databind;

    opens model to com.fasterxml.jackson.databind;

    exports weather;
}