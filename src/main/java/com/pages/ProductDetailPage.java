package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductDetailPage {

	WebDriver driver;

	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "[id='productTitle-false']")
	private WebElement productTitle;

	@FindBy(css = "[data-automation-id='addToCart']")
	private WebElement addToCartButtin;

	@FindBy(css = "[data-automation-id='at-panel-checkout-button']")
	private WebElement checkoutButton;

	public void verifyProduct(String product) {
		String text = productTitle.getText();
		Assert.assertTrue(text.contains(product));
	}

	public void clickOnAddCart() {
		addToCartButtin.click();
	}

	public void clickOnCheckoutButton() {
		checkoutButton.click();
	}
}
