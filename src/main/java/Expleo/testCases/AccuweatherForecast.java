// Java Class to Retrieve and Store the Accuweather Forecast Data

package Expleo.testCases;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import Expleo.pageObjects.AccuweatherPageObject;

public class AccuweatherForecast {
    // Private Variables
    private static String output;
    private static String baseUrl;
    private static WebDriver driver;

    // Retrieve the weather forecast for the next five days from accuweather.com
    public static AccuweatherPageObject getAccuweatherForecast() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        baseUrl = "https://www.accuweather.com/";
        // Manual Navigation
        // driver.get(baseUrl);
        // driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[1]/form/input")).sendKeys("Cape Town");
        // driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[1]/svg[1]")).click();
        // driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div[1]/div[1]/a[1]")).click();
        // driver.findElement(By.xpath("/html/body/div/div[4]/div/div/div[3]/a[4]/span")).click();
        driver.get(baseUrl + "/en/za/cape-town/306633/daily-weather-forecast/306633");
        AccuweatherPageObject pageObjectAW = PageFactory.initElements(driver, AccuweatherPageObject.class);

        // Get Max Temp for Day 1
        output = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[1]")).getAttribute("innerHTML");
        pageObjectAW.addMaxTemp(0, Integer.parseInt(output.substring(1,3)));
        // Get Min Temp for Day 1
        output =  driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[2]")).getAttribute("innerHTML");
        pageObjectAW.addMinTemp(0, Integer.parseInt(output.substring(3,5)));

        // Get Max Temp for Day 2
        output = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[1]")).getAttribute("innerHTML");
        pageObjectAW.addMaxTemp(1, Integer.parseInt(output.substring(1,3)));
        // Get Min Temp for Day 2
        output =  driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[2]")).getAttribute("innerHTML");
        pageObjectAW.addMinTemp(1, Integer.parseInt(output.substring(3,5)));

        // Get Max Temp for Day 3
        output = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[1]")).getAttribute("innerHTML");
        pageObjectAW.addMaxTemp(2, Integer.parseInt(output.substring(1,3)));
        // Get Min Temp for Day 3
        output =  driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[2]")).getAttribute("innerHTML");
        pageObjectAW.addMinTemp(2, Integer.parseInt(output.substring(3,5)));

        // Get Max Temp for Day 4
        output = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[5]/a[1]/div[2]/span[1]")).getAttribute("innerHTML");
        pageObjectAW.addMaxTemp(3, Integer.parseInt(output.substring(1,3)));
        // Get Min Temp for Day 4
        output =  driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[5]/a[1]/div[2]/span[2]")).getAttribute("innerHTML");
        pageObjectAW.addMinTemp(3, Integer.parseInt(output.substring(3,5)));

        // Get Max Temp for Day 5
        output = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[1]")).getAttribute("innerHTML");
        pageObjectAW.addMaxTemp(4, Integer.parseInt(output.substring(1,3)));
        // Get Min Temp for Day 5
        output =  driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[2]")).getAttribute("innerHTML");
        pageObjectAW.addMinTemp(4, Integer.parseInt(output.substring(3,5)));

        driver.quit();
        return pageObjectAW;
    }
}