package com.stepperform.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	
	
	By email = By.id("email");
	
	By passwrod = By.id("password");
	
	By login = By.cssSelector("button[value=Login]");
	
	public LoginPage(WebDriver driver2) {
		
		driver = driver2;
	}



	public Boolean login(String userId, String passcode) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		driver.findElement(email).sendKeys(userId);
		
		driver.findElement(passwrod).sendKeys(passcode);
		
		wait.until(ExpectedConditions.elementToBeClickable(login));
		
		driver.findElement(login).click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert().sendKeys("Sanket");
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		
		String message = driver.findElement(By.tagName("body")).getText();
		
		if ( message.contains("WELCOME") )
			return true;
		return false;
		
	}
	
	public Boolean loginInvalid(String userId, String passcode) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		driver.findElement(email).sendKeys(userId);
		
		driver.findElement(passwrod).sendKeys(passcode);
		
		wait.until(ExpectedConditions.elementToBeClickable(login));
		
		driver.findElement(login).click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert().accept();
		
		String message = driver.findElement(By.tagName("body")).getText();
		
		if ( !message.contains("WELCOME") )
			return true;
		return false;
	}
}
