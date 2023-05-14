package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetValues {

	@Test
	public void driverGetMethod() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("Forgotten password?")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		System.out.println(driver.getPageSource());
		driver.quit();
	}
	
	@Test
	public void getElementMethod() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		WebElement elementText = driver.findElement(By.tagName("h2"));
		String text = elementText.getText();
		System.out.println(text);
		Assert.assertEquals("Facebook helps you connect and share with the people in your life.",
				text);
		
		WebElement emailInput = driver.findElement(By.id("email"));
		String placeHolder = emailInput.getAttribute("placeholder");
		System.out.println(placeHolder);
		Assert.assertEquals("Email address or phone number", placeHolder);
		
		WebElement loginElement = driver.findElement(By.name("login"));
		String fontSize = loginElement.getCssValue("font-size");
		System.out.println(fontSize);
		String borderRadius = loginElement.getCssValue("border-radius");
		System.out.println(borderRadius);
		String width = loginElement.getCssValue("width");
		System.out.println(width);
		driver.quit();
	}
}
