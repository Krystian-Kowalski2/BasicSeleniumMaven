package pageObjects;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static config.TestBase.driver;
import static org.junit.Assert.assertNotSame;

@Getter
public class DragAndDropPage extends BasePageObject {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void switchColumnAWithB() {
        WebElement sourceElement = getColumnA();
        WebElement destinationElement = getColumnB();
        String textBeforeDrag = sourceElement.getText();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String script = "var sourceElement = arguments[0];\n" +
                "var destinationElement = arguments[1];\n" +
                "\n" +
                "var dragStartEvent = new Event('dragstart');\n" +
                "sourceElement.dispatchEvent(dragStartEvent);\n" +
                "\n" +
                "var dropEvent = new Event('drop');\n" +
                "destinationElement.dispatchEvent(dropEvent);\n" +
                "\n" +
                "var dragEndEvent = new Event('dragend');\n" +
                "sourceElement.dispatchEvent(dragEndEvent);";

        js.executeScript(script, sourceElement, destinationElement);

        String textAfterDrag = sourceElement.getText();
        assertNotSame(textBeforeDrag, textAfterDrag);
    }

    @FindBy(id = "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;
}
