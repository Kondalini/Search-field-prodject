package ObjectWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4200/users/";
     private final WebDriver driver;


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUrlLoaded(){
        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlContains(ProfilePage.PAGE_URL));
    }
    public String getUsername (){
        WebElement userName = driver.findElement(By.tagName("h2"));
        return userName.getText();
    }
}
