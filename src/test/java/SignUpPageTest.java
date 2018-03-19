import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    WebDriver driver;
    SignUpPage signUpPage;


    @Before
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pfsoft-user\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpWithShortPass() {
        SignUpPage sp = signUpPage.typePassword("qwe");
        String error = sp.getPasswordErrorText();
        Assert.assertEquals("Password is too short (minimum is 7 characters) and needs at least one number",error);
    }

    @Test
    public void signUpRezervedUserName() {
        SignUpPage sp = signUpPage.typeUserName("username");
        String error = sp.getUserNameErrorText();
        Assert.assertEquals("Username name 'username' is a reserved word",error);
    }

    @Test
    public void signUpUserNameTaken() {
        SignUpPage signUp = signUpPage.typeUserName("user");
        String error = signUp.getUserNameErrorText();
        Assert.assertEquals("Username is already taken",error);
    }

    @Test
    public void getHeadingTest() {
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub",heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}