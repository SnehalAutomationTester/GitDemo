package com.automation.pageobjects;

import com.automation.abstractcomponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;
    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement userPassword;

    @FindBy(id="login")
    WebElement loginButton;

    @FindBy(css="[class*='flyInOut ']")
    WebElement errorMessage;

    public ProductListingPage loginApplication(String useremail, String password){
        userEmail.sendKeys(useremail);
        userPassword.sendKeys(password);
        loginButton.click();
        return new ProductListingPage(driver);
    }

    public String getErrorMessage()
    {
        waitForWebElementToVisible(errorMessage);
        return errorMessage.getText();
    }

    public void goToLandingPage(){
        driver.get("https://rahulshettyacademy.com/client");
    }
}
