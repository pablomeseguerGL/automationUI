package framework.config;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cucumber.api.java.it.Ma;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import static framework.config.MobileCapabilities.getCapabiltiiesJson;


/**
 * Created by pablomeseguer on 1/29/18.
 */
public class DriverMobile  {



    public static AppiumDriver<WebElement> driver;

    public static  ArrayList<DesiredCapabilities> listCapabilities=new ArrayList<>();



    public DriverMobile() {
//Dinamico los puertos
        AppiumServerJava appiumServer = new AppiumServerJava();

        int port = 4723;
        if(!appiumServer.checkIfServerIsRunnning(port)) {
            appiumServer.startServer(port);
            //   appiumServer.stopServer();
        } else {
            System.out.println("Appium Server already running on Port - " + port);
        }

        String capabilities = getCapabiltiiesJson();
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

    public static   ArrayList<DesiredCapabilities> searchCapability(String property, String value){
        ArrayList<DesiredCapabilities> capabilities=new ArrayList<>();
        for(DesiredCapabilities capability :listCapabilities){
            if(capability.getCapability(property).toString().contains(value)){
                capabilities.add(capability);
            }

        }
        return capabilities;

    }

    public   AppiumDriver<?> getDriver(String platformName ) throws Exception {
        {

            AppiumDriver<?> appiumDriver = null;




            Boolean isRemote=false;
            String url="";



            switch (platformName.toLowerCase()) {

                case "android":
                    try {

                        if(isRemote) {

                         //   appiumDriver = (AppiumDriver<WebElement>) new RemoteWebDriver(new URL(url), capabilitiesObjet);
                        }
                        else
                        {
                            DesiredCapabilities desiredCapabilities = searchCapability("platformName", "Android").get(0);

                            final String URL_STRING = "";
                            String urltemp = desiredCapabilities.getCapability("url").toString();

                            driver = new AndroidDriver<WebElement>(new URL(urltemp), desiredCapabilities);
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "ios":

                    try {


                        if(isRemote) {
                       //     appiumDriver = (AppiumDriver<WebElement>) new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesObjet);
                        }
                        else
                        {
                            DesiredCapabilities desiredCapabilities = searchCapability("platformName", "iOS").get(0);

                            final String URL_STRING = "";
                            String urltemp = desiredCapabilities.getCapability("url").toString();

                            driver = new IOSDriver<WebElement>(new URL(urltemp), desiredCapabilities);
                        }

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;

            }







        }

        return (AndroidDriver) driver;

    }




}

