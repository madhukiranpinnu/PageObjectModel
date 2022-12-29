package com.project.config;

import com.project.driver.DriverExecutables;
import com.project.driver.DriverManager;
import com.project.pages.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test(description = "To login to OrangeHRM")
    public void loginTest() throws InterruptedException { WebDriverManager.chromedriver().setup();
        Loginpage loginpage=new Loginpage();
        loginpage.loginToApplication("Admin","admin1234");
        String actualResult=DriverManager.getDriver().findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
        String expected="Invalid credentials";
        Assert.assertEquals(actualResult,expected,"invalid error");
    }
}
