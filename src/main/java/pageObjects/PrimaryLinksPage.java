package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class PrimaryLinksPage extends BasePageObject {

    public PrimaryLinksPage(WebDriver driver) {
        super(driver);
    }

    public void goAddRemoveElements() {
        getAddRemoveLinkPage().click();
        waitUtils.waitForUrlToContain("add_remove_elements");
    }

    public void goToDisappearingElementsPage() {
        getDisappearingElementsPage().click();
        waitUtils.waitForUrlToContain("disappearing_elements");
    }

    @FindBy(css = "a[href='/add_remove_elements/']")
    private WebElement addRemoveLinkPage;

    @FindBy(css = "a[href='/disappearing_elements']")
    private WebElement disappearingElementsPage;
}
