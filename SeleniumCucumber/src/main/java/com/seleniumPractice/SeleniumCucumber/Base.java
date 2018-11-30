package com.seleniumPractice.SeleniumCucumber;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {
    //final variable cannot be reassigned or modified
    public final WebDriver driver;
    


  public Base(WebDriver driver)
  {
   this.driver=driver;
  }

    public void waitForElement(By element, int duration)
    {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void switchToIFrame(WebElement element)
    {
        driver.switchTo().frame(element);
    }
    public void switchToDefaultContent(WebDriver driver)
    {
        driver.switchTo().defaultContent();
    }


}