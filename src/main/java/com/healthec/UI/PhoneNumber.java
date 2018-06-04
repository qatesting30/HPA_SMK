package com.healthec.UI;


import com.healthec.generic.ExcelData;
import com.healthec.generic.ExcelUtility;
import com.healthec.generic.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.healthec.generic.TestBaseClass.testdataExcel;

public class PhoneNumber {

    public static String instance;

    public static String dialerPackageName = "com.android.contacts";
    public static String dialerActivityName = "com.android.dialer.DialtactsActivity";

    public static ExcelData testdataSheet = null;


    public static void phoneNumberValidation(RemoteWebDriver driver)
    {
        instance = driver.getClass().getName();
        if(instance.contains("AndroidDriver"))
        {
            phoneNumberAndroid(driver);
        }
        else if (instance.contains("IOSDriver"))
        {
            phoneNumberIos(driver);
        }
        else{
            System.out.println("Invalid driver passed for phone number validation");
        }
    }

    public static void phoneNumberAndroid(RemoteWebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        SwitchView.changeContext(driver,"NATIVE_APP");
        WebElement digit = driver.findElement(By.id("com.android.contacts:id/digits"));
        System.out.println("Number displaying in phone number is: "+digit.getText());
        Assert.assertTrue(digit.getText().length()>0);
        driver.navigate().back();
        SwitchView.changeContext(driver,"WEBVIEW");

    }
    public static void phoneNumberIos(RemoteWebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        SwitchView.changeContext(driver,"NATIVE_APP");
        TestBaseClass.testcaseInit();
        testdataSheet = testdataExcel;
        String phoneNumberInSheet = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 2);
        System.out.println("phone number: "+phoneNumberInSheet);
        WebElement digit = driver.findElement(By.xpath("////XCUIElementTypeStaticText[contains(@name,'+phoneNumberInSheet+')]"));
        System.out.println("Number displaying in phone number is: "+digit.getText());
        Assert.assertTrue(digit.getText().length()>0);
        Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Cancel')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Call')]")).isDisplayed());
        driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Cancel')]")).click();
        SwitchView.changeContext(driver,"WEBVIEW");

    }




}
