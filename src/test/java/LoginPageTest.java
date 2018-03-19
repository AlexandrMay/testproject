import com.sun.deploy.association.AssociationAlreadyRegisteredException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pfsoft-user\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCredsTest() {
        LoginPage newLoginPage = loginPage.LoginWithInvalidCreds("","");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.",error);
    }

    @Test
    public void loginWithIncorrectCreds() {
        LoginPage newLoginPage = loginPage.LoginWithInvalidCreds("qweqwe","qweqwe1");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.",error);
    }

    @Test
    public void createAccTest() {
        SignUpPage signUpPage = loginPage.createAccount();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub",heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
