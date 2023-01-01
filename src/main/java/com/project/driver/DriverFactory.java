package com.project.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class  DriverFactory {
    private DriverFactory(){

    }
    public static WebDriver getDriver(String browserName ,String executionArea) throws MalformedURLException {
        WebDriver driver = null;
        if(executionArea.equals("local")) {
            if (browserName.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browserName.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }
        else if (executionArea.equals("remote")) {
            DesiredCapabilities capabilities=new DesiredCapabilities();
            if(browserName.equals("chrome")){
                capabilities.setBrowserName("chrome");
            } else if (browserName.equals("edge")) {
                capabilities.setBrowserName("edge");
            }
            else{
                capabilities.setBrowserName("chrome"); 
            }
                driver = new RemoteWebDriver(new URL("http://localhost:4444/"),capabilities);
        }
        return driver;
    }
}
