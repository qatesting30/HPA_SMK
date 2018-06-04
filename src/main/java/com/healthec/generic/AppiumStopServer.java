package com.healthec.generic;


import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class AppiumStopServer {

    private static AppiumDriverLocalService service;
    private static AppiumServiceBuilder builder;
    public static String instance;
    @Test
    public static void stopServer () {

       // RemoteWebDriver driver = LoginPageUC.driver;
        //instance =driver.getClass().getName();
        Runtime runtime = Runtime.getRuntime();
        if(instance.contains("AndroidDriver")) {
            try {
                runtime.exec("taskkill /F /IM node.exe");
                runtime.exec("taskkill /F /IM cmd.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (instance.contains("IOSDriver")) {

            String[] command = { "/usr/bin/killall", "-KILL", "node" };
            try {
                Runtime.getRuntime().exec(command);
                System.out.println("Appium server stopped.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


       /* builder = new AppiumServiceBuilder();
        service = AppiumDriverLocalService.buildService(builder);
        service.stop();*/
        }
    }

