package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    public WebDriver driver;

    By uname = By.xpath("//input[@id ='username']");
    By password = By.xpath("//input[@id ='password']");
    By submit = By.xpath("//i[text()=' Login']");
    By message = By.xpath("//h4[text() ='Welcome to the Secure Area. When you are done click logout below.']");
    By invalidMessage = By.xpath("//div[@id='flash']");

    public Login(WebDriver driver)
    {
        this.driver = driver;
    }

    public void setUserName(String userName)
    {
        driver.findElement(uname).sendKeys(userName);
    }

    public void setPassword(String userPassword)
    {
        driver.findElement(password).sendKeys(userPassword);
    }

    public void clickSubmit()
    {
        driver.findElement(submit).click();
    }
    public String getMessage()
    {
       return  driver.findElement(message).getText();
    }

    public String getInvalidUsername()
    {
        return driver.findElement(invalidMessage).getText();
    }




}

