package com.project.pages;

import com.project.driver.DriverFactory;
import com.project.driver.DriverManager;
import org.openqa.selenium.By;

public class Loginpage {
    private static final
    By TXTBOX_USERNAME= By.xpath("//div/input[@name='username']");
    private static final
    By TXTBOX_PASSWORD=By.xpath("//div/input[@name='password']");
    private static final
    By BTN_SUBMIT= By.xpath("//button[@type='submit']");

    private void setTxtboxUsername(String username){
        DriverManager.getDriver().findElement(TXTBOX_USERNAME).sendKeys(username);
    }
    private  void setTxtboxPassword(String password){
        DriverManager.getDriver().findElement(TXTBOX_PASSWORD).sendKeys(password);
    }
    private void clickBtnSubmit(){
        DriverManager.getDriver().findElement(BTN_SUBMIT).click();
    }
    public void loginToApplication(String userName,String password){
        setTxtboxUsername(userName);
        setTxtboxPassword(password);
        clickBtnSubmit();
    }
}
