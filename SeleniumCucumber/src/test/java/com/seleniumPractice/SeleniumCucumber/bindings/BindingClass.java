package com.seleniumPractice.SeleniumCucumber.bindings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.seleniumPractice.SeleniumCucumber.HomePage;
import com.seleniumPractice.SeleniumCucumber.runners.MyRunnerTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BindingClass {
/*	WebDriver driver;*/
	HomePage homePage;	
	@Given("^that i am on shopping Website$")
	public void that_i_am_on_shopping_Website() {
		
		//homePage=PageFactory.initElements(driver, HomePage.class);
		homePage=PageFactory.initElements(MyRunnerTest.driver, HomePage.class);;
		/*driver=new FirefoxDriver();
		driver.get("https://www.amazon.com");*/
		
		
		MyRunnerTest.driver.get("https://www.amazon.com");
	}

	@When("^the item is added to the basket$")
	/*@Parameters("babyProduct")*/
	public void the_item_is_added_to_the_basket()  {
	    // Write code here that turns the phrase above into concrete actions
		homePage.searchProduct("babyProduct");
	}

	@Then("^the items are available in the basket$")
	public void the_items_are_available_in_the_basket() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("wait for");
	}

}
