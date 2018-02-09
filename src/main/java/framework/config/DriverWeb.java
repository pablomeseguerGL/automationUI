package framework.config;


import cucumber.api.Scenario;
import framework.common.SauceUtils;
import framework.common.Utilities;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverWeb {

    public static WebDriver myDriver=null;
    public static String browser;
    public static boolean isRemote;
    public static String username;
    public static String password;
    public static String accessKey;
    public static String port;
    public static String browserVersion;
    public static String platform;
    public static Utilities util;
    public static String testName;
    public static String sessionId;


    public static WebDriver getWebDriver(String testNameP) throws Exception {
        util = new Utilities();
        testName = testNameP;
        readConfiguration();
        if(isRemote){

     //       authentication = new SauceOnDemandAuthentication(username, accessKey);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
            capabilities.setCapability(CapabilityType.VERSION, browserVersion);
            capabilities.setCapability(CapabilityType.PLATFORM, platform);
            capabilities.setCapability("name", testNameP);

            myDriver = new RemoteWebDriver(
                        new URL("http://" + username + ":" + accessKey + "@ondemand.saucelabs.com:"+
                                port + "/wd/hub"), capabilities);
            sessionId = (((RemoteWebDriver) myDriver).getSessionId()).toString();

        }else{
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

        }

//        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return myDriver;

    }
    private static void readConfiguration() throws Exception {

        String jsonString = util.getCapabilities("WebDriverConfig.properties", false);
        JSONObject mainJsonObject = new JSONObject(jsonString);
        JSONArray dataArray = mainJsonObject.getJSONArray("capabilities");
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject jsonObject = dataArray.getJSONObject(i);
            if (i == 0) {
                username = jsonObject.get("username").toString();
                password = jsonObject.get("password").toString();
                accessKey = jsonObject.get("key").toString();
            } else {
                if (testName.equals(jsonObject.get("testName").toString())) {
                    isRemote = Boolean.parseBoolean(jsonObject.get("isRemote").toString());
                    if (isRemote) {
                        browser = jsonObject.get("browser").toString();
                        platform = jsonObject.get("platform").toString();
                        browserVersion = jsonObject.get("browserVersion").toString();
                        port = jsonObject.get("port").toString();
                    } else {
                        browser = jsonObject.get("browser").toString();
                        platform = jsonObject.get("platform").toString();
                    }

                }

            }


        }

    }

    public static void setResults(Scenario scenario){

        if(isRemote) {

            try {
                SauceUtils.UpdateResults(username, accessKey, !scenario.isFailed(), sessionId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
