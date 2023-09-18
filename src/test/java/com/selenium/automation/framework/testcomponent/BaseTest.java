package com.selenium.automation.framework.testcomponent;

import com.automation.pageobjects.LandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    //public LandingPage lpage;
    public WebDriver initializeDriver() throws IOException {
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\automation\\resources\\GlobalData.properties");
        prop.load(fis);
        String browserName=prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")) {
        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\coditas\\Desktop\\Coditas\\Selenium Automation\\Selenium Setup\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        	//WebDriverManager.chromedriver().setup();
        	driver = new ChromeDriver();

        }
        else if(browserName.equalsIgnoreCase("firefox"))

        {
            System.out.println("Firefox");
        }

        else if(browserName.equalsIgnoreCase("edge"))

        {
            System.out.println("Firefox");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    @BeforeMethod
    public LandingPage launchWebApplication() throws IOException {
        driver=initializeDriver();
        LandingPage lpage=new LandingPage(driver);
        lpage.goToLandingPage();
        return lpage;
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }

}
