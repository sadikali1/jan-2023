package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WikiPedia {

	ChromeDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "TestData")
	public void searchCountry(String name, String countryName) {
		driver.findElement(By.cssSelector("[name=\"search\"]")).sendKeys(name);
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		String text = driver.findElement(By.cssSelector("[id=\"firstHeading\"]")).getText();
		Assert.assertEquals(text, countryName);
	}
	
	@DataProvider(name="TestData")
	public Object[][] data() {
		Object[][] obj = new Object[][]{
			{"India", "India"},
			{"United States", "United States"},
			{"UAE", "United Arab Emirates"},
			{"UK", "United Kingdom"}
		};
		return obj;
	}
}
