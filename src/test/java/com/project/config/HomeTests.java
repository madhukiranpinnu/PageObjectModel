package com.project.config;

import com.project.driver.DriverManager;
import com.project.pages.HomePage;
import com.project.pages.Loginpage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTests extends BaseTest{
    @Test
    public void homePageTitle(){
        Loginpage loginpage=new Loginpage();
        loginpage.loginToApplication("Admin","admin123");
        HomePage homePage=new HomePage();
        String actualTitle=homePage.title();
        Assert.assertEquals(actualTitle,"OrangeHRM","Title is not matching");
    }
}
