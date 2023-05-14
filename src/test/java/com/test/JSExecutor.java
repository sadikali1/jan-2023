package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSExecutor {
	
	@Test
	public void jsExecitor() {
		ChromeDriver driver = new ChromeDriver();
		Dimension newDimension = new Dimension(800, 600);
		driver.manage().window().setSize(newDimension);
		driver.get("https://demoqa.com/buttons");
		WebElement element = driver.findElement(By.xpath("//button[text()='Click Me']")); //.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		
		//js.executeScript("arguments[0].click()", element);
		//js.executeScript("window.scroll(1000, 1000)");
	}

}
