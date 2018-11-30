package com.seleniumPractice.SeleniumCucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Base {
	
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	public void searchProduct(String babyProduct)
	{
		searchBox.click();
		searchBox.sendKeys(babyProduct);
	}

}
