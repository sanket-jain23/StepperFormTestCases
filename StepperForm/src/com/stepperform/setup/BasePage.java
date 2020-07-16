package com.stepperform.setup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BasePage {
	
	protected WebDriver driver;
	
	
	public void Initialize(String browser, String url) {
		//System.setProperty("webdriver.chrome.driver","E:\\Sanket\\Career\\Java\\Drivers\\Chrome\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RASHMIKA\\Desktop\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	@Parameters({"browser", "url"})
	public void setup(String browser, String url) {
		this.Initialize(browser, url);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
