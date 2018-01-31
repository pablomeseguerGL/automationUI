package framework.config;

/**
 * Created by pablomeseguer on 1/30/18.
 */

import io.appium.java_client.AppiumDriver;

public class Driver extends MobileCapabilities  {


    public  static AppiumDriver appiumDriver;

    public Driver() {

        AppiumServerJava appiumServer = new AppiumServerJava();

        int port = 4723;
        if(!appiumServer.checkIfServerIsRunnning(port)) {
            appiumServer.startServer(port);
            //   appiumServer.stopServer();
        } else {
            System.out.println("Appium Server already running on Port - " + port);
        }
    }

    public static AppiumDriver setDriver(String platformName){
        switch (platformName.toLowerCase()) {
            case "android":
                appiumDriver = new framework.config.AndroidDriver(CapabilitiesAndroid().get(0)).executeAndroidDriver();
                break;
            case "ios":
                appiumDriver =  new framework.config.iOSDriver(CapabilitiesiOS().get(0)).executeiOSDriver();
                break;
        }
        return appiumDriver;

    }
/*
    public void parallelExecution(String driverType){

        switch (driverType.toLowerCase()) {
            case "android":
                Runnable r1 = new framework.config.AndroidDriver(desiredCapabilities);
                break;
            case "iOS":

        }

*/






    }








