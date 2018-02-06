package framework.config;

import framework.common.Utilities;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

public class DriverWeb {

    public static WebDriver myDriver=null;
    public static String browser;
    public static boolean isRemote;
    public static String username;
    public static String password;
    public static String accessKey;
    public static String port;
    public static String localBrowser;
    public static Utilities util;
    public static String testName;

    public static WebDriver getWebDriver(String localBrowser) {
       // util = new Utilities();
       // testName = testNameP;


        browser=localBrowser;

        switch (browser.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "./Resources/geckodriver");
                myDriver = new FirefoxDriver();
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver");
                myDriver = new ChromeDriver();
                break;

            case "safari":
                myDriver = new SafariDriver();
                break;

            case "internetExplorer":
               // if (platform.toLowerCase().equals("mac")) {
               //     throw new RuntimeException("Internet Explorer not supported on MAC platform");
               // }
                System.setProperty("webdriver.ie.driver", "./Resources/MicrosoftWebDriver.exe");
                myDriver = new InternetExplorerDriver();
                break;

            default:
                throw new RuntimeException("Browser Type not supported. " +
                        "Only Firefox, Chrome, Safari, HtmlUnitDriver and InternetExplorer(Only Windows) browsers are supported");
        }

        return myDriver;

    }
  /*  private void readConfiguration() throws Exception {

        String jsonString = util.getCapabilities("WebDriverConfig.properties",false);
        JSONObject mainJsonObject = new JSONObject(jsonString);
        JSONArray dataArray = mainJsonObject.getJSONArray("capabilities");
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject jsonObject = dataArray.getJSONObject(i);
            if(i==0){
                isRemote=Boolean.parseBoolean(jsonObject.get("isRemote").toString());
                username=jsonObject.get("username").toString();
                password=jsonObject.get("password").toString();
                accessKey=jsonObject.get("key").toString();
            }else{
                if(testName.equals(jsonObject.get("testName").toString())){
                    browsers.add(new String[]{jsonObject.get("platform").toString(),
                            jsonObject.get("browserVersion").toString(),
                            jsonObject.get("browser").toString(), null, null});
                }else{
                    browsers.add(new String[]{null,
                            null,
                            null, null, null});
                    break;
                }

            }

        }
        return browsers;


    }
*/




}
