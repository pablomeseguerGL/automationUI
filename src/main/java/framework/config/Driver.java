package framework.config;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cucumber.api.java.it.Ma;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.*;
import org.openqa.selenium.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;


/**
 * Created by pablomeseguer on 1/29/18.
 */
public class Driver  {



    public static AppiumDriver<WebElement> driver;

    public static  ArrayList<DesiredCapabilities> listCapabilities=new ArrayList<>();
    String capabilities;


    public Driver(String capabilities) {
        AppiumServerJava appiumServer = new AppiumServerJava();

        int port = 4723;
        if(!appiumServer.checkIfServerIsRunnning(port)) {
            appiumServer.startServer(port);
         //   appiumServer.stopServer();
        } else {
            System.out.println("Appium Server already running on Port - " + port);
        }
        this.capabilities=capabilities;
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
    DesiredCapabilities desiredCapabilities = searchCapability("platformName", "Android").get(0);





    final String URL_STRING = "";
    String urltemp = desiredCapabilities.getCapability("url").toString();

    driver = new AndroidDriver<WebElement>(new URL(urltemp), desiredCapabilities);

}
        }

   return (AndroidDriver) driver;

        }


public Map<Boolean,DesiredCapabilities> remoteExecution(DesiredCapabilities desiredCapabilities ) {

    boolean remoteExecution = false;
    DesiredCapabilities desiredCapabilitiesTemp = null;
    Map<Boolean,DesiredCapabilities> values=null;
    String[] capabilities = desiredCapabilities.toString().split(",");
    for (String capability : capabilities) {
        if (capability.toString().contains("remote")) {
            if (capability.toString().contains("yes")) {
                remoteExecution = true;
            }

        } else
            desiredCapabilitiesTemp.setCapability(capability.split(":")[0].toString(), capability.split(":")[1].toString());
    }
    values.keySet().add(remoteExecution);
    values.values().add(desiredCapabilitiesTemp);

return values;
}





    }

