package weather;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scheduler.WeatherScheduler;
import ui.WeatherUI;

public class WeatherApp extends Application {

    @Override
    public void start(Stage stage) {

        WeatherUI ui = new WeatherUI();

        Scene scene = new Scene(ui, 350, 300);

        stage.setTitle("Weather Dashboard");
        stage.setScene(scene);
        stage.show();

        WeatherScheduler scheduler = new WeatherScheduler();
        scheduler.start(ui);
    }

    public static void main(String[] args) {
        launch();
    }
}
