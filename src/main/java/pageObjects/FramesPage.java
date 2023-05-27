package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static config.TestBase.driver;
import static org.junit.Assert.assertTrue;

@Getter
public class FramesPage extends BasePageObject {
    public FramesPage(WebDriver driver) {
        super(driver);
    }
    public void clickNestedFramesLink() {
        getNestedFramesLink().click();
    }

    public void switchToMiddleFrame() {
        driver.switchTo().frame(getTopFrames());
        driver.switchTo().frame(getMiddleFrame());
        assertTrue(getFrameContent().getText().contains("MIDDLE"));
    }

    public void clickIFrameLink() {
        getIFrameLink().click();
    }

    @FindBy(css = "a[href='/nested_frames']")
    private WebElement nestedFramesLink;

    @FindBy(css = "a[href='/iframe']")
    private WebElement iFrameLink;

    @FindBy(name = "frame-top")
    private WebElement topFrames;

    @FindBy(name = "frame-middle")
    private WebElement middleFrame;

    @FindBy(id = "content")
    private WebElement frameContent;
}
