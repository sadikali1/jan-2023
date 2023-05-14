package com.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertHandle {

	@Test
	public void javaSciptAlert() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.id("timerAlertButton")).click();
		WebDriverWait waitObj = new WebDriverWait(driver, Duration.ofSeconds(50));
		waitObj.until(ExpectedConditions.alertIsPresent());
		
		// Thread.sleep(50000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("alertButton")).click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		Assert.assertEquals("You clicked a button", text);
		alert.accept();
		driver.findElement(By.id("confirmButton")).click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.dismiss();
		
		driver.findElement(By.id("promtButton")).click();
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Testing");
		System.out.println(alert3.getText());
		alert.accept();
		
		
	}
	
}
