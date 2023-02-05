package Tests;

import WebPages.HomePage;
import WebPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class searchFieldTest {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //void setup() {
        //        driver = new ChromeDriver();
        //        driver.manage().window().maximize();
        //    }
    }

    @Test
    public void searchFieldTest() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isUrlLoaded(), "The login URL is not correct");
        String signInText = loginPage.getSingInElementText();
        Assert.assertEquals(signInText, "Sign in" );
        loginPage.fillUserName("Alex78");
        loginPage.fillPassword("12345");
        loginPage.clickSignIn();
        Assert.assertTrue(loginPage.isUrlLoaded(), "The LoginPage URL is not correct");

        loginPage.populateSearchField("MARIELKATA");
         String actualName = loginPage.getUsername();
         Assert.assertEquals(actualName, "MARIELKATA", "The user name is incorrect");







    }



    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
        //void cleanUp() {
        //driver.quit();
        //}









    }
}

