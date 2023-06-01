import config.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.PrimaryLinksPage;
import pageObjects.TablesPage;

public class TablesTests extends TestBase {

    PrimaryLinksPage primaryLinksPage;
    TablesPage tablesPage;

    @BeforeMethod(alwaysRun = true)
    private void initOperations() {
        primaryLinksPage = new PrimaryLinksPage(driver);
        tablesPage = new TablesPage(driver);
    }

    @Test
    public void countCellsTest() {
        primaryLinksPage.goToTablesPage();
        tablesPage.countNumberOfCells();
    }

    @Test
    public void countRowsTest() {
        primaryLinksPage.goToTablesPage();
        tablesPage.countNumberOfRows();
    }
}
