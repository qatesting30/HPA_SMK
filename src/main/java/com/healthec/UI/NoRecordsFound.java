package com.healthec.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NoRecordsFound {


    public static WebElement noRecordsFoundMsg(RemoteWebDriver driver)
    {
       WebElement ele1 = driver.findElement(By.xpath("//div[@class='no-records-msg']"));
       return ele1;
    }
    public static WebElement RecordsAvailableMsg(RemoteWebDriver driver)
    {

        WebElement ele2 = driver.findElement(By.className("Record_Main"));
        return ele2;
    }
}