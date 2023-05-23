package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Getter
public class DropdownPage extends BasePageObject{
    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void chooseFromDropdown() {
        Select dropdown = new Select(getDropdown());
        dropdown.selectByVisibleText("Option 1");
        assertTrue(getFirstOption().isSelected());
        assertFalse(getSecondOption().isSelected());
        dropdown.selectByVisibleText("Option 2");
        assertFalse(getFirstOption().isSelected());
        assertTrue(getSecondOption().isSelected());
    }

    @FindBy(css = "option[value='1']")
    private WebElement firstOption;

    @FindBy(css = "option[value='2']")
    private WebElement secondOption;

    @FindBy(id = "dropdown")
    private WebElement dropdown;
}
