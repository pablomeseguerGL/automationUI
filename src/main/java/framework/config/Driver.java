package framework.config;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;






/**
 * Created by pablomeseguer on 1/29/18.
 */
public class Driver  {



    public static AppiumDriver<WebElement> driver;

    public static  ArrayList<DesiredCapabilities> listCapabilities=new ArrayList<>();



    public Driver(String capabilities) {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        listCapabilities=generateCapabilities(capabilities);

    }

    public static ArrayList<DesiredCapabilities> generateCapabilities(String capabilities){

        JsonParser jsonObject = new JsonParser();
        JsonObject jsonObjet = jsonObject.parse(capabilities).getAsJsonObject();
        JsonObject jsonObjetAsJsonObject = jsonObjet.getAsJsonObject();
        boolean execution=false;
        for(JsonElement jsonElement:jsonObjetAsJsonObject.get("capabilities").getAsJsonArray()){
            DesiredCapabilities capabilitiesObjet=new DesiredCapabilities();
            for(int i=0;i<=jsonElement.getAsJsonObject().entrySet().toArray().length-1;i++){

             String[] capabilityObject=   jsonElement.getAsJsonObject().entrySet().toArray()[i].toString().split("=");
                if(capabilityObject[0].toString().contains("run")){
                    if(capabilityObject[1].toString().contains("yes")){
                        execution=true;
                    }

                }
                if(execution && !capabilityObject[1].toString().contains("yes")){

                    capabilitiesObjet.setCapability(capabilityObject[0].toString(),capabilityObject[1].toString().toString().replace("\"",""));

                }


            }
            if(execution){

            listCapabilities.add(capabilitiesObjet);
            }
            execution=false;

        }

     return listCapabilities;
    }

public  ArrayList<DesiredCapabilities> searchCapability(String property, String value){
    ArrayList<DesiredCapabilities> capabilities=new ArrayList<>();
        for(DesiredCapabilities capability :listCapabilities){
        if(capability.getCapability(property).toString().contains(value)){
            capabilities.add(capability);
        }

    }
    return capabilities;

}

    public  AndroidDriver androidDriverRun() throws Exception {
        {


  if(searchCapability("platformName","Android").size()>=1) {
    DesiredCapabilities desiredCapabilities = searchCapability("deviceName", "gloo").get(0);
    final String URL_STRING = "";
    String urltemp = desiredCapabilities.getCapability("url").toString();
    driver = new AndroidDriver<WebElement>(new URL(urltemp), desiredCapabilities);
}
        }

   return (AndroidDriver) driver;

        }

    }

