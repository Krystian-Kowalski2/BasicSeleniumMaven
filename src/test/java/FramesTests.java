import config.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.FramesPage;
import pageObjects.PrimaryLinksPage;

public class FramesTests extends TestBase {
    public PrimaryLinksPage primaryLinksPage;
    public FramesPage framesPage;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        primaryLinksPage = new PrimaryLinksPage(driver);
        framesPage =new FramesPage(driver);
    }

    @Test
    public void nestedFramesTextExtractionTest() {
        primaryLinksPage.goToFramesPage();
        framesPage.clickNestedFramesLink();
        framesPage.switchToMiddleFrame();
    }

    @Test
    public void iFrameElementsInteraction() {
        primaryLinksPage.goToFramesPage();
        framesPage.clickIFrameLink();
        framesPage.makeTextBold();
        framesPage.switchToTextFieldFrame();
    }
}
