import config.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.NewWindowPage;
import pageObjects.PrimaryLinksPage;

public class NewTabTests extends TestBase {
    PrimaryLinksPage primaryLinksPage;
    NewWindowPage newWindowPage;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        primaryLinksPage = new PrimaryLinksPage(driver);
        newWindowPage = new NewWindowPage(driver);
    }


    @Test
    public void openNewTabTest() {
        primaryLinksPage.goToWindowsPage();
        newWindowPage.checkRedirect();
    }
}
