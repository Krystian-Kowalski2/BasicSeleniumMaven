package pageObjects;

import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static config.TestBase.driver;

@Getter
public class BasicAuthPage extends BasePageObject{

    public BasicAuthPage(WebDriver driver) {
        super(driver);
    }

    public void fillInFieldsValid() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        assertTrue(getTextField().getText().contains("Congratulations! You must have the proper credentials."));
    }

    public void fillInFieldsInvalid() {
        driver.get("https://false:false@the-internet.herokuapp.com/basic_auth");
        try {
            assertFalse(getTextField().isDisplayed());
        } catch (NoSuchElementException ignore){ }
    }

    @FindBy(className = "example")
    private WebElement textField;

}
