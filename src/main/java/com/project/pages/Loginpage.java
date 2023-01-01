package com.project.pages;

import com.project.driver.DriverManager;
import com.project.enums.WaitType;
import com.project.utils.SeliniumUtils;
import org.openqa.selenium.By;

public class Loginpage {
    private static final
    By TXTBOX_USERNAME= By.xpath("//div/input[@id='user-name']");
    private static final
    By TXTBOX_PASSWORD=By.xpath("//div/input[@id='password']");
    private static final
    By BTN_SUBMIT= By.xpath("//input[@type='submit']");
    private static final
    By TXT_ERROR=By.xpath("//div/h3");


    private void setTxtboxUsername(String username){
        SeliniumUtils.sendKeys(TXTBOX_USERNAME,username,"username");
    }
    private  void setTxtboxPassword(String password){
        SeliniumUtils.sendKeys(TXTBOX_PASSWORD,password,"password");

    }
    private void clickBtnSubmit(){
        SeliniumUtils.click(BTN_SUBMIT, WaitType.CLICKABLE,"submit button");
    }
    public void loginToApplication(String userName,String password){
        setTxtboxUsername(userName);
        setTxtboxPassword(password);
        clickBtnSubmit();
    }
    public String getErrorText(){
        return SeliniumUtils.getText(TXT_ERROR,"errorMessage");
    }
}
