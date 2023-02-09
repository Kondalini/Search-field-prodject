package ObjectWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
     private final WebDriver driver;


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getUsername (){
        WebElement userName = driver.findElement(By.tagName("h2"));
        return userName.getText();
    }
}
