import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "C:\\STORAGE\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        mainPage = new MainPage(driver);
    }


    @Test
    public void searchTest() {
        SearchResultsPage searchResultsPage = mainPage.typeSearch("12asd");
        mainPage.typeEnter();
        String header = searchResultsPage.getAdvancedSearchLinkText();
        Assert.assertEquals("Advanced search", header);
    }

    @Test
    public void signInTest() {
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void signUpTest() {
        SignUpPage signUpPage = mainPage.clicksignUpButton();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", heading);
    }

    @Test
    public void registerFailTest() {
        SignUpPage signUpPage = mainPage.register("usertest", "usermail","testpass");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.",error);
    }

    @Test
    public void signUpEmptyUsername() {
        SignUpPage signUpPage = mainPage.register("", "mail", "pass");
        String error = signUpPage.getUserNameErrorText();
        Assert.assertEquals("Login can't be blank",error);
    }

    @Test
    public void signUpInvalidEmail() {
        SignUpPage signUpPage = mainPage.register("Maysalexandr", "mail", "pass123");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken",error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
