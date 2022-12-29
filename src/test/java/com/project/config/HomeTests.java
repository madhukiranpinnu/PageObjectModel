package com.project.config;

import com.project.driver.DriverManager;
import com.project.pages.Loginpage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTests extends BaseTest{
    @Test
    public void homePageTitle(){
        Loginpage loginpage=new Loginpage();
        loginpage.loginToApplication("Admin","admin123");
        String actualTitle=DriverManager.getDriver().getTitle();
        String expectedTitle="OrangeHRM";
        Assert.assertEquals(actualTitle,expectedTitle,"Title is not matching");
    }
}
