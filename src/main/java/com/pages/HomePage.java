package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id = "searchInputId")
	private WebElement searchInput;
	
	@FindBy(css = "button[data-automation-id='searchIconBlock']")
	private WebElement searchButton;
	
	
	public void searchProduct(String product) {
		searchInput.sendKeys(product);
		searchButton.click();
	}
}


// PageFactorty
// new 
