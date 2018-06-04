package com.healthec.generic;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

public class AppiumStartServer {

        private static AppiumDriverLocalService service;
        private static AppiumServiceBuilder builder;
        private static DesiredCapabilities cap;


        public static void startServer(int port) {
            //Set Capabilities
            cap = new DesiredCapabilities();
            cap.setCapability("noReset", "false");

            //Build the Appium service
            builder = new AppiumServiceBuilder();
            builder.withIPAddress("127.0.0.1");
            builder.usingPort(port);
            builder.withCapabilities(cap);
            builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
            builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
            builder.withLogFile(new File("./log4j/server.logs"));

            //Start the server with the builder
            service = AppiumDriverLocalService.buildService(builder);
            service.start();
        }
        public static boolean checkIfServerIsRunnning(int port) {

            boolean isServerRunning = false;
            ServerSocket serverSocket;
            try {
                serverSocket = new ServerSocket(port);
                serverSocket.close();
            } catch (IOException e) {
                //If control comes here, then it means that the port is in use
                isServerRunning = true;
            } finally {
                serverSocket = null;
            }
            return isServerRunning;
        }

        @Test
        public static void startServer() {
            AppiumStartServer appiumStartServer = new AppiumStartServer();

            int port = 4723;
            if(!appiumStartServer.checkIfServerIsRunnning(port)) {
                appiumStartServer.startServer(port);
                //appiumStartServer.stopServer();
            } else {
                System.out.println(" Appium Server already running on Port - " + port);
            }
        }
    }

