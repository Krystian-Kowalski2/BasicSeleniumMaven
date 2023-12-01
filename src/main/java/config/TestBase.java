package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static String BASE_URL = "https://the-internet.herokuapp.com/";
    public static WebDriver driver;

    @BeforeGroups
    public WebDriver setDriver() {
        // Set up the WebDriverManager for chrome driver
        return new ChromeDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void prepareSuite() {
        driver = setDriver();
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
