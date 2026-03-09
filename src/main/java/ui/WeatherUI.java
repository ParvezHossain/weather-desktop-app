package ui;

import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class WeatherUI extends VBox {

	public ComboBox<String> cityDropdown = new ComboBox<>();

	public Label iconLabel = new Label("☀");
	public Label tempLabel = new Label("-- °C");
	public Label humidityLabel = new Label("Humidity: --");
	public Label descLabel = new Label("Condition: --");
	
	public ProgressBar tempGauge = new ProgressBar();
	public ProgressIndicator loader = new ProgressIndicator();
	
			;

	public WeatherUI() {

		cityDropdown.getItems().addAll("Dhaka", "London", "Tokyo", "New York");

		cityDropdown.setValue("Dhaka");

		setAlignment(Pos.CENTER);
		setSpacing(15);

		// Big weather icon
		iconLabel.setFont(new Font(50));

		// Big temperature display
		tempLabel.setFont(new Font(40));

		// Smaller labels
		humidityLabel.setFont(new Font(16));
		descLabel.setFont(new Font(18));
		
		tempGauge.setPrefWidth(220);
        tempGauge.setProgress(0);

		// Gradient sky background
		setStyle("""
				    -fx-padding: 30;
				    -fx-background-color: linear-gradient(to bottom,#4facfe,#00f2fe);
				""");

		getChildren().addAll(cityDropdown, loader, iconLabel, tempLabel,tempGauge, descLabel, humidityLabel);
	}
}