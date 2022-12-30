package com.project.pages;

import com.project.driver.DriverManager;

public class HomePage {
    public String title(){
        return DriverManager.getDriver().getTitle();
    }
}
