package com.healthec.generic;


import com.healthec.projectSpec.CreateDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;


public class Screenshots {

    public static Logger log = Logger.getLogger("devpinoyLogger");


    public static void takeScreenShots(String screenshotName)  {
    String instance = null;
    RemoteWebDriver driver = CreateDriver.driver;
    instance =  driver.getClass().getName();

    if(instance.contains("AndroidDriver")) {
        screenshotForAndroid(screenshotName,driver);

    }
    else if(instance.contains("IOSDriver")) {
        screenshotForIos(screenshotName,driver);
        log.info("Screensshot taken in ios");
    }

    else {
        System.out.println("Invalid driver passed in screesnsot method");
        log.info("Invalid driver passed in screesnsot method");
    }
    }

    public static void screenshotForAndroid(String screenshotName,RemoteWebDriver driver) {

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destdir = new File("./Screenshots/"+screenshotName+".png");
            FileUtils.copyFile(src, destdir);
            log.info("Screenshot taken");
        }catch(Exception e) {
            System.out.println("Exception in taking screenshot: "+e.getMessage());
            log.info("Exception in taking screenshot in android");
        }
    }

    /*public static void screenshotForAndroid(String screenshotName,RemoteWebDriver driver) {
        AndroidDriver driver1 =  (AndroidDriver)driver;
        try {
            File src = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("./Screenshots/"+screenshotName+".png")); //"./appConfig/"+fileName+".properties"
            log.info("Screenshot taken");
        }catch(Exception e) {
            System.out.println("Exception in taking screenshot: "+e.getMessage());
            log.info("Exception in taking screenshot in android");
        }
    }*/
    public static void screenshotForIos(String screenshotName,RemoteWebDriver driver) {
        IOSDriver driver2 =  (IOSDriver)driver;
        try {
            File src = driver2.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("./Screenshots/"+screenshotName+".png"));
            log.info("Screenshot taken");
        }catch(Exception e) {
            System.out.println("Exception in taking screenshot: "+e.getMessage());
            log.info("Exception in taking screenshot in ios");
        }
    }



}
