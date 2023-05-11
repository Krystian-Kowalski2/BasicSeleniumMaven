package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static org.junit.Assert.assertTrue;

@Getter
public class AddRemoveElementsPage extends BasePageObject {

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    public void addElement() {
        getAddElementButton().click();
        assertTrue(addElementButton.isDisplayed());
    }

    public void deleteElement() throws IndexOutOfBoundsException {
        try {
            addedElements.get(0).click();
        } catch (IndexOutOfBoundsException ignore) { }

    }

    public void countAddedElements(int numberOfAdded) {
        assertTrue(getAddedElements().size() == numberOfAdded);
    }

    @FindBy(css = "button[onclick='addElement()']")
    private WebElement addElementButton;

    @FindBys({
            @FindBy(id = "elements"),
            @FindBy(className = "added-manually")
    })
    private List<WebElement> addedElements;
}
