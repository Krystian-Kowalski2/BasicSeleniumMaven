package pageObjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static config.TestBase.driver;

@Getter
public class DisappearingElementsPage extends BasePageObject{

    public DisappearingElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickHomeButton() {
        getHomeButton().click();
        waitUtils.waitForPresenceOf(By.xpath("//*[contains(text(),'Welcome to the-internet')]"));
        driver.navigate().back();
        waitUtils.waitForElement(getHomeButton());
    }

    private void clickAndBack(WebElement element, String url) {
        element.click();
        waitUtils.waitForUrlToContain(url);
        driver.navigate().back();
        waitUtils.waitForElement(element);
    }

    public void clickAboutButton() {
        clickAndBack(getAboutButton(), "/about/");
    }

    public void clickContactButton() {
        clickAndBack(getContactButton(), "/contact-us/");
    }

    public void clickPortfolioButton() {
        clickAndBack(getPortfolioButton(), "portfolio");
    }

    public void clickGalleryButton() {
        clickAndBack(getPortfolioButton(), "portfolio");
    }

    @FindBy(css = "#content > div > ul > li:nth-child(1) > a")
    private WebElement homeButton;

    @FindBy(xpath = "//*[contains(text(),'About')]")
    private WebElement aboutButton;

    @FindBy(css = "a[href='/contact-us/']")
    private WebElement contactButton;

    @FindBy(css = "li:nth-child(4) > a")
    private WebElement portfolioButton;

    @FindBy(css = "a[href='/gallery/']")
    private WebElement galleryButton;
}
