package com.selenium.automation.framework.test;


import com.automation.pageobjects.CartPage;
import com.automation.pageobjects.LandingPage;
import com.automation.pageobjects.ProductListingPage;
import com.selenium.automation.framework.testcomponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidationTest extends BaseTest {
	
	@Test
    public void errorValidation() throws IOException {
        LandingPage lpage = launchWebApplication();
        //ProductListingPage
        lpage.loginApplication("snehl.pil@gmail.com", "Snl@123");
        //Assert.assertEquals("Incorrect email or password.",lpage.getErrorMessage());


    }
	
	@Test
	public void productErrorValidation() throws IOException, InterruptedException
	{
		 String productName="ZARA COAT 3";
	        LandingPage lpage=launchWebApplication();
	        //ProductListingPage
	        ProductListingPage productListPage=lpage.loginApplication("snehal.patil@gmail.com", "Snehal@123");
	       // List<WebElement> products=productListPage.getProductList();
	        productListPage.addProductToCart(productName);
	        //CartPage
	        CartPage cartPage=productListPage.goToCartPage();//access goToCartPage() by using any of the Page object class
	        Boolean match=cartPage.productDisplay(productName);
	        Assert.assertTrue(match);
	}
}
