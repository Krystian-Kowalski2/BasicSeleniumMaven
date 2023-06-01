package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

@Getter
public class TablesPage extends BasePageObject {
    public TablesPage(WebDriver driver) {
        super(driver);
    }

    public void countNumberOfCells() {
        System.out.println(getTableRowWithValues().size());
    }

    public void countNumberOfRows() {
        System.out.println(getTableRows().size());
    }

    @FindBys({
            @FindBy(xpath = "//*[@id='table2']/tbody"),//table row
            @FindBy(xpath = "//*[@id='table2']/tbody/tr") //row records
    })
    private List<WebElement> tableRows;

    @FindBys({
            @FindBy(xpath = "//*[@id='table2']/tbody/tr[1]"),//table row
            @FindBy(xpath = "//*[@id='table2']/tbody/tr[1]/td") //row records
    })
    private List<WebElement> tableRowWithValues;
}
