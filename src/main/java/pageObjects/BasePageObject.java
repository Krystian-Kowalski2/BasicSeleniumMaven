package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;


public class BasePageObject {
    public WaitUtils waitUtils;

    public BasePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }
}
