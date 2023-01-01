package com.project.pages.pagecomponents;


import com.project.driver.DriverManager;
import com.project.enums.WaitType;
import com.project.utils.SeliniumUtils;
import org.openqa.selenium.By;

public class SideMeneComponent {
   private String menuComponent="//span[text()='menu']";

   public void clickTime(){
       SeliniumUtils.click(By.xpath(menuComponent.replace("menu","PIM")),WaitType.PRESCENCE,"time");
   }
}
