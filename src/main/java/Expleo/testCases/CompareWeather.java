// This class contains the main method which creates two page objects, each containing the data retrieved
// from the respective websites. The max and min temperature for each day are then compared.

package Expleo.testCases;
import Expleo.pageObjects.AccuweatherPageObject;
import Expleo.pageObjects.WeatherNews24PageObject;

public class CompareWeather {
    public static void main(String[] args) {
        // Create a page object and retrieve the weather forecast for the next five days
        AccuweatherPageObject accuweatherForecast = AccuweatherForecast.getAccuweatherForecast();
        System.out.println("Accuweather Forecast for Cape Town");
        accuweatherForecast.printBoth();

        // Create a page object and retrieve the weather forecast for the next five days
        WeatherNews24PageObject weatherNews24Forecast = WeatherNews24Forecast.getWeatherNews24Forecast();
        System.out.println("Weather News 24 Forecast for Cape Town");
        weatherNews24Forecast.printBoth();

        // Compare the max and min temperatures for both websites
        System.out.println("\n\n\nWeather Site Comparisons for Cape Town");
        for (int i = 0; i < 5; i++) {
            System.out.println("\nDay " + (i+1) + " Comparison");
            System.out.print("AW Max: " + accuweatherForecast.getMaxTemp(i) + " °C\t\tWN24 Max: " + weatherNews24Forecast.getMaxTemp(i) + " °C");
            if (accuweatherForecast.getMaxTemp(i) == weatherNews24Forecast.getMaxTemp(i))
                System.out.println("\t\t[Max Temperatures are equal]");
            else
                System.out.println("\t\t[Max Temperatures are different]");
            System.out.print("AW Min: " + accuweatherForecast.getMinTemp(i) + " °C\t\tWN24 Min: " + weatherNews24Forecast.getMinTemp(i) + " °C");
            if (accuweatherForecast.getMinTemp(i) == weatherNews24Forecast.getMinTemp(i))
                System.out.println("\t\t[Min Temperatures are equal]");
            else
                System.out.println("\t\t[Min Temperatures are different]");
        }
    }
}