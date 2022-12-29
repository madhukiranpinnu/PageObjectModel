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
    public static WebDriver getDriver(String browserName){
        WebDriver driver;
        if(browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        else if (browserName.equals("remote")) {
            DesiredCapabilities capabilities=new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/"),capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        return driver;
    }
}
