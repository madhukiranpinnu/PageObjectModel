package com.project.config;

import com.project.annotation.CustomAnnotation;
import com.project.pages.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @DataProvider
    public Object[][] dataLoginPage(){
        return new Object[][]{
                {"Admin","admin1234","Epic sadface: Username and password do not match any user in this service"}
        };
    }
    @CustomAnnotation(author = "swag",category = "functional")
    @Test(description = "To login to OrangeHRM", dataProvider = "dataLoginPage")
    public void loginTest(String userName,String password,String errorText) throws InterruptedException { WebDriverManager.chromedriver().setup();
        Loginpage loginpage=new Loginpage();
        loginpage.loginToApplication(userName,password);
        String actualResult=loginpage.getErrorText();
        Assert.assertEquals(actualResult,errorText,"invalid error");
    }
}
