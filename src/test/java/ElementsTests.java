import config.TestBase;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import pageObjects.AddRemoveElementsPage;
import pageObjects.PrimaryLinksPage;

public class ElementsTests extends TestBase {
    public PrimaryLinksPage primaryLinksPage;
    public AddRemoveElementsPage addRemoveElementsPage;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        primaryLinksPage = new PrimaryLinksPage(driver);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
    }

    @Test
    public void addRemoveTest() {
        primaryLinksPage.goAddRemoveElements();
        addRemoveElementsPage.addElement();
        addRemoveElementsPage.addElement();
        addRemoveElementsPage.countAddedElements(2);
        addRemoveElementsPage.deleteElement();
        addRemoveElementsPage.countAddedElements(1);
        addRemoveElementsPage.deleteElement();
        addRemoveElementsPage.countAddedElements(0);
        addRemoveElementsPage.deleteElement();
        addRemoveElementsPage.countAddedElements(0);    }
}
