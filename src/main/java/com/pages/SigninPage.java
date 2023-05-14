package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPage {

	WebDriver driver;

	public SigninPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "email")
	private WebElement userInput;

	@FindBy(id = "cartSignInPassword")
	private WebElement passowrdInput;

	@FindBy(css = "[class*='signInBlock'] [data-automation-id='at-sign-in-button']")
	private WebElement signInButton;

	@FindBy(css = "[data-automation-id=\"at-continue-as-guest\"]")
	private WebElement guestButton;
	
	public void login(String user, String password) {
		userInput.sendKeys(user);
		passowrdInput.sendKeys(password);
		signInButton.click();
	}
	
	public void clickOnGuestButton() {
		guestButton.click();
	}

	
}
