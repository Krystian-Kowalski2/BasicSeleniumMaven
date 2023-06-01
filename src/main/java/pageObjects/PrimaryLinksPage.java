package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class PrimaryLinksPage extends BasePageObject {

    public PrimaryLinksPage(WebDriver driver) {
        super(driver);
    }

    private void goToPage(WebElement element, String url) {
        element.click();
        waitUtils.waitForUrlToContain(url);
    }

    public void goAddRemoveElements() {
        goToPage(getAddRemovePage(), "add_remove_elements");
    }

    public void goToDisappearingElementsPage() {
        goToPage(getDisappearingElementsPage(), "disappearing_elements");
    }

    public void goToFormAuthenticationPage() {
        goToPage(getFormAuthenticationPage(), "login");
    }

    public void goToBasicAuthPage() {
        goToPage(getBasicAuthPage(), "basic_auth");
    }

    public void goToHoversPage() {
        goToPage(getHoversPage(), "hovers");
    }

    public void goToBrokenImagesPage() {
        goToPage(getBrokenImagesPage(), "/broken_images");
    }

    public void goToCheckboxesPage() {
        goToPage(getCheckboxesPage(), "/checkboxes");
    }

    public void goDragAndDropPage() {
        goToPage(getDragAngDropPage(), "/drag_and_drop");
    }

    public void goToContextMenuPage() {
        goToPage(getContextMenuPage(), "/context_menu");
    }

    public void goToDropdownPage() {
        goToPage(getDropdownPage(), "/dropdown");
    }

    public void goToDynamicControlsPage() {
        goToPage(getDynamicControlsPage(), "/dynamic_controls");
    }

    public void goToHorizontalSliderPage() {
        goToPage(getHorizontalSlider(), "/horizontal_slider");
    }

    public void goToJQueryMenuPage() {
        goToPage(getJQueryMenuPage(), "/jqueryui/menu");
    }

    public void goToFramesPage() {
        goToPage(getFramesPage(), "/frames");
    }

    public void goToWindowsPage() {
        goToPage(getNewWindowPage(), "windows");
    }

    public void goToTablesPage() {
        goToPage(getTablesPage(), "tables");
    }

    @FindBy(css = "a[href='/add_remove_elements/']")
    private WebElement addRemovePage;

    @FindBy(css = "a[href='/disappearing_elements']")
    private WebElement disappearingElementsPage;

    @FindBy(css = "a[href='/basic_auth']")
    private WebElement basicAuthPage;

    @FindBy(css = "a[href='/login']")
    private WebElement formAuthenticationPage;

    @FindBy(css = "a[href='/hovers']")
    private WebElement hoversPage;

    @FindBy(css = "a[href='/broken_images']")
    private WebElement brokenImagesPage;

    @FindBy(css = "a[href='/checkboxes']")
    private WebElement checkboxesPage;

    @FindBy(css = "a[href='/drag_and_drop']")
    private WebElement dragAngDropPage;

    @FindBy(css = "a[href='/context_menu']")
    private WebElement contextMenuPage;

    @FindBy(css = "a[href='/dropdown']")
    private WebElement dropdownPage;

    @FindBy(css = "a[href='/dynamic_controls']")
    private WebElement dynamicControlsPage;

    @FindBy(css = "a[href='/horizontal_slider']")
    private WebElement horizontalSlider;

    @FindBy(css = "a[href='/jqueryui/menu']")
    private WebElement jQueryMenuPage;

    @FindBy(css = "a[href='/frames']")
    private WebElement framesPage;

    @FindBy(css = "a[href='/windows']")
    private WebElement newWindowPage;

    @FindBy(css = "a[href='/tables']")
    private WebElement tablesPage;
}
