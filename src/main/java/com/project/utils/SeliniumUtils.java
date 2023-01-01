package com.project.utils;

import com.project.config.ConfigFactory;
import com.project.driver.DriverManager;
import com.project.enums.WaitType;
import com.project.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeliniumUtils {
    public static void click(By by, WaitType waitType,String elementName){
        if(waitType==WaitType.PRESCENCE){
            waitUntilElementPresent(by).getText();
            ExtentLogger.pass("Successfully clicked on"+" "+elementName);
        }
        else if (waitType==WaitType.CLICKABLE) {
            waitUntilElementClickable(by).click();
            ExtentLogger.pass("Successfully clicked on"+" "+elementName);
        }
        else {
            DriverManager.getDriver().findElement(by).click();
            ExtentLogger.pass("Successfully clicked on"+" "+elementName);
        }
    }
    public static void sendKeys(By by,String key,String elementName){
        waitUntilElementPresent(by).sendKeys(key);
        ExtentLogger.pass("Successfully sent keys for "+" "+elementName+" "+ "is"+" "+key);
    }
    public static String getText(By by,String textField){
        ExtentLogger.pass("Successfully got text for"+" "+textField);
        return waitUntilElementPresent(by).getText();
    }

    private static WebElement waitUntilElementClickable(By by){
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),ConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    private static WebElement waitUntilElementPresent(By by){
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),ConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
