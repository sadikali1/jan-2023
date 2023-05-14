package com.jcpenny.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.core.BaseTest;
import com.core.Configuration;
import com.pages.HomePage;
import com.pages.ProductDetailPage;

public class Search extends BaseTest {
	
	@Test
	public void testSearch() {
		String product = "Eclipse Ambiance Texture Draft Stopper Energy Saving 100% Blackout Grommet";
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//HomePage homePage = new HomePage(driver);
		homePage.searchProduct(product);
		
		ProductDetailPage productdetail = PageFactory.initElements(driver, ProductDetailPage.class);
		productdetail.verifyProduct(product);
	}

}
