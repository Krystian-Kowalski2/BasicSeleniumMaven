package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertTrue;

import static config.TestBase.driver;

@Getter
public class HoversPage extends BasePageObject {
    public HoversPage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    public void hoverOverUser1() {
        actions.moveToElement(getUser1()).perform();
        assertTrue(getUser1Profile().isDisplayed());
    }

    public void clickUser1Redirect() {
        getUser1Profile().click();
        waitUtils.waitForUrlToContain("/users/1");
    }

    @FindBy(css = "div:nth-child(3) > img")
    private WebElement user1;

    @FindBy(css = "a[href='/users/1']")
    private WebElement user1Profile;
}
