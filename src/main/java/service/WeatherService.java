/**
 * 
 */
package service;


import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.WeatherData;

/**
 * 
 */
public class WeatherService {

	private static final String API_KEY = System.getenv("API_KEY");
	
	public WeatherData fetchWeather(String city) {
		try {
			
			// Encode city for URL
			String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
			
			String url =
	                "https://api.openweathermap.org/data/2.5/weather?q="
	                        + encodedCity + "&appid=" + API_KEY + "&units=metric";
			HttpClient client = HttpClient.newHttpClient();
			
			HttpRequest request = HttpRequest.newBuilder()
						.uri(URI.create(url))
						.GET()
						.build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			// Check HTTP status
            if (response.statusCode() != 200) {
                throw new RuntimeException("Weather API error: " + response.body());
            }
			
			ObjectMapper mapper = new ObjectMapper();
			JsonNode json = mapper.readTree(response.body());
			
			double temp = json.get("main").get("temp").asDouble();
            int humidity = json.get("main").get("humidity").asInt();
            
            String description = json.get("weather").get(0).get("description").asText();

            return new WeatherData(temp, humidity, description);
			
		} catch(Exception e) {
			
			throw new RuntimeException("Weather API error: " + e.getMessage());
		}
	}
}
