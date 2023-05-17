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

    private void goToPage(WebElement element, String url) {
        element.click();
        waitUtils.waitForUrlToContain(url);
    }

    public void goAddRemoveElements() {
        goToPage(getAddRemovePage(), "add_remove_elements");
    }

    public void goToDisappearingElementsPage() {
        goToPage(getDisappearingElementsPage(), "disappearing_elements");
    }

    public void goToFormAuthenticationPage() {
        goToPage(getFormAuthenticationPage(), "login");
    }

    public void goToBasicAuthPage(){
        goToPage(getBasicAuthPage(), "basic_auth");
    }

    public void goToHoversPage(){
        goToPage(getHoversPage(), "hovers");
    }

    @FindBy(css = "a[href='/add_remove_elements/']")
    private WebElement addRemovePage;

    @FindBy(css = "a[href='/disappearing_elements']")
    private WebElement disappearingElementsPage;

    @FindBy(css = "a[href='/basic_auth']")
    private WebElement basicAuthPage;

    @FindBy(css = "a[href='/login']")
    private WebElement formAuthenticationPage;

    @FindBy(css = "a[href='/hovers']")
    private WebElement hoversPage;
}
