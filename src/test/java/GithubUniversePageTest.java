import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GithubUniversePageTest {

    private WebDriver driver;
    private GithubUniversePage universePage;

    @Before
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pfsoft-user\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://githubuniverse.com/watch/");
        universePage = new GithubUniversePage(driver);
    }

    @Test
    public void getHeadingTest() {
        String heading = universePage.getHeadingText();
        Assert.assertEquals("PROGRAM",heading);
    }

    @Test
    public void addmeWithEmptyField () {
        GithubUniversePage up = universePage.tryToAddMe(" ");
        String error = up.getErrorText();
        Assert.assertEquals("This field is required.",error);
    }

    @Test
    public void addmeWithWrongEmail () {
        GithubUniversePage up = universePage.tryToAddMe("1");
        String error = up.getErrorText();
        Assert.assertEquals("Please enter a valid email address.",error);
    }

    @Test
    public void addmeWithCorrectEmail () {
        GithubUniversePage up = universePage.tryToAddMe("mytest@test.com");
        String error = up.getLinkText();
        Assert.assertEquals("Click here to update your profile.",error);
    }

    @Test
    public void addmeWithInvalidEmail () {
        GithubUniversePage up = universePage.tryToAddMe("test@test.com");
        String error = up.getInvalidMailErrorText();
        Assert.assertEquals("This email cannot be added to this list. Please enter a different email address.",error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}



