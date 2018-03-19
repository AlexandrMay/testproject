import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    private By heading = By.xpath("//div[@class=\"setup-header setup-org\"]/h1");
    private By signUpButton = By.xpath(".//*[@id='signup_button']");
    private By userNameField = By.xpath(".//*[@id='user_login']");
    private By emailField = By.xpath(".//*[@id='user_email']");
    private By passwordField = By.xpath(".//*[@id='user_password']");
    private By mainError = By.xpath("//form[@id=\"signup-form\"]//div[contains(@class, \"flash flash-error my-3\")]");
    private By UserNameError = By.xpath("//input[@id=\"user_login\"]/ancestor::dd/following-sibling::dd[@class='error']");
    private By emailError = By.xpath("//input[@id=\"user_email\"]/ancestor::dd/following-sibling::dd[@class='error']");
    private By passwordError = By.xpath("//input[@id=\"user_password\"]/ancestor::dd/following-sibling::dd[@class='error']");

    public SignUpPage typeUserName (String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typePassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeEmail (String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage registerwithInvalidCreds(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getMainErrorText() {
        return driver.findElement(mainError).getText();
    }

    public String getUserNameErrorText() {
        return driver.findElement(UserNameError).getText();
    }

    public String getEmailErrorText() {
        return driver.findElement(emailError).getText();
    }

    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }

}
