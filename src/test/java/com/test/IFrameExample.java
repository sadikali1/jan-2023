package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IFrameExample {

	@Test
	public void frame1() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		
		driver.switchTo().frame("frame1");
		String text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(text);
		
		driver.switchTo().parentFrame();
		String text1 = driver.findElement(By.xpath("//div[@id='framesWrapper']/div")).getText();
		System.out.println(text1);
	}
	
	@Test
	public void nestedFrame() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");
		
		driver.switchTo().frame("frame1");
		String bodyText = driver.findElement(By.tagName("body")).getText();
		System.out.println(bodyText);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc=\"<p>Child Iframe</p>\"]")));

		String pText = driver.findElement(By.tagName("p")).getText();
		System.out.println(pText);
		
		driver.switchTo().defaultContent();
		String text1 = driver.findElement(By.xpath("//div[@id='framesWrapper']/div")).getText();
		System.out.println(text1);
	}
}
