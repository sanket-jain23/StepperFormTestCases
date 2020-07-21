package com.stepperform.testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.stepperform.pageobjects.InsuringParty;
import com.stepperform.pageobjects.LoginPage;
import com.stepperform.pageobjects.VehicleInfo;
import com.stepperform.setup.BasePage;

public class InsuringPartyTest extends BasePage{

	WebDriver driver;
	
	@Test
	public void valid() throws Exception{
		try {
			LoginPage login = new LoginPage(driver);
			
			login.login("sanket@infy.com", "sanket123");
			
			VehicleInfo vinfo = new VehicleInfo(driver);
			
			vinfo.VehicleInfoValid("XXXX00YY", "C09876432", 1, "Yes");
			
			InsuringParty insure1 = new InsuringParty(driver);
			
			Boolean result = insure1.valid("XXXX00YY", "Sophia", "sanket@infy.com");
			
			Assert.assertTrue(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
