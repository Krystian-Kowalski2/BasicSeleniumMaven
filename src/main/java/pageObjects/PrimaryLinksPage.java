package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class PrimaryLinksPage {
    public WaitUtils waitUtils;

    public PrimaryLinksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }

    public void goToEnglishVersion() {
        getEnglishVersion().click();
        waitUtils.waitForUrlToContain("en.wikipedia");
    }

    @Getter
    @FindBy(id = "js-link-box-en")
    private WebElement englishVersion;
}
