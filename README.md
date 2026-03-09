# Weather Desktop Application 🌤️

A **Java 21 + JavaFX desktop application** that fetches real-time weather data from the OpenWeatherMap API.  
Designed as a **lightweight, responsive desktop app** with modern Java techniques.

The app demonstrates modern Java development practices, **including Virtual Threads, Maven build automation, and responsive JavaFX UI updates**.

---

## Features

- 🌍 Weather lookup for multiple cities

- 📋 Dropdown city selection

- 🔄 Automatic weather refresh every 10 seconds

- ⚡ Instant update when the city changes

- 📊 Temperature progress bar gauge

- ⏳ Loading indicator while fetching data

- 🌦️ Weather icons for common conditions

- 🧵 Virtual Threads (Java 21) for efficient background tasks

- 🖥️ Runs as a standalone desktop application

---

## 🧰 Technologies Used
Technology	Purpose
Java 21	Core programming language
JavaFX 21	Desktop UI framework
Maven	Dependency management and build automation
Jackson Databind	JSON parsing
OpenWeatherMap API	Weather data provider
Virtual Threads	Lightweight concurrency model
ScheduledExecutorService	Periodic task scheduli
---

## 🧵 Concurrency Technique (Virtual Threads)

This project uses **Java 21 Virtual Threads** to fetch weather data without blocking the UI.

Benefits:

- Lightweight threads

- Thousands of concurrent tasks possible

- Ideal for I/O operations like API calls

- Cleaner asynchronous code

Example:

```bash
Thread.startVirtualThread(() -> fetchWeather(ui));

Periodic refresh:

scheduler.scheduleAtFixedRate(
    () -> fetchWeather(ui),
    0,
    10,
    TimeUnit.SECONDS
);
```
---


### 🏗️ Project Structure

```bash
weather-desktop-app/
├── src/main/java
│   ├── weather/WeatherApp.java          # Main app launcher
│   ├── ui/WeatherUI.java                # JavaFX UI
│   ├── service/WeatherService.java      # API fetch logic
│   ├── model/WeatherData.java           # Data model
│   └── scheduler/WeatherScheduler.java  # Scheduler using virtual threads
├── src/main/resources                   # Static resources (optional)
├── pom.xml                              # Maven configuration
└── README.md                            # Project documentation
```
---

## ⚙️ Setup & Installation

### 1️⃣ Clone the repository
`https://github.com/ParvezHossain/weather-desktop-app`
`cd weather-desktop-app`

#### Export you API KEY Linux:
`export API_KEY=f91e397080434089bbcaec`

##### Export you API KEY Window:

`$env:API_KEY="f91e397080434089bbcaec35"`

--- 

## ▶️ Run the Application

####Option 1: Build with jpackage (Executable file based on OS)

`mvn clean package jpackage:jpackage`

Executable file will be available on directory ${project.basedir}/dist

You can also create a real **Linux installer** like
- .deb
- .rpm

Example:

`mvn clean package jpackage:jpackage -Djpackage.type=deb`

Output:

`dist/weatherapp_1.0_amd64.deb`

Install the App for **Ubuntu**:

`sudo dpkg -i weatherapp_1.0_amd64.deb`

#### Option 2: Run with Maven

```bash
mvn clean javafx:run

This runs the application using the JavaFX Maven Plugin.

```

#### Option 3: Build a standalone fat JAR (recommended)

The fat JAR includes JavaFX runtime, so no extra module path is needed:

### Build the fat JAR
`mvn clean package`

### Run the standalone desktop app
`java -jar target/weather-desktop-app-1.0.jar`

---

## 🔑 API Configuration

The application uses OpenWeatherMap API.

Get a free API key:

`https://openweathermap.org/api`

Then update the API key inside:

`WeatherService.java`

Example:

`private static final String API_KEY = "YOUR_API_KEY";`

---

## 📚 Learning Highlights

This project demonstrates:

- Modern Java 21 development

- Virtual Thread concurrency

- JavaFX desktop UI design

- Maven build automation

- API integration with HTTP Client

- JSON parsing with Jacks

---

### 📜 License

MIT License

Feel free to use this project for learning, experimentation, or portfolio work.
