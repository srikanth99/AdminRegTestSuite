package com.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

/**
 * Created by ACER on 12/16/2014.
 */
public class Utils extends BaseClass{

    public static int generateRandomNo()
    {
        Random random1=new Random();
        int randomNumber=random1.nextInt();
        return randomNumber;
    }
    public static boolean isTextPresent(String text)
    {
        return driver.findElement(By.tagName("body")).getText().contains(text);
    }

    public static void selectFromDropDownMenu(By element,String text)
    {
        Select select=new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }
}
