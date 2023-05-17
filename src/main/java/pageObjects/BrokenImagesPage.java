package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Getter
public class BrokenImagesPage extends BasePageObject {

    public BrokenImagesPage(WebDriver driver) {
        super(driver);

    }

    private List<WebElement> collectImages() {
        List<WebElement> imageElements = new ArrayList<>();
        imageElements.addAll(images);
        return imageElements;
    }

    private boolean isValidStatusCode(int statusCode) {
        return String.valueOf(statusCode).startsWith("2") || String.valueOf(statusCode).startsWith("3");
    }

    private boolean checkImageValidity(WebElement imageElement) {
        try {
            URL imageURL = new URL(imageElement.getAttribute("src"));
            HttpURLConnection connection = (HttpURLConnection) imageURL.openConnection();
            connection.setRequestMethod("HEAD");
            int statusCode = connection.getResponseCode();
            return isValidStatusCode(statusCode);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void checkImages() {
        List<WebElement> imageElements = collectImages();
        for (WebElement imageElement : imageElements) {
            boolean isValid = checkImageValidity(imageElement);
            if (isValid) {
                System.out.println("Image is valid: " + imageElement.getAttribute("src"));
            } else {
                System.out.println("Image is invalid: " + imageElement.getAttribute("src"));
            }
        }
    }

    @FindBy(tagName = "img")
    private List<WebElement> images;
}
