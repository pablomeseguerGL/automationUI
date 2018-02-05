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
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;
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

    public DriverMobile() {



        this.capabilities=capabilities;

        AppiumServerJava appiumServer = new AppiumServerJava();

        int port = 5000;
        if(!appiumServer.checkIfServerIsRunnning(port)) {
            appiumServer.startServer(port);
        } else {
            System.out.println("Appium Server already running on Port - " + port);
        }



    }

    public static DesiredCapabilities ignoreCapabilities(DesiredCapabilities capability,String deleteCapability) {
        DesiredCapabilities capabilityValue=new DesiredCapabilities();
        for (String capabilityTemp : capability.toString().replace("Capabilities {","").replace("}","")
                .split(",")) {
         String[]  capabilityTempSecondLevel=  capabilityTemp.split(":");
            if(!capabilityTempSecondLevel[0].contains(deleteCapability)){
                capabilityValue.setCapability(capabilityTempSecondLevel[0],capabilityTempSecondLevel[1]);
            }

        }
        return capabilityValue;
    }

    public static AppiumDriver<?> returnDriver(String platformName,DesiredCapabilities capabilitiesObjet) {


        final String URL_STRING = "";
        String typeExecution="";
        AppiumDriver<?> appiumDriver = null;




        Boolean isRemote=false;
        String url="";



        switch (platformName.toLowerCase()) {

            case "android":
                try {


                    url=  capabilitiesObjet.getCapability("url").toString();
                    capabilitiesObjet= ignoreCapabilities(capabilitiesObjet,"url");
                    capabilitiesObjet= ignoreCapabilities(capabilitiesObjet,"app");
                    capabilitiesObjet.setCapability("app","/Users/pablomeseguer/Desktop/Demogloo/PatientEngagement-Apperian.apk");
                    if(isRemote) {



                        appiumDriver = (AppiumDriver<WebElement>) new RemoteWebDriver(new URL(url), capabilitiesObjet);
                    }
                    else
                    {
                        appiumDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesObjet);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case "ios":
                try {

                    url=  capabilitiesObjet.getCapability("url").toString();
                    capabilitiesObjet= ignoreCapabilities(capabilitiesObjet,"url");
                    if(isRemote) {
                        appiumDriver = (AppiumDriver<WebElement>) new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesObjet);
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








