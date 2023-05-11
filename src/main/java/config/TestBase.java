package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static String BASE_URL = "https://the-internet.herokuapp.com/";
    public static WebDriver driver;

    public WebDriver setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void prepareSuite() {
        driver = setDriver();
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}
