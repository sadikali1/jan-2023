package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

	@Test
	public void testDragAndDrop() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable");
		
		Actions action = new Actions(driver);
		WebElement sourceElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		action.dragAndDrop(sourceElement, targetElement).build().perform();
		driver.quit();
	}
	
	@Test
	public void testDragAndDropByPosition() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/dragabble");
		
		Actions action = new Actions(driver);
		WebElement sourceElement = driver.findElement(By.id("dragBox"));
		action.dragAndDropBy(sourceElement, 200, 200).build().perform();
		driver.quit();
	}
}
