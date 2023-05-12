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

    private void addElement() {
        getAddElementButton().click();
    }

    private void deleteElement() {
        addedElements.get(0).click();
    }

    int numberOfAdded = (int) (Math.random() * 4) + 1;
    int numberOfDeleted = numberOfAdded - numberOfAdded;
    public void countAddedElements() {
        for (int i = 0; i < numberOfAdded; i++) {
            addElement();
            waitUtils.waitForVisibilityOfElements(getAddedElements());
        }
        assertTrue("Number of found elements " + getAddedElements().size(), getAddedElements().size() == numberOfAdded);
        for (int i = 0; i < numberOfAdded; i++) {
            deleteElement();
        }
        assertTrue("Found elements " + getAddedElements().size() + " Expected " + numberOfDeleted, getAddedElements().size() == numberOfDeleted);
    }

    @FindBy(css = "button[onclick='addElement()']")
    private WebElement addElementButton;

    @FindBys({
            @FindBy(id = "elements"),
            @FindBy(className = "added-manually")
    })
    private List<WebElement> addedElements;
}
