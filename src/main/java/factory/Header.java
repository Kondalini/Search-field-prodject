package factory;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//*[@id=\"navbarColor01\"]/form/div/app-search-dropdown/div/div[1]/app-small-user-profile/div/div[1]/a")
    private WebElement userName;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
    }

    public void populateSearchField(String name) {
        searchField.sendKeys(name);

    }

    public void clickUser()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarColor01\"]/form/div/app-search-dropdown/div/div[1]/app-small-user-profile/div/div[1]/a")));
        userName.click();
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users"));
    }
}

