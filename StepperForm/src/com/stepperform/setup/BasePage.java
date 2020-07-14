package com.stepperform.setup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BasePage {
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void Initialize(String browser, String url) {
		System.setProperty("webdriver.chrome.driver","E:\\Sanket\\Career\\Java\\Drivers\\Chrome\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	@Parameters({"browser", "url"})
	public void setup(String browser, String url) {
		this.Initialize(browser, url);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
