package com.project.driver;

import com.project.config.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public final  class DriverExecutables {
    private DriverExecutables(){

    }
    public static void initDriver() throws MalformedURLException {
        String browserName=ConfigFactory.getConfig().browser();
        if(DriverManager.getDriver()==null){
            WebDriver driver=DriverFactory.getDriver(browserName,ConfigFactory.getConfig().execution());
            DriverManager.setDriver(driver);
            DriverManager.getDriver().get(ConfigFactory.getConfig().url());
            DriverManager.getDriver().manage().window().maximize();
        }
        }
    public static void quitDriver(){
        if (DriverManager.getDriver()!=null){
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }
    }
}
