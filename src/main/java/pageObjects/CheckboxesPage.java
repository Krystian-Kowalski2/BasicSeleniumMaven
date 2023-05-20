package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Getter
public class CheckboxesPage extends BasePageObject {
    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    private void checkCheckbox(WebElement element) {
        if (!element.isSelected()) element.click();
        assertTrue(element.isSelected());
    }

    private void uncheckCheckbox(WebElement element) {
        if (element.isSelected()) element.click();
        assertFalse(element.isSelected());
    }

    public void checkFirstCheckbox() {
        checkCheckbox(getCheckbox1());
    }

    public void checkSecondCheckbox() {
        checkCheckbox(getCheckbox2());
    }

    public void uncheckFirstCheckbox() {
        uncheckCheckbox(getCheckbox1());
    }

    public void uncheckSecondCheckbox() {
        uncheckCheckbox(getCheckbox2());
    }

    @FindBy(css = "input[type=checkbox]:nth-child(1)")
    private WebElement checkbox1;

    @FindBy(css = "input[type=checkbox]:nth-child(3)")
    private WebElement checkbox2;
}
