package Conection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class Conection {
    private static String conditionString;
    private static String descripitionString;
    private static Double humidityDouble;
    private static Double windSpeedyDouble;
    private static Double pressureDouble;
    private static String datetimeString;
    private static Double windgustDouble;
    public static void main(String[] args) {
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://bestweather.p.rapidapi.com/weather/Salvador%20BA/today"))
		.header("X-RapidAPI-Key", "f2f143bc54msh8c3040493d71cdbp1c6858jsnb949724e6234")
		.header("X-RapidAPI-Host", "bestweather.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        try {
           HttpResponse<String>  response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
           JSONObject weather = new JSONObject(response.body());  
            conditionString = weather.getJSONArray("days").getJSONObject(0).getString("conditions");;
             descripitionString = weather.getJSONArray("days").getJSONObject(0).getString("description") ;
             humidityDouble = weather.getJSONArray("days").getJSONObject(0).getDouble("humidity");
             windSpeedyDouble = weather.getJSONArray("days").getJSONObject(0).getDouble("windspeed");
             pressureDouble = weather.getJSONArray("days").getJSONObject(0).getDouble("pressure");    
             datetimeString = weather.getJSONArray("days").getJSONObject(0).getString("datetime");;
            windgustDouble = weather.getJSONArray("days").getJSONObject(0).getDouble("windgust");    
            System.out.println("Dado da api: "+pressureDouble);
           

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
    }
        /*Method for save the variable */
 
        public static String getConditionString() {
            return conditionString;
        }
        public static void setConditionString(String conditionString) {
            Conection.conditionString = conditionString;
        }
        public static String getDescripitionString() {
            return descripitionString;
        }
        public static void setDescripitionString(String descripitionString) {
            Conection.descripitionString = descripitionString;
        }
        public static Double getHumidityDouble() {
            return humidityDouble;
        }
        public static void setHumidityDouble(Double humidityDouble) {
            Conection.humidityDouble = humidityDouble;
        }
        public static Double getWindSpeedyDouble() {
            return windSpeedyDouble;
        }
        public static void setWindSpeedyDouble(Double windSpeedyDouble) {
            Conection.windSpeedyDouble = windSpeedyDouble;
        }
        public static Double getPressureDouble() {
            return pressureDouble;
        }
        public static void setPressureDouble(Double pressureDouble) {
            Conection.pressureDouble = pressureDouble;
        }
        public static String getDatetimeString() {
            return datetimeString;
        }
        public static void setDatetimeString(String datetimeString) {
            Conection.datetimeString = datetimeString;
        }
        public static Double getWindgustDouble() {
            return windgustDouble;
        }
        public static void setWindgustDouble(Double windgustDouble) {
            Conection.windgustDouble = windgustDouble;
        }
    
        
           
        
    
   
}

