package com.project.config;

import com.project.driver.DriverExecutables;
import com.project.reports.ExtentReport;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class BaseTest {
    protected FrameworkConfig config;
    @AfterMethod
    public void AfterMethod(){
        DriverExecutables.quitDriver();
    }
    @BeforeMethod
    public void BeforeMethod() throws MalformedURLException {
        DriverExecutables.initDriver();
    }
}
