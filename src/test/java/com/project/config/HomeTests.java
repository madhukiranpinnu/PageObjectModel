package com.project.config;

import com.project.driver.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTests extends BaseTest{
    @Test
    public void homePageTitle(){
        DriverManager.getDriver().findElement(By.xpath("//div/input[@name='username']")).sendKeys("Admin");
        DriverManager.getDriver().findElement(By.xpath("//div/input[@name='password']")).sendKeys("admin123");
        DriverManager.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        String actualTitle=DriverManager.getDriver().getTitle();
        String expectedTitle="OrangeHRM";
        Assert.assertEquals(actualTitle,expectedTitle,"Title is not matching");
    }
}
