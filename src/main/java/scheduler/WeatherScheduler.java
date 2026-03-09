package scheduler;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import model.WeatherData;
import service.WeatherService;
import ui.WeatherUI;

public class WeatherScheduler {

    private final WeatherService service = new WeatherService();

    // Scheduled executor using virtual threads
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1, Thread.ofVirtual().factory());

    public void start(WeatherUI ui) {

        // Schedule periodic weather fetch every 10 seconds
        scheduler.scheduleAtFixedRate(() -> fetchWeather(ui),
                0, 10, TimeUnit.SECONDS); // initial delay 0, repeat every 10s

        // Immediate fetch on city selection using virtual thread
        ui.cityDropdown.setOnAction(e ->
                Thread.startVirtualThread(() -> fetchWeather(ui)));
    }

    private void fetchWeather(WeatherUI ui) {
        String city = ui.cityDropdown.getValue();

        // show loader
        Platform.runLater(() -> ui.loader.setVisible(true));

        try {
            WeatherData data = service.fetchWeather(city);

            Platform.runLater(() -> {
                ui.tempLabel.setText(data.getTemperature() + " °C");
                ui.humidityLabel.setText("Humidity: " + data.getHumidity() + "%");
                ui.descLabel.setText(data.getDescription());
                ui.iconLabel.setText(getWeatherIcon(data.getDescription()));
                ui.tempGauge.setProgress(data.getTemperature() / 50.0);

                ui.loader.setVisible(false);
            });

        } catch (Exception ex) {
            Platform.runLater(() -> {
                ui.descLabel.setText("Failed to fetch data");
                ui.loader.setVisible(false);
            });
            ex.printStackTrace();
        }
    }

    private String getWeatherIcon(String description) {
        description = description.toLowerCase();
        if (description.contains("clear")) return "☀";
        if (description.contains("cloud")) return "☁";
        if (description.contains("rain")) return "🌧";
        if (description.contains("storm")) return "⛈";
        if (description.contains("snow")) return "❄";
        return "🌡";
    }
}
