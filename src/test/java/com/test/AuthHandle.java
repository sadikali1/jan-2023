package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AuthHandle {

	@Test
	public void testAuth() {
		ChromeDriver driver = new ChromeDriver();
		HasAuthentication authentication = (HasAuthentication) driver;
		// You can either register something for all sites
		authentication.register(() -> new UsernameAndPassword("admin", "admin"));

		driver.get("https://the-internet.herokuapp.com/basic_auth");
		System.out.println(driver.findElement(By.tagName("h3")).getText());
	}
}

// Manual Testing
// Agile
// SQL
// Jira/Zephyr
// API Testing
// Postman
// Java 
// TestNg
// Selenium

// Access Modifiers (private, public, project, default)
// Final 

// RestAssured
// Page Object Model
// Cucumber (BDD)
// Git

