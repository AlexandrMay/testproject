import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    private By loginField = By.xpath("//input[@id=\"login_field\"]");
    private By passwordField = By.xpath("//input[@id=\"password\"]");
    private By signInButton = By.xpath("//input[@type=\"submit\"]");
    private By heading = By.xpath("//div[contains(@class, \"auth-form-header p-0\")]/h1");
    private By error = By.xpath(".//*[@id='js-flash-container']//div[@class=\"container\"]");
    private By createAccLink = By.xpath("//a[text()='Create an account']");

    @Step
    public LoginPage typeUsername(String username) {
        driver.findElement(loginField).sendKeys(username);
        return this;
    }
    @Step
    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    @Step
    public LoginPage typeUserName(String userName) {
        driver.findElement(loginField).sendKeys(userName);
        return this;
    }
    @Step
    public LoginPage LoginWithInvalidCreds (String password, String username) {
        this.typeUserName(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }
    @Step
    public SignUpPage createAccount() {
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }

}
