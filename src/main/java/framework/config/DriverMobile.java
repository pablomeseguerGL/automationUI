package framework.config;

/**
 * Created by pablomeseguer on 1/30/18.
 */

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DriverMobile extends MobileCapabilities  {


    public  static AppiumDriver appiumDriver;
    Capabilities capabilities;
    public  static  String platform;
    public DriverMobile() {



        this.capabilities=capabilities;
        this.platform=platform;
        AppiumServerJava appiumServer = new AppiumServerJava();

        int port = 4723;
        if(!appiumServer.checkIfServerIsRunnning(port)) {
            appiumServer.startServer(port);
        } else {
            System.out.println("Appium Server already running on Port - " + port);
        }



    }

    public static AppiumDriver<?> returnDriver(DesiredCapabilities capabilitiesObjet) {
        final String URL_STRING = "";
        String typeExecution="";
        AppiumDriver<?> appiumDriver = null;




        Boolean isRemote=false;
        String url="";



        switch (platform.toLowerCase()) {

            case "android":
                try {

                    url=  capabilitiesObjet.getCapability("url").toString();
                    if(isRemote) {



                        appiumDriver = (AppiumDriver<WebElement>) new RemoteWebDriver(new URL(url), capabilitiesObjet);
                    }
                    else
                    {
                        appiumDriver = new AndroidDriver<>(new URL(url), capabilitiesObjet);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case "ios":
                try {

                    url=  capabilitiesObjet.getCapability("url").toString();
                    if(isRemote) {
                        appiumDriver = (AppiumDriver<WebElement>) new RemoteWebDriver(new URL(url), capabilitiesObjet);
                    }
                    else
                    {
                        appiumDriver = new IOSDriver<>(new URL(url), capabilitiesObjet);
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

        }
        return appiumDriver;


    }




    public static ArrayList<DesiredCapabilities> getCapabilities(String platformName) {
        boolean isRemote=false;
        List<DesiredCapabilities> capabilities=null;
        DesiredCapabilities capabilitiesObjet=null;
        for(String capability :getJsonProperties()){
            if(capability.equals("isRemote=\"false\"")){
                isRemote=true;
            }
            if(!isRemote) {
                String[] capabilityValues = capability.split("~");
                capabilitiesObjet.setCapability(capabilityValues[0].toString(), capabilityValues[1].toString().toString().replace("\"", ""));
            }
            capabilities.add(capabilitiesObjet);
        }
        return  searchCapability(capabilities,"platformName",platformName);
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








