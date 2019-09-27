// Java Class to Retrieve and Store the Weather News 24 Forecast Data

package Expleo.testCases;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import Expleo.pageObjects.WeatherNews24PageObject;

public class WeatherNews24Forecast {
    // Private Variables
    private static String output;
    private static String baseUrl;
    private static WebDriver driver;

    // Retrieve the weather forecast for the next five days from weather.news24.com
    public static WeatherNews24PageObject getWeatherNews24Forecast() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        baseUrl = "http://weather.news24.com/";
        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='wrapper']/table/tbody/tr[3]/td/div[2]/div[1]/a[1]")).click();
        driver.findElement(By.xpath(".//*[@id='ext-gen32']")).click();
        WeatherNews24PageObject pageObjectWN24 = PageFactory.initElements(driver, WeatherNews24PageObject.class);

        // Get Max Temp for Day 1
        output = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[3]/td[4]")).getAttribute("innerHTML");
        pageObjectWN24.addMaxTemp(0, Integer.parseInt(output.substring(0,2)));
        // Get Min Temp for Day 1
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[5]")).getAttribute("innerHTML");
        pageObjectWN24.addMinTemp(0, Integer.parseInt(output.substring(0,2)));

        // Get Max Temp for Day 2
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[4]")).getAttribute("innerHTML");
        pageObjectWN24.addMaxTemp(1, Integer.parseInt(output.substring(0,2)));
        // Get Min Temp for Day 2
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[5]")).getAttribute("innerHTML");
        pageObjectWN24.addMinTemp(1, Integer.parseInt(output.substring(0,2)));

        // Get Max Temp for Day 3
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[4]")).getAttribute("innerHTML");
        pageObjectWN24.addMaxTemp(2, Integer.parseInt(output.substring(0,2)));
        // Get Min Temp for Day 3
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[5]")).getAttribute("innerHTML");
        pageObjectWN24.addMinTemp(2, Integer.parseInt(output.substring(0,2)));

        // Get Max Temp for Day 4
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[4]")).getAttribute("innerHTML");
        pageObjectWN24.addMaxTemp(3, Integer.parseInt(output.substring(0,2)));
        // Get Min Temp for Day4
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[5]")).getAttribute("innerHTML");
        pageObjectWN24.addMinTemp(3, Integer.parseInt(output.substring(0,2)));

        // Get Max Temp for Day 5
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[4]")).getAttribute("innerHTML");
        pageObjectWN24.addMaxTemp(4, Integer.parseInt(output.substring(0,2)));
        // Get Min Temp for Day 5
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[5]")).getAttribute("innerHTML");
        pageObjectWN24.addMinTemp(4, Integer.parseInt(output.substring(0,2)));

        driver.quit();
        return pageObjectWN24;
    }
}