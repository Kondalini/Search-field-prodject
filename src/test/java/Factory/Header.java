package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {
    private final WebDriver driver;
    @FindBy(id = "nav-link-login" )
    private WebElement loginLink;

    @FindBy(id = "search-bar")
    private WebElement searchField;

    @FindBy(xpath = "//*[text() = 'MARIELKATA']")
    private WebElement userMarielkata;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

}
