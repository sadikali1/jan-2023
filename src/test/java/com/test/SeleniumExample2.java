package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeleniumExample2 {
	
	@Test
	public void exampleDroDown() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.linkText("Create new account")).click();
		WebElement userInput = driver.findElement(By.name("firstname"));
		userInput.clear();
		userInput.sendKeys("FirstName");
		driver.findElement(By.name("lastname")).sendKeys("SurName");
		driver.findElement(By.name("reg_email__")).sendKeys("test@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Password@1");
		
		WebElement dayElement = driver.findElement(By.id("day"));
		Select selectDay = new Select(dayElement);
		//selectDay.selectByIndex(0);
		//selectDay.selectByVisibleText("10");
		
		WebElement monthElement = driver.findElement(By.id("month"));
		Select selectMonth = new Select(monthElement);
		//selectMonth.selectByVisibleText("Jul");
		selectMonth.selectByValue("5");
		
	}

}
