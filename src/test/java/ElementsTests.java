import config.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;

public class ElementsTests extends TestBase {
    public PrimaryLinksPage primaryLinksPage;
    public AddRemoveElementsPage addRemoveElementsPage;
    public DisappearingElementsPage disappearingElementsPage;
    public CheckboxesPage checkboxesPage;
    public DragAndDropPage dragAndDropPage;
    public ContextMenuPage contextMenuPage;
    public DropdownPage dropdownPage;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        primaryLinksPage = new PrimaryLinksPage(driver);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
        disappearingElementsPage = new DisappearingElementsPage(driver);
        checkboxesPage = new CheckboxesPage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
        contextMenuPage = new ContextMenuPage(driver);
        dropdownPage = new DropdownPage(driver);
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

    @Test
    public void checkAllCheckboxesTest() {
        primaryLinksPage.goToCheckboxesPage();
        checkboxesPage.checkFirstCheckbox();
        checkboxesPage.checkSecondCheckbox();
    }

    @Test
    public void uncheckAllCheckboxesTest() {
        primaryLinksPage.goToCheckboxesPage();
        checkboxesPage.uncheckFirstCheckbox();
        checkboxesPage.uncheckSecondCheckbox();
    }

    @Test
    public void switchColumnsByDraggingTest() {
        primaryLinksPage.goDragAndDropPage();
        dragAndDropPage.switchColumnAWithB();
    }

    @Test
    public void getTextFromAlertTest() {
        primaryLinksPage.goToContextMenuPage();
        contextMenuPage.openHotSpot();
        contextMenuPage.checkAlertText();
    }

    @Test
    public void dropdownTest() {
        primaryLinksPage.goToDropdownPage();
        dropdownPage.chooseFromDropdown();
    }
}
