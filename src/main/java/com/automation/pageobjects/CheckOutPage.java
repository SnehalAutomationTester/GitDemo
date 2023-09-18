package com.automation.pageobjects;

import com.automation.abstractcomponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends AbstractComponent {

    WebDriver driver;
    public CheckOutPage(WebDriver driver) {

        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="[placeholder='Select Country']")
    WebElement country;
    @FindBy(xpath = "//div[@class='actions']/a")
    WebElement submit;

    @FindBy(xpath = "//div[@class='form-group'] /section/button[2]")
    WebElement selectCountry;

    By results=By.cssSelector(".ta-results");

    public void selectCountry(String countryName)
    {
        Actions a=new Actions(driver);
        a.sendKeys(country,countryName).build().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        waitForElementToVisible(results);
        selectCountry.click();
    }

    public ConfirmationPage submitOrder(){
        submit.click();
        return new ConfirmationPage(driver);
    }
}
