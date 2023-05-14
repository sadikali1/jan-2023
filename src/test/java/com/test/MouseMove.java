package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseMove {
	
	@Test
	public void driverGetMethod() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/menu");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Main Item 2']")))
			.pause(1000).moveToElement(driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']")))
			.pause(1000).click(driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"))).build().perform();
	}

}
