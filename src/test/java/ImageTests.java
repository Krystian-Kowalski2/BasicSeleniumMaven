import config.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HoversPage;
import pageObjects.PrimaryLinksPage;

public class ImageTests extends TestBase {
    public PrimaryLinksPage primaryLinksPage;
    public HoversPage hoversPage;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        primaryLinksPage = new PrimaryLinksPage(driver);
        hoversPage = new HoversPage(driver);
    }

    @Test
    public void hoversTest() {
        primaryLinksPage.goToHoversPage();
        hoversPage.hoverOverUser1();
        hoversPage.clickUser1Redirect();
    }
}
