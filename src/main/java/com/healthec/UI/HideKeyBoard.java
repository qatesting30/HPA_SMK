package com.healthec.UI;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HideKeyBoard {
	
	public static String instance;
	
	@SuppressWarnings("rawtypes")
	public static void hideKeyBoard(RemoteWebDriver driver)
	{
	    SwitchView.changeContext(driver, "NATIVE_APP");
		instance = driver.getClass().getName();
		if(instance.contains("AndroidDriver")){
			AndroidDriver driver1= (AndroidDriver)driver;
			driver1.hideKeyboard();
			}
		else if(instance.contains("IOSDriver")){
			IOSDriver driver2= (IOSDriver)driver;
			driver2.hideKeyboard();
		}
		SwitchView.changeContext(driver, "WEBVIEW");
	}

}
