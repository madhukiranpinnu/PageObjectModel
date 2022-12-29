package com.project.driver;

import com.project.config.ConfigFactory;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public final  class DriverExecutables {
    private DriverExecutables(){

    }
    public static void initDriver() {
        String browserName=ConfigFactory.getConfig().browser();
        if(DriverManager.getDriver()==null){
            WebDriver driver=DriverFactory.getDriver(browserName);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().get(ConfigFactory.getConfig().url());
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(ConfigFactory.getConfig().timeout(), TimeUnit.SECONDS);
        }
        }
    public static void quitDriver(){
        if (DriverManager.getDriver()!=null){
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }
    }
}
