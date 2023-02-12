package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/posts/all";
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlToBe(ObjectWebPages.HomePage.PAGE_URL));

    }
    public void navigateTo() {
        this.driver.get(PAGE_URL);
    }

}
