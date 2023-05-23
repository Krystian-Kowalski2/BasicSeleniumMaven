package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
    }

    @FindBy(css = "option[value='1']")
    private WebElement firstOption;

    @FindBy(id = "dropdown")
    private WebElement dropdown;
}
