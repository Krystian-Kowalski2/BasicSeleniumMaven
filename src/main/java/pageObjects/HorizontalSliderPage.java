package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static config.TestBase.driver;
import static org.junit.Assert.assertTrue;

@Getter
public class HorizontalSliderPage extends BasePageObject {
    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    public void moveSlider() {
        Actions move = new Actions(driver);
        Action action = move.dragAndDropBy(getSlider(), 30, 0).build();
        action.perform();
    }

    public void readSliderValue() {
        assertTrue(getSliderValue().getText().contains("4"));
    }

    @FindBy(id = "range")
    private WebElement sliderValue;

    @FindBy(css = "input[type='range']")
    private WebElement slider;
}
