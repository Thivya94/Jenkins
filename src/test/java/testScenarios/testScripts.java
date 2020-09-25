package testScenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentTest;

import resources.Base;

public class testScripts extends Base
{
	public WebDriver driver;
	
	
	
	@Test
	 public void test1() throws IOException, InterruptedException
	 {
		//Reports();
		ExtentTest test = extent.createTest("Users");
		Td.set(initializeDriver("chrome"));
		Login(Td.get(),"Login",test);}
	//commit from home
		
		
		 
		
		 

	
	@Test
	 public void test2() throws IOException, InterruptedException
	 {
		ExtentTest test = extent.createTest("New_Test");
		Td.set(initializeDriver("chrome"));
		Login(Td.get(),"Login",test);
	 }
	 
	
	
	@AfterMethod
	public void after()
	{
		
		Td.get().quit();
		extent.flush();
	}
	
}
