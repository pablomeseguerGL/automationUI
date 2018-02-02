package framework.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import framework.common.Utilities;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static framework.config.DriverMobile.getJsonProperties;

/**
 * Created by pablomeseguer on 1/30/18.
 */
public class MobileCapabilities {
    public static ArrayList<Capabilities> listCapabilities=new ArrayList<>();

    public MobileCapabilities() {


    }



    private static String getCapabiltiiesJson(){

        String capabilitiesList = null;
        Utilities utilities = new Utilities();
        try {
            capabilitiesList = utilities.getCapabilities("config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  capabilitiesList;
    }

    private  ArrayList<Capabilities> generateCapabilities(String capabilities){

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

    public   static ArrayList<DesiredCapabilities> searchCapability(List<DesiredCapabilities> capabilities, String property, String value) {
        ArrayList<DesiredCapabilities> capabilitiesArrayList = null;
        for (DesiredCapabilities capability :capabilities) {
            if (capability.getCapability(property).toString().contains(value)) {
                capabilitiesArrayList.add(capability);
            }

        }
        return capabilitiesArrayList;
    }



    public static List<String>  getJsonProperties() {
        JsonParser jsonObject = new JsonParser();
        JsonObject jsonObjet = jsonObject.parse(getCapabiltiiesJson()).getAsJsonObject();
        JsonObject jsonObjetAsJsonObject = jsonObjet.getAsJsonObject();
        List<String> capabilities=null;

        for (JsonElement jsonElement : jsonObjetAsJsonObject.get("capabilities").getAsJsonArray()) {

            for (int i = 0; i <= jsonElement.getAsJsonObject().entrySet().toArray().length - 1; i++) {
                String[] capabilityObject=   jsonElement.getAsJsonObject().entrySet().toArray()[i].toString().split("=");

                capabilities.add(capabilityObject[0].toString()+"~"+capabilityObject[1].toString().toString().replace("\"",""));
            }


        }
        return capabilities;

    }

}
