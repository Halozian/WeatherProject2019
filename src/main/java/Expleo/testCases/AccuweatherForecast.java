// Java Class to Retrieve and Store the Accuweather Forecast

package Expleo.testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import Expleo.pageObjects.AccuweatherPageObject;
import org.junit.*;
import static junit.framework.TestCase.fail;

public class AccuweatherForecast {
    private String output;
    private String baseUrl;
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @Test
    public void getAccuweatherForecast() throws Exception {
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
        System.out.print("Accuweather Day 1 Max: " + output);
        pageObjectAW.addMaxTemp(0, Integer.parseInt(output.substring(1,3)));
        // Get Min Temp for Day 1
        output =  driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[2]")).getAttribute("innerHTML");
        System.out.println("\tMin: " + output.substring(3,7));
        pageObjectAW.addMinTemp(0, Integer.parseInt(output.substring(3,5)));

        // Get Max Temp for Day 2
        output = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[3]/span[1]")).getAttribute("innerHTML");
        System.out.print("Accuweather Day 2 Max: " + output);
        pageObjectAW.addMaxTemp(1, Integer.parseInt(output.substring(1,3)));
        // Get Min Temp for Day 2
        output =  driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[3]/span[2]")).getAttribute("innerHTML");
        System.out.println("\tMin: " + output.substring(3,7));
        pageObjectAW.addMinTemp(1, Integer.parseInt(output.substring(3,5)));

        // Get Max Temp for Day 3
        output = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[4]/span[1]")).getAttribute("innerHTML");
        System.out.print("Accuweather Day 3 Max: " + output);
        pageObjectAW.addMaxTemp(2, Integer.parseInt(output.substring(1,3)));
        // Get Min Temp for Day 3
        output =  driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[4]/span[2]")).getAttribute("innerHTML");
        System.out.println("\tMin: " + output.substring(3,7));
        pageObjectAW.addMinTemp(2, Integer.parseInt(output.substring(3,5)));

        // Get Max Temp for Day 4
        output = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[5]/span[1]")).getAttribute("innerHTML");
        System.out.print("Accuweather Day 4 Max: " + output);
        pageObjectAW.addMaxTemp(3, Integer.parseInt(output.substring(1,3)));
        // Get Min Temp for Day 4
        output =  driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[5]/span[2]")).getAttribute("innerHTML");
        System.out.println("\tMin: " + output.substring(3,7));
        pageObjectAW.addMinTemp(3, Integer.parseInt(output.substring(3,5)));

        // Get Max Temp for Day 5
        output = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[6]/span[1]")).getAttribute("innerHTML");
        System.out.print("Accuweather Day 5 Max: " + output);
        pageObjectAW.addMaxTemp(4, Integer.parseInt(output.substring(1,3)));
        // Get Min Temp for Day 5
        output =  driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[6]/span[2]")).getAttribute("innerHTML");
        System.out.println("\tMin: " + output.substring(3,7));
        pageObjectAW.addMinTemp(4, Integer.parseInt(output.substring(3,5)));
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