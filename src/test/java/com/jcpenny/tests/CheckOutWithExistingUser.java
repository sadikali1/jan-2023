package com.jcpenny.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.core.BaseTest;
import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.ProductDetailPage;
import com.pages.SigninPage;

public class CheckOutWithExistingUser extends BaseTest{

	String product = "Eclipse Ambiance Texture Draft Stopper Energy Saving 100% Blackout Grommet";

	@Test
	public void searchTest() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.searchProduct(product);

		ProductDetailPage productdetail = PageFactory.initElements(driver, ProductDetailPage.class);
		productdetail.verifyProduct(product);
		
		productdetail.clickOnAddCart();
		productdetail.clickOnCheckoutButton();
		
		CartPage cartPage =  PageFactory.initElements(driver, CartPage.class);
		cartPage.verifyProduct(product);
		cartPage.clickOnCheckOut();
		
		SigninPage signPage = PageFactory.initElements(driver, SigninPage.class);
		signPage.login(userName, password);
	}
}

// TestNG (TDD)
// cucumber (BDD)

//Scenario:
//	I am in login 
//	I click on login button 
//	I enter user name and password
//	I am click on signin button
//	I verify user login successfully



