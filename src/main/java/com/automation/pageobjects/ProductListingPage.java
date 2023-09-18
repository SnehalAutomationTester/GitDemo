package com.automation.pageobjects;

import com.automation.abstractcomponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListingPage extends AbstractComponent {

    WebDriver driver;
    public ProductListingPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className="mb-3")
    List<WebElement> productList;

    By productBy=By.className("mb-3");
    By addToCart=By.xpath("//*[@class='card-body']/button[2]");
    By toastMessage=By.id("toast-container");

    public List<WebElement> getProductList() {
        waitForElementToVisible(productBy);
        return productList;
    }

    public WebElement getProductByName(String productName) {
        WebElement specificProductName=productList.stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return specificProductName;
    }

    public void addProductToCart(String productName) throws InterruptedException {
        WebElement targetedProduct=getProductByName(productName);
        targetedProduct.findElement(addToCart).click();
        waitForElementToVisible(toastMessage);
        Thread.sleep(3000);

    }



}
