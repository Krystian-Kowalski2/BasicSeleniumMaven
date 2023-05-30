package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static config.TestBase.driver;
import static org.junit.Assert.assertTrue;

@Getter
public class NewWindowPage extends BasePageObject {
    public NewWindowPage(WebDriver driver) {
        super(driver);
    }

    private void switchToNewTab() {
        driver.switchTo().window(
                driver.getWindowHandles()
                        .stream()
                        .reduce((first, last) -> last)
                        .get());
    }

    public void checkRedirect() {
        getRedirectionLink().click();
        switchToNewTab();
        assertTrue(getHeader().getText().contains("New Window"));
    }

    @FindBy(css = "h3")
    private WebElement header;

    @FindBy(xpath = "//a[contains(text(),'Click Here')]")
    private WebElement redirectionLink;
}
