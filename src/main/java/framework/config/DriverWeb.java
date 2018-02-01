package framework.config;

import framework.common.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverWeb {

    public static WebDriver myDriver=null;
    public static Utilities util;
    public static boolean isRemote;
    public static String browser;
    public static String platform;
    public static String username; //userName used for sauceLab
    public static String password; //password used for sauceLab
    public static String key; //key used for sauceLab
    public static String port; //port used for sauceLab
    public static String browserVersion;


    public static WebDriver getWebDriver() {

        util =new Utilities();
        initialize();

        if (isRemote) {

            getRemoteWebDriver();

        } else {
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
                    if (platform.toLowerCase().equals("mac")) {
                        throw new RuntimeException("Internet Explorer not supported on MAC platform");
                    }
                    System.setProperty("webdriver.ie.driver", "./Resources/MicrosoftWebDriver.exe");
                    myDriver = new InternetExplorerDriver();
                    break;

                default:
                    throw new RuntimeException("Browser Type not supported. " +
                            "Only Firefox, Chrome, Safari, HtmlUnitDriver and InternetExplorer(Only Windows) browsers are supported");
            }

        }
        return myDriver;

    }

    private static void getRemoteWebDriver(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setCapability("version", browserVersion);
        capabilities.setCapability("platform", platform);
        // Create the connection  to run the tests
        try {
            myDriver =  new RemoteWebDriver(
                    new URL("http://" + username + ":" + key + "@ondemand.saucelabs.com:"+ port + "/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    private static void initialize(){

        browser = util.getProperty("WebDriverConfig.properties","browser");
        platform = util.getProperty("WebDriverConfig.properties","platform");
        username=util.getProperty("WebDriverConfig.properties","username");
        password=util.getProperty("WebDriverConfig.properties","password");
        port=util.getProperty("WebDriverConfig.properties","port");
        key=util.getProperty("WebDriverConfig.properties","key");
        browserVersion = util.getProperty("WebDriverConfig.properties","browserVersion");
        isRemote = Boolean.parseBoolean(util.getProperty("WebDriverConfig.properties","isRemote"));
    }

}
