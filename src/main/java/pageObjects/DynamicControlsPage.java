package pageObjects;

import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.*;

@Getter
public class DynamicControlsPage extends BasePageObject{

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public void checkCheckboxSwitch() {
        assertTrue(getCheckbox().isDisplayed());
        try {
            assertFalse(getCheckboxMessage().isDisplayed());
        } catch (NoSuchElementException ignore) { }

        getCheckbox().click();
        getCheckboxOnOffButton().click();
        waitUtils.waitForElement(getCheckboxMessage());

        assertTrue(getCheckboxMessage().getText().contains("It's gone!"));
        try {
            assertFalse(getCheckbox().isDisplayed());
        } catch (NoSuchElementException ignore) { }
    }

    public void checkTextFieldSwitch() {
        assertFalse(getTextField().isEnabled());

        getInputOnOffButton().click();
        waitUtils.waitForElement(getCheckboxMessage());
        assertTrue(getCheckboxMessage().getText().contains("It's enabled!"));

        getTextField().sendKeys("testing");
    }

    @FindBy(css = "button[onclick='swapCheckbox()']")
    private WebElement checkboxOnOffButton;

    @FindBy(css = "input[type='checkbox']")
    private WebElement checkbox;

    @FindBy(css = "p[id='message']")
    private WebElement checkboxMessage;

    @FindBy(css = "button[onclick='swapInput()']")
    private WebElement inputOnOffButton;

    @FindBy(css = "input[type='text']")
    private WebElement textField;
}
