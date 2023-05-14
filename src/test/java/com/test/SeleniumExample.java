package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumExample {

	@Test
	public void sampleTest() {
		//System.setProperty("webdriver.chrome.driver", "");
		//WebDriverManager.chromedriver().setup();
		//ChromeDriver driver = new ChromeDriver();
		// WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		// EdgeDriver driver = new EdgeDriver();
		//SafariDriver driver = new SafariDriver();
		//InternetExplorerDriver driver = new InternetExplorerDriver();
		
		driver.get("https://www.facebook.com/");
		WebElement element = driver.findElement(By.id("email"));
		element.sendKeys("Testing@gmail.com");
		
		WebElement passElement = driver.findElement(By.id("pass"));
		passElement.sendKeys("Password");
		
		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.click();
		driver.quit();
	}

	// ID
	// Name
	// XPath ( Relative, absolute Xpath)
	// CSS
	// Class Name
	// Link Text
	// Partial Link Text
	// Tag Name
	
	// 4.6 // SeleniumManager
}
