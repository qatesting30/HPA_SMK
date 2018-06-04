package com.healthec.UI;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.time.Duration;



public class Swipe {

	public static String instance;

	public static void swipeVerticalDown(RemoteWebDriver driver, int duration)
	{
       instance = driver.getClass().getName();
       if(instance.contains("AndroidDriver"))
	   {
		   swipeVerticalDownAndroid(driver,duration);
	   }
	   else if(instance.contains("AndroidDriver"))
	   {
		   swipeVerticalDownIos(driver,duration);
	   }
	   else{
		   System.out.println("Invalid driver passed");
	   }

	}

	public static void swipeVerticalUp(RemoteWebDriver driver, int duration)
	{
		instance = driver.getClass().getName();
		if(instance.contains("AndroidDriver"))
		{
			swipeVerticalUpAndroid(driver,duration);
		}
		else if(instance.contains("AndroidDriver"))
		{
			swipeVerticalUpIos(driver,duration);
		}
		else{
			System.out.println("Invalid driver passed");
		}

	}

	public static void swipeVerticalDownIos(RemoteWebDriver driver, int duration)
	{
		IOSDriver driver1= (IOSDriver) driver;
		String currentContext = driver1.getContext();
		System.out.println("Current Context is: "+currentContext);
		SwitchView.changeContext(driver, "NATIVE_APP");
		Dimension size = driver.manage().window().getSize();
		int ht=size.getHeight();
		int wd=size.getWidth();
		int width = (int) (wd*0.5);
		int startPoint = (int) (ht * 0.8);
		int endPoint = (int) (ht * 0.2);

		new TouchAction((PerformsTouchActions) driver).press(width, startPoint).waitAction(Duration.ofSeconds(duration)).moveTo(width, endPoint).release().perform();
        SwitchView.changeContext(driver, currentContext);



	}

	public static void swipeVerticalDownAndroid(RemoteWebDriver driver, int duration)
	{
	    AndroidDriver driver1= (AndroidDriver)driver;
	    String currentContext = driver1.getContext();
	    System.out.println("Current Context is: "+currentContext);
		SwitchView.changeContext(driver, "NATIVE_APP");
		Dimension size = driver.manage().window().getSize();
		int ht=size.getHeight();
		int wd=size.getWidth();
	    int width = (int) (wd*0.5);
	    int startPoint = (int) (ht * 0.8);
	    int endPoint = (int) (ht * 0.2);
	    new TouchAction((PerformsTouchActions) driver).press(width, startPoint).waitAction(Duration.ofSeconds(duration)).moveTo(width, endPoint).release().perform();
	    SwitchView.changeContext(driver, currentContext);
	}

	public static void swipeVerticalUpAndroid(RemoteWebDriver driver, int duration)
	{
		AndroidDriver driver1= (AndroidDriver)driver;
	    String currentContext = driver1.getContext();
		SwitchView.changeContext(driver, "NATIVE_APP");
		Dimension size = driver.manage().window().getSize();
		int ht=size.getHeight();
		int wd=size.getWidth();
	    int width = (int) (wd*0.5);
	    int startPoint = (int) (ht * 0.2);
	    int endPoint = (int) (ht * 0.8);
	    new TouchAction((PerformsTouchActions) driver).press(width, startPoint).waitAction(Duration.ofSeconds(duration)).moveTo(width, endPoint).release().perform();
	    SwitchView.changeContext(driver, currentContext);
	}
	public static void swipeVerticalUpIos(RemoteWebDriver driver, int duration)
	{
		IOSDriver driver1= (IOSDriver) driver;
		String currentContext = driver1.getContext();
		SwitchView.changeContext(driver, "NATIVE_APP");
		Dimension size = driver.manage().window().getSize();
		int ht=size.getHeight();
		int wd=size.getWidth();
		int width = (int) (wd*0.5);
		int startPoint = (int) (ht * 0.2);
		int endPoint = (int) (ht * 0.8);
		new TouchAction((PerformsTouchActions) driver).press(width, startPoint).waitAction(Duration.ofSeconds(duration)).moveTo(width, endPoint).release().perform();
		SwitchView.changeContext(driver, currentContext);
	}

	public static void swipeVerticalUpWithDimensionsAndroid(RemoteWebDriver driver, int duration, WebElement ele)
	{
		//SwitchView.changeContext(driver, "NATIVE_APP");

		int ht=ele.getSize().getHeight();
		int wd=ele.getSize().getWidth();
	    int width = (int) (wd*0.5);
	    int startPoint = (int) (ht * 0.7);
	    int endPoint = (int) (ht * 9);
	    new TouchAction((PerformsTouchActions) driver).press(width, startPoint).waitAction(Duration.ofSeconds(duration)).moveTo(width, endPoint).release().perform();
	    SwitchView.changeContext(driver, "WEBVIEW");
	}



}
