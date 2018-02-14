package framework.common;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.Properties;

import static framework.config.DriverWeb.util;

/**
 * Created by pablomeseguer on 1/29/18.
 */
public class Utilities {

    public String getCapabilities(String name,boolean validateRequiredFields) throws Exception {
        String initialRead = "";
        String finalRead = "";
        String strLine;
        int line = 0;
        // Open the file
        FileInputStream fstream = new FileInputStream(name);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        //Read File Line By Line
        while ((strLine = br.readLine()) != null) {
            if (strLine != null) {
                if (line==0) {
                    initialRead = "{";
                } else if (strLine.contains("#")) {
                    initialRead = initialRead + "},{";
                } else {
                    initialRead = initialRead + "\"" + strLine.replace('=', ':') + ",";
                }
            }
            line++;
        }

        String[] parts = initialRead.split(",");

        for (int i = 0; i < parts.length - 1; i++) {

            if (parts[i].contains("url")) {
                parts[i] = parts[i].replace("url:", "url\":");
                parts[i].trim();

                finalRead = finalRead + parts[i] + ",";

            } else if (parts[i + 1].contains("}") || i == parts.length - 2) {
                parts[i] = parts[i].replace(":", "\":");
                finalRead = finalRead + parts[i];

            } else {
                parts[i] = parts[i].replace(":", "\":");
                finalRead = finalRead + parts[i] + ",";
            }
        }
        //Add last value due to +1 in the Split.
        parts[parts.length - 1] = parts[parts.length - 1].replace(":", "\":");
        finalRead = finalRead + "," + parts[parts.length - 1];

        //Json Formatting
        finalRead = finalRead.replace(",\"}", "}");
        finalRead = finalRead.replace("{\",", "{");
        finalRead = "{\"capabilities\": [" + finalRead + "}]}";

        //Close the input stream
        br.close();
        if (validateRequiredFields) {
            Boolean validation = false;
            validation = dataValidator(finalRead);

            System.out.println(finalRead);

            if (validation == true) {
            } else {
                throw new Exception("Required capabilities are missing");
            }
        }
        return finalRead;
    }

    private boolean dataValidator(String text) {
        Boolean bool = false;

        try {
            JSONObject mainJsonObject = new JSONObject(text);
            JSONArray dataArray = mainJsonObject.getJSONArray("capabilities");
            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject jsonObject = dataArray.getJSONObject(i);
                if(!jsonObject.get("platformName").toString().isEmpty() && !jsonObject.get("platformVersion").toString().isEmpty()
                        && !jsonObject.get("deviceName").toString().isEmpty() && !jsonObject.get("automationName").toString().isEmpty()
                        && !jsonObject.get("app").toString().isEmpty()){
                    bool = true;
                    }else{
                    bool = false;
                    break;
                }
            }

            return bool;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getProperty(String fileName, String property) {
        Properties prop = new Properties();
        InputStream input = null;
        String value="";
        try {

            input = new FileInputStream(fileName);
            prop.load(input);
            value=prop.getProperty(property);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    public  String getSelectors(String featureName, String property ) {
        Properties prop;
        String value = null;
        try {
            prop = new Properties();
            String fileName="src/test/java/PageFactory/"+featureName+".properties";
            prop.load(new FileInputStream(new File(fileName)));

            value = prop.getProperty(property);

            if (value == null || value.isEmpty()) {
                throw new Exception("Value not set or empty");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }




}
