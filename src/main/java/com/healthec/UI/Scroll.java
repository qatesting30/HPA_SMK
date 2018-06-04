package com.healthec.UI;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;

public class Scroll {

    public static String instance;
    public static RemoteWebDriver driver;


	public static void scrollToText(RemoteWebDriver driver, Object text)
    {

        instance =driver.getClass().getName();

        if(instance.contains("AndroidDriver")) {
            scrollToTextAndroid(driver, text);
        }
        else if(instance.contains("IOSDriver")){
            scrollToTextIos(driver, text);
        }
        else
        {
            System.out.println("Invalid driver  getting passed");
        }
    }


    public static void scrollToTextAndroid(RemoteWebDriver driver, Object text)
	{
		SwitchView.changeContext(driver, "NATIVE_APP");
		System.out.println("text value is: "+text);


        /*driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().textMatches(\""+text +"\"))")).click();*/

        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
    		+ "scrollIntoView(new UiSelector().text(\""+text+"\").instance(0))")).click();
	SwitchView.changeContext(driver, "WEBVIEW");
	}

    /*public static void scrollToTextIos(RemoteWebDriver driver,Object text)
    {
        SwitchView.changeContext(driver, "NATIVE_APP");
        System.out.println("text value is: "+text);
        driver.findElement(MobileBy.IosUIAutomation("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
                + "scrollIntoView(new UiSelector().textMatches(\"" +text + "\").instance(0))")).click();
        SwitchView.changeContext(driver, "WEBVIEW");
    }*/

    public static  void scrollToTextIos(RemoteWebDriver driver, Object text) {
        System.out.println("   tapItemByDescription(): " + text);

        // scroll to item
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap scrollObject = new HashMap();
        scrollObject.put("predicateString", "value == '" + text + "'");
        js.executeScript("mobile: scroll", scrollObject);

        // tap item
        /*WebElement el = ((IOSDriver) driver).findElementByIosNsPredicate("value = '" + text + "'");
        return tapElement((MobileElement) el);*/
    }

}
