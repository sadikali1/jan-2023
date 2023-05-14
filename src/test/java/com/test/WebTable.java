package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTable {

	@Test
	public void testWebTable() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div/div[4]"));
		for(WebElement element : elements) {
			String email = element.getText();
			if(email.isBlank()) {
				break;
			}
			System.out.println(email);
		}
		
	
	}
		
}
