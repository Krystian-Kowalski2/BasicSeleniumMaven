import config.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.JQueryMenuPage;
import pageObjects.PrimaryLinksPage;

public class JQueryUITests extends TestBase {
    public PrimaryLinksPage primaryLinksPage;
    public JQueryMenuPage jQueryMenuPage;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        primaryLinksPage = new PrimaryLinksPage(driver);
        jQueryMenuPage = new JQueryMenuPage(driver);
    }

    @Test
    public void downloadFile() throws InterruptedException {
        primaryLinksPage.goToJQueryMenuPage();
        jQueryMenuPage.downloadPdfFile();
    }

    @Test
    public void checkPageLinks() throws InterruptedException {
        primaryLinksPage.goToJQueryMenuPage();
        jQueryMenuPage.verifyBackToJQueryLinks();
    }
}
