package Tests;


import Factory.Header;
import Factory.HomePage;
import Factory.LoginPage;
import Factory.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class FactorySearchFieldTest {
    private WebDriver driver;

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //void setup() {
        //        driver = new ChromeDriver();
        //        driver.manage().window().maximize();
        //    }
    }
    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
    //void cleanUp() {
    //driver.quit();
    //}

    @Test
    public void searchFieldTest() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "The Home page URL is not loaded");

        Header header = new Header(driver);
        header.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isUrlLoaded(), "The login URL is not correct");
        String signInText = loginPage.getSingInElementText();
        Assert.assertEquals(signInText, "Sign in" );
        loginPage.fillUserName("Alex78");
        loginPage.fillPassword("12345");
        loginPage.clickSignIn();
        Assert.assertTrue(loginPage.isUrlLoaded(), "The LoginPage URL is not correct");

        header.populateSearchField("MARIELKATA");
        header.clickUser();

        ProfilePage profilePage = new ProfilePage(driver);
        String actualName = profilePage.getUsername();
        Assert.assertEquals(actualName, "MARIELKATA", "The user name is incorrect");

    }

}
