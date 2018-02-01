package framework.common;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.Properties;

/**
 * Created by pablomeseguer on 1/29/18.
 */
public class Utilities {

    public String getCapabilities(String name) throws Exception {
        String initialRead = "";
        String finalRead = "";
        String strLine;

        // Open the file
        FileInputStream fstream = new FileInputStream(name);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        //Read File Line By Line
        while ((strLine = br.readLine()) != null) {
            if (strLine != null) {
                if (strLine.contains("#") && strLine.contains("iOS")) {
                    initialRead = "{";
                } else if (strLine.contains("#")) {
                    initialRead = initialRead + "},{";
                } else {
                    initialRead = initialRead + "\"" + strLine.replace('=', ':') + ",";
                }
            }
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

        dataValidator(finalRead);

        return finalRead;
    }

    private void dataValidator(String text) throws Exception {
        try {
            JSONObject mainJsonObject = new JSONObject(text);
            JSONArray dataArray = mainJsonObject.getJSONArray("capabilities");
            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject jsonObject = dataArray.getJSONObject(i);
                if(!jsonObject.get("platformName").toString().isEmpty() && !jsonObject.get("platformVersion").toString().isEmpty()
                        && !jsonObject.get("deviceName").toString().isEmpty() && !jsonObject.get("automationName").toString().isEmpty()
                        && !jsonObject.get("app").toString().isEmpty()){
                    }else{
                    throw new Exception("Mandatory capabilities are empty");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public String getProperty(String fileName, String property) {
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
}
