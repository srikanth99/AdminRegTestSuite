package com.admin;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by revathi on 12/16/2014.
 */
public class BaseTest{
    WebDriver driver = BrowserFactory.getDriver();
    String URL1="http://insoftt.trial47.orangehrmlive.com/";

    @Before
    public void startBrowser(){

        try {
            BrowserFactory.StartBrowser("Firefox", URL1);
            driver = BrowserFactory.driver;
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

  @After
    public void stopBrowser()
    {
        driver.quit();
    }

}
