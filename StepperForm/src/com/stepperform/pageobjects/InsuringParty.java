package com.stepperform.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuringParty {
	
	private WebDriver driver;
	
	By lnch = By.cssSelector("input[id=egn]");
	
	By dropdown = By.tagName("mat-select");
	
	By email = By.cssSelector("input[id=email]");
	
	By button = By.cssSelector("button[id=next]");

	public InsuringParty(WebDriver driver2) {
		driver = driver2;
	}
	
	public Boolean valid(String lnchNo, String value, String emailId) {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		this.setLnch(lnchNo);
		
		this.chooseAddress(value);
		
		this.setEmail(emailId);
		
		wait.until(ExpectedConditions.elementToBeClickable(button));
		
		driver.findElement(button).click();
		
		String text = driver.findElement(By.tagName("body")).getText();
		
		if( text.contains("Policy Details") )
			return true;
		return false;
		
	}
	
	public void setLnch(String lnchNo) {
		
		driver.findElement(lnch).sendKeys(lnchNo);
		
	}
	
	public void chooseAddress(String value) {
		WebElement select = driver.findElement(dropdown);
		
		Select selectFrom = new Select(select);
		
		selectFrom.selectByValue(value);
	}
	
	public void setEmail(String emailId) {
		
		driver.findElement(email).sendKeys(emailId);
		
	}
}
