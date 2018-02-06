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



/**
 * Created by pablomeseguer on 1/30/18.
 */
public class MobileCapabilities {
    public static ArrayList<DesiredCapabilities> listCapabilities=new ArrayList<>();

    public MobileCapabilities() {


    }



    public static String getCapabiltiiesJson(){

        String capabilitiesList = null;
        Utilities utilities = new Utilities();
        try {
            capabilitiesList = utilities.getCapabilities("config.properties",true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  capabilitiesList;
    }



    public   static ArrayList<DesiredCapabilities> searchCapability(ArrayList<DesiredCapabilities> capabilities, String property, String value) {
        ArrayList<DesiredCapabilities> capabilitiesArrayList = new ArrayList<>();
        for (DesiredCapabilities capability :capabilities) {
            if (capability.getCapability(property).toString().contains(value)) {
                capabilitiesArrayList.add(capability);
            }

        }
        return capabilitiesArrayList;
    }
    private  ArrayList<DesiredCapabilities> generateCapabilities(String capabilities){

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


    public static ArrayList<DesiredCapabilities>  getJsonProperties() {
        JsonParser jsonObject = new JsonParser();
        JsonObject jsonObjet = jsonObject.parse(getCapabiltiiesJson()).getAsJsonObject();
        JsonObject jsonObjetAsJsonObject = jsonObjet.getAsJsonObject();
        ArrayList<DesiredCapabilities> capabilities=new ArrayList<>() ;
        Boolean isRun=false;
        DesiredCapabilities capabilitiesList=new DesiredCapabilities();

        for (JsonElement jsonElement : jsonObjetAsJsonObject.get("capabilities").getAsJsonArray()) {

            for (int i = 0; i <= jsonElement.getAsJsonObject().entrySet().toArray().length - 1; i++) {

                String[] capabilityObject=   jsonElement.getAsJsonObject().entrySet().toArray()[i].toString().split("=");
                if(capabilityObject[0].contains("run")){
                    if (capabilityObject[1].contains("yes")){
                        isRun=true;
                    }
                }
                if (isRun == true && !capabilityObject[0].contains("run")) {
                    capabilitiesList.setCapability(capabilityObject[0].toString(),capabilityObject[1].toString());

                }

            }
            capabilities.add(capabilitiesList);

        }
        return capabilities;

    }
    public static ArrayList<DesiredCapabilities> getCapabilities(String platformName) {


        return  searchCapability(getJsonProperties(),"platformName",platformName);
    }
}
