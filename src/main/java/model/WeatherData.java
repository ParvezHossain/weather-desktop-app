package model;

public class WeatherData {
	private double temperature;
	private int humidity;
	private String description;
	
	public WeatherData(double temperature, int humidity, String description) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.description = description;
	}

	public double getTemperature() {
		return temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public String getDescription() {
		return description;
	}
	
	
	
}
