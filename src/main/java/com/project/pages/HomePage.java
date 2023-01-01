package com.project.pages;

import com.project.driver.DriverManager;
import com.project.pages.pagecomponents.SideMeneComponent;
import org.openqa.selenium.By;

public class HomePage {
    private SideMeneComponent sideMeneComponent;
    public HomePage(){
        sideMeneComponent=new SideMeneComponent();
    }
    public String Title(){
        return DriverManager.getDriver().getTitle();
    }
    public void clickOnTime(){
        sideMeneComponent.clickTime();
    }

}
