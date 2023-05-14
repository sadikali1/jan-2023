package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "[data-automation-id='at-product-title-link'] span")
	private WebElement productTitle;
	
	@FindBy(css = "[id='checkoutButton']")
	private WebElement checkoutButton;
	
	
	public void verifyProduct(String product) {
		String text1 = productTitle.getText();
		Assert.assertTrue(text1.contains(product));
	}
	
	public void clickOnCheckOut(){
		checkoutButton.click();
	}

}
