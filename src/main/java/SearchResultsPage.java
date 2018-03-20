
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    private By header = By.xpath("//form[@id=\"search_form\"]/following-sibling::p");
    private By advancedSearchLink = By.xpath("//a[text()=\"Advanced search\"]");
    private By advancedOptionsHeader = By.xpath("//h3[text()=\"Advanced options\"]");

    public String getHeadingText() {
        return driver.findElement(header).getText();
    }

    public String getAdvancedSearchLinkText() {
        return driver.findElement(advancedSearchLink).getText();
    }

    public String getadvancedOptionsHeaderText() {
        return driver.findElement(advancedOptionsHeader).getText();
    }

    public SearchResultsPage pressAdvancedSearchLink() {
        driver.findElement(advancedSearchLink).click();
        return new SearchResultsPage(driver);
    }

}
