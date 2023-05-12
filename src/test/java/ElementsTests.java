import config.TestBase;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import pageObjects.AddRemoveElementsPage;
import pageObjects.DisappearingElementsPage;
import pageObjects.PrimaryLinksPage;

public class ElementsTests extends TestBase {
    public PrimaryLinksPage primaryLinksPage;
    public AddRemoveElementsPage addRemoveElementsPage;
    public DisappearingElementsPage disappearingElementsPage;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        primaryLinksPage = new PrimaryLinksPage(driver);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
        disappearingElementsPage = new DisappearingElementsPage(driver);
    }

    @Test
    public void addRemoveTest() {
        primaryLinksPage.goAddRemoveElements();
        addRemoveElementsPage.countAddedElements();
    }

    @Test
    public void disappearingElementsTest() {
        primaryLinksPage.goToDisappearingElementsPage();
        disappearingElementsPage.clickHomeButton();
        disappearingElementsPage.clickAboutButton();
        disappearingElementsPage.clickContactButton();
        disappearingElementsPage.clickPortfolioButton();
        disappearingElementsPage.clickGalleryButton();
    }
}
