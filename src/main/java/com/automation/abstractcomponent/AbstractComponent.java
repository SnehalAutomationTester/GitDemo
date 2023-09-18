package com.automation.abstractcomponent;

import com.automation.pageobjects.CartPage;
import com.automation.pageobjects.OrderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(css="[routerlink*='cart']")
    WebElement cartButton;
    
    @FindBy(css="[routerlink*='myorder']")
    WebElement orderButton;
    
    public void waitForElementToVisible(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElementToVisible(WebElement findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public CartPage goToCartPage()
    {
      cartButton.click();
      return new CartPage(driver);
    }
    

    public OrderPage goToOrderPage()
    {
      orderButton.click();
      return new OrderPage(driver);
    }

}
