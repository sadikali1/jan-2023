package com.test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandle {

	@Test
	public void newWindowAndTab() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		String currentWindow = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		//driver.switchTo().window(currentWindow);
		driver.navigate().to("https://www.selenium.dev/documentation/webdriver/interactions/windows/");	
	}
	
	@Test
	public void testSwitchWindow() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.findElement(By.id("tabButton")).click();
		String currentWindow = driver.getWindowHandle();
		Set<String> windowIds = driver.getWindowHandles();
		
		for(String wind : windowIds) {
			driver.switchTo().window(wind);
		}
		String text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(text);
		driver.close();
		driver.switchTo().window(currentWindow);
		driver.findElement(By.id("windowButton")).click();
		driver.close();
		driver.quit();
	}
}
