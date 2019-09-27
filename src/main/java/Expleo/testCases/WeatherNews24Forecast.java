// Java Class to Retrieve and Store the Weather News 24 Forecast

package Expleo.testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import Expleo.pageObjects.WeatherNews24PageObject;
import org.junit.*;
import static junit.framework.TestCase.fail;

public class WeatherNews24Forecast {
    private String output;
    private String baseUrl;
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Test
    public void getWeatherNews24Forecast() throws Exception {
        baseUrl = "http://weather.news24.com/";
        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='wrapper']/table/tbody/tr[3]/td/div[2]/div[1]/a[1]")).click();
        driver.findElement(By.xpath(".//*[@id='ext-gen32']")).click();
        WeatherNews24PageObject pageObjectWN24 = PageFactory.initElements(driver, WeatherNews24PageObject.class);

        // Get Max Temp for Day 1
        output = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[3]/td[4]")).getAttribute("innerHTML");
        // System.out.print("WN24 Day 1 Max: " + output);
        pageObjectWN24.addMaxTemp(0, Integer.parseInt(output.substring(0,2)));
        // Get Min Temp for Day 1
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[5]")).getAttribute("innerHTML");
        // System.out.println("\tMin: " + output);
        pageObjectWN24.addMinTemp(0, Integer.parseInt(output.substring(0,2)));

        // Get Max Temp for Day 2
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[4]")).getAttribute("innerHTML");
        // System.out.print("WN24 Day 2 Max: " + output);
        pageObjectWN24.addMaxTemp(1, Integer.parseInt(output.substring(0,2)));
        // Get Min Temp for Day 2
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[5]")).getAttribute("innerHTML");
        // System.out.println("\tMin: " +output);
        pageObjectWN24.addMinTemp(1, Integer.parseInt(output.substring(0,2)));

        // Get Max Temp for Day 3
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[4]")).getAttribute("innerHTML");
        // System.out.print("WN24 Day 3 Max: " + output);
        pageObjectWN24.addMaxTemp(2, Integer.parseInt(output.substring(0,2)));
        // Get Min Temp for Day 3
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[5]")).getAttribute("innerHTML");
        // System.out.println("\tMin: " + output);
        pageObjectWN24.addMinTemp(2, Integer.parseInt(output.substring(0,2)));

        // Get Max Temp for Day 4
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[4]")).getAttribute("innerHTML");
        // System.out.print("WN24 Day 4 Max: " + output);
        pageObjectWN24.addMaxTemp(3, Integer.parseInt(output.substring(0,2)));
        // Get Min Temp for Day4
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[5]")).getAttribute("innerHTML");
        // System.out.println("\tMin: " + output);
        pageObjectWN24.addMinTemp(3, Integer.parseInt(output.substring(0,2)));

        // Get Max Temp for Day 5
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[4]")).getAttribute("innerHTML");
        // System.out.print("WN24 Day 5 Max: " + output);
        pageObjectWN24.addMaxTemp(4, Integer.parseInt(output.substring(0,2)));
        // Get Min Temp for Day 5
        output = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[5]")).getAttribute("innerHTML");
        // System.out.println("\tMin: " + output);
        pageObjectWN24.addMinTemp(4, Integer.parseInt(output.substring(0,2)));

        // Print Results
        System.out.println("Weather News 24 Forecast:");
        pageObjectWN24.printBoth();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}