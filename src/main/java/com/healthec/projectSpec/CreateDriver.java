package com.healthec.projectSpec;

import com.healthec.generic.PropertiesData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class CreateDriver {

	public static DesiredCapabilities cap;
	public static RemoteWebDriver driver ;

	@SuppressWarnings("rawtypes")
	public static RemoteWebDriver getDriver()
	{
		driver = null;
        String env = PropertiesData.getDataFromProperties("config","env");
        if(env.equalsIgnoreCase("AOS"))
		{
			driver = androidSetUp();
		}
		else if (env.equalsIgnoreCase("IOS"))
		{
			driver = iosSetUp();
		}
		else{
		System.out.println("Invalid driver format");
	     }

	     return driver;
		}



	public static RemoteWebDriver androidSetUp() {
		RemoteWebDriver driver = null;
		try {
			String env = PropertiesData.getDataFromProperties("config", "env");
			String platformName = PropertiesData.getDataFromProperties("config" + env, "platformName");
			String platformVersion = PropertiesData.getDataFromProperties("config" + env, "platformVersion");
			String appPackage = PropertiesData.getDataFromProperties("config" + env, "appPackage");
			String appActivity = PropertiesData.getDataFromProperties("config" + env, "appActivity");
			String deviceName = PropertiesData.getDataFromProperties("config" + env, "deviceName");
			String appiumURL = PropertiesData.getDataFromProperties("config" + env, "appiumURL");
			String automationName = PropertiesData.getDataFromProperties("config" + env, "automationName");
            String skipUnlock = PropertiesData.getDataFromProperties("config"+env,"skipUnlock");
            String autoWebView = PropertiesData.getDataFromProperties("config"+env,"autoWebview");
            String nativeWebScreenshot = PropertiesData.getDataFromProperties("config"+env,"nativeWebScreenshot");
			cap = new DesiredCapabilities();
			cap.setCapability("platformName", platformName);
			cap.setCapability("platformVersion", platformVersion);
			cap.setCapability("appPackage", appPackage);
			cap.setCapability("appActivity", appActivity);
			cap.setCapability("deviceName", deviceName);
			//cap.setCapability("automationName",automationName);
            cap.setCapability("skipUnlock",skipUnlock);
            //cap.setCapability("autoWebView",autoWebView);
			cap.setCapability("nativeWebScreenshot",nativeWebScreenshot);

			driver = new AndroidDriver(new URL(appiumURL),cap);

		} catch (Exception e) {
			System.out.println("Exception in getting driver value: " + e.getMessage());
		}
		return driver;
	}

	public static RemoteWebDriver iosSetUp() {
		RemoteWebDriver driver = null;
		try {
			String env = PropertiesData.getDataFromProperties("config", "env");
			String platformName = PropertiesData.getDataFromProperties("config" + env, "platformName");
			String platformVersion = PropertiesData.getDataFromProperties("config" + env, "platformVersion");
			String deviceName = PropertiesData.getDataFromProperties("config" + env, "deviceName");
			String appiumURL = PropertiesData.getDataFromProperties("config" + env, "appiumURL");
			String bundleId = PropertiesData.getDataFromProperties("config" + env, "bundleId");
			String udid = PropertiesData.getDataFromProperties("config" + env, "udid");
			String automationName = PropertiesData.getDataFromProperties("config" + env, "automationName");

			cap = new DesiredCapabilities();
			cap.setCapability("platfromName", platformName);
			cap.setCapability("platformVersion", platformVersion);
			cap.setCapability("bundleId", bundleId);
            cap.setCapability("udid", udid);
			cap.setCapability("deviceName", deviceName);
			cap.setCapability("automationName",automationName);
			driver = new IOSDriver(new URL(appiumURL),cap);
		} catch (Exception e) {
			System.out.println("Exception in getting driver value: " + e.getMessage());
		}
		return driver;
	}




	/*public static RemoteWebDriver getDriver()
	{
		RemoteWebDriver driver = null;
		try{
			String env = PropertiesData.getDataFromProperties("config", "env");
			String platformName = PropertiesData.getDataFromProperties("config"+env, "platformName");
			String platformVersion = PropertiesData.getDataFromProperties("config"+env, "platformVersion");
			String appPackage = PropertiesData.getDataFromProperties("config"+env, "appPackage");
			String appActivity = PropertiesData.getDataFromProperties("config"+env, "appActivity");
			String deviceName = PropertiesData.getDataFromProperties("config"+env, "deviceName");
			String appiumURL = PropertiesData.getDataFromProperties("config"+env, "appiumURL");
			String bundleId = PropertiesData.getDataFromProperties("config"+env, "bundleid");
			
			cap = new DesiredCapabilities();
			cap.setCapability("platfromName", platformName);
			cap.setCapability("platformVersion", platformVersion);
			cap.setCapability("appPackage", appPackage);
			cap.setCapability("appActivity", appActivity);
			cap.setCapability("deviceName", deviceName);
			
			if(env.equalsIgnoreCase("AOS")){
				driver = new AndroidDriver(new URL(appiumURL),cap);
			}
			else if(env.equalsIgnoreCase("IOS")){
				cap.setCapability("bundleId", bundleId);
				driver = new IOSDriver(new URL(appiumURL),cap);
			}
			else{
				System.out.println("Invalid driver");
			}
					
		}
		catch(Exception e)
		{
			System.out.println("Exception in getting driver value: "+e.getMessage());
		}
		return driver;
	}*/

}
