package com.stepperform.testcases;


import org.testng.annotations.Test;

import com.stepperform.pageobjects.LoginPage;
import com.stepperform.setup.BasePage;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LoginPageTest extends BasePage{

//	WebDriver driver;
	
//	@BeforeClass
//	public void setup() {
//		driver = getDriver();
//	}
	
	@Test( priority = 2 )
	public void login() {
	
		
			try {
				LoginPage login = new LoginPage(driver);
				
				Boolean result = login.login("sanket@infy.com", "sanket123");
				
				Assert.assertTrue(result);
			} catch (Exception e) {
				System.out.println("The error message says: "+e.getMessage());
			}		
		
		
	}
	
	@Test(priority = 1)
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
	
}
