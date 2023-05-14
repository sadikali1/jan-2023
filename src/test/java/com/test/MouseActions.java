package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseActions {

	@Test
	public void driverGetMethod() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/buttons");
		
		Actions action = new Actions(driver);
		WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
		action.doubleClick(doubleClickBtn).build().perform();
		String doubleMessage = driver.findElement(By.id("doubleClickMessage")).getText();
		Assert.assertEquals(doubleMessage, "You have done a double click");
		
		WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
		action.contextClick(rightClickBtn).build().perform();
		String rightClickMessage = driver.findElement(By.id("rightClickMessage")).getText();
		Assert.assertEquals(rightClickMessage, "You have done a right click");
		
		WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
		action.click(clickButton).build().perform();	
	}
}
