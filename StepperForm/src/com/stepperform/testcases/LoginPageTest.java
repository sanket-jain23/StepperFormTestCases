package com.stepperform.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stepperform.pageobjects.LoginPage;
import com.stepperform.setup.BasePage;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LoginPageTest extends BasePage{

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = getDriver();
	}
	
	@Test
	public void login() {
	
		
			try {
				LoginPage login = new LoginPage(driver);
				
				Boolean result = login.login("sanket@infy.com", "sanket123");
				
				Assert.assertTrue(result);
			} catch (Exception e) {
				System.out.println("The error message says: "+e.getMessage());
			}		
		
		
	}
	
	@Test
	public void loginInvlaid() {
		try {
			LoginPage login = new LoginPage(driver);
			
			Boolean result = login.loginInvalid("karan@infy.com", "karan123");
			
			Assert.assertTrue(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("The error message says: "+e.getMessage());
		}
	}
	
	@AfterClass
	public void back() {
		driver.navigate().back();
	}
}
