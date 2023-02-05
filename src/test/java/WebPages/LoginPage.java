package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public static final String Page_URL = "http://training.skillo-bg.com:4200/users/login";
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUrlLoaded(){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       return wait.until(ExpectedConditions.urlToBe(Page_URL));
    }
    public String getSingInElementText() {
        WebElement signInElement = driver.findElement(By.xpath("//p[text()='Sign in']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(signInElement));
        return signInElement.getText();
    }
    public void fillUserName(String username){
        WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNameField.sendKeys("Alex78");
    }
    public void fillPassword(String password){
        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys("123456");

    }
public void clickSignIn(){
        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(signInButton));
      signInButton.click();
}

}
