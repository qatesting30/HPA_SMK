package com.healthec.UI;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Set;

public class SwitchView {
	
	public static String instance;

	public static void changeContext(RemoteWebDriver driver, String context)
	{
		instance = driver.getClass().getName();
		if(instance.contains("AndroidDriver"))
		{
			
			AndroidDriver driver1= (AndroidDriver)driver;
			Set<String>availContexts = driver1.getContextHandles();
			System.out.println("Driver is Android and available contents: "+availContexts);
			for(String givenContext : availContexts){
				if(givenContext.contains(context)){
					driver1.context(context);
			        System.out.println("Context changed to: "+context);
				}
			}
		}
		else if(instance.contains("IOSDriver"))
		{
			IOSDriver driver2= (IOSDriver)driver;
			Set<String>availContexts = driver2.getContextHandles();
			System.out.println("Driver is IOS and available contents: "+availContexts);
			for(String givenContext : availContexts){

				if(context.equalsIgnoreCase("WEBVIEW")) {
					if (givenContext.contains(context + "_")) {
						driver2.context(context + "_4");
						System.out.println("Context changed to: " + context + "_4");
					}
				}
				if(context.equalsIgnoreCase("NATIVE_APP"))
				{
					if(givenContext.contains(context)) {
						driver2.context(context);
						System.out.println("Context changed to: " + context);
					}
				}

			}
		}
	}

}
