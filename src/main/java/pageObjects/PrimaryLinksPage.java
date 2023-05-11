package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

@Getter
public class PrimaryLinksPage extends BasePageObject {

    public PrimaryLinksPage(WebDriver driver) {
        super(driver);
    }

    public void goAddRemoveElements() {
        getAddRemoveLink().click();
        waitUtils.waitForUrlToContain("add_remove_elements");
    }

    @FindBy(css = "a[href='/add_remove_elements/']")
    private WebElement addRemoveLink;
}
