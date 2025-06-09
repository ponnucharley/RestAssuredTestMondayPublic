package testClasses;

import PageClasses.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

class LoginTest {

    public WebDriver driver;
    public Login loginPage;

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String br) {

        if(br.equals("Chrome"))
        {
            driver = new ChromeDriver();
        }

        else
        {
            driver = new FirefoxDriver();
        }

    }


    @Test
    public void loginToHeroApp()
    {
        loginPage = new Login(driver);
        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickSubmit();
        String actualMessage = loginPage.getMessage();
        Assert.assertEquals(actualMessage,"Welcome to the Secure Area. When you are done click logout below.");
    }

    @Test(priority =1)

    public void invalidUserLogin()
    {
        loginPage = new Login(driver);
        loginPage.setUserName("ponnu");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickSubmit();
       String actualMessage= loginPage.getInvalidUsername();
        Assert.assertEquals(actualMessage," Your username is invalid!");
    }

    @Test

    public void invalidPasswordLogin()
    {
        loginPage = new Login(driver);
        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecret");
        loginPage.clickSubmit();
        String actualMessage= loginPage.getInvalidUsername();
        Assert.assertEquals(actualMessage," Your password is invalid!");
    }
    @AfterTest
    public void afterTest() {

        driver.quit();
    }

}