package com.seleniumPractice.SeleniumCucumber.runners;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
//This annotation is used to run all feature files Junit/testng tests 
//@cucumber options is used to set output format and other specifications
//dryRun=true-check availability of step definitions for feature files
//strict=false means even there is no step definitions for scenarios the cucumber wont fail the build it will skip the undefined steps
//plugin attribute is use to defined output format. Pretty means prints gherkin source code with additional colors and stack trace for errors
//html://target/cucumber generates html report in target/cucumber path    
/*@CucumberOptions(plugin={"pretty","html://target/cucumber"},features="classpath:\\src\\test\\java\\com\\seleniumPractice\\SeleniumCucumber\\resources",glue={"src\\test\\java\\com\\seleniumPractice\\SeleniumCucumber\\bindings"} ,snippets=SnippetType.CAMELCASE,monochrome=true,dryRun=false,strict=false)*/
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(plugin={"pretty","html://target/cucumber"},features="C:\\Users\\user\\SeleniumProject\\SeleniumCucumber\\resources",glue="src\\test\\java\\com\\seleniumPractice\\SeleniumCucumber\\bindings",dryRun=false)
public class MyRunnerTest{
public static WebDriver driver;
private TestNGCucumberRunner testRunner;

@BeforeClass
public void setUp()
{
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	testRunner=new TestNGCucumberRunner(MyRunnerTest.class);
	
}
@Test(description="search",dataProvider="features")
public void search(CucumberFeatureWrapper cFeature)
{
	testRunner.runCucumber(cFeature.getCucumberFeature());
}
@DataProvider(name="features")
public Object[][] getFeatures()
{
	
	return testRunner.provideFeatures();
	
}
@AfterClass
public void tearDown()
{
	testRunner.finish();
}


}
