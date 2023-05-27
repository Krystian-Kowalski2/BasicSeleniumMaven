package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static config.TestBase.driver;

@Getter
public class JQueryMenuPage extends BasePageObject {
    public JQueryMenuPage(WebDriver driver) {
        super(driver);
    }

    private void hoverAndClick(WebElement element) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
        Thread.sleep(200);
    }

    public void downloadPdfFile() throws InterruptedException {
        hoverAndClick(getEnabledMenuItem());
        hoverAndClick(getDownloadMenuItem());
        hoverAndClick(getPdfFileMenuItem());
    }

    public void verifyBackToJQueryLinks() throws InterruptedException {
        hoverAndClick(getEnabledMenuItem());
        hoverAndClick(getBackToJQueryPageLink());
        waitUtils.waitForVisibilityOf(getBackToJQueryMenuPageLink());
        getBackToJQueryMenuPageLink().click();
        waitUtils.waitForUrlToContain("menu");
    }

    @FindBy(id = "ui-id-3")
    private WebElement enabledMenuItem;

    @FindBy(id = "ui-id-4")
    private WebElement downloadMenuItem;

    @FindBy(id = "ui-id-5")
    private WebElement pdfFileMenuItem;

    @FindBy(id = "ui-id-8")
    private WebElement backToJQueryPageLink;

    @FindBy(xpath = "//*[contains(text(),'Menu')]")
    private WebElement backToJQueryMenuPageLink;
}
