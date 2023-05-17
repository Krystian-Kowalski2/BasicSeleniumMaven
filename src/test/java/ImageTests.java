import config.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BrokenImagesPage;
import pageObjects.HoversPage;
import pageObjects.PrimaryLinksPage;

public class ImageTests extends TestBase {
    public PrimaryLinksPage primaryLinksPage;
    public HoversPage hoversPage;
    public BrokenImagesPage brokenImagesPage;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        primaryLinksPage = new PrimaryLinksPage(driver);
        hoversPage = new HoversPage(driver);
        brokenImagesPage = new BrokenImagesPage(driver);
    }

    @Test
    public void hoversTest() {
        primaryLinksPage.goToHoversPage();
        hoversPage.hoverOverUser1();
        hoversPage.clickUser1Redirect();
    }

    @Test
    public void brokenImages() {
        primaryLinksPage.goToBrokenImagesPage();
        brokenImagesPage.checkImages();
    }
}
