package com.project.config;

import com.project.driver.DriverExecutables;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected FrameworkConfig config;

    @AfterMethod
    public void AfterMethod(){
        DriverExecutables.quitDriver();
    }
    @BeforeMethod
    public void BeforeMethod(){
        DriverExecutables.initDriver();
    }
}
