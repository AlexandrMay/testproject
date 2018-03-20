
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;


public class MainPage {
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;
    private By signInButton = By.xpath("//a[text()='Sign in']");
    private By signUpButton = By.xpath("//a[text()='Sign up']");
    private By userNameField = By.xpath(".//*[@id='user[login]']");
    private By emailField = By.xpath(".//*[@id='user[email]']");
    private By passwordField = By.xpath(".//*[@id='user[password]']");
    private By signUpFormButton = By.xpath("(//button[text()='Sign up for GitHub'])[1]");
    private By searchField = By.xpath("//input[@placeholder='Search GitHub']");

    @Step
    public SearchResultsPage typeSearch(String searchInfo) {
        driver.findElement(searchField).sendKeys(searchInfo);
        return new SearchResultsPage(driver);
    }
    @Step
    public SearchResultsPage typeEnter () {
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

    @Step
   public LoginPage clickSignIn() {
       driver.findElement(signInButton).click();
       return new LoginPage(driver);
   }
    @Step
    public SignUpPage clicksignUpButton() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }
    @Step
    public SignUpPage clicksignUpFormButton() {
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }
    @Step
    public MainPage typeUserName (String username) {
       driver.findElement(userNameField).sendKeys(username);
       return this;
    }

    public MainPage typePassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    @Step
    public MainPage typeEmail (String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    @Step
    public SignUpPage register (String username, String email, String password) {
       this.typeUserName(username);
       this.typeEmail(email);
       this.typePassword(password);
       this.clicksignUpFormButton();
       return new  SignUpPage(driver);
    }

}


