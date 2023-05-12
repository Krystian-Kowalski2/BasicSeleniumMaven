import config.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BasicAuthPage;
import pageObjects.FormAuthenticationPage;
import pageObjects.PrimaryLinksPage;

public class AuthorisationTests extends TestBase {
    public PrimaryLinksPage primaryLinksPage;
    public BasicAuthPage basicAuthPage;
    public FormAuthenticationPage formAuthenticationPage;

    @BeforeMethod
    public void initOperations() {
        primaryLinksPage = new PrimaryLinksPage(driver);
        basicAuthPage = new BasicAuthPage(driver);
        formAuthenticationPage = new FormAuthenticationPage(driver);
    }

    @Test
    public void basicAuthPassTest() {
        primaryLinksPage.goToBasicAuthPage();
        basicAuthPage.fillInFieldsValid();
    }

    @Test
    public void basicAuthFailTest() {
        primaryLinksPage.goToBasicAuthPage();
        basicAuthPage.fillInFieldsInvalid();
    }

    @Test
    public void formAuthenticationValidTest() {
        primaryLinksPage.goToFormAuthenticationPage();
        formAuthenticationPage.fillInUsername("tomsmith");
        formAuthenticationPage.fillInPassword("SuperSecretPassword!");
        formAuthenticationPage.clickLogin();
        formAuthenticationPage.clickLogout();
    }

    @Test
    public void formAuthenticationInvalidTest() {
        primaryLinksPage.goToFormAuthenticationPage();
        formAuthenticationPage.fillInUsername("nottomsmith");
        formAuthenticationPage.fillInPassword("easytocrackpassword");
        formAuthenticationPage.clickLogin();
        formAuthenticationPage.checkInvalidLoginMessage();
    }
}
