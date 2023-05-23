package pageObjects;

import lombok.Getter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static config.TestBase.driver;
import static org.junit.Assert.assertTrue;

@Getter
public class ContextMenuPage extends BasePageObject{

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public void openHotSpot() {
        Actions actions = new Actions(driver);
        actions.contextClick(getHotSpot()).perform();
    }

    public void checkAlertText() {
        Alert alert = driver.switchTo().alert();
        assertTrue(alert.getText().contains("You selected a context menu"));
        alert.accept();
    }

    @FindBy(id = "hot-spot")
    private WebElement hotSpot;
}
