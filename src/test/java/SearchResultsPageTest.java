import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SearchResultsPageTest {

    private WebDriver driver;
    private SearchResultsPage searchResultsPage;

    @Before
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pfsoft-user\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/search/");
        searchResultsPage = new SearchResultsPage(driver);
    }


    @Test
    public void searchResults() {
        String heading = searchResultsPage.getHeadingText();
        Assert.assertEquals("ProTip! For an advanced search, use some of our prefixes.", heading);
    }



    @After
    public void tearDown() {
        driver.quit();
    }


}

