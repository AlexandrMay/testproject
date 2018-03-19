import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GithubUniversePage {
    public GithubUniversePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    private By heading = By.xpath("//a[text()=\"Program\"]");
    private By emailField = By.xpath("//input[@id=\"mce-EMAIL\"]");
    private By addMeButton = By.xpath("//button[@id=\"mc-embedded-subscribe\"]");
    private By error = By.xpath("//div[@class=\"mce_inline_error\"]");
    private By invalidMailError = By.xpath("//div[text()=\"This email cannot be added to this list. Please enter a different email address.\"]");
    //private By success = By.xpath("//div[@id=\"mce-error-response\"]");                                                                           xpath or smth incorrect
    private By link  = By.xpath("//a[text()='Click here to update your profile.']");



    public GithubUniversePage typeEmail (String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public GithubUniversePage tryToAddMe (String email) {
        this.typeEmail(email);
        driver.findElement(addMeButton).click();
        return new GithubUniversePage(driver);
    }

    public String getHeadingText () {
        return driver.findElement(heading).getText();
    }

    public String getErrorText () {
        return driver.findElement(error).getText();
    }

  //  public String getSuccessText () { return driver.findElement(success).getText();}


    public String getInvalidMailErrorText () {
        return driver.findElement(invalidMailError).getText();
    }

    public String getLinkText () { return driver.findElement(link).getText();}

}
