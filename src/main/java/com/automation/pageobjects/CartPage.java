package com.automation.pageobjects;

import com.automation.abstractcomponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;
    public CartPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

   

    @FindBy(xpath="//div[@class='cartSection']/h3")
    List<WebElement> cartProductList;

    @FindBy(xpath="//li[@class='totalRow']/button")
    WebElement checkoutEle;

    public Boolean productDisplay(String productName)
    {
        Boolean match= cartProductList.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckOutPage checkOut()
    {
        checkoutEle.click();
        return new CheckOutPage(driver);
    }

}

