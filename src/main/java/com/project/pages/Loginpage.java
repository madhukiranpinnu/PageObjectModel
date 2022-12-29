package com.project.pages;

import com.project.driver.DriverFactory;
import com.project.driver.DriverManager;
import org.openqa.selenium.By;

public class Loginpage {
    private static final
    By txtboxUsername= By.xpath("//div/input[@name='username']");
    private static final
    By txtboxPassword=By.xpath("//div/input[@name='password']");
    private static final
    By btnSubmit= By.xpath("//button[@type='submit']");

    public  void setTxtboxUsername(String username){
        DriverManager.getDriver().findElement(txtboxUsername).sendKeys(username);
    }
    public  void setTxtboxPassword(String password){
        DriverManager.getDriver().findElement(txtboxPassword).sendKeys(password);
    }
    public  void clickBtnSubmit(){
        DriverManager.getDriver().findElement(btnSubmit).click();
    }
}
