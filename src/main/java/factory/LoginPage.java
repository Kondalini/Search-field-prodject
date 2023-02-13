package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public static final String  PAGE_URL = "http://training.skillo-bg.com:4300/users/login";
    private final WebDriver driver;
    @FindBy(xpath = "//p[text()='Sign in']")
    private WebElement signInElement;
    @FindBy(id = "defaultLoginFormUsername")
    private WebElement userNameField;
    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordField;
    @FindBy(id = "sign-in-button")
    private WebElement signInButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(LoginPage.PAGE_URL));
    }

    public String getSingInElementText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(signInElement));
        return signInElement.getText();

    }

    public void fillUserName(String user) {
        userNameField.sendKeys(user);
    }

    public void fillPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }
}