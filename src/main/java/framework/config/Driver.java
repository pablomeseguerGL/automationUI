package framework.config;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import io.appium.java_client.*;
import org.openqa.selenium.*;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.html5.LocationContext;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.remote.Response;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by pablomeseguer on 1/29/18.
 */
public class Driver {



    public static AppiumDriver<WebElement> driver;
    List<DesiredCapabilities> listCapabilities=null;
    public static String capabilities;

    public Driver() {
        listCapabilities=generateCapabilities(capabilities);

    }

    public static  List<DesiredCapabilities> generateCapabilities(String capabilities){
        List<DesiredCapabilities> desiredCapabilities = null;
        JsonParser jsonObject = new JsonParser();
        JsonObject jsonObjet = jsonObject.parse(capabilities).getAsJsonObject();
        JsonObject jsonObjetAsJsonObject = jsonObjet.getAsJsonObject();
        for(JsonElement jsonElement:jsonObjetAsJsonObject.get("capabilities").getAsJsonArray()){
            DesiredCapabilities capabilitiesObjet=new DesiredCapabilities();
            for(int i=0;i<=jsonElement.getAsJsonObject().entrySet().toArray().length-1;i++){
          
             String[] capabilityObject=   jsonElement.getAsJsonObject().entrySet().toArray()[i].toString().split("=");
                if(capabilityObject[0].toString().contains("run")){

                }
                capabilitiesObjet.setCapability(capabilityObject[0].toString(),capabilityObject[1].toString());

            }
            desiredCapabilities.add(capabilitiesObjet);

        }

     return desiredCapabilities;
    }



    public  void androidCapabilities(){
        for(int i=0;i<=listCapabilities.size();i++){
           if(listCapabilities.get(i).getCapability("platformName").toString().contains("Android")){

           }

        }
    }


    public File getDirectoryApp(String directory , String appName){
       try {
           File appDir = new File(directory);
           File app = new File(appDir, appName);
           return app;
       }
       catch (Exception ex){
           throw  ex;
       }
    }




}
