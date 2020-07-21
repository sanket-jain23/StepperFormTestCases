package com.stepperform.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.stepperform.pageobjects.LoginPage;
import com.stepperform.pageobjects.VehicleInfo;
import com.stepperform.setup.BasePage;

public class VehicleInfoTest extends BasePage{
  @Test
  public void vehicleInfoValid() throws Exception {
	  
      LoginPage login=new LoginPage(driver);
      login.login("sanket@infy.com", "sanket123");
      
      VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.setRegistrationNumber("12345678");
	  
	  vInfo.setCertificationNumber("123456789");
	  
	  vInfo.setDrivingOutside("No");
	  vInfo.setPurpose(1);
	  
	  Thread.sleep(5000);
	  Boolean value=vInfo.setButton(true);
	  Thread.sleep(5000);
	  Boolean text=vInfo.getTitle();
	  
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Submit successful.Moves to the insuring party page.");
	  
//	  System.out.println("The title of next page : "+text);
	  Assert.assertTrue(text);
  }
}
