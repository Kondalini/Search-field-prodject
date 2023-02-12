package Factory;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver driver;
    @FindBy(id = "nav-link-login")
    private WebElement loginLink;

    @FindBy(id = "search-bar")
    private WebElement searchField;

    @FindBy(xpath = "//*[text() = 'MARIELKATA']")
    private WebElement userMarielkata;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
    }

    public void populateSearchField(String text) {
        searchField.sendKeys("MARIELKATA");

    }

    public void clickUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        wait.until(ExpectedConditions.visibilityOf(userMarielkata));
        wait.ignoring(StaleElementReferenceException.class);

        userMarielkata.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/user"));

}
}
