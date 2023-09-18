package com.selenium.automation.framework.test;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import com.automation.pageobjects.*;
import com.selenium.automation.framework.testcomponent.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SubmitOrderTest extends BaseTest {
	
    String productName="ZARA COAT 3";
    
	@Test(dataProvider="getData", groups={"Purchase"})
    public void submitOrder(String userEmail, String password,String productName) throws InterruptedException, IOException
    {
    
        LandingPage lpage=launchWebApplication();
        //ProductListingPage
        ProductListingPage productListPage=lpage.loginApplication(userEmail, password);
       // List<WebElement> products=productListPage.getProductList();
        productListPage.addProductToCart(productName);
        //CartPage
        CartPage cartPage=productListPage.goToCartPage();//access goToCartPage() by using any of the Page object class
        Boolean match=cartPage.productDisplay(productName);
        Assert.assertTrue(match);
        CheckOutPage checkoutPage=cartPage.checkOut();
        checkoutPage.selectCountry("India");
        //ConfirmationPage
        ConfirmationPage confirmationPage=checkoutPage.submitOrder();
        String text=confirmationPage.getConfirmationMessage();
        Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


    }

    
    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest() throws IOException
    {
    	 LandingPage lpage=launchWebApplication();
         //ProductListingPage
         ProductListingPage productListPage=lpage.loginApplication("snehal.patil@gmail.com", "Snehal@123");
         OrderPage orderPage=productListPage.goToOrderPage();
         Assert.assertTrue(orderPage.productDisplay(productName));
         
    }
    
    @DataProvider
    public Object[][] getData()
    {
    	return new Object[][] {{"snehal.patil@gmail.com","Snehal@123","ZARA COAT 3"},{"snehal.patil@gmail.com","Sneha@123","ADIDAS ORIGINAL"}};
    }
    
    
   

    
    @Test
    public Object[][] getGitData()
    {
    	return new Object[][] {{"snehal.patil@gmail.com","Snehal@123","ZARA COAT 3"},{"snehal.patil@gmail.com","Sneha@123","ADIDAS ORIGINAL"}};
    }

}


