package com.healthec.UI;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BackButton {

    public static String instance;

    public static void backButon(RemoteWebDriver driver) {
        SwitchView.changeContext(driver, "NATIVE_APP");

        instance = driver.getClass().getName();
        if (instance.contains("AndroidDriver")) {
            AndroidDriver driver1 = (AndroidDriver) driver;
            driver1.navigate().back();
        }
        else if(instance.contains("IOSDriver")){
            IOSDriver driver2 = (IOSDriver) driver;
            //driver2.navigate().back();
            driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Return to PHR Pro')]")).click();

        }
        SwitchView.changeContext(driver, "WEBVIEW");
    }
}
