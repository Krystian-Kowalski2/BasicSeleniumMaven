package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertTrue;

@Getter
public class FormAuthenticationPage extends BasePageObject {
    public FormAuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public void fillInUsername(String login) {
        getUsername().sendKeys(login);
    }

    public void fillInPassword(String password) {
        getPassword().sendKeys(password);
    }

    public void clickLogin() {
        getLoginButton().click();
    }

    public void clickLogout() {
        getLogoutButton().click();
        assertTrue(getFlashPrompt().getText().contains("You logged out of the secure area!"));
    }

    public void checkInvalidLoginMessage() {
        assertTrue(getFlashPrompt().getText().contains("Your username is invalid!"));
    }

    @FindBy(id="username")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(className = "radius")
    private WebElement loginButton;

    @FindBy(tagName = "h4")
    private WebElement loggedInText;

    @FindBy(className = "icon-signout")
    private WebElement logoutButton;

    @FindBy(id = "flash")
    private WebElement flashPrompt;
}
