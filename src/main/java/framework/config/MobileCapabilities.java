package framework.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import framework.common.Utilities;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by pablomeseguer on 1/30/18.
 */
public class MobileCapabilities {
    public static ArrayList<Capabilities> listCapabilities=new ArrayList<>();

    public MobileCapabilities() {
        String capabilitiesList = null;
        Utilities utilities = new Utilities();
        try {
            capabilitiesList = utilities.getCapabilities("config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        listCapabilities=generateCapabilities(capabilitiesList);
    }

    public  ArrayList<Capabilities> generateCapabilities(String capabilities){

        JsonParser jsonObject = new JsonParser();
        JsonObject jsonObjet = jsonObject.parse(capabilities).getAsJsonObject();
        JsonObject jsonObjetAsJsonObject = jsonObjet.getAsJsonObject();
        boolean execution=false;
        for(JsonElement jsonElement:jsonObjetAsJsonObject.get("capabilities").getAsJsonArray()){
            DesiredCapabilities capabilitiesObjet=new DesiredCapabilities();
            for(int i=0;i<=jsonElement.getAsJsonObject().entrySet().toArray().length-1;i++){

                String[] capabilityObject=   jsonElement.getAsJsonObject().entrySet().toArray()[i].toString().split("=");



                capabilitiesObjet.setCapability(capabilityObject[0].toString(),capabilityObject[1].toString().toString().replace("\"",""));

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

    public Capabilities searchCapability( ArrayList<Capabilities>  capabilities,String property, String value) {

        for (Capabilities capability : capabilities) {
            if (capability.getCapability(property).toString().contains(value)) {
                return capability;
            }

        }
        return null;
    }





    public static ArrayList<Capabilities> CapabilitiesAndroid(){
        ArrayList<Capabilities> capabilities=new ArrayList<>();
        for(Capabilities capability :listCapabilities){
            if(capability.getCapability("platformName").toString().contains("Android")){
                capabilities.add(capability);
            }

        }
        return capabilities;

    }

    public static ArrayList<Capabilities> CapabilitiesiOS(){
        ArrayList<Capabilities> capabilities=new ArrayList<>();
        for(Capabilities capability :listCapabilities){
            if(capability.getCapability("platformName").toString().contains("iOS")){
                capabilities.add(capability);
            }

        }
        return capabilities;

    }


}
