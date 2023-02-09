package ObjectWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
     private final WebDriver driver;


    public Header(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLogin(){
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
    }
    public void populateSearchField(String text)  {

        WebElement searchField = driver.findElement(By.id("search-bar"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        searchField.sendKeys("MARIELKATA");

        WebElement userMarielkata = driver.findElement(By.partialLinkText("MARIELKATA")); //*[text() = 'MARIELKATA']
        wait.until(ExpectedConditions.elementToBeClickable(userMarielkata));
        userMarielkata.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/32"));



    }
}