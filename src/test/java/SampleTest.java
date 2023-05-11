import config.TestBase;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import pageObjects.PrimaryLinksPage;

public class SampleTest extends TestBase {
    public PrimaryLinksPage primaryLinksPage;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        primaryLinksPage = new PrimaryLinksPage(driver);
    }

    @Test
    public void sampleTest() {
        primaryLinksPage.goToEnglishVersion();
    }
}
