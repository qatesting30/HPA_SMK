package com.healthec.test;


import com.healthec.projectSpec.CreateDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LaunchAppTest {
	
	public static RemoteWebDriver driver;
	
	public static Logger log = Logger.getLogger("devpinoyLogger");

	@Test
	public static RemoteWebDriver launchAppTest()
	{
		CreateDriver.getDriver();
		log.info("App has launched");
		return driver;
	}

}
