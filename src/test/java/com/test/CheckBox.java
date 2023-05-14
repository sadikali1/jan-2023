package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckBox {

	@Test
	public void testCheckBox() {
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/checkbox");
		boolean status1 = driver.findElement(By.id("tree-node-home")).isSelected();
		System.out.println(status1);
		driver.findElement(By.xpath("//span[@class='rct-title']")).click();
		boolean status2 = driver.findElement(By.id("tree-node-home")).isSelected();
		System.out.println(status2);
	}
	
}
