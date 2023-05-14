package com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakeScreenshotEx {
	
	@Test
	public void driverGetMethod() throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		TakesScreenshot tc = (TakesScreenshot)driver;
		File file1 = tc.getScreenshotAs(OutputType.FILE);
		File file2 = new File("image.png");
		FileUtils.copyFile(file1, file2);
		
		WebElement login = driver.findElement(By.name("login"));
		File fileElement1 = login.getScreenshotAs(OutputType.FILE);
		File fileElement2 = new File("login.png");
		FileUtils.copyFile(fileElement1, fileElement2);
	}
	

}
